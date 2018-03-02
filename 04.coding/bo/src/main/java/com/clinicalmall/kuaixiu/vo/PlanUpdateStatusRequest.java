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
 * PlanUpdateStatusRequest
 */
@Validated

public class PlanUpdateStatusRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("status")
  private Integer status = null;

  public PlanUpdateStatusRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 计划主键
   * @return id
  **/
  @ApiModelProperty(value = "计划主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PlanUpdateStatusRequest status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、未启用  1、启用
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、未启用  1、启用")


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
    PlanUpdateStatusRequest planUpdateStatusRequest = (PlanUpdateStatusRequest) o;
    return Objects.equals(this.id, planUpdateStatusRequest.id) &&
        Objects.equals(this.status, planUpdateStatusRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanUpdateStatusRequest {\n");
    
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

