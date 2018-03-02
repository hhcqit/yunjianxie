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
 * TaskExecuteRequest
 */
@Validated

public class TaskExecuteRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("visibleStatus")
  private Integer visibleStatus = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("attachmentIds")
  private String attachmentIds = null;

  public TaskExecuteRequest id(Long id) {
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

  public TaskExecuteRequest visibleStatus(Integer visibleStatus) {
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

  public TaskExecuteRequest description(String description) {
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

  public TaskExecuteRequest attachmentIds(String attachmentIds) {
    this.attachmentIds = attachmentIds;
    return this;
  }

   /**
   * 附件主键列表,格式：id1,id2,...
   * @return attachmentIds
  **/
  @ApiModelProperty(example = "1,2", value = "附件主键列表,格式：id1,id2,...")


  public String getAttachmentIds() {
    return attachmentIds;
  }

  public void setAttachmentIds(String attachmentIds) {
    this.attachmentIds = attachmentIds;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TaskExecuteRequest taskExecuteRequest = (TaskExecuteRequest) o;
    return Objects.equals(this.id, taskExecuteRequest.id) &&
        Objects.equals(this.visibleStatus, taskExecuteRequest.visibleStatus) &&
        Objects.equals(this.description, taskExecuteRequest.description) &&
        Objects.equals(this.attachmentIds, taskExecuteRequest.attachmentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, visibleStatus, description, attachmentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskExecuteRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    visibleStatus: ").append(toIndentedString(visibleStatus)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    attachmentIds: ").append(toIndentedString(attachmentIds)).append("\n");
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

