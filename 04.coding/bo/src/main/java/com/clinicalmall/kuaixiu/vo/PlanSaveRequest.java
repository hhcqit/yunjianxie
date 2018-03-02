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
 * PlanSaveRequest
 */
@Validated

public class PlanSaveRequest  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("periodType")
  private Integer periodType = null;

  @JsonProperty("period")
  private Integer period = null;

  @JsonProperty("warnDay")
  private Integer warnDay = null;

  @JsonProperty("executePermission")
  private Integer executePermission = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("startTime")
  private Date startTime = null;

  public PlanSaveRequest id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 计划主键
   * @return id
  **/
  @ApiModelProperty(value = "计划主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public PlanSaveRequest equipId(Long equipId) {
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

  public PlanSaveRequest name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 计划名称
   * @return name
  **/
  @ApiModelProperty(example = "月底保养", value = "计划名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PlanSaveRequest type(Integer type) {
    this.type = type;
    return this;
  }

   /**
   * 类型<br>1、保养计划 2、检定计划
   * @return type
  **/
  @ApiModelProperty(example = "1", value = "类型<br>1、保养计划 2、检定计划")


  public Integer getType() {
    return type;
  }

  public void setType(Integer type) {
    this.type = type;
  }

  public PlanSaveRequest periodType(Integer periodType) {
    this.periodType = periodType;
    return this;
  }

   /**
   * 周期类型<br>0、自定义  1、每日 2、每周 3、每月 4、每3月  5、每半年 6、每年
   * @return periodType
  **/
  @ApiModelProperty(example = "0", value = "周期类型<br>0、自定义  1、每日 2、每周 3、每月 4、每3月  5、每半年 6、每年")


  public Integer getPeriodType() {
    return periodType;
  }

  public void setPeriodType(Integer periodType) {
    this.periodType = periodType;
  }

  public PlanSaveRequest period(Integer period) {
    this.period = period;
    return this;
  }

   /**
   * 周期<br>自定义时使用，单位天
   * @return period
  **/
  @ApiModelProperty(example = "0", value = "周期<br>自定义时使用，单位天")


  public Integer getPeriod() {
    return period;
  }

  public void setPeriod(Integer period) {
    this.period = period;
  }

  public PlanSaveRequest warnDay(Integer warnDay) {
    this.warnDay = warnDay;
    return this;
  }

   /**
   * 预警时间<br>自定义时使用，单位天
   * @return warnDay
  **/
  @ApiModelProperty(example = "0", value = "预警时间<br>自定义时使用，单位天")


  public Integer getWarnDay() {
    return warnDay;
  }

  public void setWarnDay(Integer warnDay) {
    this.warnDay = warnDay;
  }

  public PlanSaveRequest executePermission(Integer executePermission) {
    this.executePermission = executePermission;
    return this;
  }

   /**
   * 执行权限<br>0、不限  1、内部 2、外部
   * @return executePermission
  **/
  @ApiModelProperty(example = "0", value = "执行权限<br>0、不限  1、内部 2、外部")


  public Integer getExecutePermission() {
    return executePermission;
  }

  public void setExecutePermission(Integer executePermission) {
    this.executePermission = executePermission;
  }

  public PlanSaveRequest content(String content) {
    this.content = content;
    return this;
  }

   /**
   * 计划内容
   * @return content
  **/
  @ApiModelProperty(example = "月底保养", value = "计划内容")


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public PlanSaveRequest startTime(Date startTime) {
    this.startTime = startTime;
    return this;
  }

   /**
   * 开始时间
   * @return startTime
  **/
  @ApiModelProperty(value = "开始时间")

  @Valid

  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PlanSaveRequest planSaveRequest = (PlanSaveRequest) o;
    return Objects.equals(this.id, planSaveRequest.id) &&
        Objects.equals(this.equipId, planSaveRequest.equipId) &&
        Objects.equals(this.name, planSaveRequest.name) &&
        Objects.equals(this.type, planSaveRequest.type) &&
        Objects.equals(this.periodType, planSaveRequest.periodType) &&
        Objects.equals(this.period, planSaveRequest.period) &&
        Objects.equals(this.warnDay, planSaveRequest.warnDay) &&
        Objects.equals(this.executePermission, planSaveRequest.executePermission) &&
        Objects.equals(this.content, planSaveRequest.content) &&
        Objects.equals(this.startTime, planSaveRequest.startTime);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, equipId, name, type, periodType, period, warnDay, executePermission, content, startTime);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PlanSaveRequest {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    periodType: ").append(toIndentedString(periodType)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    warnDay: ").append(toIndentedString(warnDay)).append("\n");
    sb.append("    executePermission: ").append(toIndentedString(executePermission)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
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

