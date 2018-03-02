package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table task_comment
 * @date 2017-12-22
 * @author jiff
 */
public class TaskComment {
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

    /** 服务态度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分(必填项)  (默认值: 0) */
    private Integer service;

    /** 技术能力
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分(必填项)  (默认值: 0) */
    private Integer technology;

    /** 响应速度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分(必填项)  (默认值: 0) */
    private Integer response;

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
     * 服务态度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @return service
     */
    public Integer getService() {
        return service;
    }

    /**
     * 服务态度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @param service
     */
    public void setService(Integer service) {
        this.service = service;
    }

    /**
     * 技术能力
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @return technology
     */
    public Integer getTechnology() {
        return technology;
    }

    /**
     * 技术能力
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @param technology
     */
    public void setTechnology(Integer technology) {
        this.technology = technology;
    }

    /**
     * 响应速度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @return response
     */
    public Integer getResponse() {
        return response;
    }

    /**
     * 响应速度
            0、0分
            1、1分
            2、2分
            3、3分
            4、4分
            5、5分
     * @param response
     */
    public void setResponse(Integer response) {
        this.response = response;
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