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
 * UserModifyTypeRequest
 */
@Validated

public class UserModifyTypeRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("userType")
  private Integer userType = null;

  public UserModifyTypeRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 用户主键
   * @return id
  **/
  @ApiModelProperty(value = "用户主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public UserModifyTypeRequest userType(Integer userType) {
    this.userType = userType;
    return this;
  }

   /**
   * 用户类型<br>0、系统管理员  1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户
   * @return userType
  **/
  @ApiModelProperty(example = "1", value = "用户类型<br>0、系统管理员  1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户")


  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserModifyTypeRequest userModifyTypeRequest = (UserModifyTypeRequest) o;
    return Objects.equals(this.id, userModifyTypeRequest.id) &&
        Objects.equals(this.userType, userModifyTypeRequest.userType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, userType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserModifyTypeRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
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

