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
 * Work
 */
@Validated

public class Work  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("labId")
  private Long labId = null;

  @JsonProperty("providerId")
  private Long providerId = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("equipName")
  private String equipName = null;

  @JsonProperty("planId")
  private Long planId = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("type")
  private Integer type = null;

  @JsonProperty("origin")
  private Integer origin = null;

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

  @JsonProperty("result")
  private String result = null;

  @JsonProperty("certificateNo")
  private String certificateNo = null;

  @JsonProperty("certificateFileName")
  private String certificateFileName = null;

  @JsonProperty("certificateFilePath")
  private String certificateFilePath = null;

  @JsonProperty("executeOrgId")
  private Long executeOrgId = null;

  @JsonProperty("executeUser")
  private Long executeUser = null;

  @JsonProperty("executeUserName")
  private String executeUserName = null;

  @JsonProperty("acceptTime")
  private Date acceptTime = null;

  @JsonProperty("executeTime")
  private Date executeTime = null;

  @JsonProperty("finishedTime")
  private Date finishedTime = null;

  @JsonProperty("remark")
  private String remark = null;

  public Work id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 作业主键
   * @return id
  **/
  @ApiModelProperty(value = "作业主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Work createTime(Date createTime) {
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

  public Work updateTime(Date updateTime) {
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

  public Work orgId(Long orgId) {
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

  public Work labId(Long labId) {
    this.labId = labId;
    return this;
  }

   /**
   * 实验室主键
   * @return labId
  **/
  @ApiModelProperty(value = "实验室主键")


  public Long getLabId() {
    return labId;
  }

  public void setLabId(Long labId) {
    this.labId = labId;
  }

  public Work providerId(Long providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * 服务商主键
   * @return providerId
  **/
  @ApiModelProperty(value = "服务商主键")


  public Long getProviderId() {
    return providerId;
  }

  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  public Work createUser(Long createUser) {
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

  public Work updateUser(Long updateUser) {
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

  public Work equipId(Long equipId) {
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

  public Work equipName(String equipName) {
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

  public Work planId(Long planId) {
    this.planId = planId;
    return this;
  }

   /**
   * 计划主键
   * @return planId
  **/
  @ApiModelProperty(value = "计划主键")


  public Long getPlanId() {
    return planId;
  }

  public void setPlanId(Long planId) {
    this.planId = planId;
  }

  public Work name(String name) {
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

  public Work type(Integer type) {
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

  public Work origin(Integer origin) {
    this.origin = origin;
    return this;
  }

   /**
   * 来源<br>1、计划生成  2、手工生成
   * @return origin
  **/
  @ApiModelProperty(example = "1", value = "来源<br>1、计划生成  2、手工生成")


  public Integer getOrigin() {
    return origin;
  }

  public void setOrigin(Integer origin) {
    this.origin = origin;
  }

  public Work periodType(Integer periodType) {
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

  public Work period(Integer period) {
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

  public Work warnDay(Integer warnDay) {
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

  public Work executePermission(Integer executePermission) {
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

  public Work status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、未开始  1、执行中 2、待确认 3、已完成
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、未开始  1、执行中 2、待确认 3、已完成")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Work content(String content) {
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

  public Work result(String result) {
    this.result = result;
    return this;
  }

   /**
   * 执行结果，可以是保养说明也可以是检定结论
   * @return result
  **/
  @ApiModelProperty(example = "月底保养", value = "执行结果，可以是保养说明也可以是检定结论")


  public String getResult() {
    return result;
  }

  public void setResult(String result) {
    this.result = result;
  }

  public Work certificateNo(String certificateNo) {
    this.certificateNo = certificateNo;
    return this;
  }

   /**
   * 证书编号
   * @return certificateNo
  **/
  @ApiModelProperty(example = "20180101", value = "证书编号")


  public String getCertificateNo() {
    return certificateNo;
  }

  public void setCertificateNo(String certificateNo) {
    this.certificateNo = certificateNo;
  }

  public Work certificateFileName(String certificateFileName) {
    this.certificateFileName = certificateFileName;
    return this;
  }

   /**
   * 证书文件名称
   * @return certificateFileName
  **/
  @ApiModelProperty(example = "20180101", value = "证书文件名称")


  public String getCertificateFileName() {
    return certificateFileName;
  }

  public void setCertificateFileName(String certificateFileName) {
    this.certificateFileName = certificateFileName;
  }

  public Work certificateFilePath(String certificateFilePath) {
    this.certificateFilePath = certificateFilePath;
    return this;
  }

   /**
   * 证书文件路径
   * @return certificateFilePath
  **/
  @ApiModelProperty(example = "20180101", value = "证书文件路径")


  public String getCertificateFilePath() {
    return certificateFilePath;
  }

  public void setCertificateFilePath(String certificateFilePath) {
    this.certificateFilePath = certificateFilePath;
  }

  public Work executeOrgId(Long executeOrgId) {
    this.executeOrgId = executeOrgId;
    return this;
  }

   /**
   * 执行组织
   * @return executeOrgId
  **/
  @ApiModelProperty(value = "执行组织")


  public Long getExecuteOrgId() {
    return executeOrgId;
  }

  public void setExecuteOrgId(Long executeOrgId) {
    this.executeOrgId = executeOrgId;
  }

  public Work executeUser(Long executeUser) {
    this.executeUser = executeUser;
    return this;
  }

   /**
   * 执行用户
   * @return executeUser
  **/
  @ApiModelProperty(value = "执行用户")


  public Long getExecuteUser() {
    return executeUser;
  }

  public void setExecuteUser(Long executeUser) {
    this.executeUser = executeUser;
  }

  public Work executeUserName(String executeUserName) {
    this.executeUserName = executeUserName;
    return this;
  }

   /**
   * 执行用户名
   * @return executeUserName
  **/
  @ApiModelProperty(value = "执行用户名")


  public String getExecuteUserName() {
    return executeUserName;
  }

  public void setExecuteUserName(String executeUserName) {
    this.executeUserName = executeUserName;
  }

  public Work acceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
    return this;
  }

   /**
   * 接收时间
   * @return acceptTime
  **/
  @ApiModelProperty(value = "接收时间")

  @Valid

  public Date getAcceptTime() {
    return acceptTime;
  }

  public void setAcceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
  }

  public Work executeTime(Date executeTime) {
    this.executeTime = executeTime;
    return this;
  }

   /**
   * 执行时间
   * @return executeTime
  **/
  @ApiModelProperty(value = "执行时间")

  @Valid

  public Date getExecuteTime() {
    return executeTime;
  }

  public void setExecuteTime(Date executeTime) {
    this.executeTime = executeTime;
  }

  public Work finishedTime(Date finishedTime) {
    this.finishedTime = finishedTime;
    return this;
  }

   /**
   * 完成时间
   * @return finishedTime
  **/
  @ApiModelProperty(value = "完成时间")

  @Valid

  public Date getFinishedTime() {
    return finishedTime;
  }

  public void setFinishedTime(Date finishedTime) {
    this.finishedTime = finishedTime;
  }

  public Work remark(String remark) {
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
    Work work = (Work) o;
    return Objects.equals(this.id, work.id) &&
        Objects.equals(this.createTime, work.createTime) &&
        Objects.equals(this.updateTime, work.updateTime) &&
        Objects.equals(this.orgId, work.orgId) &&
        Objects.equals(this.labId, work.labId) &&
        Objects.equals(this.providerId, work.providerId) &&
        Objects.equals(this.createUser, work.createUser) &&
        Objects.equals(this.updateUser, work.updateUser) &&
        Objects.equals(this.equipId, work.equipId) &&
        Objects.equals(this.equipName, work.equipName) &&
        Objects.equals(this.planId, work.planId) &&
        Objects.equals(this.name, work.name) &&
        Objects.equals(this.type, work.type) &&
        Objects.equals(this.origin, work.origin) &&
        Objects.equals(this.periodType, work.periodType) &&
        Objects.equals(this.period, work.period) &&
        Objects.equals(this.warnDay, work.warnDay) &&
        Objects.equals(this.executePermission, work.executePermission) &&
        Objects.equals(this.status, work.status) &&
        Objects.equals(this.content, work.content) &&
        Objects.equals(this.result, work.result) &&
        Objects.equals(this.certificateNo, work.certificateNo) &&
        Objects.equals(this.certificateFileName, work.certificateFileName) &&
        Objects.equals(this.certificateFilePath, work.certificateFilePath) &&
        Objects.equals(this.executeOrgId, work.executeOrgId) &&
        Objects.equals(this.executeUser, work.executeUser) &&
        Objects.equals(this.executeUserName, work.executeUserName) &&
        Objects.equals(this.acceptTime, work.acceptTime) &&
        Objects.equals(this.executeTime, work.executeTime) &&
        Objects.equals(this.finishedTime, work.finishedTime) &&
        Objects.equals(this.remark, work.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, orgId, labId, providerId, createUser, updateUser, equipId, equipName, planId, name, type, origin, periodType, period, warnDay, executePermission, status, content, result, certificateNo, certificateFileName, certificateFilePath, executeOrgId, executeUser, executeUserName, acceptTime, executeTime, finishedTime, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Work {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    labId: ").append(toIndentedString(labId)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    equipName: ").append(toIndentedString(equipName)).append("\n");
    sb.append("    planId: ").append(toIndentedString(planId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    periodType: ").append(toIndentedString(periodType)).append("\n");
    sb.append("    period: ").append(toIndentedString(period)).append("\n");
    sb.append("    warnDay: ").append(toIndentedString(warnDay)).append("\n");
    sb.append("    executePermission: ").append(toIndentedString(executePermission)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    content: ").append(toIndentedString(content)).append("\n");
    sb.append("    result: ").append(toIndentedString(result)).append("\n");
    sb.append("    certificateNo: ").append(toIndentedString(certificateNo)).append("\n");
    sb.append("    certificateFileName: ").append(toIndentedString(certificateFileName)).append("\n");
    sb.append("    certificateFilePath: ").append(toIndentedString(certificateFilePath)).append("\n");
    sb.append("    executeOrgId: ").append(toIndentedString(executeOrgId)).append("\n");
    sb.append("    executeUser: ").append(toIndentedString(executeUser)).append("\n");
    sb.append("    executeUserName: ").append(toIndentedString(executeUserName)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    executeTime: ").append(toIndentedString(executeTime)).append("\n");
    sb.append("    finishedTime: ").append(toIndentedString(finishedTime)).append("\n");
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

