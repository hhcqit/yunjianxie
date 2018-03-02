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
 * UserRegisterRequest
 */
@Validated

public class UserRegisterRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  public UserRegisterRequest mobile(String mobile) {
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

  public UserRegisterRequest password(String password) {
    this.password = password;
    return this;
  }

   /**
   * 密码
   * @return password
  **/
  @ApiModelProperty(example = "123456", value = "密码")


  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRegisterRequest code(String code) {
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

  public UserRegisterRequest orgId(Long orgId) {
    this.orgId = orgId;
    return this;
  }

   /**
   * 组织主键
   * @return orgId
  **/
  @ApiModelProperty(value = "组织主键")


  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserRegisterRequest userRegisterRequest = (UserRegisterRequest) o;
    return Objects.equals(this.mobile, userRegisterRequest.mobile) &&
        Objects.equals(this.password, userRegisterRequest.password) &&
        Objects.equals(this.code, userRegisterRequest.code) &&
        Objects.equals(this.orgId, userRegisterRequest.orgId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mobile, password, code, orgId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserRegisterRequest {\n");
    
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
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

