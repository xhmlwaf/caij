package com.yaohui.caij.enums;

public enum DealType {

  SAVE_TEXT(0, "保存文本"),
  DOWNLOAD(1, "下载文件");

  private int type;
  private String desc;

  DealType(int type, String desc) {
    this.type = type;
    this.desc = desc;
  }

  /**
   * 通过value获取对象
   */
  public static DealType get(int val) {
    for (DealType c : DealType.values()) {
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
