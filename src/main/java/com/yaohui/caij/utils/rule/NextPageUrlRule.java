package com.yaohui.caij.utils.rule;


import com.yaohui.caij.bo.PageConfigBO;

public class NextPageUrlRule {

  /**
   * 页码标识
   */
  private static final String PAGE_INDEX_TAG = "${index}";


  public static String getNextPageUrl(PageConfigBO pageConfigBO, int index) {
    String nextPageRule = pageConfigBO.getNextPageUrl();
    nextPageRule = nextPageRule.replace(PAGE_INDEX_TAG, index + "");
    return nextPageRule;
  }

}
