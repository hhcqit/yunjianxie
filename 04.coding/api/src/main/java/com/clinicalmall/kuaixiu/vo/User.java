package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * User
 */
@Validated

public class User  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("dept")
  private String dept = null;

  @JsonProperty("userType")
  private Integer userType = null;

  @JsonProperty("userName")
  private String userName = null;

  @JsonProperty("password")
  private String password = null;

  @JsonProperty("realName")
  private String realName = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("blacklistFlag")
  private Integer blacklistFlag = null;

  @JsonProperty("headImgUrl")
  private String headImgUrl = null;

  @JsonProperty("remark")
  private String remark = null;

  public User id(Long id) {
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

  public User createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")

  @Valid

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public User updateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * 更新时间
   * @return updateTime
  **/
  @ApiModelProperty(value = "更新时间")

  @Valid

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public User orgId(Long orgId) {
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

  public User dept(String dept) {
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

  public User userType(Integer userType) {
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

  public User userName(String userName) {
    this.userName = userName;
    return this;
  }

   /**
   * 用户名
   * @return userName
  **/
  @ApiModelProperty(example = "13588441519", value = "用户名")


  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public User password(String password) {
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

  public User realName(String realName) {
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

  public User email(String email) {
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

  public User blacklistFlag(Integer blacklistFlag) {
    this.blacklistFlag = blacklistFlag;
    return this;
  }

   /**
   * 黑名单标记<br>0、否  1、是
   * @return blacklistFlag
  **/
  @ApiModelProperty(value = "黑名单标记<br>0、否  1、是")


  public Integer getBlacklistFlag() {
    return blacklistFlag;
  }

  public void setBlacklistFlag(Integer blacklistFlag) {
    this.blacklistFlag = blacklistFlag;
  }

  public User headImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
    return this;
  }

   /**
   * 头像
   * @return headImgUrl
  **/
  @ApiModelProperty(value = "头像")


  public String getHeadImgUrl() {
    return headImgUrl;
  }

  public void setHeadImgUrl(String headImgUrl) {
    this.headImgUrl = headImgUrl;
  }

  public User remark(String remark) {
    this.remark = remark;
    return this;
  }

   /**
   * 备注
   * @return remark
  **/
  @ApiModelProperty(value = "备注")


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return Objects.equals(this.id, user.id) &&
        Objects.equals(this.createTime, user.createTime) &&
        Objects.equals(this.updateTime, user.updateTime) &&
        Objects.equals(this.orgId, user.orgId) &&
        Objects.equals(this.dept, user.dept) &&
        Objects.equals(this.userType, user.userType) &&
        Objects.equals(this.userName, user.userName) &&
        Objects.equals(this.password, user.password) &&
        Objects.equals(this.realName, user.realName) &&
        Objects.equals(this.email, user.email) &&
        Objects.equals(this.blacklistFlag, user.blacklistFlag) &&
        Objects.equals(this.headImgUrl, user.headImgUrl) &&
        Objects.equals(this.remark, user.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, orgId, dept, userType, userName, password, realName, email, blacklistFlag, headImgUrl, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class User {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    dept: ").append(toIndentedString(dept)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("    password: ").append(toIndentedString(password)).append("\n");
    sb.append("    realName: ").append(toIndentedString(realName)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    blacklistFlag: ").append(toIndentedString(blacklistFlag)).append("\n");
    sb.append("    headImgUrl: ").append(toIndentedString(headImgUrl)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
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

