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
 * SendSmsCodeRequest
 */
@Validated

public class SendSmsCodeRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("mobile")
  private String mobile = null;

  public SendSmsCodeRequest type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * 类型<br>1、注册 2、找回密码 3、动态密码登录
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型<br>1、注册 2、找回密码 3、动态密码登录")


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public SendSmsCodeRequest mobile(String mobile) {
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


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendSmsCodeRequest sendSmsCodeRequest = (SendSmsCodeRequest) o;
    return Objects.equals(this.type, sendSmsCodeRequest.type) &&
        Objects.equals(this.mobile, sendSmsCodeRequest.mobile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, mobile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendSmsCodeRequest {\n");
    
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    mobile: ").append(toIndentedString(mobile)).append("\n");
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

