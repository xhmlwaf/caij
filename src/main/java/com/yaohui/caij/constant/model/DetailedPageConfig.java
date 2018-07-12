package com.yaohui.caij.constant.model;

public class DetailedPageConfig {
    /**
     * 参数路径
     */
    private String xpath;

    /**
     * 内容类型
     */
    private String contentType;

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

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
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
