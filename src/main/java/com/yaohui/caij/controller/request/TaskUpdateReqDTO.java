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
     *任务名称
     */
    @ApiModelProperty(name = "任务名称")
    private String name;

    /**
     *目标URL
     */
    @ApiModelProperty(name = "目标URL")
    private String targetUrl;

    /**
     *列表xpath
     */
    @ApiModelProperty(name = "列表xpath")
    private String entityListXpath;

    /**
     *属性配置
     */
    @ApiModelProperty(name = "属性配置")
    private String paramsRuleMap;

    /**
     *详情页配置
     */
    @ApiModelProperty(name = "详情页配置")
    private String detailPageConfig;

    /**
     *详情页属性配置
     */
    @ApiModelProperty(name = "详情页属性配置")
    private String detailParamsRuleMap;

    /**
     *是否动态页面
     */
    @ApiModelProperty(name = "是否动态页面")
    private Byte isDynamic;

    /**
     *创建时间
     */
    @ApiModelProperty(name = "创建时间")
    private Date createdAt;

    /**
     *状态1新建 2开始 3完成 4失败
     */
    @ApiModelProperty(name = "状态1新建 2开始 3完成 4失败")
    private Byte status;

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
    public String getDetailParamsRuleMap() {
        return detailParamsRuleMap;
    }

    public void setDetailParamsRuleMap(String detailParamsRuleMap) {
        this.detailParamsRuleMap = detailParamsRuleMap;
    }
    public Byte getIsDynamic() {
        return isDynamic;
    }

    public void setIsDynamic(Byte isDynamic) {
        this.isDynamic = isDynamic;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}
