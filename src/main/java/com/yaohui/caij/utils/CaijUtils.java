package com.yaohui.caij.utils;

import com.google.common.collect.Lists;

import com.alibaba.fastjson.JSON;
import com.yaohui.caij.cache.FileUrlQueue;
import com.yaohui.caij.constant.model.DetailPageConfig;
import com.yaohui.caij.constant.model.PageConfig;
import com.yaohui.caij.constant.model.ParamsElement;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.enums.LocationType;
import com.yaohui.caij.utils.rule.DetailPageUrlRule;
import com.yaohui.caij.utils.rule.NextPageUrlRule;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public class CaijUtils {

  public static final Logger logger = LoggerFactory.getLogger(CaijUtils.class);

  public static List<WebPageConfig> listWebPageConfig(WebPageConfig webPageConfig, PageConfig pageConfig) {
    List<WebPageConfig> webPageConfigList = new ArrayList<>();
    webPageConfigList.add(webPageConfig);
    if (pageConfig != null) {
      int start = pageConfig.getStartPageNum();
      int end = pageConfig.getEndPageNum();
      for (int i = start; i <= end; i++) {
        WebPageConfig t = new WebPageConfig();
        BeanUtils.copyProperties(webPageConfig, t);
        String url = NextPageUrlRule.getNextPageUrl(pageConfig, i);
        t.setTargetUrl(url);
        webPageConfigList.add(t);
      }
    }
    return webPageConfigList;
  }

  public static List<Map<String, Object>> dealAndReturn(WebPageConfig webPageConfig) {
    logger.info("采集目标URL:" + webPageConfig.getTargetUrl());
    String webContent = WebPageContentUtil.getWebPageContent(webPageConfig.getTargetUrl(), webPageConfig.isDynamic());
    if (webContent == null) {
      logger.error("获取网页内容异常.url:" + webPageConfig.getTargetUrl());
      return null;
    }
    Document doc = JsoupUtil.getDocumentFromContent(webContent);
    List<Element> entityContentList = JsoupUtil.selectElements(doc, webPageConfig.getEntityListXpath());
    List<Map<String, Object>> resultList = new ArrayList<>();
    for (Element e : entityContentList) {
      Map<String, Object> m = new HashMap<>();
      getResultMap(webPageConfig.getParamsRuleMap(), e, m, webPageConfig.getHomeUrl());
      List<DetailPageConfig> detailPageConfigList = webPageConfig.getDetailPageConfigList();
      if (!CollectionUtils.isEmpty(detailPageConfigList)) {
        for (DetailPageConfig detailPageConfig : detailPageConfigList) {
          String detailPageUrl = DetailPageUrlRule.getDetailPageUrl(webPageConfig.getHomeUrl(), detailPageConfig, e);
          String detailWebContent = WebPageContentUtil.getWebPageContent(detailPageUrl, webPageConfig.isDynamic());
          Document detailDoc = JsoupUtil.getDocumentFromContent(detailWebContent);
          getResultMap(detailPageConfig.getOtherParamsRuleMap(), detailDoc, m, webPageConfig.getHomeUrl());
        }
      }
      resultList.add(m);
    }
    System.out.println(JSON.toJSONString(resultList));

    return resultList;
  }

  private static void getResultMap(Map<String, ParamsElement> paramsMap, Element e, Map<String, Object> result, String homeUrl) {
    for (Map.Entry<String, ParamsElement> entry : paramsMap.entrySet()) {
      String key = entry.getKey();
      ParamsElement value = entry.getValue();
      String data = null;
      if (value.getLocation() == LocationType.HTML.getValue()) {
        data = e.select(value.getXpath()).html();
      } else if (value.getLocation() == LocationType.ATTR.getValue()) {
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
