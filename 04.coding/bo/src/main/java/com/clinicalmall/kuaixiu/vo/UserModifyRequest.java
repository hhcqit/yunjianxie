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
 * UserModifyRequest
 */
@Validated

public class UserModifyRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("dept")
  private String dept = null;

  @JsonProperty("realName")
  private String realName = null;

  @JsonProperty("email")
  private String email = null;

  public UserModifyRequest dept(String dept) {
    this.dept = dept;
    return this;
  }

   /**
   * 部门
   * @return dept
  **/
  @ApiModelProperty(value = "部门")


  public String getDept() {
    return dept;
  }

  public void setDept(String dept) {
    this.dept = dept;
  }

  public UserModifyRequest realName(String realName) {
    this.realName = realName;
    return this;
  }

   /**
   * 真实姓名
   * @return realName
  **/
  @ApiModelProperty(value = "真实姓名")


  public String getRealName() {
    return realName;
  }

  public void setRealName(String realName) {
    this.realName = realName;
  }

  public UserModifyRequest email(String email) {
    this.email = email;
    return this;
  }

   /**
   * 邮箱
   * @return email
  **/
  @ApiModelProperty(value = "邮箱")


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserModifyRequest userModifyRequest = (UserModifyRequest) o;
    return Objects.equals(this.dept, userModifyRequest.dept) &&
        Objects.equals(this.realName, userModifyRequest.realName) &&
        Objects.equals(this.email, userModifyRequest.email);
  }

  @Override
  public int hashCode() {
    return Objects.hash(dept, realName, email);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserModifyRequest {\n");
    
    sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
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

