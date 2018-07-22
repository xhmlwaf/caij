package com.yaohui.caij.controller.request;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class TaskInsertReqDTO implements Serializable {

    /**
     *名称
     */
    @NotBlank(message = "name不能为空")
    @Max(value = 50,message = "name长度不能超过50")
    @ApiModelProperty(name = "名称")
    private String name;

    /**
     *网页地址
     */
    @NotBlank(message = "pageUrl不能为空")
    @Max(value = 255,message = "pageUrl长度不能超过255")
    @ApiModelProperty(name = "网页地址")
    private String pageUrl;

    /**
     *xpath路径
     */
    @NotBlank(message = "listXpath不能为空")
    @Max(value = 50,message = "listXpath长度不能超过50")
    @ApiModelProperty(name = "xpath路径")
    private String listXpath;

    /**
     *动态 0否 1是
     */
    @NotNull(message = "dynamic不能为空")
    @ApiModelProperty(name = "动态 0否 1是")
    private Byte dynamic;

    /**
     *是否多页面 0否 1是
     */
    @NotNull(message = "multiPage不能为空")
    @ApiModelProperty(name = "是否多页面 0否 1是")
    private Byte multiPage;

    /**
     *分页模板
     */
    @Max(value = 255,message = "pageUrlTemplate长度不能超过255")
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


    private static final long serialVersionUID = 1L;

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

}
