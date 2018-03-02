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
 * WorkListRequest
 */
@Validated

public class WorkListRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pageNumber")
  private Integer pageNumber = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private Integer status = null;

  public WorkListRequest pageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
    return this;
  }

   /**
   * 页码
   * minimum: 0
   * @return pageNumber
  **/
  @ApiModelProperty(example = "0", value = "页码")

@Min(0)
  public Integer getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(Integer pageNumber) {
    this.pageNumber = pageNumber;
  }

  public WorkListRequest pageSize(Integer pageSize) {
    this.pageSize = pageSize;
    return this;
  }

   /**
   * 页大小
   * minimum: 0
   * @return pageSize
  **/
  @ApiModelProperty(example = "10", value = "页大小")

@Min(0)
  public Integer getPageSize() {
    return pageSize;
  }

  public void setPageSize(Integer pageSize) {
    this.pageSize = pageSize;
  }

  public WorkListRequest type(Integer type) {
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

  public WorkListRequest equipId(Long equipId) {
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

  public WorkListRequest name(String name) {
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

  public WorkListRequest status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 不传值：全部 0、未开始 1、执行中 2、待确认 3、已完成
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "不传值：全部 0、未开始 1、执行中 2、待确认 3、已完成")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    WorkListRequest workListRequest = (WorkListRequest) o;
    return Objects.equals(this.pageNumber, workListRequest.pageNumber) &&
        Objects.equals(this.pageSize, workListRequest.pageSize) &&
        Objects.equals(this.type, workListRequest.type) &&
        Objects.equals(this.equipId, workListRequest.equipId) &&
        Objects.equals(this.name, workListRequest.name) &&
        Objects.equals(this.status, workListRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, type, equipId, name, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class WorkListRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

