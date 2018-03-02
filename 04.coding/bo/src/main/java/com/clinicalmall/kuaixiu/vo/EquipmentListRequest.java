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
 * EquipmentListRequest
 */
@Validated

public class EquipmentListRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pageNumber")
  private Integer pageNumber = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("labId")
  private Long labId = null;

  @JsonProperty("providerId")
  private Long providerId = null;

  @JsonProperty("own")
  private Integer own = null;

  @JsonProperty("bind")
  private Integer bind = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private Integer status = null;

  public EquipmentListRequest pageNumber(Integer pageNumber) {
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

  public EquipmentListRequest pageSize(Integer pageSize) {
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

  public EquipmentListRequest labId(Long labId) {
    this.labId = labId;
    return this;
  }

   /**
   * 实验室主键
   * @return labId
  **/
  @ApiModelProperty(value = "实验室主键")


  public Long getLabId() {
    return labId;
  }

  public void setLabId(Long labId) {
    this.labId = labId;
  }

  public EquipmentListRequest providerId(Long providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * 服务商主键
   * @return providerId
  **/
  @ApiModelProperty(value = "服务商主键")


  public Long getProviderId() {
    return providerId;
  }

  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  public EquipmentListRequest own(Integer own) {
    this.own = own;
    return this;
  }

   /**
   * 是否只查询自己维护的<br>null或0：所有的  1：自己的
   * @return own
  **/
  @ApiModelProperty(value = "是否只查询自己维护的<br>null或0：所有的  1：自己的")


  public Integer getOwn() {
    return own;
  }

  public void setOwn(Integer own) {
    this.own = own;
  }

  public EquipmentListRequest bind(Integer bind) {
    this.bind = bind;
    return this;
  }

   /**
   * 是否绑定实验室/服务商<br>不传值：全部 0：未绑定 1：已绑定
   * @return bind
  **/
  @ApiModelProperty(value = "是否绑定实验室/服务商<br>不传值：全部 0：未绑定 1：已绑定")


  public Integer getBind() {
    return bind;
  }

  public void setBind(Integer bind) {
    this.bind = bind;
  }

  public EquipmentListRequest code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 设备编号
   * @return code
  **/
  @ApiModelProperty(example = "10001", value = "设备编号")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public EquipmentListRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 设备名称
   * @return name
  **/
  @ApiModelProperty(example = "自动贴标签机", value = "设备名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EquipmentListRequest status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 不传值：全部 0：未启用 1：启用
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "不传值：全部 0：未启用 1：启用")


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
    EquipmentListRequest equipmentListRequest = (EquipmentListRequest) o;
    return Objects.equals(this.pageNumber, equipmentListRequest.pageNumber) &&
        Objects.equals(this.pageSize, equipmentListRequest.pageSize) &&
        Objects.equals(this.labId, equipmentListRequest.labId) &&
        Objects.equals(this.providerId, equipmentListRequest.providerId) &&
        Objects.equals(this.own, equipmentListRequest.own) &&
        Objects.equals(this.bind, equipmentListRequest.bind) &&
        Objects.equals(this.code, equipmentListRequest.code) &&
        Objects.equals(this.name, equipmentListRequest.name) &&
        Objects.equals(this.status, equipmentListRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, labId, providerId, own, bind, code, name, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentListRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    labId: ").append(toIndentedString(labId)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    own: ").append(toIndentedString(own)).append("\n");
    sb.append("    bind: ").append(toIndentedString(bind)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

