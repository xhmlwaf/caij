package com.yaohui.caij.dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Task implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 目标URL
     */
    @Column(name = "target_url")
    private String targetUrl;

    /**
     * 列表xpath
     */
    @Column(name = "entity_list_xpath")
    private String entityListXpath;

    /**
     * 属性配置
     */
    @Column(name = "params_rule_map")
    private String paramsRuleMap;

    /**
     * 详情页配置
     */
    @Column(name = "detail_page_config")
    private String detailPageConfig;

    /**
     * 详情页属性配置
     */
    @Column(name = "detail_params_rule_map")
    private String detailParamsRuleMap;

    /**
     * 是否动态页面
     */
    @Column(name = "is_dynamic")
    private Byte isDynamic;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 状态1新建 2开始 3完成 4失败
     */
    private Byte status;

    private static final long serialVersionUID = 1L;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取任务名称
     *
     * @return name - 任务名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置任务名称
     *
     * @param name 任务名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取目标URL
     *
     * @return target_url - 目标URL
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * 设置目标URL
     *
     * @param targetUrl 目标URL
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    /**
     * 获取列表xpath
     *
     * @return entity_list_xpath - 列表xpath
     */
    public String getEntityListXpath() {
        return entityListXpath;
    }

    /**
     * 设置列表xpath
     *
     * @param entityListXpath 列表xpath
     */
    public void setEntityListXpath(String entityListXpath) {
        this.entityListXpath = entityListXpath;
    }

    /**
     * 获取属性配置
     *
     * @return params_rule_map - 属性配置
     */
    public String getParamsRuleMap() {
        return paramsRuleMap;
    }

    /**
     * 设置属性配置
     *
     * @param paramsRuleMap 属性配置
     */
    public void setParamsRuleMap(String paramsRuleMap) {
        this.paramsRuleMap = paramsRuleMap;
    }

    /**
     * 获取详情页配置
     *
     * @return detail_page_config - 详情页配置
     */
    public String getDetailPageConfig() {
        return detailPageConfig;
    }

    /**
     * 设置详情页配置
     *
     * @param detailPageConfig 详情页配置
     */
    public void setDetailPageConfig(String detailPageConfig) {
        this.detailPageConfig = detailPageConfig;
    }

    /**
     * 获取详情页属性配置
     *
     * @return detail_params_rule_map - 详情页属性配置
     */
    public String getDetailParamsRuleMap() {
        return detailParamsRuleMap;
    }

    /**
     * 设置详情页属性配置
     *
     * @param detailParamsRuleMap 详情页属性配置
     */
    public void setDetailParamsRuleMap(String detailParamsRuleMap) {
        this.detailParamsRuleMap = detailParamsRuleMap;
    }

    /**
     * 获取是否动态页面
     *
     * @return is_dynamic - 是否动态页面
     */
    public Byte getIsDynamic() {
        return isDynamic;
    }

    /**
     * 设置是否动态页面
     *
     * @param isDynamic 是否动态页面
     */
    public void setIsDynamic(Byte isDynamic) {
        this.isDynamic = isDynamic;
    }

    /**
     * 获取创建时间
     *
     * @return created_at - 创建时间
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * 设置创建时间
     *
     * @param createdAt 创建时间
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * 获取状态1新建 2开始 3完成 4失败
     *
     * @return status - 状态1新建 2开始 3完成 4失败
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置状态1新建 2开始 3完成 4失败
     *
     * @param status 状态1新建 2开始 3完成 4失败
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Task other = (Task) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getTargetUrl() == null ? other.getTargetUrl() == null : this.getTargetUrl().equals(other.getTargetUrl()))
            && (this.getEntityListXpath() == null ? other.getEntityListXpath() == null : this.getEntityListXpath().equals(other.getEntityListXpath()))
            && (this.getParamsRuleMap() == null ? other.getParamsRuleMap() == null : this.getParamsRuleMap().equals(other.getParamsRuleMap()))
            && (this.getDetailPageConfig() == null ? other.getDetailPageConfig() == null : this.getDetailPageConfig().equals(other.getDetailPageConfig()))
            && (this.getDetailParamsRuleMap() == null ? other.getDetailParamsRuleMap() == null : this.getDetailParamsRuleMap().equals(other.getDetailParamsRuleMap()))
            && (this.getIsDynamic() == null ? other.getIsDynamic() == null : this.getIsDynamic().equals(other.getIsDynamic()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTargetUrl() == null) ? 0 : getTargetUrl().hashCode());
        result = prime * result + ((getEntityListXpath() == null) ? 0 : getEntityListXpath().hashCode());
        result = prime * result + ((getParamsRuleMap() == null) ? 0 : getParamsRuleMap().hashCode());
        result = prime * result + ((getDetailPageConfig() == null) ? 0 : getDetailPageConfig().hashCode());
        result = prime * result + ((getDetailParamsRuleMap() == null) ? 0 : getDetailParamsRuleMap().hashCode());
        result = prime * result + ((getIsDynamic() == null) ? 0 : getIsDynamic().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", targetUrl=").append(targetUrl);
        sb.append(", entityListXpath=").append(entityListXpath);
        sb.append(", paramsRuleMap=").append(paramsRuleMap);
        sb.append(", detailPageConfig=").append(detailPageConfig);
        sb.append(", detailParamsRuleMap=").append(detailParamsRuleMap);
        sb.append(", isDynamic=").append(isDynamic);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}