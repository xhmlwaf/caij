package com.yaohui.caij.utils;

import com.alibaba.fastjson.JSON;
import com.yaohui.caij.constant.model.DetailedPageConfig;
import com.yaohui.caij.constant.model.PageConfig;
import com.yaohui.caij.constant.model.ParamsElement;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.enums.ContentType;
import com.yaohui.caij.utils.rule.DetailPageUrlRule;
import com.yaohui.caij.utils.rule.NextPageUrlRule;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CaijUtils {

    public static final Logger logger = LoggerFactory.getLogger(CaijUtils.class);

    public static List<WebPageConfig> listWebPageConfig(WebPageConfig webPageConfig, PageConfig pageConfig) {
        List<WebPageConfig> webPageConfigList = new ArrayList<WebPageConfig>();
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
        System.out.println(webPageConfig.getTargetUrl());
        String webContent = WebPageContentUtil.getWebPageContent(webPageConfig.getTargetUrl(), webPageConfig.isDynamicPage());
        if (webContent == null) {
            logger.error("获取网页内容异常.url:" + webPageConfig.getTargetUrl());
            return null;
        }
        Document doc = JsoupUtil.getDocumentFromContent(webContent);
        List<Element> entityContentList = JsoupUtil.selectElements(doc, webPageConfig.getEntityListXpath());
        List<Map<String, Object>> resultList = new ArrayList<Map<String, Object>>();
        for (Element e : entityContentList) {
            Map<String, Object> m = new HashMap<String, Object>();
            getResultMap(webPageConfig.getParamsRuleMap(), e, m);
            DetailedPageConfig detailedPageConfig = webPageConfig.getDetailedPageConfig();
            if (detailedPageConfig != null) {
                String detailPageUrl = DetailPageUrlRule.getDetailPageUrl(webPageConfig, e);
                String detailWebContent = WebPageContentUtil.getWebPageContent(detailPageUrl, webPageConfig.isDynamicPage());
                Document detailDoc = JsoupUtil.getDocumentFromContent(detailWebContent);
                getResultMap(webPageConfig.getOtherParamsRuleMap(), detailDoc, m);
            }
            resultList.add(m);
        }
        System.out.println(JSON.toJSONString(resultList));

        return resultList;
    }

    private static void getResultMap(Map<String, ParamsElement> paramsMap, Element e, Map<String, Object> result) {
        for (Map.Entry<String, ParamsElement> entry : paramsMap.entrySet()) {
            String key = entry.getKey();
            ParamsElement value = entry.getValue();
            String data = null;
            if (value.getContentType().equals(ContentType.HTML.getValue())) {
                data = e.select(value.getXpath()).html();
            } else if (value.getContentType().equals(ContentType.ATTR.getValue())) {
                data = e.select(value.getXpath()).attr(value.getAttrName());
            }
            String regex = value.getRegex();
            if (regex != null) {
                String regexStr = getGroupValue(data, regex);
                if (regexStr != null) {
                    data = regexStr;
                }
            }
            result.put(key, data);
        }
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
