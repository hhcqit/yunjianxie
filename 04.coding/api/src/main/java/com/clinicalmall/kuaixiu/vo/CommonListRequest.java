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
 * CommonListRequest
 */
@Validated

public class CommonListRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pageNumber")
  private Integer pageNumber = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  public CommonListRequest pageNumber(Integer pageNumber) {
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

  public CommonListRequest pageSize(Integer pageSize) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonListRequest commonListRequest = (CommonListRequest) o;
    return Objects.equals(this.pageNumber, commonListRequest.pageNumber) &&
        Objects.equals(this.pageSize, commonListRequest.pageSize);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonListRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
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

