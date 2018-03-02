package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TaskRepair
 */
@Validated

public class TaskRepair  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("createUserName")
  private String createUserName = null;

  @JsonProperty("taskId")
  private Long taskId = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("reason")
  private String reason = null;

  @JsonProperty("acceptTime")
  private Date acceptTime = null;

  @JsonProperty("finishedTime")
  private Date finishedTime = null;

  @JsonProperty("visibleStatus")
  private Integer visibleStatus = null;

  public TaskRepair id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务维修主键
   * @return id
  **/
  @ApiModelProperty(value = "任务维修主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskRepair createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")

  @Valid

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public TaskRepair createUser(Long createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * 创建用户
   * @return createUser
  **/
  @ApiModelProperty(value = "创建用户")


  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }

  public TaskRepair createUserName(String createUserName) {
    this.createUserName = createUserName;
    return this;
  }

   /**
   * 创建用户名
   * @return createUserName
  **/
  @ApiModelProperty(value = "创建用户名")


  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public TaskRepair taskId(Long taskId) {
    this.taskId = taskId;
    return this;
  }

   /**
   * 任务主键
   * @return taskId
  **/
  @ApiModelProperty(value = "任务主键")


  public Long getTaskId() {
    return taskId;
  }

  public void setTaskId(Long taskId) {
    this.taskId = taskId;
  }

  public TaskRepair status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、待维修  1、已修好 -1、已退回
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、待维修  1、已修好 -1、已退回")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public TaskRepair description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 维修描述
   * @return description
  **/
  @ApiModelProperty(example = "指示灯异常", value = "维修描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskRepair reason(String reason) {
    this.reason = reason;
    return this;
  }

   /**
   * 退回原因
   * @return reason
  **/
  @ApiModelProperty(example = "不属于我的设备", value = "退回原因")


  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public TaskRepair acceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
    return this;
  }

   /**
   * 受理时间
   * @return acceptTime
  **/
  @ApiModelProperty(value = "受理时间")

  @Valid

  public Date getAcceptTime() {
    return acceptTime;
  }

  public void setAcceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
  }

  public TaskRepair finishedTime(Date finishedTime) {
    this.finishedTime = finishedTime;
    return this;
  }

   /**
   * 完成时间
   * @return finishedTime
  **/
  @ApiModelProperty(value = "完成时间")

  @Valid

  public Date getFinishedTime() {
    return finishedTime;
  }

  public void setFinishedTime(Date finishedTime) {
    this.finishedTime = finishedTime;
  }

  public TaskRepair visibleStatus(Integer visibleStatus) {
    this.visibleStatus = visibleStatus;
    return this;
  }

   /**
   * 报修人是否可见状态<br>0、否  1、是
   * @return visibleStatus
  **/
  @ApiModelProperty(example = "1", value = "报修人是否可见状态<br>0、否  1、是")


  public Integer getVisibleStatus() {
    return visibleStatus;
  }

  public void setVisibleStatus(Integer visibleStatus) {
    this.visibleStatus = visibleStatus;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskRepair taskRepair = (TaskRepair) o;
    return Objects.equals(this.id, taskRepair.id) &&
        Objects.equals(this.createTime, taskRepair.createTime) &&
        Objects.equals(this.createUser, taskRepair.createUser) &&
        Objects.equals(this.createUserName, taskRepair.createUserName) &&
        Objects.equals(this.taskId, taskRepair.taskId) &&
        Objects.equals(this.status, taskRepair.status) &&
        Objects.equals(this.description, taskRepair.description) &&
        Objects.equals(this.reason, taskRepair.reason) &&
        Objects.equals(this.acceptTime, taskRepair.acceptTime) &&
        Objects.equals(this.finishedTime, taskRepair.finishedTime) &&
        Objects.equals(this.visibleStatus, taskRepair.visibleStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, createUser, createUserName, taskId, status, description, reason, acceptTime, finishedTime, visibleStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskRepair {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    finishedTime: ").append(toIndentedString(finishedTime)).append("\n");
    sb.append("    visibleStatus: ").append(toIndentedString(visibleStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

