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
 * TaskListRequest
 */
@Validated

public class TaskListRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("pageNumber")
  private Integer pageNumber = null;

  @JsonProperty("pageSize")
  private Integer pageSize = null;

  @JsonProperty("own")
  private Integer own = null;

  @JsonProperty("status")
  private Integer status = null;

  public TaskListRequest pageNumber(Integer pageNumber) {
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

  public TaskListRequest pageSize(Integer pageSize) {
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

  public TaskListRequest own(Integer own) {
    this.own = own;
    return this;
  }

   /**
   * 是否只查询自己的<br>0：所有的  1：自己的
   * @return own
  **/
  @ApiModelProperty(example = "0", value = "是否只查询自己的<br>0：所有的  1：自己的")


  public Integer getOwn() {
    return own;
  }

  public void setOwn(Integer own) {
    this.own = own;
  }

  public TaskListRequest status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 报修人<br>1：未完成  2：已完成 3：已撤销<br> 维修人<br>11：新报修  12：待维修  13：已修好
   * @return status
  **/
  @ApiModelProperty(example = "1", value = "报修人<br>1：未完成  2：已完成 3：已撤销<br> 维修人<br>11：新报修  12：待维修  13：已修好")


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
    TaskListRequest taskListRequest = (TaskListRequest) o;
    return Objects.equals(this.pageNumber, taskListRequest.pageNumber) &&
        Objects.equals(this.pageSize, taskListRequest.pageSize) &&
        Objects.equals(this.own, taskListRequest.own) &&
        Objects.equals(this.status, taskListRequest.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(pageNumber, pageSize, own, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TaskListRequest {\n");
    
    sb.append("    pageNumber: ").append(toIndentedString(pageNumber)).append("\n");
    sb.append("    pageSize: ").append(toIndentedString(pageSize)).append("\n");
    sb.append("    own: ").append(toIndentedString(own)).append("\n");
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

