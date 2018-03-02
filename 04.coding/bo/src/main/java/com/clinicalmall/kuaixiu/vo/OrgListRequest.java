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
 * OrgListRequest
 */
@Validated

public class OrgListRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pageNumber")
  private Integer pageNumber = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private Integer type = null;

  public OrgListRequest pageNumber(Integer pageNumber) {
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

  public OrgListRequest pageSize(Integer pageSize) {
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

  public OrgListRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 名称
   * @return name
  **/
  @ApiModelProperty(example = "艾迪康", value = "名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrgListRequest type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * 类型<br>0、全部 1、实验室 2、服务商
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型<br>0、全部 1、实验室 2、服务商")


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrgListRequest orgListRequest = (OrgListRequest) o;
    return Objects.equals(this.pageNumber, orgListRequest.pageNumber) &&
        Objects.equals(this.pageSize, orgListRequest.pageSize) &&
        Objects.equals(this.name, orgListRequest.name) &&
        Objects.equals(this.type, orgListRequest.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, name, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgListRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

