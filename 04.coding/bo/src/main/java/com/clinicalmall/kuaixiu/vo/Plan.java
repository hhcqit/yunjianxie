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
 * Plan
 */
@Validated

public class Plan  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("equipName")
  private String equipName = null;

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

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("content")
  private String content = null;

  @JsonProperty("executeCount")
  private Integer executeCount = null;

  @JsonProperty("startTime")
  private Date startTime = null;

  @JsonProperty("latestExecuteTime")
  private Date latestExecuteTime = null;

  @JsonProperty("nextExecuteTime")
  private Date nextExecuteTime = null;

  @JsonProperty("remark")
  private String remark = null;

  public Plan id(Long id) {
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

  public Plan createTime(Date createTime) {
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

  public Plan updateTime(Date updateTime) {
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

  public Plan orgId(Long orgId) {
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

  public Plan createUser(Long createUser) {
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

  public Plan updateUser(Long updateUser) {
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

  public Plan equipId(Long equipId) {
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

  public Plan equipName(String equipName) {
    this.equipName = equipName;
    return this;
  }

   /**
   * 设备名称
   * @return equipName
  **/
  @ApiModelProperty(example = "自动贴标签机", value = "设备名称")


  public String getEquipName() {
    return equipName;
  }

  public void setEquipName(String equipName) {
    this.equipName = equipName;
  }

  public Plan name(String name) {
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

  public Plan type(Integer type) {
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

  public Plan periodType(Integer periodType) {
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

  public Plan period(Integer period) {
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

  public Plan warnDay(Integer warnDay) {
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

  public Plan executePermission(Integer executePermission) {
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

  public Plan status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、未启用  1、启用
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、未启用  1、启用")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Plan content(String content) {
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

  public Plan executeCount(Integer executeCount) {
    this.executeCount = executeCount;
    return this;
  }

   /**
   * 已执行次数
   * @return executeCount
  **/
  @ApiModelProperty(example = "0", value = "已执行次数")


  public Integer getExecuteCount() {
    return executeCount;
  }

  public void setExecuteCount(Integer executeCount) {
    this.executeCount = executeCount;
  }

  public Plan startTime(Date startTime) {
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

  public Plan latestExecuteTime(Date latestExecuteTime) {
    this.latestExecuteTime = latestExecuteTime;
    return this;
  }

   /**
   * 最近执行时间
   * @return latestExecuteTime
  **/
  @ApiModelProperty(value = "最近执行时间")

  @Valid

  public Date getLatestExecuteTime() {
    return latestExecuteTime;
  }

  public void setLatestExecuteTime(Date latestExecuteTime) {
    this.latestExecuteTime = latestExecuteTime;
  }

  public Plan nextExecuteTime(Date nextExecuteTime) {
    this.nextExecuteTime = nextExecuteTime;
    return this;
  }

   /**
   * 下次执行时间
   * @return nextExecuteTime
  **/
  @ApiModelProperty(value = "下次执行时间")

  @Valid

  public Date getNextExecuteTime() {
    return nextExecuteTime;
  }

  public void setNextExecuteTime(Date nextExecuteTime) {
    this.nextExecuteTime = nextExecuteTime;
  }

  public Plan remark(String remark) {
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
    Plan plan = (Plan) o;
    return Objects.equals(this.id, plan.id) &&
        Objects.equals(this.createTime, plan.createTime) &&
        Objects.equals(this.updateTime, plan.updateTime) &&
        Objects.equals(this.orgId, plan.orgId) &&
        Objects.equals(this.createUser, plan.createUser) &&
        Objects.equals(this.updateUser, plan.updateUser) &&
        Objects.equals(this.equipId, plan.equipId) &&
        Objects.equals(this.equipName, plan.equipName) &&
        Objects.equals(this.name, plan.name) &&
        Objects.equals(this.type, plan.type) &&
        Objects.equals(this.periodType, plan.periodType) &&
        Objects.equals(this.period, plan.period) &&
        Objects.equals(this.warnDay, plan.warnDay) &&
        Objects.equals(this.executePermission, plan.executePermission) &&
        Objects.equals(this.status, plan.status) &&
        Objects.equals(this.content, plan.content) &&
        Objects.equals(this.executeCount, plan.executeCount) &&
        Objects.equals(this.startTime, plan.startTime) &&
        Objects.equals(this.latestExecuteTime, plan.latestExecuteTime) &&
        Objects.equals(this.nextExecuteTime, plan.nextExecuteTime) &&
        Objects.equals(this.remark, plan.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, orgId, createUser, updateUser, equipId, equipName, name, type, periodType, period, warnDay, executePermission, status, content, executeCount, startTime, latestExecuteTime, nextExecuteTime, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Plan {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    equipName: ").append(toIndentedString(equipName)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    periodType: ").append(toIndentedString(periodType)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    warnDay: ").append(toIndentedString(warnDay)).append("\n");
    sb.append("    executePermission: ").append(toIndentedString(executePermission)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    executeCount: ").append(toIndentedString(executeCount)).append("\n");
    sb.append("    startTime: ").append(toIndentedString(startTime)).append("\n");
    sb.append("    latestExecuteTime: ").append(toIndentedString(latestExecuteTime)).append("\n");
    sb.append("    nextExecuteTime: ").append(toIndentedString(nextExecuteTime)).append("\n");
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

