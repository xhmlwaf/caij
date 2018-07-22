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
     * 名称
     */
    private String name;

    /**
     * 网页地址
     */
    @Column(name = "page_url")
    private String pageUrl;

    /**
     * xpath路径
     */
    @Column(name = "list_xpath")
    private String listXpath;

    /**
     * 动态 0否 1是
     */
    private Byte dynamic;

    /**
     * 是否多页面 0否 1是
     */
    @Column(name = "multi_page")
    private Byte multiPage;

    /**
     * 分页模板
     */
    @Column(name = "page_url_template")
    private String pageUrlTemplate;

    /**
     * 开始页码
     */
    @Column(name = "start_page")
    private Integer startPage;

    /**
     * 结束页码
     */
    @Column(name = "end_page")
    private Integer endPage;

    /**
     * 创建时间
     */
    @Column(name = "created_at")
    private Date createdAt;

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
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取网页地址
     *
     * @return page_url - 网页地址
     */
    public String getPageUrl() {
        return pageUrl;
    }

    /**
     * 设置网页地址
     *
     * @param pageUrl 网页地址
     */
    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    /**
     * 获取xpath路径
     *
     * @return list_xpath - xpath路径
     */
    public String getListXpath() {
        return listXpath;
    }

    /**
     * 设置xpath路径
     *
     * @param listXpath xpath路径
     */
    public void setListXpath(String listXpath) {
        this.listXpath = listXpath;
    }

    /**
     * 获取动态 0否 1是
     *
     * @return dynamic - 动态 0否 1是
     */
    public Byte getDynamic() {
        return dynamic;
    }

    /**
     * 设置动态 0否 1是
     *
     * @param dynamic 动态 0否 1是
     */
    public void setDynamic(Byte dynamic) {
        this.dynamic = dynamic;
    }

    /**
     * 获取是否多页面 0否 1是
     *
     * @return multi_page - 是否多页面 0否 1是
     */
    public Byte getMultiPage() {
        return multiPage;
    }

    /**
     * 设置是否多页面 0否 1是
     *
     * @param multiPage 是否多页面 0否 1是
     */
    public void setMultiPage(Byte multiPage) {
        this.multiPage = multiPage;
    }

    /**
     * 获取分页模板
     *
     * @return page_url_template - 分页模板
     */
    public String getPageUrlTemplate() {
        return pageUrlTemplate;
    }

    /**
     * 设置分页模板
     *
     * @param pageUrlTemplate 分页模板
     */
    public void setPageUrlTemplate(String pageUrlTemplate) {
        this.pageUrlTemplate = pageUrlTemplate;
    }

    /**
     * 获取开始页码
     *
     * @return start_page - 开始页码
     */
    public Integer getStartPage() {
        return startPage;
    }

    /**
     * 设置开始页码
     *
     * @param startPage 开始页码
     */
    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    /**
     * 获取结束页码
     *
     * @return end_page - 结束页码
     */
    public Integer getEndPage() {
        return endPage;
    }

    /**
     * 设置结束页码
     *
     * @param endPage 结束页码
     */
    public void setEndPage(Integer endPage) {
        this.endPage = endPage;
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
            && (this.getPageUrl() == null ? other.getPageUrl() == null : this.getPageUrl().equals(other.getPageUrl()))
            && (this.getListXpath() == null ? other.getListXpath() == null : this.getListXpath().equals(other.getListXpath()))
            && (this.getDynamic() == null ? other.getDynamic() == null : this.getDynamic().equals(other.getDynamic()))
            && (this.getMultiPage() == null ? other.getMultiPage() == null : this.getMultiPage().equals(other.getMultiPage()))
            && (this.getPageUrlTemplate() == null ? other.getPageUrlTemplate() == null : this.getPageUrlTemplate().equals(other.getPageUrlTemplate()))
            && (this.getStartPage() == null ? other.getStartPage() == null : this.getStartPage().equals(other.getStartPage()))
            && (this.getEndPage() == null ? other.getEndPage() == null : this.getEndPage().equals(other.getEndPage()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getPageUrl() == null) ? 0 : getPageUrl().hashCode());
        result = prime * result + ((getListXpath() == null) ? 0 : getListXpath().hashCode());
        result = prime * result + ((getDynamic() == null) ? 0 : getDynamic().hashCode());
        result = prime * result + ((getMultiPage() == null) ? 0 : getMultiPage().hashCode());
        result = prime * result + ((getPageUrlTemplate() == null) ? 0 : getPageUrlTemplate().hashCode());
        result = prime * result + ((getStartPage() == null) ? 0 : getStartPage().hashCode());
        result = prime * result + ((getEndPage() == null) ? 0 : getEndPage().hashCode());
        result = prime * result + ((getCreatedAt() == null) ? 0 : getCreatedAt().hashCode());
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
        sb.append(", pageUrl=").append(pageUrl);
        sb.append(", listXpath=").append(listXpath);
        sb.append(", dynamic=").append(dynamic);
        sb.append(", multiPage=").append(multiPage);
        sb.append(", pageUrlTemplate=").append(pageUrlTemplate);
        sb.append(", startPage=").append(startPage);
        sb.append(", endPage=").append(endPage);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}