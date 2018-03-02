package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table message_notify_option
 * @date 2017-12-22
 * @author jiff
 */
public class MessageNotifyOption {
    /** 用户主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 用户主键(必填项) */
    private Long userId;

    /** 微信消息通知
            0、关闭
            1、打开(必填项)  (默认值: 1) */
    private Integer wechatNotify;

    /** 消息通知总开关
            0、关闭
            1、打开(必填项)  (默认值: 1) */
    private Integer taskNotify;

    /** 修好消息通知
            0、关闭
            1、打开(必填项)  (默认值: 1) */
    private Integer repairedTaskNotify;

    /** 补充记录消息通知
            0、关闭
            1、打开(必填项)  (默认值: 1) */
    private Integer patchTaskNotify;

    /** 新报修消息通知
            0、关闭
            1、打开(必填项)  (默认值: 1) */
    private Integer newTaskNotify;

    /** 更新时间(可选项) */
    private Date updateTime;

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
     * 用户主键
     * @return userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 用户主键
     * @param userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 微信消息通知
            0、关闭
            1、打开
     * @return wechatNotify
     */
    public Integer getWechatNotify() {
        return wechatNotify;
    }

    /**
     * 微信消息通知
            0、关闭
            1、打开
     * @param wechatNotify
     */
    public void setWechatNotify(Integer wechatNotify) {
        this.wechatNotify = wechatNotify;
    }

    /**
     * 消息通知总开关
            0、关闭
            1、打开
     * @return taskNotify
     */
    public Integer getTaskNotify() {
        return taskNotify;
    }

    /**
     * 消息通知总开关
            0、关闭
            1、打开
     * @param taskNotify
     */
    public void setTaskNotify(Integer taskNotify) {
        this.taskNotify = taskNotify;
    }

    /**
     * 修好消息通知
            0、关闭
            1、打开
     * @return repairedTaskNotify
     */
    public Integer getRepairedTaskNotify() {
        return repairedTaskNotify;
    }

    /**
     * 修好消息通知
            0、关闭
            1、打开
     * @param repairedTaskNotify
     */
    public void setRepairedTaskNotify(Integer repairedTaskNotify) {
        this.repairedTaskNotify = repairedTaskNotify;
    }

    /**
     * 补充记录消息通知
            0、关闭
            1、打开
     * @return patchTaskNotify
     */
    public Integer getPatchTaskNotify() {
        return patchTaskNotify;
    }

    /**
     * 补充记录消息通知
            0、关闭
            1、打开
     * @param patchTaskNotify
     */
    public void setPatchTaskNotify(Integer patchTaskNotify) {
        this.patchTaskNotify = patchTaskNotify;
    }

    /**
     * 新报修消息通知
            0、关闭
            1、打开
     * @return newTaskNotify
     */
    public Integer getNewTaskNotify() {
        return newTaskNotify;
    }

    /**
     * 新报修消息通知
            0、关闭
            1、打开
     * @param newTaskNotify
     */
    public void setNewTaskNotify(Integer newTaskNotify) {
        this.newTaskNotify = newTaskNotify;
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