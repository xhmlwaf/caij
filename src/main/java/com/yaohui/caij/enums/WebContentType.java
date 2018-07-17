package com.yaohui.caij.enums;

public enum WebContentType {
  DYNAMIC(1, "动态"),
  STATIC(0, "静态");

  private int type;
  private String desc;

  WebContentType(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  /**
   * 通过value获取对象
   */
  public static WebContentType get(int val) {
    for (WebContentType c : WebContentType.values()) {
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
