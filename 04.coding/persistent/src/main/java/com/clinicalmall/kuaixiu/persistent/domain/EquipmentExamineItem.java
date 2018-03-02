package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table equipment_examine_item
 * @date 2017-12-22
 * @author jiff
 */
public class EquipmentExamineItem {
    /** 用户主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 验收主键(必填项) */
    private Long examineId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(可选项) */
    private Long updateUser;

    /** 更新时间(可选项) */
    private Date updateTime;

    /** 项目名称(可选项) */
    private String name;

    /** 计量单位(可选项) */
    private String unit;

    /** 标准值(可选项) */
    private String standardValue;

    /** 测量值(可选项) */
    private String measureValue;

    /** 误差值(可选项) */
    private String deviationValue;

    /** 是否合格
            0、不合格
            1、合格(可选项) */
    private Integer isQualified;

    /** 备注(可选项) */
    private String remark;

    /** 预留字段(可选项) */
    private String reserved;

    /**
     * 用户主键
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 用户主键
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
     * 验收主键
     * @return examineId
     */
    public Long getExamineId() {
        return examineId;
    }

    /**
     * 验收主键
     * @param examineId
     */
    public void setExamineId(Long examineId) {
        this.examineId = examineId;
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
     * 项目名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 项目名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 计量单位
     * @return unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * 计量单位
     * @param unit
     */
    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    /**
     * 标准值
     * @return standardValue
     */
    public String getStandardValue() {
        return standardValue;
    }

    /**
     * 标准值
     * @param standardValue
     */
    public void setStandardValue(String standardValue) {
        this.standardValue = standardValue == null ? null : standardValue.trim();
    }

    /**
     * 测量值
     * @return measureValue
     */
    public String getMeasureValue() {
        return measureValue;
    }

    /**
     * 测量值
     * @param measureValue
     */
    public void setMeasureValue(String measureValue) {
        this.measureValue = measureValue == null ? null : measureValue.trim();
    }

    /**
     * 误差值
     * @return deviationValue
     */
    public String getDeviationValue() {
        return deviationValue;
    }

    /**
     * 误差值
     * @param deviationValue
     */
    public void setDeviationValue(String deviationValue) {
        this.deviationValue = deviationValue == null ? null : deviationValue.trim();
    }

    /**
     * 是否合格
            0、不合格
            1、合格
     * @return isQualified
     */
    public Integer getIsQualified() {
        return isQualified;
    }

    /**
     * 是否合格
            0、不合格
            1、合格
     * @param isQualified
     */
    public void setIsQualified(Integer isQualified) {
        this.isQualified = isQualified;
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