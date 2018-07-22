package com.yaohui.caij.controller.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class AssociatePageUpdateReqDTO implements Serializable {

    /**
     *
     */
    @NotNull(message = "更新时ID不能为空")
    @ApiModelProperty(name = "")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private Integer taskId;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String name;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String xpath;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private Byte location;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String attrName;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String regex;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private Date createdAt;

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
    public String getXpath() {
        return xpath;
    }

    public void setXpath(String xpath) {
        this.xpath = xpath;
    }
    public Byte getLocation() {
        return location;
    }

    public void setLocation(Byte location) {
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
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
