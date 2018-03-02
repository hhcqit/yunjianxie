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
 * UserModifyPwdRequest
 */
@Validated

public class UserModifyPwdRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("oldPassword")
  private String oldPassword = null;

  @JsonProperty("newPassword")
  private String newPassword = null;

  public UserModifyPwdRequest oldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
    return this;
  }

   /**
   * 旧密码
   * @return oldPassword
  **/
  @ApiModelProperty(value = "旧密码")


  public String getOldPassword() {
    return oldPassword;
  }

  public void setOldPassword(String oldPassword) {
    this.oldPassword = oldPassword;
  }

  public UserModifyPwdRequest newPassword(String newPassword) {
    this.newPassword = newPassword;
    return this;
  }

   /**
   * 新密码
   * @return newPassword
  **/
  @ApiModelProperty(value = "新密码")


  public String getNewPassword() {
    return newPassword;
  }

  public void setNewPassword(String newPassword) {
    this.newPassword = newPassword;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UserModifyPwdRequest userModifyPwdRequest = (UserModifyPwdRequest) o;
    return Objects.equals(this.oldPassword, userModifyPwdRequest.oldPassword) &&
        Objects.equals(this.newPassword, userModifyPwdRequest.newPassword);
  }

  @Override
  public int hashCode() {
    return Objects.hash(oldPassword, newPassword);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UserModifyPwdRequest {\n");
    
    sb.append("    oldPassword: ").append(toIndentedString(oldPassword)).append("\n");
    sb.append("    newPassword: ").append(toIndentedString(newPassword)).append("\n");
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

