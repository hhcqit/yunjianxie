package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table task_repair
 * @date 2018-01-18
 * @author jiff
 */
public class TaskRepair {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 任务主键(必填项) */
    private Long taskId;

    /** 当前状态
            0、待维修
            1、已修好
            -1、已退回(必填项)  (默认值: 0) */
    private Integer status;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 描述(可选项) */
    private String description;

    /** 退回原因(可选项) */
    private String reason;

    /** 受理时间(必填项) */
    private Date acceptTime;

    /** 完成时间(可选项) */
    private Date finishedTime;

    /** 是否可见状态
            0、否
            1、是(必填项)  (默认值: 0) */
    private Integer visibleStatus;

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
     * 任务主键
     * @return taskId
     */
    public Long getTaskId() {
        return taskId;
    }

    /**
     * 任务主键
     * @param taskId
     */
    public void setTaskId(Long taskId) {
        this.taskId = taskId;
    }

    /**
     * 当前状态
            0、待维修
            1、已修好
            -1、已退回
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态
            0、待维修
            1、已修好
            -1、已退回
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 描述
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * 退回原因
     * @return reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * 退回原因
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason == null ? null : reason.trim();
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
     * 是否可见状态
            0、否
            1、是
     * @return visibleStatus
     */
    public Integer getVisibleStatus() {
        return visibleStatus;
    }

    /**
     * 是否可见状态
            0、否
            1、是
     * @param visibleStatus
     */
    public void setVisibleStatus(Integer visibleStatus) {
        this.visibleStatus = visibleStatus;
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