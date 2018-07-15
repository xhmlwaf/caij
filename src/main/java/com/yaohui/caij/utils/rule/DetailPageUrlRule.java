package com.yaohui.caij.utils.rule;

import com.yaohui.caij.constant.model.DetailPageConfig;
import com.yaohui.caij.constant.model.WebPageConfig;
import com.yaohui.caij.enums.ContentType;

import org.jsoup.nodes.Element;

public class DetailPageUrlRule {

  private static final String URL_START_TAG = "http";

  /**
   * 获取详情页信息
   */
  public static String getDetailPageUrl(WebPageConfig webPageConfig, Element e) {
    DetailPageConfig detailPageConfig = webPageConfig.getDetailPageConfig();
    String value = null;
    if (detailPageConfig.getContentType().equals(ContentType.HTML.getValue())) {
      value = e.select(detailPageConfig.getXpath()).html();
    } else if (detailPageConfig.getContentType().equals(ContentType.ATTR.getValue())) {
      value = e.select(detailPageConfig.getXpath()).attr(detailPageConfig.getAttrName());
    }
    if (value != null && !value.toLowerCase().startsWith(URL_START_TAG)) {
      return webPageConfig.getHomeUrl() + value;
    }
    return value;
  }
}
