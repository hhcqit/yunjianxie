package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table attachment
 * @date 2017-12-22
 * @author jiff
 */
public class Attachment {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 微信端文件ID(必填项) */
    private String mediaId;

    /** 名称(必填项) */
    private String name;

    /** 类型
            0、未定义
            1、图片
            2、语音
            3、文件(必填项)  (默认值: 0) */
    private Integer type;

    /** 大小，单位字节(必填项)  (默认值: 0) */
    private Integer size;

    /** 当前状态
            0、未启用
            1、启用(必填项)  (默认值: 0) */
    private Integer status;

    /** 归属组织(必填项) */
    private Long orgId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(必填项) */
    private Long updateUser;

    /** 更新时间(必填项) */
    private Date updateTime;

    /** 附件路径(必填项) */
    private String path;

    /** 附件地址(必填项) */
    private String url;

    /** 图片宽度(可选项)  (默认值: 0) */
    private Integer width;

    /** 图片高度(可选项)  (默认值: 0) */
    private Integer height;

    /** 语音时长(可选项)  (默认值: 0) */
    private Integer duration;

    /** 备注(可选项) */
    private String remark;

    /** 预留字段(可选项) */
    private String reserved;

    /** 关联表名，允许为空(可选项) */
    private String tableName;

    /** 关联表主键ID(可选项) */
    private String tableId;

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
     * 微信端文件ID
     * @return mediaId
     */
    public String getMediaId() {
        return mediaId;
    }

    /**
     * 微信端文件ID
     * @param mediaId
     */
    public void setMediaId(String mediaId) {
        this.mediaId = mediaId == null ? null : mediaId.trim();
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
     * 类型
            0、未定义
            1、图片
            2、语音
            3、文件
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
            0、未定义
            1、图片
            2、语音
            3、文件
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 大小，单位字节
     * @return size
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 大小，单位字节
     * @param size
     */
    public void setSize(Integer size) {
        this.size = size;
    }

    /**
     * 当前状态
            0、未启用
            1、启用
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 当前状态
            0、未启用
            1、启用
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 附件路径
     * @return path
     */
    public String getPath() {
        return path;
    }

    /**
     * 附件路径
     * @param path
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 附件地址
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 附件地址
     * @param url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 图片宽度
     * @return width
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 图片宽度
     * @param width
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 图片高度
     * @return height
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 图片高度
     * @param height
     */
    public void setHeight(Integer height) {
        this.height = height;
    }

    /**
     * 语音时长
     * @return duration
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     * 语音时长
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
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

    /**
     * 关联表名，允许为空
     * @return tableName
     */
    public String getTableName() {
        return tableName;
    }

    /**
     * 关联表名，允许为空
     * @param tableName
     */
    public void setTableName(String tableName) {
        this.tableName = tableName == null ? null : tableName.trim();
    }

    /**
     * 关联表主键ID
     * @return tableId
     */
    public String getTableId() {
        return tableId;
    }

    /**
     * 关联表主键ID
     * @param tableId
     */
    public void setTableId(String tableId) {
        this.tableId = tableId == null ? null : tableId.trim();
    }
}