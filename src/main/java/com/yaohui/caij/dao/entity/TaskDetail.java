package com.yaohui.caij.dao.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

@Table(name = "task_detail")
public class TaskDetail implements Serializable {
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
     * 任务页面
     */
    private String url;

    /**
     * 结果量
     */
    @Column(name = "result_size")
    private Integer resultSize;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private Date startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private Date endTime;

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
     * 获取任务页面
     *
     * @return url - 任务页面
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置任务页面
     *
     * @param url 任务页面
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取结果量
     *
     * @return result_size - 结果量
     */
    public Integer getResultSize() {
        return resultSize;
    }

    /**
     * 设置结果量
     *
     * @param resultSize 结果量
     */
    public void setResultSize(Integer resultSize) {
        this.resultSize = resultSize;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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
        TaskDetail other = (TaskDetail) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskId() == null ? other.getTaskId() == null : this.getTaskId().equals(other.getTaskId()))
            && (this.getUrl() == null ? other.getUrl() == null : this.getUrl().equals(other.getUrl()))
            && (this.getResultSize() == null ? other.getResultSize() == null : this.getResultSize().equals(other.getResultSize()))
            && (this.getStartTime() == null ? other.getStartTime() == null : this.getStartTime().equals(other.getStartTime()))
            && (this.getEndTime() == null ? other.getEndTime() == null : this.getEndTime().equals(other.getEndTime()))
            && (this.getCreatedAt() == null ? other.getCreatedAt() == null : this.getCreatedAt().equals(other.getCreatedAt()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskId() == null) ? 0 : getTaskId().hashCode());
        result = prime * result + ((getUrl() == null) ? 0 : getUrl().hashCode());
        result = prime * result + ((getResultSize() == null) ? 0 : getResultSize().hashCode());
        result = prime * result + ((getStartTime() == null) ? 0 : getStartTime().hashCode());
        result = prime * result + ((getEndTime() == null) ? 0 : getEndTime().hashCode());
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
        sb.append(", url=").append(url);
        sb.append(", resultSize=").append(resultSize);
        sb.append(", startTime=").append(startTime);
        sb.append(", endTime=").append(endTime);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}