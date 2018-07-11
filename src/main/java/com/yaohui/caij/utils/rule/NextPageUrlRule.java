package com.yaohui.caij.utils.rule;


import com.yaohui.caij.constant.model.PageConfig;

public class NextPageUrlRule {

  /**
   * 页码标识
   */
  private static final String PAGE_INDEX_TAG = "${index}";


  public static String getNextPageUrl(PageConfig pageConfig, int index) {
    String nextPageRule = pageConfig.getNextPageUrl();
    nextPageRule = nextPageRule.replace(PAGE_INDEX_TAG, index + "");
    return nextPageRule;
  }

}
