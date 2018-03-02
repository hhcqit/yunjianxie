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
 * WorkSaveRequest
 */
@Validated

public class WorkSaveRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("content")
  private String content = null;

  public WorkSaveRequest equipId(Long equipId) {
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

  public WorkSaveRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 计划名称
   * @return name
  **/
  @ApiModelProperty(example = "月底保养", value = "计划名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public WorkSaveRequest type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * 类型<br>1、保养计划 2、检定计划
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型<br>1、保养计划 2、检定计划")


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public WorkSaveRequest content(String content) {
    this.content = content;
    return this;
  }

   /**
   * 计划内容
   * @return content
  **/
  @ApiModelProperty(example = "月底保养", value = "计划内容")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkSaveRequest workSaveRequest = (WorkSaveRequest) o;
    return Objects.equals(this.equipId, workSaveRequest.equipId) &&
        Objects.equals(this.name, workSaveRequest.name) &&
        Objects.equals(this.type, workSaveRequest.type) &&
        Objects.equals(this.content, workSaveRequest.content);
  }

  @Override
  public int hashCode() {
    return Objects.hash(equipId, name, type, content);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkSaveRequest {\n");
    
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
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

