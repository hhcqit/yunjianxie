package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table work
 * @date 2017-12-22
 * @author jiff
 */
public class Work {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 计划主键(必填项) */
    private Long planId;

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

    /** 执行权限
            0、不限
            1、内部
            2、外部(必填项)  (默认值: 0) */
    private Integer executePermission;

    /** 来源
            1、计划生成
            2、手工生成(必填项)  (默认值: 0) */
    private Integer origin;

    /** 类型
            1、保养计划
            2、检定计划(必填项)  (默认值: 0) */
    private Integer type;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 实验室ID(必填项) */
    private Long labId;

    /** 服务商ID(必填项) */
    private Long providerId;

    /** 当前状态
            0、未开始
            1、执行中
            2、待确认
            3、已完成(必填项)  (默认值: 0) */
    private Integer status;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(必填项) */
    private Long updateUser;

    /** 更新时间(必填项) */
    private Date updateTime;

    /** 设备主键(必填项) */
    private Long equipId;

    /** 执行组织(可选项) */
    private Long executeOrgId;

    /** 执行用户(可选项) */
    private Long executeUser;

    /** 证书编号(可选项) */
    private String certificateNo;

    /** 证书文件(可选项) */
    private String certificateFileName;

    /** 证书文件(可选项) */
    private String certificateFilePath;

    /** 名称(可选项) */
    private String name;

    /** 描述，可以是保养内容也可以是检定内容(可选项) */
    private String content;

    /** 执行结果，可以是保养说明也可以是检定结论(可选项) */
    private String result;

    /** 接收时间(可选项) */
    private Date acceptTime;

    /** 执行时间(可选项) */
    private Date executeTime;

    /** 完成时间(可选项) */
    private Date finishedTime;

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
     * 计划主键
     * @return planId
     */
    public Long getPlanId() {
        return planId;
    }

    /**
     * 计划主键
     * @param planId
     */
    public void setPlanId(Long planId) {
        this.planId = planId;
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
     * 来源
            1、计划生成
            2、手工生成
     * @return origin
     */
    public Integer getOrigin() {
        return origin;
    }

    /**
     * 来源
            1、计划生成
            2、手工生成
     * @param origin
     */
    public void setOrigin(Integer origin) {
        this.origin = origin;
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
     * 当前状态
            0、未开始
            1、执行中
            2、待确认
            3、已完成
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态
            0、未开始
            1、执行中
            2、待确认
            3、已完成
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
     * 执行组织
     * @return executeOrgId
     */
    public Long getExecuteOrgId() {
        return executeOrgId;
    }

    /**
     * 执行组织
     * @param executeOrgId
     */
    public void setExecuteOrgId(Long executeOrgId) {
        this.executeOrgId = executeOrgId;
    }

    /**
     * 执行用户
     * @return executeUser
     */
    public Long getExecuteUser() {
        return executeUser;
    }

    /**
     * 执行用户
     * @param executeUser
     */
    public void setExecuteUser(Long executeUser) {
        this.executeUser = executeUser;
    }

    /**
     * 证书编号
     * @return certificateNo
     */
    public String getCertificateNo() {
        return certificateNo;
    }

    /**
     * 证书编号
     * @param certificateNo
     */
    public void setCertificateNo(String certificateNo) {
        this.certificateNo = certificateNo == null ? null : certificateNo.trim();
    }

    /**
     * 证书文件
     * @return certificateFileName
     */
    public String getCertificateFileName() {
        return certificateFileName;
    }

    /**
     * 证书文件
     * @param certificateFileName
     */
    public void setCertificateFileName(String certificateFileName) {
        this.certificateFileName = certificateFileName == null ? null : certificateFileName.trim();
    }

    /**
     * 证书文件
     * @return certificateFilePath
     */
    public String getCertificateFilePath() {
        return certificateFilePath;
    }

    /**
     * 证书文件
     * @param certificateFilePath
     */
    public void setCertificateFilePath(String certificateFilePath) {
        this.certificateFilePath = certificateFilePath == null ? null : certificateFilePath.trim();
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
     * 描述，可以是保养内容也可以是检定内容
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 描述，可以是保养内容也可以是检定内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 执行结果，可以是保养说明也可以是检定结论
     * @return result
     */
    public String getResult() {
        return result;
    }

    /**
     * 执行结果，可以是保养说明也可以是检定结论
     * @param result
     */
    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    /**
     * 接收时间
     * @return acceptTime
     */
    public Date getAcceptTime() {
        return acceptTime;
    }

    /**
     * 接收时间
     * @param acceptTime
     */
    public void setAcceptTime(Date acceptTime) {
        this.acceptTime = acceptTime;
    }

    /**
     * 执行时间
     * @return executeTime
     */
    public Date getExecuteTime() {
        return executeTime;
    }

    /**
     * 执行时间
     * @param executeTime
     */
    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
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