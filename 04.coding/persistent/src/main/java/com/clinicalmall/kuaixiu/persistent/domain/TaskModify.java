package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table task_modify
 * @date 2018-01-18
 * @author jiff
 */
public class TaskModify {
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

    /** 创建用户(必填项) */
    private Long createUser;

    /** 设备主键(必填项) */
    private Long equipId;

    /** 设备编号(可选项) */
    private String equipCode;

    /** 设备名称(可选项) */
    private String equipName;

    /** 地点(可选项) */
    private String address;

    /** 描述(必填项) */
    private String description;

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
     * 设备编号
     * @return equipCode
     */
    public String getEquipCode() {
        return equipCode;
    }

    /**
     * 设备编号
     * @param equipCode
     */
    public void setEquipCode(String equipCode) {
        this.equipCode = equipCode == null ? null : equipCode.trim();
    }

    /**
     * 设备名称
     * @return equipName
     */
    public String getEquipName() {
        return equipName;
    }

    /**
     * 设备名称
     * @param equipName
     */
    public void setEquipName(String equipName) {
        this.equipName = equipName == null ? null : equipName.trim();
    }

    /**
     * 地点
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地点
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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