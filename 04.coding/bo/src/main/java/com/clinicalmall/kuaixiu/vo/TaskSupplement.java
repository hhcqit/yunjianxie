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
 * TaskSupplement
 */
@Validated

public class TaskSupplement  implements Serializable {
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

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("visibleStatus")
  private Integer visibleStatus = null;

  public TaskSupplement id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务补充主键
   * @return id
  **/
  @ApiModelProperty(value = "任务补充主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskSupplement createTime(Date createTime) {
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

  public TaskSupplement createUser(Long createUser) {
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

  public TaskSupplement createUserName(String createUserName) {
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

  public TaskSupplement taskId(Long taskId) {
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

  public TaskSupplement description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 补充描述
   * @return description
  **/
  @ApiModelProperty(example = "指示灯异常", value = "补充描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskSupplement visibleStatus(Integer visibleStatus) {
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
    TaskSupplement taskSupplement = (TaskSupplement) o;
    return Objects.equals(this.id, taskSupplement.id) &&
        Objects.equals(this.createTime, taskSupplement.createTime) &&
        Objects.equals(this.createUser, taskSupplement.createUser) &&
        Objects.equals(this.createUserName, taskSupplement.createUserName) &&
        Objects.equals(this.taskId, taskSupplement.taskId) &&
        Objects.equals(this.description, taskSupplement.description) &&
        Objects.equals(this.visibleStatus, taskSupplement.visibleStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, createUser, createUserName, taskId, description, visibleStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskSupplement {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

