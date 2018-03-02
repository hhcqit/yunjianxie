package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * TaskCommentRequest
 */
@Validated

public class TaskCommentRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("service")
  private Integer service = null;

  @JsonProperty("technology")
  private Integer technology = null;

  @JsonProperty("response")
  private Integer response = null;

  @JsonProperty("description")
  private String description = null;

  public TaskCommentRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务主键
   * @return id
  **/
  @ApiModelProperty(value = "任务主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public TaskCommentRequest service(Integer service) {
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

  public TaskCommentRequest technology(Integer technology) {
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

  public TaskCommentRequest response(Integer response) {
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

  public TaskCommentRequest description(String description) {
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
    TaskCommentRequest taskCommentRequest = (TaskCommentRequest) o;
    return Objects.equals(this.id, taskCommentRequest.id) &&
        Objects.equals(this.service, taskCommentRequest.service) &&
        Objects.equals(this.technology, taskCommentRequest.technology) &&
        Objects.equals(this.response, taskCommentRequest.response) &&
        Objects.equals(this.description, taskCommentRequest.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, service, technology, response, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskCommentRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

