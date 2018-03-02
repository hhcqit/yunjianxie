package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table user
 * @date 2017-12-22
 * @author jiff
 */
public class User {
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

    /** 归属部门(可选项) */
    private String dept;

    /** 用户名(必填项) */
    private String userName;

    /** 密码(必填项) */
    private String password;

    /** 真实姓名(可选项) */
    private String realName;

    /** 用户类型
            0、系统管理员
            1、平台管理员，一个平台只有一个
            2、业务管理员，一个平台可以有多个
            3、普通用户
            (必填项) */
    private Integer userType;

    /** 电子邮箱(可选项) */
    private String email;

    /** 黑名单标记
            0、否
            1、是(必填项)  (默认值: 0) */
    private Integer blacklistFlag;

    /** 更新时间(可选项) */
    private Date updateTime;

    /** 头像图片地址(可选项) */
    private String headImgUrl;

    /** 预留字段(可选项) */
    private String reserved;

    /** 备注(可选项) */
    private String remark;

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
     * 归属部门
     * @return dept
     */
    public String getDept() {
        return dept;
    }

    /**
     * 归属部门
     * @param dept
     */
    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
    }

    /**
     * 用户名
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 密码
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 真实姓名
     * @return realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 用户类型
            0、系统管理员
            1、平台管理员，一个平台只有一个
            2、业务管理员，一个平台可以有多个
            3、普通用户
            
     * @return userType
     */
    public Integer getUserType() {
        return userType;
    }

    /**
     * 用户类型
            0、系统管理员
            1、平台管理员，一个平台只有一个
            2、业务管理员，一个平台可以有多个
            3、普通用户
            
     * @param userType
     */
    public void setUserType(Integer userType) {
        this.userType = userType;
    }

    /**
     * 电子邮箱
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 电子邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 黑名单标记
            0、否
            1、是
     * @return blacklistFlag
     */
    public Integer getBlacklistFlag() {
        return blacklistFlag;
    }

    /**
     * 黑名单标记
            0、否
            1、是
     * @param blacklistFlag
     */
    public void setBlacklistFlag(Integer blacklistFlag) {
        this.blacklistFlag = blacklistFlag;
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
     * 头像图片地址
     * @return headImgUrl
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 头像图片地址
     * @param headImgUrl
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
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
}