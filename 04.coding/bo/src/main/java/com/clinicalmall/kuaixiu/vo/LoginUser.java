package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.clinicalmall.kuaixiu.vo.Org;
import com.clinicalmall.kuaixiu.vo.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * LoginUser
 */
@Validated

public class LoginUser  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("token")
  private String token = null;

  @JsonProperty("user")
  private User user = null;

  @JsonProperty("org")
  private Org org = null;

  public LoginUser token(String token) {
    this.token = token;
    return this;
  }

   /**
   * 会话令牌
   * @return token
  **/
  @ApiModelProperty(value = "会话令牌")


  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public LoginUser user(User user) {
    this.user = user;
    return this;
  }

   /**
   * Get user
   * @return user
  **/
  @ApiModelProperty(value = "")

  @Valid

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public LoginUser org(Org org) {
    this.org = org;
    return this;
  }

   /**
   * Get org
   * @return org
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Org getOrg() {
    return org;
  }

  public void setOrg(Org org) {
    this.org = org;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginUser loginUser = (LoginUser) o;
    return Objects.equals(this.token, loginUser.token) &&
        Objects.equals(this.user, loginUser.user) &&
        Objects.equals(this.org, loginUser.org);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token, user, org);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginUser {\n");
    
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    org: ").append(toIndentedString(org)).append("\n");
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

