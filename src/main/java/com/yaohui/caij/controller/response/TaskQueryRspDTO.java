package com.yaohui.caij.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class TaskQueryRspDTO implements Serializable {

    /**
     *
     */
    @ApiModelProperty(name = "")
    private Integer id;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String name;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String targetUrl;

    /**
     *
     */
    @ApiModelProperty(name = "")
    private String homeUrl;

    /**
     *实体列表路径
     */
    @ApiModelProperty(name = "实体列表路径")
    private String entityListXpath;

    /**
     *参数配置
     */
    @ApiModelProperty(name = "参数配置")
    private String paramsRuleMap;

    /**
     *详情页配置
     */
    @ApiModelProperty(name = "详情页配置")
    private String detailPageConfig;

    /**
     *是否动态网页
     */
    @ApiModelProperty(name = "是否动态网页")
    private Byte dynamic;

    /**
     *创建时间
     */
    @ApiModelProperty(name = "创建时间")
    private Date createdAt;

    /**
     *状态
     */
    @ApiModelProperty(name = "状态")
    private Boolean status;

    /**
     *分页配置
     */
    @ApiModelProperty(name = "分页配置")
    private String pageConfig;

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
    public String getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }
    public String getHomeUrl() {
        return homeUrl;
    }

    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }
    public String getEntityListXpath() {
        return entityListXpath;
    }

    public void setEntityListXpath(String entityListXpath) {
        this.entityListXpath = entityListXpath;
    }
    public String getParamsRuleMap() {
        return paramsRuleMap;
    }

    public void setParamsRuleMap(String paramsRuleMap) {
        this.paramsRuleMap = paramsRuleMap;
    }
    public String getDetailPageConfig() {
        return detailPageConfig;
    }

    public void setDetailPageConfig(String detailPageConfig) {
        this.detailPageConfig = detailPageConfig;
    }
    public Byte getDynamic() {
        return dynamic;
    }

    public void setDynamic(Byte dynamic) {
        this.dynamic = dynamic;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    public String getPageConfig() {
        return pageConfig;
    }

    public void setPageConfig(String pageConfig) {
        this.pageConfig = pageConfig;
    }
}
