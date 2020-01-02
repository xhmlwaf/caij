package com.yaohui.caij.bo;

import lombok.Getter;
import lombok.Setter;

/**
 * 参数元素
 */
@Getter
@Setter
public class ParamsElementBO {

  /**
   * 参数路径
   */
  private String xpath;
  /**
   * 内容类型
   */
  private int location;
  /**
   * 属性名称
   */
  private String attrName;
  /**
   * 正则表达式
   */
  private String regex;

  public ParamsElementBO() {
  }

  public ParamsElementBO(String xpath, int location, String attrName, String regex) {
    this.xpath = xpath;
    this.location = location;
    this.attrName = attrName;
    this.regex = regex;
  }
}
