package com.yaohui.caij.utils;

import com.google.common.collect.Lists;

import com.alibaba.fastjson.JSON;
import com.yaohui.caij.bo.DetailPageConfigBO;
import com.yaohui.caij.bo.PageConfigBO;
import com.yaohui.caij.bo.ParamsElementBO;
import com.yaohui.caij.bo.WebPageConfigBO;
import com.yaohui.caij.cache.FileUrlQueue;
import com.yaohui.caij.enums.LocationTypeEnum;
import com.yaohui.caij.utils.rule.DetailPageUrlRule;
import com.yaohui.caij.utils.rule.NextPageUrlRule;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaijUtils {

  public static List<WebPageConfigBO> listWebPageConfig(WebPageConfigBO webPageConfigBO, PageConfigBO pageConfigBO) {
    List<WebPageConfigBO> webPageConfigBOList = new ArrayList<>();
    webPageConfigBOList.add(webPageConfigBO);
    if (pageConfigBO != null) {
      int start = pageConfigBO.getStartPageNum();
      int end = pageConfigBO.getEndPageNum();
      for (int i = start; i <= end; i++) {
        WebPageConfigBO t = new WebPageConfigBO();
        BeanUtils.copyProperties(webPageConfigBO, t);
        String url = NextPageUrlRule.getNextPageUrl(pageConfigBO, i);
        t.setTargetUrl(url);
        webPageConfigBOList.add(t);
      }
    }
    return webPageConfigBOList;
  }

  public static List<Map<String, Object>> dealAndReturn(WebPageConfigBO webPageConfigBO) {
    log.info("采集目标URL:" + webPageConfigBO.getTargetUrl());
    String webContent = WebPageContentUtil.getWebPageContent(webPageConfigBO.getTargetUrl(), webPageConfigBO.isDynamic());
    if (webContent == null) {
      log.error("获取网页内容异常.url:" + webPageConfigBO.getTargetUrl());
      return null;
    }
    Document doc = JsoupUtil.getDocumentFromContent(webContent);
    List<Element> entityContentList = JsoupUtil.selectElements(doc, webPageConfigBO.getEntityListXpath());
    log.info("找到目标个数:{}", entityContentList.size());
    List<Map<String, Object>> resultList = new ArrayList<>();
    for (Element e : entityContentList) {
      Map<String, Object> m = new HashMap<>();
      getResultMap(webPageConfigBO.getParamsRuleMap(), e, m, webPageConfigBO.getHomeUrl());
      List<DetailPageConfigBO> detailPageConfigBOList = webPageConfigBO.getDetailPageConfigBOList();
      if (!CollectionUtils.isEmpty(detailPageConfigBOList)) {
        for (DetailPageConfigBO detailPageConfigBO : detailPageConfigBOList) {
          String detailPageUrl = DetailPageUrlRule.getDetailPageUrl(webPageConfigBO.getHomeUrl(), detailPageConfigBO, e);
          String detailWebContent = WebPageContentUtil.getWebPageContent(detailPageUrl, webPageConfigBO.isDynamic());
          Document detailDoc = JsoupUtil.getDocumentFromContent(detailWebContent);
          getResultMap(detailPageConfigBO.getOtherParamsRuleMap(), detailDoc, m, webPageConfigBO.getHomeUrl());
        }
      }
      log.info("m:{}", JSON.toJSONString(m));
      resultList.add(m);
    }
    System.out.println(JSON.toJSONString(resultList));

    return resultList;
  }

  private static void getResultMap(Map<String, ParamsElementBO> paramsMap, Element e, Map<String, Object> result, String homeUrl) {
    if (CollectionUtils.isEmpty(paramsMap)) {
      return;
    }
    for (Map.Entry<String, ParamsElementBO> entry : paramsMap.entrySet()) {
      String key = entry.getKey();
      ParamsElementBO value = entry.getValue();
      String data = null;
      if (value.getLocation() == LocationTypeEnum.HTML.getValue()) {
        data = e.select(value.getXpath()).html();
      } else if (value.getLocation() == LocationTypeEnum.ATTR.getValue()) {
        data = e.select(value.getXpath()).attr(value.getAttrName());
      }
      String regex = value.getRegex();
      if (!StringUtils.isEmpty(regex)) {
        String regexStr = getGroupValue(data, regex);
        if (regexStr != null) {
          data = regexStr;
        }
      }
      if (Objects.nonNull(data) && data.startsWith("/") && isImage(data)) {
        data = homeUrl + data;
      }
      //如果是文件，放到队列.
      if (Objects.nonNull(data) && data.startsWith("http")) {
        FileUrlQueue.put(data);
      }
      result.put(key, data);
    }
  }

  private static boolean isImage(String data) {
    if (Objects.isNull(data)) {
      return false;
    }
    data = data.toLowerCase();
    List<String> imageStuff = Lists.newArrayList(".jpg", ".png", ".gif", ".bmp");
    boolean exsit = false;
    for (String image : imageStuff) {
      if (data.endsWith(image)) {
        exsit = true;
      }
    }
    return exsit;
  }

  private static String getGroupValue(String value, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher m = pattern.matcher(value);
    System.out.println(m.groupCount());
    if (m.find()) {
      return m.group(1);
    } else {
      return null;
    }
  }
}
