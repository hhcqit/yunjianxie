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
 * EquipmentExamine
 */
@Validated

public class EquipmentExamine  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("reference")
  private String reference = null;

  @JsonProperty("conclusion")
  private String conclusion = null;

  @JsonProperty("examineTime")
  private Date examineTime = null;

  public EquipmentExamine id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 设备验收主键
   * @return id
  **/
  @ApiModelProperty(value = "设备验收主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EquipmentExamine createTime(Date createTime) {
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

  public EquipmentExamine updateTime(Date updateTime) {
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

  public EquipmentExamine equipId(Long equipId) {
    this.equipId = equipId;
    return this;
  }

   /**
   * 设备主键
   * @return equipId
  **/
  @ApiModelProperty(value = "设备主键")


  public Long getEquipId() {
    return equipId;
  }

  public void setEquipId(Long equipId) {
    this.equipId = equipId;
  }

  public EquipmentExamine orgId(Long orgId) {
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

  public EquipmentExamine createUser(Long createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * 创建用户
   * @return createUser
  **/
  @ApiModelProperty(value = "创建用户")


  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }

  public EquipmentExamine updateUser(Long updateUser) {
    this.updateUser = updateUser;
    return this;
  }

   /**
   * 更新用户
   * @return updateUser
  **/
  @ApiModelProperty(value = "更新用户")


  public Long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Long updateUser) {
    this.updateUser = updateUser;
  }

  public EquipmentExamine status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、草稿  1、归档
   * @return status
  **/
  @ApiModelProperty(value = "状态<br>0、草稿  1、归档")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public EquipmentExamine reference(String reference) {
    this.reference = reference;
    return this;
  }

   /**
   * 验收依据
   * @return reference
  **/
  @ApiModelProperty(value = "验收依据")


  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public EquipmentExamine conclusion(String conclusion) {
    this.conclusion = conclusion;
    return this;
  }

   /**
   * 验收结论
   * @return conclusion
  **/
  @ApiModelProperty(value = "验收结论")


  public String getConclusion() {
    return conclusion;
  }

  public void setConclusion(String conclusion) {
    this.conclusion = conclusion;
  }

  public EquipmentExamine examineTime(Date examineTime) {
    this.examineTime = examineTime;
    return this;
  }

   /**
   * 验收时间
   * @return examineTime
  **/
  @ApiModelProperty(value = "验收时间")

  @Valid

  public Date getExamineTime() {
    return examineTime;
  }

  public void setExamineTime(Date examineTime) {
    this.examineTime = examineTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EquipmentExamine equipmentExamine = (EquipmentExamine) o;
    return Objects.equals(this.id, equipmentExamine.id) &&
        Objects.equals(this.createTime, equipmentExamine.createTime) &&
        Objects.equals(this.updateTime, equipmentExamine.updateTime) &&
        Objects.equals(this.equipId, equipmentExamine.equipId) &&
        Objects.equals(this.orgId, equipmentExamine.orgId) &&
        Objects.equals(this.createUser, equipmentExamine.createUser) &&
        Objects.equals(this.updateUser, equipmentExamine.updateUser) &&
        Objects.equals(this.status, equipmentExamine.status) &&
        Objects.equals(this.reference, equipmentExamine.reference) &&
        Objects.equals(this.conclusion, equipmentExamine.conclusion) &&
        Objects.equals(this.examineTime, equipmentExamine.examineTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, equipId, orgId, createUser, updateUser, status, reference, conclusion, examineTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentExamine {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    conclusion: ").append(toIndentedString(conclusion)).append("\n");
    sb.append("    examineTime: ").append(toIndentedString(examineTime)).append("\n");
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

