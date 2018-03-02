package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table plan
 * @date 2017-12-22
 * @author jiff
 */
public class Plan {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 名称(必填项) */
    private String name;

    /** 类型
            1、保养计划
            2、检定计划(必填项)  (默认值: 0) */
    private Integer type;

    /** 周期类型
            0、自定义
            1、每日
            2、每周
            3、每月
            4、每3月
            5、每半年
            6、每年(必填项)  (默认值: 0) */
    private Integer periodType;

    /** 周期
            自定义时使用，单位天(必填项)  (默认值: 0) */
    private Integer period;

    /** 预警时间
            自定义时使用，单位天(必填项)  (默认值: 0) */
    private Integer warnDay;

    /** 执行权限
            0、不限
            1、内部
            2、外部(必填项)  (默认值: 0) */
    private Integer executePermission;

    /** 当前状态
            0、未启用
            1、启用(必填项)  (默认值: 0) */
    private Integer status;

    /** 设备主键(必填项) */
    private Long equipId;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(必填项) */
    private Long updateUser;

    /** 计划内容(必填项) */
    private String content;

    /** 已执行次数(必填项)  (默认值: 0) */
    private Integer executeCount;

    /** 开始时间(必填项) */
    private Date startTime;

    /** 最近执行时间(必填项)  (默认值: CURRENT_TIMESTAMP) */
    private Date latestExecuteTime;

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
     * 名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 类型
            1、保养计划
            2、检定计划
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
            1、保养计划
            2、检定计划
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 周期类型
            0、自定义
            1、每日
            2、每周
            3、每月
            4、每3月
            5、每半年
            6、每年
     * @return periodType
     */
    public Integer getPeriodType() {
        return periodType;
    }

    /**
     * 周期类型
            0、自定义
            1、每日
            2、每周
            3、每月
            4、每3月
            5、每半年
            6、每年
     * @param periodType
     */
    public void setPeriodType(Integer periodType) {
        this.periodType = periodType;
    }

    /**
     * 周期
            自定义时使用，单位天
     * @return period
     */
    public Integer getPeriod() {
        return period;
    }

    /**
     * 周期
            自定义时使用，单位天
     * @param period
     */
    public void setPeriod(Integer period) {
        this.period = period;
    }

    /**
     * 预警时间
            自定义时使用，单位天
     * @return warnDay
     */
    public Integer getWarnDay() {
        return warnDay;
    }

    /**
     * 预警时间
            自定义时使用，单位天
     * @param warnDay
     */
    public void setWarnDay(Integer warnDay) {
        this.warnDay = warnDay;
    }

    /**
     * 执行权限
            0、不限
            1、内部
            2、外部
     * @return executePermission
     */
    public Integer getExecutePermission() {
        return executePermission;
    }

    /**
     * 执行权限
            0、不限
            1、内部
            2、外部
     * @param executePermission
     */
    public void setExecutePermission(Integer executePermission) {
        this.executePermission = executePermission;
    }

    /**
     * 当前状态
            0、未启用
            1、启用
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态
            0、未启用
            1、启用
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 计划内容
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 计划内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 已执行次数
     * @return executeCount
     */
    public Integer getExecuteCount() {
        return executeCount;
    }

    /**
     * 已执行次数
     * @param executeCount
     */
    public void setExecuteCount(Integer executeCount) {
        this.executeCount = executeCount;
    }

    /**
     * 开始时间
     * @return startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * 开始时间
     * @param startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * 最近执行时间
     * @return latestExecuteTime
     */
    public Date getLatestExecuteTime() {
        return latestExecuteTime;
    }

    /**
     * 最近执行时间
     * @param latestExecuteTime
     */
    public void setLatestExecuteTime(Date latestExecuteTime) {
        this.latestExecuteTime = latestExecuteTime;
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