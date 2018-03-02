package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table org_option
 * @date 2017-12-22
 * @author jiff
 */
public class OrgOption {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 设备编号
            0、不需要
            1、需要但可以不填
            2、必须填写(必填项)  (默认值: 0) */
    private Integer equipId;

    /** 设备二维码
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer equipQrcode;

    /** 报修人姓名
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer repairUser;

    /** 报修人部门
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer repairDept;

    /** 报修人电话
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer repairMobile;

    /** 报修加急
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer repairUrgent;

    /** 报修内容修改
            0、关闭
            1、打开(必填项)  (默认值: 0) */
    private Integer repairModify;

    /** 报修内容修改期限
            0、无限制
            1、1小时
            3、3小时
            6、6小时
            12、12小时(必填项)  (默认值: 0) */
    private Integer repairModifyExpiry;

    /** 已修好保留期限
            0、无限制
            1、1天
            3、3天
            5、5天
            7、7天
            10、10天(必填项)  (默认值: 0) */
    private Integer repairedRemainExpiry;

    /** 已修好确认
            0、未开启
            1、开启(必填项)  (默认值: 0) */
    private Integer repairedConfirm;

    /** 受理后退回
            0、未开启
            1、开启(必填项)  (默认值: 0) */
    private Integer acceptedSendBack;

    /** 更新时间(可选项) */
    private Date updateTime;

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
     * 设备编号
            0、不需要
            1、需要但可以不填
            2、必须填写
     * @return equipId
     */
    public Integer getEquipId() {
        return equipId;
    }

    /**
     * 设备编号
            0、不需要
            1、需要但可以不填
            2、必须填写
     * @param equipId
     */
    public void setEquipId(Integer equipId) {
        this.equipId = equipId;
    }

    /**
     * 设备二维码
            0、关闭
            1、打开
     * @return equipQrcode
     */
    public Integer getEquipQrcode() {
        return equipQrcode;
    }

    /**
     * 设备二维码
            0、关闭
            1、打开
     * @param equipQrcode
     */
    public void setEquipQrcode(Integer equipQrcode) {
        this.equipQrcode = equipQrcode;
    }

    /**
     * 报修人姓名
            0、关闭
            1、打开
     * @return repairUser
     */
    public Integer getRepairUser() {
        return repairUser;
    }

    /**
     * 报修人姓名
            0、关闭
            1、打开
     * @param repairUser
     */
    public void setRepairUser(Integer repairUser) {
        this.repairUser = repairUser;
    }

    /**
     * 报修人部门
            0、关闭
            1、打开
     * @return repairDept
     */
    public Integer getRepairDept() {
        return repairDept;
    }

    /**
     * 报修人部门
            0、关闭
            1、打开
     * @param repairDept
     */
    public void setRepairDept(Integer repairDept) {
        this.repairDept = repairDept;
    }

    /**
     * 报修人电话
            0、关闭
            1、打开
     * @return repairMobile
     */
    public Integer getRepairMobile() {
        return repairMobile;
    }

    /**
     * 报修人电话
            0、关闭
            1、打开
     * @param repairMobile
     */
    public void setRepairMobile(Integer repairMobile) {
        this.repairMobile = repairMobile;
    }

    /**
     * 报修加急
            0、关闭
            1、打开
     * @return repairUrgent
     */
    public Integer getRepairUrgent() {
        return repairUrgent;
    }

    /**
     * 报修加急
            0、关闭
            1、打开
     * @param repairUrgent
     */
    public void setRepairUrgent(Integer repairUrgent) {
        this.repairUrgent = repairUrgent;
    }

    /**
     * 报修内容修改
            0、关闭
            1、打开
     * @return repairModify
     */
    public Integer getRepairModify() {
        return repairModify;
    }

    /**
     * 报修内容修改
            0、关闭
            1、打开
     * @param repairModify
     */
    public void setRepairModify(Integer repairModify) {
        this.repairModify = repairModify;
    }

    /**
     * 报修内容修改期限
            0、无限制
            1、1小时
            3、3小时
            6、6小时
            12、12小时
     * @return repairModifyExpiry
     */
    public Integer getRepairModifyExpiry() {
        return repairModifyExpiry;
    }

    /**
     * 报修内容修改期限
            0、无限制
            1、1小时
            3、3小时
            6、6小时
            12、12小时
     * @param repairModifyExpiry
     */
    public void setRepairModifyExpiry(Integer repairModifyExpiry) {
        this.repairModifyExpiry = repairModifyExpiry;
    }

    /**
     * 已修好保留期限
            0、无限制
            1、1天
            3、3天
            5、5天
            7、7天
            10、10天
     * @return repairedRemainExpiry
     */
    public Integer getRepairedRemainExpiry() {
        return repairedRemainExpiry;
    }

    /**
     * 已修好保留期限
            0、无限制
            1、1天
            3、3天
            5、5天
            7、7天
            10、10天
     * @param repairedRemainExpiry
     */
    public void setRepairedRemainExpiry(Integer repairedRemainExpiry) {
        this.repairedRemainExpiry = repairedRemainExpiry;
    }

    /**
     * 已修好确认
            0、未开启
            1、开启
     * @return repairedConfirm
     */
    public Integer getRepairedConfirm() {
        return repairedConfirm;
    }

    /**
     * 已修好确认
            0、未开启
            1、开启
     * @param repairedConfirm
     */
    public void setRepairedConfirm(Integer repairedConfirm) {
        this.repairedConfirm = repairedConfirm;
    }

    /**
     * 受理后退回
            0、未开启
            1、开启
     * @return acceptedSendBack
     */
    public Integer getAcceptedSendBack() {
        return acceptedSendBack;
    }

    /**
     * 受理后退回
            0、未开启
            1、开启
     * @param acceptedSendBack
     */
    public void setAcceptedSendBack(Integer acceptedSendBack) {
        this.acceptedSendBack = acceptedSendBack;
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