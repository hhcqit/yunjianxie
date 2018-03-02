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
 * CommonResponse
 */
@Validated

public class CommonResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("msg")
  private String msg = null;

  @JsonProperty("totalRow")
  private Long totalRow = null;

  @JsonProperty("data")
  private String data = null;

  public CommonResponse code(Integer code) {
    this.code = code;
    return this;
  }

   /**
   * 响应码<br>0：成功，其他失败，小于0为系统错误，        大于0为业务错误，1为会话超时，需要重新登录
   * @return code
  **/
  @ApiModelProperty(value = "响应码<br>0：成功，其他失败，小于0为系统错误，        大于0为业务错误，1为会话超时，需要重新登录")


  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public CommonResponse msg(String msg) {
    this.msg = msg;
    return this;
  }

   /**
   * 响应说明
   * @return msg
  **/
  @ApiModelProperty(value = "响应说明")


  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public CommonResponse totalRow(Long totalRow) {
    this.totalRow = totalRow;
    return this;
  }

   /**
   * 总记录数
   * @return totalRow
  **/
  @ApiModelProperty(value = "总记录数")


  public Long getTotalRow() {
    return totalRow;
  }

  public void setTotalRow(Long totalRow) {
    this.totalRow = totalRow;
  }

  public CommonResponse data(String data) {
    this.data = data;
    return this;
  }

   /**
   * 业务数据
   * @return data
  **/
  @ApiModelProperty(value = "业务数据")


  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CommonResponse commonResponse = (CommonResponse) o;
    return Objects.equals(this.code, commonResponse.code) &&
        Objects.equals(this.msg, commonResponse.msg) &&
        Objects.equals(this.totalRow, commonResponse.totalRow) &&
        Objects.equals(this.data, commonResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, msg, totalRow, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CommonResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    msg: ").append(toIndentedString(msg)).append("\n");
    sb.append("    totalRow: ").append(toIndentedString(totalRow)).append("\n");
    sb.append("    data: ").append(toIndentedString(data)).append("\n");
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

