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
 * TaskComment
 */
@Validated

public class TaskComment  implements Serializable {
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

  @JsonProperty("service")
  private Integer service = null;

  @JsonProperty("technology")
  private Integer technology = null;

  @JsonProperty("response")
  private Integer response = null;

  @JsonProperty("description")
  private String description = null;

  public TaskComment id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务评价主键
   * @return id
  **/
  @ApiModelProperty(value = "任务评价主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskComment createTime(Date createTime) {
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

  public TaskComment createUser(Long createUser) {
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

  public TaskComment createUserName(String createUserName) {
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

  public TaskComment taskId(Long taskId) {
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

  public TaskComment service(Integer service) {
    this.service = service;
    return this;
  }

   /**
   * 服务态度<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分
   * @return service
  **/
  @ApiModelProperty(example = "5", value = "服务态度<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分")


  public Integer getService() {
    return service;
  }

  public void setService(Integer service) {
    this.service = service;
  }

  public TaskComment technology(Integer technology) {
    this.technology = technology;
    return this;
  }

   /**
   * 技术能力<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分
   * @return technology
  **/
  @ApiModelProperty(example = "5", value = "技术能力<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分")


  public Integer getTechnology() {
    return technology;
  }

  public void setTechnology(Integer technology) {
    this.technology = technology;
  }

  public TaskComment response(Integer response) {
    this.response = response;
    return this;
  }

   /**
   * 响应速度<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分
   * @return response
  **/
  @ApiModelProperty(example = "5", value = "响应速度<br>0、0分 1、1分  2、2分  3、3分  4、4分  5、5分")


  public Integer getResponse() {
    return response;
  }

  public void setResponse(Integer response) {
    this.response = response;
  }

  public TaskComment description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 评价描述
   * @return description
  **/
  @ApiModelProperty(example = "指示灯异常", value = "评价描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskComment taskComment = (TaskComment) o;
    return Objects.equals(this.id, taskComment.id) &&
        Objects.equals(this.createTime, taskComment.createTime) &&
        Objects.equals(this.createUser, taskComment.createUser) &&
        Objects.equals(this.createUserName, taskComment.createUserName) &&
        Objects.equals(this.taskId, taskComment.taskId) &&
        Objects.equals(this.service, taskComment.service) &&
        Objects.equals(this.technology, taskComment.technology) &&
        Objects.equals(this.response, taskComment.response) &&
        Objects.equals(this.description, taskComment.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, createUser, createUserName, taskId, service, technology, response, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskComment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    taskId: ").append(toIndentedString(taskId)).append("\n");
    sb.append("    service: ").append(toIndentedString(service)).append("\n");
    sb.append("    technology: ").append(toIndentedString(technology)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

