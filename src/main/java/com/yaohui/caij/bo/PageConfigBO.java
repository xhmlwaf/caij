package com.yaohui.caij.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 页码规则
 */
@Getter
@Setter
public class PageConfigBO {

  /**
   * 页码对应的url
   */
  private String nextPageUrl;

  /**
   * 开始页码数
   */
  private int startPageNum;

  /**
   * 结束页码数
   */
  private int endPageNum;
}
