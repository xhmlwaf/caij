package com.yaohui.caij.dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

public class Task implements Serializable {
    @Id
    private Integer id;

    private String name;

    @Column(name = "target_url")
    private String targetUrl;

    @Column(name = "home_url")
    private String homeUrl;

    /**
     * 实体列表路径
     */
    @Column(name = "entity_list_xpath")
    private String entityListXpath;

    /**
     * 参数配置
     */
    @Column(name = "params_rule_map")
    private String paramsRuleMap;

    /**
     * 详情页配置
     */
    @Column(name = "detail_page_config")
    private String detailPageConfig;

    /**
     * 是否动态网页
     */
    private Byte dynamic;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

    /**
     * 状态
     */
    private Boolean status;

    /**
     * 分页配置
     */
    @Column(name = "page_config")
    private String pageConfig;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return target_url
     */
    public String getTargetUrl() {
        return targetUrl;
    }

    /**
     * @param targetUrl
     */
    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    /**
     * @return home_url
     */
    public String getHomeUrl() {
        return homeUrl;
    }

    /**
     * @param homeUrl
     */
    public void setHomeUrl(String homeUrl) {
        this.homeUrl = homeUrl;
    }

    /**
     * 获取实体列表路径
     *
     * @return entity_list_xpath - 实体列表路径
     */
    public String getEntityListXpath() {
        return entityListXpath;
    }

    /**
     * 设置实体列表路径
     *
     * @param entityListXpath 实体列表路径
     */
    public void setEntityListXpath(String entityListXpath) {
        this.entityListXpath = entityListXpath;
    }

    /**
     * 获取参数配置
     *
     * @return params_rule_map - 参数配置
     */
    public String getParamsRuleMap() {
        return paramsRuleMap;
    }

    /**
     * 设置参数配置
     *
     * @param paramsRuleMap 参数配置
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
     * 获取是否动态网页
     *
     * @return dynamic - 是否动态网页
     */
    public Byte getDynamic() {
        return dynamic;
    }

    /**
     * 设置是否动态网页
     *
     * @param dynamic 是否动态网页
     */
    public void setDynamic(Byte dynamic) {
        this.dynamic = dynamic;
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
     * 获取状态
     *
     * @return status - 状态
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * 设置状态
     *
     * @param status 状态
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * 获取分页配置
     *
     * @return page_config - 分页配置
     */
    public String getPageConfig() {
        return pageConfig;
    }

    /**
     * 设置分页配置
     *
     * @param pageConfig 分页配置
     */
    public void setPageConfig(String pageConfig) {
        this.pageConfig = pageConfig;
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
            && (this.getHomeUrl() == null ? other.getHomeUrl() == null : this.getHomeUrl().equals(other.getHomeUrl()))
            && (this.getEntityListXpath() == null ? other.getEntityListXpath() == null : this.getEntityListXpath().equals(other.getEntityListXpath()))
            && (this.getParamsRuleMap() == null ? other.getParamsRuleMap() == null : this.getParamsRuleMap().equals(other.getParamsRuleMap()))
            && (this.getDetailPageConfig() == null ? other.getDetailPageConfig() == null : this.getDetailPageConfig().equals(other.getDetailPageConfig()))
            && (this.getDynamic() == null ? other.getDynamic() == null : this.getDynamic().equals(other.getDynamic()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getPageConfig() == null ? other.getPageConfig() == null : this.getPageConfig().equals(other.getPageConfig()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getTargetUrl() == null) ? 0 : getTargetUrl().hashCode());
        result = prime * result + ((getHomeUrl() == null) ? 0 : getHomeUrl().hashCode());
        result = prime * result + ((getEntityListXpath() == null) ? 0 : getEntityListXpath().hashCode());
        result = prime * result + ((getParamsRuleMap() == null) ? 0 : getParamsRuleMap().hashCode());
        result = prime * result + ((getDetailPageConfig() == null) ? 0 : getDetailPageConfig().hashCode());
        result = prime * result + ((getDynamic() == null) ? 0 : getDynamic().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getPageConfig() == null) ? 0 : getPageConfig().hashCode());
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
        sb.append(", homeUrl=").append(homeUrl);
        sb.append(", entityListXpath=").append(entityListXpath);
        sb.append(", paramsRuleMap=").append(paramsRuleMap);
        sb.append(", detailPageConfig=").append(detailPageConfig);
        sb.append(", dynamic=").append(dynamic);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", status=").append(status);
        sb.append(", pageConfig=").append(pageConfig);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}