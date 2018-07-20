package com.yaohui.caij.controller.response;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class TaskDTO {

  private Integer id;
  private String name;
  private Boolean isDynamic;
  private Integer status;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  private Date createdAt;

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

  public Boolean getDynamic() {
    return isDynamic;
  }

  public void setDynamic(Boolean dynamic) {
    isDynamic = dynamic;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}
