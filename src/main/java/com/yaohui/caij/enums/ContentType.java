package com.yaohui.caij.enums;

import java.util.LinkedHashMap;
import java.util.Map;

public enum ContentType {
  /**
   * 0-放款
   */
  HTML("HTML", "包含内容"),
  /**
   * 1-提前还款
   */
  ATTR("ATTR", "属性");

  // 成员变量
  private String value; // value
  private String desc; // 描述

  // 构造方法
  private ContentType(String val, String desc) {
    this.value = val;
    this.desc = desc;
  }

  public static Map<String, String> getDescValueMap() {
    ContentType[] loops = ContentType.values();
    Map<String, String> map = new LinkedHashMap<String, String>();
    for (ContentType loop : loops) {
      map.put(loop.getDesc(), loop.getValue());
    }
    return map;
  }

  /**
   * 通过value获取对象
   */
  public static ContentType getMessageType(String val) {
    for (ContentType c : ContentType.values()) {
      if (c.getValue().equals(val)) {
        return c;
      }
    }
    return null;
  }

  public String getValue() {
    return value;
  }

  public String getDesc() {
    return desc;
  }
}
