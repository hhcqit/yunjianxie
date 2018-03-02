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
 * TaskSaveRequest
 */
@Validated

public class TaskSaveRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("attachmentIds")
  private String attachmentIds = null;

  public TaskSaveRequest equipId(Long equipId) {
    this.equipId = equipId;
    return this;
  }

   /**
   * 设备主键
   * @return equipId
  **/
  @ApiModelProperty(value = "设备主键")


  public Long getEquipId() {
    return equipId;
  }

  public void setEquipId(Long equipId) {
    this.equipId = equipId;
  }

  public TaskSaveRequest description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 任务描述
   * @return description
  **/
  @ApiModelProperty(example = "指示灯异常", value = "任务描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public TaskSaveRequest attachmentIds(String attachmentIds) {
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
    TaskSaveRequest taskSaveRequest = (TaskSaveRequest) o;
    return Objects.equals(this.equipId, taskSaveRequest.equipId) &&
        Objects.equals(this.description, taskSaveRequest.description) &&
        Objects.equals(this.attachmentIds, taskSaveRequest.attachmentIds);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipId, description, attachmentIds);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskSaveRequest {\n");
    
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
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

