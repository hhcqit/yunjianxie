package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table equipment_examine
 * @date 2018-01-07
 * @author jiff
 */
public class EquipmentExamine {
    /** 用户主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 设备主键(必填项) */
    private Long equipId;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(可选项) */
    private Long updateUser;

    /** 更新时间(可选项) */
    private Date updateTime;

    /** 状态
            0、草稿
            1、归档(必填项)  (默认值: 0) */
    private Integer status;

    /** 验收时间(可选项) */
    private Date examineTime;

    /** 验收依据(可选项) */
    private String reference;

    /** 验收结论(可选项) */
    private String conclusion;

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
     * 状态
            0、草稿
            1、归档
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
            0、草稿
            1、归档
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 验收时间
     * @return examineTime
     */
    public Date getExamineTime() {
        return examineTime;
    }

    /**
     * 验收时间
     * @param examineTime
     */
    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    /**
     * 验收依据
     * @return reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * 验收依据
     * @param reference
     */
    public void setReference(String reference) {
        this.reference = reference == null ? null : reference.trim();
    }

    /**
     * 验收结论
     * @return conclusion
     */
    public String getConclusion() {
        return conclusion;
    }

    /**
     * 验收结论
     * @param conclusion
     */
    public void setConclusion(String conclusion) {
        this.conclusion = conclusion == null ? null : conclusion.trim();
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