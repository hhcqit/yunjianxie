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
 * EquipmentUpdateStatusRequest
 */
@Validated

public class EquipmentUpdateStatusRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private Integer status = null;

  public EquipmentUpdateStatusRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 设备主键
   * @return id
  **/
  @ApiModelProperty(value = "设备主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EquipmentUpdateStatusRequest status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、未启用  1、已启用
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、未启用  1、已启用")


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
    EquipmentUpdateStatusRequest equipmentUpdateStatusRequest = (EquipmentUpdateStatusRequest) o;
    return Objects.equals(this.id, equipmentUpdateStatusRequest.id) &&
        Objects.equals(this.status, equipmentUpdateStatusRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentUpdateStatusRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

