package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.clinicalmall.kuaixiu.vo.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * UserListResponse
 */
@Validated

public class UserListResponse  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("code")
  private Integer code = null;

  @JsonProperty("msg")
  private String msg = null;

  @JsonProperty("totalRow")
  private Long totalRow = null;

  @JsonProperty("data")
  @Valid
  private List<User> data = null;

  public UserListResponse code(Integer code) {
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

  public UserListResponse msg(String msg) {
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

  public UserListResponse totalRow(Long totalRow) {
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

  public UserListResponse data(List<User> data) {
    this.data = data;
    return this;
  }

  public UserListResponse addDataItem(User dataItem) {
    if (this.data == null) {
      this.data = new ArrayList<User>();
    }
    this.data.add(dataItem);
    return this;
  }

   /**
   * Get data
   * @return data
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<User> getData() {
    return data;
  }

  public void setData(List<User> data) {
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
    UserListResponse userListResponse = (UserListResponse) o;
    return Objects.equals(this.code, userListResponse.code) &&
        Objects.equals(this.msg, userListResponse.msg) &&
        Objects.equals(this.totalRow, userListResponse.totalRow) &&
        Objects.equals(this.data, userListResponse.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, msg, totalRow, data);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserListResponse {\n");
    
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

