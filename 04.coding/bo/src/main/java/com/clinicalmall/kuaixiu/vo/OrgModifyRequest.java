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
 * OrgModifyRequest
 */
@Validated

public class OrgModifyRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("owner")
  private Long owner = null;

  @JsonProperty("contact")
  private String contact = null;

  @JsonProperty("telephone")
  private String telephone = null;

  @JsonProperty("email")
  private String email = null;

  @JsonProperty("postcode")
  private String postcode = null;

  @JsonProperty("area")
  private String area = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("qrcodeImg")
  private String qrcodeImg = null;

  @JsonProperty("remark")
  private String remark = null;

  public OrgModifyRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 主键
   * @return id
  **/
  @ApiModelProperty(value = "主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public OrgModifyRequest createTime(Date createTime) {
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

  public OrgModifyRequest updateTime(Date updateTime) {
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

  public OrgModifyRequest type(Integer type) {
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

  public OrgModifyRequest name(String name) {
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

  public OrgModifyRequest owner(Long owner) {
    this.owner = owner;
    return this;
  }

   /**
   * 管理员
   * @return owner
  **/
  @ApiModelProperty(value = "管理员")


  public Long getOwner() {
    return owner;
  }

  public void setOwner(Long owner) {
    this.owner = owner;
  }

  public OrgModifyRequest contact(String contact) {
    this.contact = contact;
    return this;
  }

   /**
   * 联系人
   * @return contact
  **/
  @ApiModelProperty(value = "联系人")


  public String getContact() {
    return contact;
  }

  public void setContact(String contact) {
    this.contact = contact;
  }

  public OrgModifyRequest telephone(String telephone) {
    this.telephone = telephone;
    return this;
  }

   /**
   * 联系电话
   * @return telephone
  **/
  @ApiModelProperty(value = "联系电话")


  public String getTelephone() {
    return telephone;
  }

  public void setTelephone(String telephone) {
    this.telephone = telephone;
  }

  public OrgModifyRequest email(String email) {
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

  public OrgModifyRequest postcode(String postcode) {
    this.postcode = postcode;
    return this;
  }

   /**
   * 邮编
   * @return postcode
  **/
  @ApiModelProperty(value = "邮编")


  public String getPostcode() {
    return postcode;
  }

  public void setPostcode(String postcode) {
    this.postcode = postcode;
  }

  public OrgModifyRequest area(String area) {
    this.area = area;
    return this;
  }

   /**
   * 地区
   * @return area
  **/
  @ApiModelProperty(value = "地区")


  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public OrgModifyRequest address(String address) {
    this.address = address;
    return this;
  }

   /**
   * 地址
   * @return address
  **/
  @ApiModelProperty(value = "地址")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public OrgModifyRequest qrcodeImg(String qrcodeImg) {
    this.qrcodeImg = qrcodeImg;
    return this;
  }

   /**
   * 二维码图片地址
   * @return qrcodeImg
  **/
  @ApiModelProperty(value = "二维码图片地址")


  public String getQrcodeImg() {
    return qrcodeImg;
  }

  public void setQrcodeImg(String qrcodeImg) {
    this.qrcodeImg = qrcodeImg;
  }

  public OrgModifyRequest remark(String remark) {
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
    OrgModifyRequest orgModifyRequest = (OrgModifyRequest) o;
    return Objects.equals(this.id, orgModifyRequest.id) &&
        Objects.equals(this.createTime, orgModifyRequest.createTime) &&
        Objects.equals(this.updateTime, orgModifyRequest.updateTime) &&
        Objects.equals(this.type, orgModifyRequest.type) &&
        Objects.equals(this.name, orgModifyRequest.name) &&
        Objects.equals(this.owner, orgModifyRequest.owner) &&
        Objects.equals(this.contact, orgModifyRequest.contact) &&
        Objects.equals(this.telephone, orgModifyRequest.telephone) &&
        Objects.equals(this.email, orgModifyRequest.email) &&
        Objects.equals(this.postcode, orgModifyRequest.postcode) &&
        Objects.equals(this.area, orgModifyRequest.area) &&
        Objects.equals(this.address, orgModifyRequest.address) &&
        Objects.equals(this.qrcodeImg, orgModifyRequest.qrcodeImg) &&
        Objects.equals(this.remark, orgModifyRequest.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, type, name, owner, contact, telephone, email, postcode, area, address, qrcodeImg, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrgModifyRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    contact: ").append(toIndentedString(contact)).append("\n");
    sb.append("    telephone: ").append(toIndentedString(telephone)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    postcode: ").append(toIndentedString(postcode)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    qrcodeImg: ").append(toIndentedString(qrcodeImg)).append("\n");
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

