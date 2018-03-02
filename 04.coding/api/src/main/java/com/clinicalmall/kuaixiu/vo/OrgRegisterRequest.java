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
 * OrgRegisterRequest
 */
@Validated

public class OrgRegisterRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("mobile")
  private String mobile = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("code")
  private String code = null;

  public OrgRegisterRequest type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * 类型<br>1、实验室 2、服务商
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型<br>1、实验室 2、服务商")


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public OrgRegisterRequest mobile(String mobile) {
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

  public OrgRegisterRequest name(String name) {
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

  public OrgRegisterRequest password(String password) {
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

  public OrgRegisterRequest code(String code) {
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
    OrgRegisterRequest orgRegisterRequest = (OrgRegisterRequest) o;
    return Objects.equals(this.type, orgRegisterRequest.type) &&
        Objects.equals(this.mobile, orgRegisterRequest.mobile) &&
        Objects.equals(this.name, orgRegisterRequest.name) &&
        Objects.equals(this.password, orgRegisterRequest.password) &&
        Objects.equals(this.code, orgRegisterRequest.code);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, mobile, name, password, code);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgRegisterRequest {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

