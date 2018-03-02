package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table notification
 * @date 2017-12-22
 * @author jiff
 */
public class Notification {
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

    /** 创建用户(必填项) */
    private Long createUser;

    /** 标题(必填项) */
    private String title;

    /** 标题(必填项) */
    private String content;

    /** 图片(可选项) */
    private String img1;

    /** 图片(可选项) */
    private String img2;

    /** 图片(可选项) */
    private String img3;

    /** 通告类型
            0、所有人
            1、报修人
            2、检修团队(必填项) */
    private Integer type;

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
     * 标题
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * 标题
     * @param title
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * 标题
     * @return content
     */
    public String getContent() {
        return content;
    }

    /**
     * 标题
     * @param content
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * 图片
     * @return img1
     */
    public String getImg1() {
        return img1;
    }

    /**
     * 图片
     * @param img1
     */
    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    /**
     * 图片
     * @return img2
     */
    public String getImg2() {
        return img2;
    }

    /**
     * 图片
     * @param img2
     */
    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    /**
     * 图片
     * @return img3
     */
    public String getImg3() {
        return img3;
    }

    /**
     * 图片
     * @param img3
     */
    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    /**
     * 通告类型
            0、所有人
            1、报修人
            2、检修团队
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 通告类型
            0、所有人
            1、报修人
            2、检修团队
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
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