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
 * EquipmentExamineItem
 */
@Validated

public class EquipmentExamineItem  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("examineId")
  private Long examineId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("unit")
  private String unit = null;

  @JsonProperty("standardValue")
  private String standardValue = null;

  @JsonProperty("measureValue")
  private String measureValue = null;

  @JsonProperty("deviationValue")
  private String deviationValue = null;

  @JsonProperty("isQualified")
  private Integer isQualified = null;

  @JsonProperty("remark")
  private String remark = null;

  public EquipmentExamineItem id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 设备验收项目主键
   * @return id
  **/
  @ApiModelProperty(value = "设备验收项目主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public EquipmentExamineItem createTime(Date createTime) {
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

  public EquipmentExamineItem updateTime(Date updateTime) {
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

  public EquipmentExamineItem createUser(Long createUser) {
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

  public EquipmentExamineItem updateUser(Long updateUser) {
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

  public EquipmentExamineItem examineId(Long examineId) {
    this.examineId = examineId;
    return this;
  }

   /**
   * 设备验收主键
   * @return examineId
  **/
  @ApiModelProperty(value = "设备验收主键")


  public Long getExamineId() {
    return examineId;
  }

  public void setExamineId(Long examineId) {
    this.examineId = examineId;
  }

  public EquipmentExamineItem name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 项目名称
   * @return name
  **/
  @ApiModelProperty(value = "项目名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public EquipmentExamineItem unit(String unit) {
    this.unit = unit;
    return this;
  }

   /**
   * 计量单位
   * @return unit
  **/
  @ApiModelProperty(value = "计量单位")


  public String getUnit() {
    return unit;
  }

  public void setUnit(String unit) {
    this.unit = unit;
  }

  public EquipmentExamineItem standardValue(String standardValue) {
    this.standardValue = standardValue;
    return this;
  }

   /**
   * 标准值
   * @return standardValue
  **/
  @ApiModelProperty(value = "标准值")


  public String getStandardValue() {
    return standardValue;
  }

  public void setStandardValue(String standardValue) {
    this.standardValue = standardValue;
  }

  public EquipmentExamineItem measureValue(String measureValue) {
    this.measureValue = measureValue;
    return this;
  }

   /**
   * 测量值
   * @return measureValue
  **/
  @ApiModelProperty(value = "测量值")


  public String getMeasureValue() {
    return measureValue;
  }

  public void setMeasureValue(String measureValue) {
    this.measureValue = measureValue;
  }

  public EquipmentExamineItem deviationValue(String deviationValue) {
    this.deviationValue = deviationValue;
    return this;
  }

   /**
   * 误差值
   * @return deviationValue
  **/
  @ApiModelProperty(value = "误差值")


  public String getDeviationValue() {
    return deviationValue;
  }

  public void setDeviationValue(String deviationValue) {
    this.deviationValue = deviationValue;
  }

  public EquipmentExamineItem isQualified(Integer isQualified) {
    this.isQualified = isQualified;
    return this;
  }

   /**
   * 是否合格<br>0、不合格  1、合格
   * @return isQualified
  **/
  @ApiModelProperty(value = "是否合格<br>0、不合格  1、合格")


  public Integer getIsQualified() {
    return isQualified;
  }

  public void setIsQualified(Integer isQualified) {
    this.isQualified = isQualified;
  }

  public EquipmentExamineItem remark(String remark) {
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
    EquipmentExamineItem equipmentExamineItem = (EquipmentExamineItem) o;
    return Objects.equals(this.id, equipmentExamineItem.id) &&
        Objects.equals(this.createTime, equipmentExamineItem.createTime) &&
        Objects.equals(this.updateTime, equipmentExamineItem.updateTime) &&
        Objects.equals(this.createUser, equipmentExamineItem.createUser) &&
        Objects.equals(this.updateUser, equipmentExamineItem.updateUser) &&
        Objects.equals(this.examineId, equipmentExamineItem.examineId) &&
        Objects.equals(this.name, equipmentExamineItem.name) &&
        Objects.equals(this.unit, equipmentExamineItem.unit) &&
        Objects.equals(this.standardValue, equipmentExamineItem.standardValue) &&
        Objects.equals(this.measureValue, equipmentExamineItem.measureValue) &&
        Objects.equals(this.deviationValue, equipmentExamineItem.deviationValue) &&
        Objects.equals(this.isQualified, equipmentExamineItem.isQualified) &&
        Objects.equals(this.remark, equipmentExamineItem.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, createUser, updateUser, examineId, name, unit, standardValue, measureValue, deviationValue, isQualified, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EquipmentExamineItem {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    examineId: ").append(toIndentedString(examineId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    unit: ").append(toIndentedString(unit)).append("\n");
    sb.append("    standardValue: ").append(toIndentedString(standardValue)).append("\n");
    sb.append("    measureValue: ").append(toIndentedString(measureValue)).append("\n");
    sb.append("    deviationValue: ").append(toIndentedString(deviationValue)).append("\n");
    sb.append("    isQualified: ").append(toIndentedString(isQualified)).append("\n");
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

