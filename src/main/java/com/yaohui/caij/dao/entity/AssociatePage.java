package com.yaohui.caij.dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "associate_page")
public class AssociatePage implements Serializable {
    @Id
    private Integer id;

    @Column(name = "task_id")
    private Integer taskId;

    private String name;

    private String xpath;

    private Byte location;

    @Column(name = "attr_name")
    private String attrName;

    private String regex;

    @Column(name = "created_at")
    private Date createdAt;

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
     * @return task_id
     */
    public Integer getTaskId() {
        return taskId;
    }

    /**
     * @param taskId
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
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
     * @return xpath
     */
    public String getXpath() {
        return xpath;
    }

    /**
     * @param xpath
     */
    public void setXpath(String xpath) {
        this.xpath = xpath;
    }

    /**
     * @return location
     */
    public Byte getLocation() {
        return location;
    }

    /**
     * @param location
     */
    public void setLocation(Byte location) {
        this.location = location;
    }

    /**
     * @return attr_name
     */
    public String getAttrName() {
        return attrName;
    }

    /**
     * @param attrName
     */
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    /**
     * @return regex
     */
    public String getRegex() {
        return regex;
    }

    /**
     * @param regex
     */
    public void setRegex(String regex) {
        this.regex = regex;
    }

    /**
     * @return created_at
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt
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
        AssociatePage other = (AssociatePage) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getName() == null ? other.getName() == null : this.getName().equals(other.getName()))
            && (this.getXpath() == null ? other.getXpath() == null : this.getXpath().equals(other.getXpath()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getAttrName() == null ? other.getAttrName() == null : this.getAttrName().equals(other.getAttrName()))
            && (this.getRegex() == null ? other.getRegex() == null : this.getRegex().equals(other.getRegex()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
        result = prime * result + ((getXpath() == null) ? 0 : getXpath().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getAttrName() == null) ? 0 : getAttrName().hashCode());
        result = prime * result + ((getRegex() == null) ? 0 : getRegex().hashCode());
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
        sb.append(", taskId=").append(taskId);
        sb.append(", name=").append(name);
        sb.append(", xpath=").append(xpath);
        sb.append(", location=").append(location);
        sb.append(", attrName=").append(attrName);
        sb.append(", regex=").append(regex);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}