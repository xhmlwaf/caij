package com.yaohui.caij.bo;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailPageConfigBO {
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

  /**
   * 详情页面其他参数
   */
  private Map<String, ParamsElementBO> otherParamsRuleMap;

}
