package com.yaohui.caij.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;

public class TaskDetailQueryRspDTO implements Serializable {

    /**
     *主键
     */
    @ApiModelProperty(name = "主键")
    private Integer id;

    /**
     *任务ID
     */
    @ApiModelProperty(name = "任务ID")
    private Integer taskId;

    /**
     *任务页面
     */
    @ApiModelProperty(name = "任务页面")
    private String url;

    /**
     *结果量
     */
    @ApiModelProperty(name = "结果量")
    private Integer resultSize;

    /**
     *开始时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "开始时间")
    private Date startTime;

    /**
     *结束时间
     */
    @JsonFormat(pattern ="yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(name = "结束时间")
    private Date endTime;

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
    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public Integer getResultSize() {
        return resultSize;
    }

    public void setResultSize(Integer resultSize) {
        this.resultSize = resultSize;
    }
    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }
    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
