package com.yaohui.caij.controller.response;

public class AssociateDTO {

  private Integer id;
  private String name;
  private String xpath;
  private Integer contentType;
  private String attrName;
  private String regex;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getXpath() {
    return xpath;
  }

  public void setXpath(String xpath) {
    this.xpath = xpath;
  }

  public Integer getContentType() {
    return contentType;
  }

  public void setContentType(Integer contentType) {
    this.contentType = contentType;
  }

  public String getAttrName() {
    return attrName;
  }

  public void setAttrName(String attrName) {
    this.attrName = attrName;
  }

  public String getRegex() {
    return regex;
  }

  public void setRegex(String regex) {
    this.regex = regex;
  }
}
