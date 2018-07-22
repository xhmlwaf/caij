package com.yaohui.caij.controller.request;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModelProperty;

public class TaskUpdateReqDTO implements Serializable {

    /**
     *主键
     */
    @NotNull(message = "更新时ID不能为空")
    @ApiModelProperty(name = "主键")
    private Integer id;

    /**
     *名称
     */
    @ApiModelProperty(name = "名称")
    private String name;

    /**
     *网页地址
     */
    @ApiModelProperty(name = "网页地址")
    private String pageUrl;

    /**
     *xpath路径
     */
    @ApiModelProperty(name = "xpath路径")
    private String listXpath;

    /**
     *动态 0否 1是
     */
    @ApiModelProperty(name = "动态 0否 1是")
    private Byte dynamic;

    /**
     *是否多页面 0否 1是
     */
    @ApiModelProperty(name = "是否多页面 0否 1是")
    private Byte multiPage;

    /**
     *分页模板
     */
    @ApiModelProperty(name = "分页模板")
    private String pageUrlTemplate;

    /**
     *开始页码
     */
    @ApiModelProperty(name = "开始页码")
    private Integer startPage;

    /**
     *结束页码
     */
    @ApiModelProperty(name = "结束页码")
    private Integer endPage;

    /**
     *创建时间
     */
    @ApiModelProperty(name = "创建时间")
    private Date createdAt;

    private static final long serialVersionUID = 1L;

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
    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }
    public String getListXpath() {
        return listXpath;
    }

    public void setListXpath(String listXpath) {
        this.listXpath = listXpath;
    }
    public Byte getDynamic() {
        return dynamic;
    }

    public void setDynamic(Byte dynamic) {
        this.dynamic = dynamic;
    }
    public Byte getMultiPage() {
        return multiPage;
    }

    public void setMultiPage(Byte multiPage) {
        this.multiPage = multiPage;
    }
    public String getPageUrlTemplate() {
        return pageUrlTemplate;
    }

    public void setPageUrlTemplate(String pageUrlTemplate) {
        this.pageUrlTemplate = pageUrlTemplate;
    }
    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }
    public Integer getEndPage() {
        return endPage;
    }

    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
