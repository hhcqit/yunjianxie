package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table sms_code
 * @date 2017-12-22
 * @author jiff
 */
public class SmsCode {
    /**  */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 手机号码(必填项) */
    private String mobile;

    /** 验证码(必填项) */
    private String code;

    /** 1、注册
            2、找回密码
            3、动态密码(必填项) */
    private Integer type;

    /** 过期时间(必填项) */
    private Date expiresTime;

    /** 使用状态(必填项) */
    private Boolean usedStatus;

    /**
     * 
     * @return id
     */
    public Long getId() {
        return id;
    }

    /**
     * 
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
     * 手机号码
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 验证码
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 验证码
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 1、注册
            2、找回密码
            3、动态密码
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 1、注册
            2、找回密码
            3、动态密码
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 过期时间
     * @return expiresTime
     */
    public Date getExpiresTime() {
        return expiresTime;
    }

    /**
     * 过期时间
     * @param expiresTime
     */
    public void setExpiresTime(Date expiresTime) {
        this.expiresTime = expiresTime;
    }

    /**
     * 使用状态
     * @return usedStatus
     */
    public Boolean getUsedStatus() {
        return usedStatus;
    }

    /**
     * 使用状态
     * @param usedStatus
     */
    public void setUsedStatus(Boolean usedStatus) {
        this.usedStatus = usedStatus;
    }
}