package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.clinicalmall.kuaixiu.vo.TaskComment;
import com.clinicalmall.kuaixiu.vo.TaskModify;
import com.clinicalmall.kuaixiu.vo.TaskRepair;
import com.clinicalmall.kuaixiu.vo.TaskSupplement;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Task
 */
@Validated

public class Task  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("taskNo")
  private String taskNo = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("createUserName")
  private String createUserName = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("labId")
  private Long labId = null;

  @JsonProperty("providerId")
  private Long providerId = null;

  @JsonProperty("equipId")
  private Long equipId = null;

  @JsonProperty("equipCode")
  private String equipCode = null;

  @JsonProperty("equipName")
  private String equipName = null;

  @JsonProperty("equipUsedDept")
  private String equipUsedDept = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("modifyStatus")
  private Integer modifyStatus = null;

  @JsonProperty("commentStatus")
  private Integer commentStatus = null;

  @JsonProperty("supplementStatus")
  private Integer supplementStatus = null;

  @JsonProperty("sendBackStatus")
  private Integer sendBackStatus = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("repairDescription")
  private String repairDescription = null;

  @JsonProperty("canceledReason")
  private String canceledReason = null;

  @JsonProperty("sendBackReason")
  private String sendBackReason = null;

  @JsonProperty("examinerUser")
  private Long examinerUser = null;

  @JsonProperty("examineCalibrate")
  private String examineCalibrate = null;

  @JsonProperty("examineQc")
  private String examineQc = null;

  @JsonProperty("examineSample")
  private String examineSample = null;

  @JsonProperty("examineDescription")
  private String examineDescription = null;

  @JsonProperty("malfunctionDuration")
  private Integer malfunctionDuration = null;

  @JsonProperty("repairerUser")
  private Long repairerUser = null;

  @JsonProperty("acceptTime")
  private Date acceptTime = null;

  @JsonProperty("repairedTime")
  private Date repairedTime = null;

  @JsonProperty("examineTime")
  private Date examineTime = null;

  @JsonProperty("finishedTime")
  private Date finishedTime = null;

  @JsonProperty("remark")
  private String remark = null;

  @JsonProperty("taskModifies")
  @Valid
  private List<TaskModify> taskModifies = null;

  @JsonProperty("taskComments")
  @Valid
  private List<TaskComment> taskComments = null;

  @JsonProperty("taskSupplements")
  @Valid
  private List<TaskSupplement> taskSupplements = null;

  @JsonProperty("taskRepairs")
  @Valid
  private List<TaskRepair> taskRepairs = null;

  public Task id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 任务主键
   * @return id
  **/
  @ApiModelProperty(value = "任务主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Task createTime(Date createTime) {
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

  public Task updateTime(Date updateTime) {
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

  public Task taskNo(String taskNo) {
    this.taskNo = taskNo;
    return this;
  }

   /**
   * 任务单号
   * @return taskNo
  **/
  @ApiModelProperty(example = "2018010100000001", value = "任务单号")


  public String getTaskNo() {
    return taskNo;
  }

  public void setTaskNo(String taskNo) {
    this.taskNo = taskNo;
  }

  public Task orgId(Long orgId) {
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

  public Task createUser(Long createUser) {
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

  public Task createUserName(String createUserName) {
    this.createUserName = createUserName;
    return this;
  }

   /**
   * 创建用户名
   * @return createUserName
  **/
  @ApiModelProperty(value = "创建用户名")


  public String getCreateUserName() {
    return createUserName;
  }

  public void setCreateUserName(String createUserName) {
    this.createUserName = createUserName;
  }

  public Task updateUser(Long updateUser) {
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

  public Task labId(Long labId) {
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

  public Task providerId(Long providerId) {
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

  public Task equipId(Long equipId) {
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

  public Task equipCode(String equipCode) {
    this.equipCode = equipCode;
    return this;
  }

   /**
   * 设备编号
   * @return equipCode
  **/
  @ApiModelProperty(example = "10001", value = "设备编号")


  public String getEquipCode() {
    return equipCode;
  }

  public void setEquipCode(String equipCode) {
    this.equipCode = equipCode;
  }

  public Task equipName(String equipName) {
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

  public Task equipUsedDept(String equipUsedDept) {
    this.equipUsedDept = equipUsedDept;
    return this;
  }

   /**
   * 设备使用部门
   * @return equipUsedDept
  **/
  @ApiModelProperty(value = "设备使用部门")


  public String getEquipUsedDept() {
    return equipUsedDept;
  }

  public void setEquipUsedDept(String equipUsedDept) {
    this.equipUsedDept = equipUsedDept;
  }

  public Task status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>10、待受理 11、报修人撤销  12、维修人删除  20、待维修  21、报修人撤销  22、维修人删除  23、被拒绝 30、待确认  40、已完成  50、已关闭
   * @return status
  **/
  @ApiModelProperty(example = "10", value = "状态<br>10、待受理 11、报修人撤销  12、维修人删除  20、待维修  21、报修人撤销  22、维修人删除  23、被拒绝 30、待确认  40、已完成  50、已关闭")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Task modifyStatus(Integer modifyStatus) {
    this.modifyStatus = modifyStatus;
    return this;
  }

   /**
   * 报修人是否有修改<br>0、无  1、有
   * @return modifyStatus
  **/
  @ApiModelProperty(example = "0", value = "报修人是否有修改<br>0、无  1、有")


  public Integer getModifyStatus() {
    return modifyStatus;
  }

  public void setModifyStatus(Integer modifyStatus) {
    this.modifyStatus = modifyStatus;
  }

  public Task commentStatus(Integer commentStatus) {
    this.commentStatus = commentStatus;
    return this;
  }

   /**
   * 评论状态<br>0、未评论  1、已评论
   * @return commentStatus
  **/
  @ApiModelProperty(example = "0", value = "评论状态<br>0、未评论  1、已评论")


  public Integer getCommentStatus() {
    return commentStatus;
  }

  public void setCommentStatus(Integer commentStatus) {
    this.commentStatus = commentStatus;
  }

  public Task supplementStatus(Integer supplementStatus) {
    this.supplementStatus = supplementStatus;
    return this;
  }

   /**
   * 维修人是否有补充<br>0、无  1、有
   * @return supplementStatus
  **/
  @ApiModelProperty(example = "0", value = "维修人是否有补充<br>0、无  1、有")


  public Integer getSupplementStatus() {
    return supplementStatus;
  }

  public void setSupplementStatus(Integer supplementStatus) {
    this.supplementStatus = supplementStatus;
  }

  public Task sendBackStatus(Integer sendBackStatus) {
    this.sendBackStatus = sendBackStatus;
    return this;
  }

   /**
   * 维修人是否有退回记录<br>0、无  1、有
   * @return sendBackStatus
  **/
  @ApiModelProperty(example = "0", value = "维修人是否有退回记录<br>0、无  1、有")


  public Integer getSendBackStatus() {
    return sendBackStatus;
  }

  public void setSendBackStatus(Integer sendBackStatus) {
    this.sendBackStatus = sendBackStatus;
  }

  public Task description(String description) {
    this.description = description;
    return this;
  }

   /**
   * 任务描述
   * @return description
  **/
  @ApiModelProperty(example = "指示灯异常", value = "任务描述")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Task repairDescription(String repairDescription) {
    this.repairDescription = repairDescription;
    return this;
  }

   /**
   * 维修描述
   * @return repairDescription
  **/
  @ApiModelProperty(example = "已替换指示灯", value = "维修描述")


  public String getRepairDescription() {
    return repairDescription;
  }

  public void setRepairDescription(String repairDescription) {
    this.repairDescription = repairDescription;
  }

  public Task canceledReason(String canceledReason) {
    this.canceledReason = canceledReason;
    return this;
  }

   /**
   * 取消原因
   * @return canceledReason
  **/
  @ApiModelProperty(example = "误报", value = "取消原因")


  public String getCanceledReason() {
    return canceledReason;
  }

  public void setCanceledReason(String canceledReason) {
    this.canceledReason = canceledReason;
  }

  public Task sendBackReason(String sendBackReason) {
    this.sendBackReason = sendBackReason;
    return this;
  }

   /**
   * 退回原因
   * @return sendBackReason
  **/
  @ApiModelProperty(example = "不属于我的设备", value = "退回原因")


  public String getSendBackReason() {
    return sendBackReason;
  }

  public void setSendBackReason(String sendBackReason) {
    this.sendBackReason = sendBackReason;
  }

  public Task examinerUser(Long examinerUser) {
    this.examinerUser = examinerUser;
    return this;
  }

   /**
   * 检验用户
   * @return examinerUser
  **/
  @ApiModelProperty(value = "检验用户")


  public Long getExaminerUser() {
    return examinerUser;
  }

  public void setExaminerUser(Long examinerUser) {
    this.examinerUser = examinerUser;
  }

  public Task examineCalibrate(String examineCalibrate) {
    this.examineCalibrate = examineCalibrate;
    return this;
  }

   /**
   * 检定情况
   * @return examineCalibrate
  **/
  @ApiModelProperty(example = "正常", value = "检定情况")


  public String getExamineCalibrate() {
    return examineCalibrate;
  }

  public void setExamineCalibrate(String examineCalibrate) {
    this.examineCalibrate = examineCalibrate;
  }

  public Task examineQc(String examineQc) {
    this.examineQc = examineQc;
    return this;
  }

   /**
   * 质控情况
   * @return examineQc
  **/
  @ApiModelProperty(example = "正常", value = "质控情况")


  public String getExamineQc() {
    return examineQc;
  }

  public void setExamineQc(String examineQc) {
    this.examineQc = examineQc;
  }

  public Task examineSample(String examineSample) {
    this.examineSample = examineSample;
    return this;
  }

   /**
   * 留样情况
   * @return examineSample
  **/
  @ApiModelProperty(example = "正常", value = "留样情况")


  public String getExamineSample() {
    return examineSample;
  }

  public void setExamineSample(String examineSample) {
    this.examineSample = examineSample;
  }

  public Task examineDescription(String examineDescription) {
    this.examineDescription = examineDescription;
    return this;
  }

   /**
   * 验收说明
   * @return examineDescription
  **/
  @ApiModelProperty(example = "正常", value = "验收说明")


  public String getExamineDescription() {
    return examineDescription;
  }

  public void setExamineDescription(String examineDescription) {
    this.examineDescription = examineDescription;
  }

  public Task malfunctionDuration(Integer malfunctionDuration) {
    this.malfunctionDuration = malfunctionDuration;
    return this;
  }

   /**
   * 故障时长，单位小时
   * @return malfunctionDuration
  **/
  @ApiModelProperty(example = "1", value = "故障时长，单位小时")


  public Integer getMalfunctionDuration() {
    return malfunctionDuration;
  }

  public void setMalfunctionDuration(Integer malfunctionDuration) {
    this.malfunctionDuration = malfunctionDuration;
  }

  public Task repairerUser(Long repairerUser) {
    this.repairerUser = repairerUser;
    return this;
  }

   /**
   * 维修用户
   * @return repairerUser
  **/
  @ApiModelProperty(value = "维修用户")


  public Long getRepairerUser() {
    return repairerUser;
  }

  public void setRepairerUser(Long repairerUser) {
    this.repairerUser = repairerUser;
  }

  public Task acceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
    return this;
  }

   /**
   * 受理时间
   * @return acceptTime
  **/
  @ApiModelProperty(value = "受理时间")

  @Valid

  public Date getAcceptTime() {
    return acceptTime;
  }

  public void setAcceptTime(Date acceptTime) {
    this.acceptTime = acceptTime;
  }

  public Task repairedTime(Date repairedTime) {
    this.repairedTime = repairedTime;
    return this;
  }

   /**
   * 修复时间
   * @return repairedTime
  **/
  @ApiModelProperty(value = "修复时间")

  @Valid

  public Date getRepairedTime() {
    return repairedTime;
  }

  public void setRepairedTime(Date repairedTime) {
    this.repairedTime = repairedTime;
  }

  public Task examineTime(Date examineTime) {
    this.examineTime = examineTime;
    return this;
  }

   /**
   * 检验时间
   * @return examineTime
  **/
  @ApiModelProperty(value = "检验时间")

  @Valid

  public Date getExamineTime() {
    return examineTime;
  }

  public void setExamineTime(Date examineTime) {
    this.examineTime = examineTime;
  }

  public Task finishedTime(Date finishedTime) {
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

  public Task remark(String remark) {
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

  public Task taskModifies(List<TaskModify> taskModifies) {
    this.taskModifies = taskModifies;
    return this;
  }

  public Task addTaskModifiesItem(TaskModify taskModifiesItem) {
    if (this.taskModifies == null) {
      this.taskModifies = new ArrayList<TaskModify>();
    }
    this.taskModifies.add(taskModifiesItem);
    return this;
  }

   /**
   * Get taskModifies
   * @return taskModifies
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaskModify> getTaskModifies() {
    return taskModifies;
  }

  public void setTaskModifies(List<TaskModify> taskModifies) {
    this.taskModifies = taskModifies;
  }

  public Task taskComments(List<TaskComment> taskComments) {
    this.taskComments = taskComments;
    return this;
  }

  public Task addTaskCommentsItem(TaskComment taskCommentsItem) {
    if (this.taskComments == null) {
      this.taskComments = new ArrayList<TaskComment>();
    }
    this.taskComments.add(taskCommentsItem);
    return this;
  }

   /**
   * Get taskComments
   * @return taskComments
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaskComment> getTaskComments() {
    return taskComments;
  }

  public void setTaskComments(List<TaskComment> taskComments) {
    this.taskComments = taskComments;
  }

  public Task taskSupplements(List<TaskSupplement> taskSupplements) {
    this.taskSupplements = taskSupplements;
    return this;
  }

  public Task addTaskSupplementsItem(TaskSupplement taskSupplementsItem) {
    if (this.taskSupplements == null) {
      this.taskSupplements = new ArrayList<TaskSupplement>();
    }
    this.taskSupplements.add(taskSupplementsItem);
    return this;
  }

   /**
   * Get taskSupplements
   * @return taskSupplements
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaskSupplement> getTaskSupplements() {
    return taskSupplements;
  }

  public void setTaskSupplements(List<TaskSupplement> taskSupplements) {
    this.taskSupplements = taskSupplements;
  }

  public Task taskRepairs(List<TaskRepair> taskRepairs) {
    this.taskRepairs = taskRepairs;
    return this;
  }

  public Task addTaskRepairsItem(TaskRepair taskRepairsItem) {
    if (this.taskRepairs == null) {
      this.taskRepairs = new ArrayList<TaskRepair>();
    }
    this.taskRepairs.add(taskRepairsItem);
    return this;
  }

   /**
   * Get taskRepairs
   * @return taskRepairs
  **/
  @ApiModelProperty(value = "")

  @Valid

  public List<TaskRepair> getTaskRepairs() {
    return taskRepairs;
  }

  public void setTaskRepairs(List<TaskRepair> taskRepairs) {
    this.taskRepairs = taskRepairs;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Task task = (Task) o;
    return Objects.equals(this.id, task.id) &&
        Objects.equals(this.createTime, task.createTime) &&
        Objects.equals(this.updateTime, task.updateTime) &&
        Objects.equals(this.taskNo, task.taskNo) &&
        Objects.equals(this.orgId, task.orgId) &&
        Objects.equals(this.createUser, task.createUser) &&
        Objects.equals(this.createUserName, task.createUserName) &&
        Objects.equals(this.updateUser, task.updateUser) &&
        Objects.equals(this.labId, task.labId) &&
        Objects.equals(this.providerId, task.providerId) &&
        Objects.equals(this.equipId, task.equipId) &&
        Objects.equals(this.equipCode, task.equipCode) &&
        Objects.equals(this.equipName, task.equipName) &&
        Objects.equals(this.equipUsedDept, task.equipUsedDept) &&
        Objects.equals(this.status, task.status) &&
        Objects.equals(this.modifyStatus, task.modifyStatus) &&
        Objects.equals(this.commentStatus, task.commentStatus) &&
        Objects.equals(this.supplementStatus, task.supplementStatus) &&
        Objects.equals(this.sendBackStatus, task.sendBackStatus) &&
        Objects.equals(this.description, task.description) &&
        Objects.equals(this.repairDescription, task.repairDescription) &&
        Objects.equals(this.canceledReason, task.canceledReason) &&
        Objects.equals(this.sendBackReason, task.sendBackReason) &&
        Objects.equals(this.examinerUser, task.examinerUser) &&
        Objects.equals(this.examineCalibrate, task.examineCalibrate) &&
        Objects.equals(this.examineQc, task.examineQc) &&
        Objects.equals(this.examineSample, task.examineSample) &&
        Objects.equals(this.examineDescription, task.examineDescription) &&
        Objects.equals(this.malfunctionDuration, task.malfunctionDuration) &&
        Objects.equals(this.repairerUser, task.repairerUser) &&
        Objects.equals(this.acceptTime, task.acceptTime) &&
        Objects.equals(this.repairedTime, task.repairedTime) &&
        Objects.equals(this.examineTime, task.examineTime) &&
        Objects.equals(this.finishedTime, task.finishedTime) &&
        Objects.equals(this.remark, task.remark) &&
        Objects.equals(this.taskModifies, task.taskModifies) &&
        Objects.equals(this.taskComments, task.taskComments) &&
        Objects.equals(this.taskSupplements, task.taskSupplements) &&
        Objects.equals(this.taskRepairs, task.taskRepairs);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, taskNo, orgId, createUser, createUserName, updateUser, labId, providerId, equipId, equipCode, equipName, equipUsedDept, status, modifyStatus, commentStatus, supplementStatus, sendBackStatus, description, repairDescription, canceledReason, sendBackReason, examinerUser, examineCalibrate, examineQc, examineSample, examineDescription, malfunctionDuration, repairerUser, acceptTime, repairedTime, examineTime, finishedTime, remark, taskModifies, taskComments, taskSupplements, taskRepairs);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Task {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    taskNo: ").append(toIndentedString(taskNo)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    createUserName: ").append(toIndentedString(createUserName)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    labId: ").append(toIndentedString(labId)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    equipId: ").append(toIndentedString(equipId)).append("\n");
    sb.append("    equipCode: ").append(toIndentedString(equipCode)).append("\n");
    sb.append("    equipName: ").append(toIndentedString(equipName)).append("\n");
    sb.append("    equipUsedDept: ").append(toIndentedString(equipUsedDept)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    modifyStatus: ").append(toIndentedString(modifyStatus)).append("\n");
    sb.append("    commentStatus: ").append(toIndentedString(commentStatus)).append("\n");
    sb.append("    supplementStatus: ").append(toIndentedString(supplementStatus)).append("\n");
    sb.append("    sendBackStatus: ").append(toIndentedString(sendBackStatus)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    repairDescription: ").append(toIndentedString(repairDescription)).append("\n");
    sb.append("    canceledReason: ").append(toIndentedString(canceledReason)).append("\n");
    sb.append("    sendBackReason: ").append(toIndentedString(sendBackReason)).append("\n");
    sb.append("    examinerUser: ").append(toIndentedString(examinerUser)).append("\n");
    sb.append("    examineCalibrate: ").append(toIndentedString(examineCalibrate)).append("\n");
    sb.append("    examineQc: ").append(toIndentedString(examineQc)).append("\n");
    sb.append("    examineSample: ").append(toIndentedString(examineSample)).append("\n");
    sb.append("    examineDescription: ").append(toIndentedString(examineDescription)).append("\n");
    sb.append("    malfunctionDuration: ").append(toIndentedString(malfunctionDuration)).append("\n");
    sb.append("    repairerUser: ").append(toIndentedString(repairerUser)).append("\n");
    sb.append("    acceptTime: ").append(toIndentedString(acceptTime)).append("\n");
    sb.append("    repairedTime: ").append(toIndentedString(repairedTime)).append("\n");
    sb.append("    examineTime: ").append(toIndentedString(examineTime)).append("\n");
    sb.append("    finishedTime: ").append(toIndentedString(finishedTime)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("    taskModifies: ").append(toIndentedString(taskModifies)).append("\n");
    sb.append("    taskComments: ").append(toIndentedString(taskComments)).append("\n");
    sb.append("    taskSupplements: ").append(toIndentedString(taskSupplements)).append("\n");
    sb.append("    taskRepairs: ").append(toIndentedString(taskRepairs)).append("\n");
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

