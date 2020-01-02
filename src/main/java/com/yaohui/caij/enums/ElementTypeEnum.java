package com.yaohui.caij.enums;

public enum ElementTypeEnum {

  TEXT(0, "文本"),
  FILEPATH(1, "文件路径");

  private int type;
  private String desc;

  ElementTypeEnum(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  /**
   * 通过value获取对象
   */
  public static ElementTypeEnum get(int val) {
    for (ElementTypeEnum c : ElementTypeEnum.values()) {
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
