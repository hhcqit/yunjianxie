package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table task
 * @date 2018-01-18
 * @author jiff
 */
public class Task {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 当前状态
            10、待受理
            11、报修人撤销
            12、维修人删除
            20、待维修
            21、报修人撤销
            22、维修人删除
            23、被拒绝
            30、待确认
            40、已完成
            50、已关闭(必填项)  (默认值: 10) */
    private Integer status;

    /** 报修人是否有修改状态
            0、无
            1、有(必填项)  (默认值: 0) */
    private Integer modifyStatus;

    /** 评论状态
            0、未评论
            1、已评论(必填项)  (默认值: 0) */
    private Integer commentStatus;

    /** 维修人是否有补充记录
            0、无
            1、有(必填项)  (默认值: 0) */
    private Integer supplementStatus;

    /** 维修人是否有退回记录
            0、无
            1、有(必填项)  (默认值: 0) */
    private Integer sendBackStatus;

    /** 任务单号(必填项) */
    private String taskNo;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 实验室ID(必填项) */
    private Long labId;

    /** 服务商ID(必填项) */
    private Long providerId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 维修用户(可选项) */
    private Long repairerUser;

    /** 检验用户(可选项) */
    private Long examinerUser;

    /** 更新用户(必填项) */
    private Long updateUser;

    /** 设备主键(必填项) */
    private Long equipId;

    /** 报修描述(必填项) */
    private String description;

    /** 维修描述(可选项) */
    private String repairDescription;

    /** 取消原因(可选项) */
    private String canceledReason;

    /** 退回原因(可选项) */
    private String sendBackReason;

    /** 检定情况(可选项) */
    private String examineCalibrate;

    /** 质控情况(可选项) */
    private String examineQc;

    /** 留样情况(可选项) */
    private String examineSample;

    /** 验收说明(可选项) */
    private String examineDescription;

    /** 故障时长，单位小时(可选项) */
    private Integer malfunctionDuration;

    /** 受理时间(可选项) */
    private Date acceptTime;

    /** 修复时间(可选项) */
    private Date repairedTime;

    /** 检验时间(可选项) */
    private Date examineTime;

    /** 完成时间(可选项) */
    private Date finishedTime;

    /** 更新时间(必填项) */
    private Date updateTime;

    /** 备注(可选项) */
    private String remark;

    /** 预留字段(可选项) */
    private String reserved;

    /**
     * 主键
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 主键
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 创建时间
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 删除状态
            0、未删除
            1、已删除
     * @return deleteStatus
     */
    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    /**
     * 删除状态
            0、未删除
            1、已删除
     * @param deleteStatus
     */
    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    /**
     * 当前状态
            10、待受理
            11、报修人撤销
            12、维修人删除
            20、待维修
            21、报修人撤销
            22、维修人删除
            23、被拒绝
            30、待确认
            40、已完成
            50、已关闭
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态
            10、待受理
            11、报修人撤销
            12、维修人删除
            20、待维修
            21、报修人撤销
            22、维修人删除
            23、被拒绝
            30、待确认
            40、已完成
            50、已关闭
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 报修人是否有修改状态
            0、无
            1、有
     * @return modifyStatus
     */
    public Integer getModifyStatus() {
        return modifyStatus;
    }

    /**
     * 报修人是否有修改状态
            0、无
            1、有
     * @param modifyStatus
     */
    public void setModifyStatus(Integer modifyStatus) {
        this.modifyStatus = modifyStatus;
    }

    /**
     * 评论状态
            0、未评论
            1、已评论
     * @return commentStatus
     */
    public Integer getCommentStatus() {
        return commentStatus;
    }

    /**
     * 评论状态
            0、未评论
            1、已评论
     * @param commentStatus
     */
    public void setCommentStatus(Integer commentStatus) {
        this.commentStatus = commentStatus;
    }

    /**
     * 维修人是否有补充记录
            0、无
            1、有
     * @return supplementStatus
     */
    public Integer getSupplementStatus() {
        return supplementStatus;
    }

    /**
     * 维修人是否有补充记录
            0、无
            1、有
     * @param supplementStatus
     */
    public void setSupplementStatus(Integer supplementStatus) {
        this.supplementStatus = supplementStatus;
    }

    /**
     * 维修人是否有退回记录
            0、无
            1、有
     * @return sendBackStatus
     */
    public Integer getSendBackStatus() {
        return sendBackStatus;
    }

    /**
     * 维修人是否有退回记录
            0、无
            1、有
     * @param sendBackStatus
     */
    public void setSendBackStatus(Integer sendBackStatus) {
        this.sendBackStatus = sendBackStatus;
    }

    /**
     * 任务单号
     * @return taskNo
     */
    public String getTaskNo() {
        return taskNo;
    }

    /**
     * 任务单号
     * @param taskNo
     */
    public void setTaskNo(String taskNo) {
        this.taskNo = taskNo == null ? null : taskNo.trim();
    }

    /**
     * 归属组织
     * @return orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 归属组织
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    /**
     * 实验室ID
     * @return labId
     */
    public Long getLabId() {
        return labId;
    }

    /**
     * 实验室ID
     * @param labId
     */
    public void setLabId(Long labId) {
        this.labId = labId;
    }

    /**
     * 服务商ID
     * @return providerId
     */
    public Long getProviderId() {
        return providerId;
    }

    /**
     * 服务商ID
     * @param providerId
     */
    public void setProviderId(Long providerId) {
        this.providerId = providerId;
    }

    /**
     * 创建用户
     * @return createUser
     */
    public Long getCreateUser() {
        return createUser;
    }

    /**
     * 创建用户
     * @param createUser
     */
    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    /**
     * 维修用户
     * @return repairerUser
     */
    public Long getRepairerUser() {
        return repairerUser;
    }

    /**
     * 维修用户
     * @param repairerUser
     */
    public void setRepairerUser(Long repairerUser) {
        this.repairerUser = repairerUser;
    }

    /**
     * 检验用户
     * @return examinerUser
     */
    public Long getExaminerUser() {
        return examinerUser;
    }

    /**
     * 检验用户
     * @param examinerUser
     */
    public void setExaminerUser(Long examinerUser) {
        this.examinerUser = examinerUser;
    }

    /**
     * 更新用户
     * @return updateUser
     */
    public Long getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新用户
     * @param updateUser
     */
    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 设备主键
     * @return equipId
     */
    public Long getEquipId() {
        return equipId;
    }

    /**
     * 设备主键
     * @param equipId
     */
    public void setEquipId(Long equipId) {
        this.equipId = equipId;
    }

    /**
     * 报修描述
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 报修描述
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 维修描述
     * @return repairDescription
     */
    public String getRepairDescription() {
        return repairDescription;
    }

    /**
     * 维修描述
     * @param repairDescription
     */
    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription == null ? null : repairDescription.trim();
    }

    /**
     * 取消原因
     * @return canceledReason
     */
    public String getCanceledReason() {
        return canceledReason;
    }

    /**
     * 取消原因
     * @param canceledReason
     */
    public void setCanceledReason(String canceledReason) {
        this.canceledReason = canceledReason == null ? null : canceledReason.trim();
    }

    /**
     * 退回原因
     * @return sendBackReason
     */
    public String getSendBackReason() {
        return sendBackReason;
    }

    /**
     * 退回原因
     * @param sendBackReason
     */
    public void setSendBackReason(String sendBackReason) {
        this.sendBackReason = sendBackReason == null ? null : sendBackReason.trim();
    }

    /**
     * 检定情况
     * @return examineCalibrate
     */
    public String getExamineCalibrate() {
        return examineCalibrate;
    }

    /**
     * 检定情况
     * @param examineCalibrate
     */
    public void setExamineCalibrate(String examineCalibrate) {
        this.examineCalibrate = examineCalibrate == null ? null : examineCalibrate.trim();
    }

    /**
     * 质控情况
     * @return examineQc
     */
    public String getExamineQc() {
        return examineQc;
    }

    /**
     * 质控情况
     * @param examineQc
     */
    public void setExamineQc(String examineQc) {
        this.examineQc = examineQc == null ? null : examineQc.trim();
    }

    /**
     * 留样情况
     * @return examineSample
     */
    public String getExamineSample() {
        return examineSample;
    }

    /**
     * 留样情况
     * @param examineSample
     */
    public void setExamineSample(String examineSample) {
        this.examineSample = examineSample == null ? null : examineSample.trim();
    }

    /**
     * 验收说明
     * @return examineDescription
     */
    public String getExamineDescription() {
        return examineDescription;
    }

    /**
     * 验收说明
     * @param examineDescription
     */
    public void setExamineDescription(String examineDescription) {
        this.examineDescription = examineDescription == null ? null : examineDescription.trim();
    }

    /**
     * 故障时长，单位小时
     * @return malfunctionDuration
     */
    public Integer getMalfunctionDuration() {
        return malfunctionDuration;
    }

    /**
     * 故障时长，单位小时
     * @param malfunctionDuration
     */
    public void setMalfunctionDuration(Integer malfunctionDuration) {
        this.malfunctionDuration = malfunctionDuration;
    }

    /**
     * 受理时间
     * @return acceptTime
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * 受理时间
     * @param acceptTime
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * 修复时间
     * @return repairedTime
     */
    public Date getRepairedTime() {
        return repairedTime;
    }

    /**
     * 修复时间
     * @param repairedTime
     */
    public void setRepairedTime(Date repairedTime) {
        this.repairedTime = repairedTime;
    }

    /**
     * 检验时间
     * @return examineTime
     */
    public Date getExamineTime() {
        return examineTime;
    }

    /**
     * 检验时间
     * @param examineTime
     */
    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    /**
     * 完成时间
     * @return finishedTime
     */
    public Date getFinishedTime() {
        return finishedTime;
    }

    /**
     * 完成时间
     * @param finishedTime
     */
    public void setFinishedTime(Date finishedTime) {
        this.finishedTime = finishedTime;
    }

    /**
     * 更新时间
     * @return updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备注
     * @return remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 预留字段
     * @return reserved
     */
    public String getReserved() {
        return reserved;
    }

    /**
     * 预留字段
     * @param reserved
     */
    public void setReserved(String reserved) {
        this.reserved = reserved == null ? null : reserved.trim();
    }
}