package com.yaohui.caij.enums;

public enum ElementType {

  TEXT(0, "文本"),
  IMG(1, "文件路径");

  private int type;
  private String desc;

  ElementType(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  /**
   * 通过value获取对象
   */
  public static ElementType get(int val) {
    for (ElementType c : ElementType.values()) {
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
