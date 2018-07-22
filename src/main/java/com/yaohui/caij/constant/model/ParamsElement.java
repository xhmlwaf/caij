package com.yaohui.caij.constant.model;

/**
 * 参数元素
 */
public class ParamsElement {

    public ParamsElement() {
    }

    public ParamsElement(String xpath, int location, String attrName, String regex) {
        this.xpath = xpath;
        this.location = location;
        this.attrName = attrName;
        this.regex = regex;
    }

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

    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
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
