package com.yaohui.caij.utils.rule;

import com.yaohui.caij.constant.model.DetailedPageConfig;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.enums.ContentType;

import org.jsoup.nodes.Element;

public class DetailPageUrlRule {

  private static final String URL_START_TAG = "http";

  /**
   * 获取详情页信息
   */
  public static String getDetailPageUrl(WebPageConfig webPageConfig, Element e) {
    DetailedPageConfig detailedPageConfig = webPageConfig.getDetailedPageConfig();
    String value = null;
    if (detailedPageConfig.getContentType().equals(ContentType.HTML.getValue())) {
      value = e.select(detailedPageConfig.getXpath()).html();
    } else if (detailedPageConfig.getContentType().equals(ContentType.ATTR.getValue())) {
      value = e.select(detailedPageConfig.getXpath()).attr(detailedPageConfig.getAttrName());
    }
    if (value != null && !value.toLowerCase().startsWith(URL_START_TAG)) {
      return webPageConfig.getHomeUrl() + value;
    }
    return value;
  }
}
