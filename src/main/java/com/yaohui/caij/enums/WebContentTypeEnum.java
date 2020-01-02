package com.yaohui.caij.enums;

public enum WebContentTypeEnum {
  DYNAMIC(1, "动态"),
  STATIC(0, "静态");

  private int type;
  private String desc;

  WebContentTypeEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  /**
   * 通过value获取对象
   */
  public static WebContentTypeEnum get(int val) {
    for (WebContentTypeEnum c : WebContentTypeEnum.values()) {
      if (c.getType() == val) {
        return c;
      }
    }
    return null;
  }

  public int getType() {
    return type;
  }

  public String getDesc() {
    return desc;
  }
}
