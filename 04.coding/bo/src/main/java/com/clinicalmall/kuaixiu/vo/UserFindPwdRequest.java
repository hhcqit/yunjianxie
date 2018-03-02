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
 * UserFindPwdRequest
 */
@Validated

public class UserFindPwdRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("code")
  private String code = null;

  public UserFindPwdRequest mobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

   /**
   * 手机号码
   * @return mobile
  **/
  @ApiModelProperty(example = "13588441519", value = "手机号码")


  public String getMobile() {
    return mobile;
  }

  public void setMobile(String mobile) {
    this.mobile = mobile;
  }

  public UserFindPwdRequest password(String password) {
    this.password = password;
    return this;
  }

   /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(value = "密码")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserFindPwdRequest code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 短信验证码
   * @return code
  **/
  @ApiModelProperty(value = "短信验证码")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserFindPwdRequest userFindPwdRequest = (UserFindPwdRequest) o;
    return Objects.equals(this.mobile, userFindPwdRequest.mobile) &&
        Objects.equals(this.password, userFindPwdRequest.password) &&
        Objects.equals(this.code, userFindPwdRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobile, password, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserFindPwdRequest {\n");
    
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
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

