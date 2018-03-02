package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table sms_send
 * @date 2017-12-22
 * @author jiff
 */
public class SmsSend {
    /**  */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 手机号码，多个号码用户英文逗号（,）分隔(必填项) */
    private String mobile;

    /** 短信内容(必填项) */
    private String content;

    /** 0、其他/未分类
            1、注册
            2、找回密码
            3、动态密码
            9、系统通知(必填项) */
    private Integer type;

    /** 关联id，如：用户ID、订单ID等(可选项) */
    private String relateId;

    /** 短信接口测ID(可选项) */
    private String sid;

    /** 发送条数(可选项) */
    private Integer send;

    /** 短信接口响应消息(可选项) */
    private String response;

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
     * 手机号码，多个号码用户英文逗号（,）分隔
     * @return mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号码，多个号码用户英文逗号（,）分隔
     * @param mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 短信内容
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 短信内容
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 0、其他/未分类
            1、注册
            2、找回密码
            3、动态密码
            9、系统通知
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 0、其他/未分类
            1、注册
            2、找回密码
            3、动态密码
            9、系统通知
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 关联id，如：用户ID、订单ID等
     * @return relateId
     */
    public String getRelateId() {
        return relateId;
    }

    /**
     * 关联id，如：用户ID、订单ID等
     * @param relateId
     */
    public void setRelateId(String relateId) {
        this.relateId = relateId == null ? null : relateId.trim();
    }

    /**
     * 短信接口测ID
     * @return sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * 短信接口测ID
     * @param sid
     */
    public void setSid(String sid) {
        this.sid = sid == null ? null : sid.trim();
    }

    /**
     * 发送条数
     * @return send
     */
    public Integer getSend() {
        return send;
    }

    /**
     * 发送条数
     * @param send
     */
    public void setSend(Integer send) {
        this.send = send;
    }

    /**
     * 短信接口响应消息
     * @return response
     */
    public String getResponse() {
        return response;
    }

    /**
     * 短信接口响应消息
     * @param response
     */
    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }
}