package com.yaohui.caij.controller.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class ElementUpdateReqDTO implements Serializable {

    /**
     *主键
     */
    @NotNull(message = "更新时ID不能为空")
    @ApiModelProperty(name = "主键")
    private Integer id;

    /**
     *任务ID
     */
    @ApiModelProperty(name = "任务ID")
    private Integer taskId;

    /**
     *参数名称
     */
    @ApiModelProperty(name = "参数名称")
    private String name;

    /**
     *参数类型 文本，文件地址
     */
    @ApiModelProperty(name = "参数类型 文本，文件地址")
    private Byte type;

    /**
     *位置
     */
    @ApiModelProperty(name = "位置")
    private Byte location;

    /**
     *xpath
     */
    @ApiModelProperty(name = "xpath")
    private String xpath;

    /**
     *属性名称
     */
    @ApiModelProperty(name = "属性名称")
    private String attrName;

    /**
     *正则表达式
     */
    @ApiModelProperty(name = "正则表达式")
    private String regex;

    /**
     *关联页面ID
     */
    @ApiModelProperty(name = "关联页面ID")
    private Integer associatePageId;

    /**
     *处理方式
     */
    @ApiModelProperty(name = "处理方式")
    private Byte dealType;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }
    public Byte getLocation() {
        return location;
    }

    public void setLocation(Byte location) {
        this.location = location;
    }
    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
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
    public Integer getAssociatePageId() {
        return associatePageId;
    }

    public void setAssociatePageId(Integer associatePageId) {
        this.associatePageId = associatePageId;
    }
    public Byte getDealType() {
        return dealType;
    }

    public void setDealType(Byte dealType) {
        this.dealType = dealType;
    }
}
