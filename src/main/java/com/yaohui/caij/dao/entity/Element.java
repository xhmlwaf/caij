package com.yaohui.caij.dao.entity;

import java.io.Serializable;
import javax.persistence.*;

public class Element implements Serializable {
    /**
     * 主键
     */
    @Id
    private Integer id;

    /**
     * 任务ID
     */
    @Column(name = "task_id")
    private Integer taskId;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 参数类型 文本，文件地址
     */
    private Byte type;

    /**
     * 位置
     */
    private Byte location;

    /**
     * xpath
     */
    private String xpath;

    /**
     * 属性名称
     */
    @Column(name = "attr_name")
    private String attrName;

    /**
     * 正则表达式
     */
    private String regex;

    /**
     * 关联页面ID
     */
    @Column(name = "associate_page_id")
    private Integer associatePageId;

    /**
     * 处理方式
     */
    @Column(name = "deal_type")
    private Byte dealType;

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
     * 获取任务ID
     *
     * @return task_id - 任务ID
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * 设置任务ID
     *
     * @param taskId 任务ID
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     * 获取参数名称
     *
     * @return name - 参数名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置参数名称
     *
     * @param name 参数名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取参数类型 文本，文件地址
     *
     * @return type - 参数类型 文本，文件地址
     */
    public Byte getType() {
        return type;
    }

    /**
     * 设置参数类型 文本，文件地址
     *
     * @param type 参数类型 文本，文件地址
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     * 获取位置
     *
     * @return location - 位置
     */
    public Byte getLocation() {
        return location;
    }

    /**
     * 设置位置
     *
     * @param location 位置
     */
    public void setLocation(Byte location) {
        this.location = location;
    }

    /**
     * 获取xpath
     *
     * @return xpath - xpath
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * 设置xpath
     *
     * @param xpath xpath
     */
    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    /**
     * 获取属性名称
     *
     * @return attr_name - 属性名称
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * 设置属性名称
     *
     * @param attrName 属性名称
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * 获取正则表达式
     *
     * @return regex - 正则表达式
     */
    public String getRegex() {
        return regex;
    }

    /**
     * 设置正则表达式
     *
     * @param regex 正则表达式
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * 获取关联页面ID
     *
     * @return associate_page_id - 关联页面ID
     */
    public Integer getAssociatePageId() {
        return associatePageId;
    }

    /**
     * 设置关联页面ID
     *
     * @param associatePageId 关联页面ID
     */
    public void setAssociatePageId(Integer associatePageId) {
        this.associatePageId = associatePageId;
    }

    /**
     * 获取处理方式
     *
     * @return deal_type - 处理方式
     */
    public Byte getDealType() {
        return dealType;
    }

    /**
     * 设置处理方式
     *
     * @param dealType 处理方式
     */
    public void setDealType(Byte dealType) {
        this.dealType = dealType;
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
        Element other = (Element) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getType() == null ? other.getType() == null : this.getType().equals(other.getType()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getXpath() == null ? other.getXpath() == null : this.getXpath().equals(other.getXpath()))
            && (this.getAttrName() == null ? other.getAttrName() == null : this.getAttrName().equals(other.getAttrName()))
            && (this.getRegex() == null ? other.getRegex() == null : this.getRegex().equals(other.getRegex()))
            && (this.getAssociatePageId() == null ? other.getAssociatePageId() == null : this.getAssociatePageId().equals(other.getAssociatePageId()))
            && (this.getDealType() == null ? other.getDealType() == null : this.getDealType().equals(other.getDealType()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getType() == null) ? 0 : getType().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getXpath() == null) ? 0 : getXpath().hashCode());
        result = prime * result + ((getAttrName() == null) ? 0 : getAttrName().hashCode());
        result = prime * result + ((getRegex() == null) ? 0 : getRegex().hashCode());
        result = prime * result + ((getAssociatePageId() == null) ? 0 : getAssociatePageId().hashCode());
        result = prime * result + ((getDealType() == null) ? 0 : getDealType().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskId=").append(taskId);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", location=").append(location);
        sb.append(", xpath=").append(xpath);
        sb.append(", attrName=").append(attrName);
        sb.append(", regex=").append(regex);
        sb.append(", associatePageId=").append(associatePageId);
        sb.append(", dealType=").append(dealType);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}