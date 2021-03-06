package com.yaohui.caij.enums;

public enum LocationTypeEnum {
  /**
   * HTML-包含内容
   */
  HTML(0, "包含的内容"),
  /**
   * ATTR-属性
   */
  ATTR(1, "属性值");

  LocationTypeEnum(int value, String desc) {
    this.value = value;
    this.desc = desc;
  }

  // 成员变量
  private int value; // value
  private String desc; // 描述

  /**
   * 通过value获取对象
   */
  public static LocationTypeEnum get(int val) {
    for (LocationTypeEnum c : LocationTypeEnum.values()) {
      if (c.getValue() == val) {
        return c;
      }
    }
    return null;
  }

  public int getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
