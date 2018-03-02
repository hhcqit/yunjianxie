package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table org
 * @date 2017-12-22
 * @author jiff
 */
public class Org {
    /** 主键 */
    private Long id;

    /** 创建时间(必填项) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项)  (默认值: 0) */
    private Integer deleteStatus;

    /** 公司名称(必填项) */
    private String name;

    /** 所有人(必填项) */
    private Long owner;

    /** 类型
            1、实验室
            2、服务商
            (必填项) */
    private Integer type;

    /** 联系人(可选项) */
    private String contact;

    /** 联系电话(可选项) */
    private String telephone;

    /** 邮箱(可选项) */
    private String email;

    /** 所在区域(可选项) */
    private String postcode;

    /** 所在区域(可选项) */
    private String area;

    /** 详细地址(可选项) */
    private String address;

    /** 更新时间(可选项) */
    private Date updateTime;

    /** 邀请二维码图片(可选项) */
    private String qrcodeImg;

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
     * 公司名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 公司名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 所有人
     * @return owner
     */
    public Long getOwner() {
        return owner;
    }

    /**
     * 所有人
     * @param owner
     */
    public void setOwner(Long owner) {
        this.owner = owner;
    }

    /**
     * 类型
            1、实验室
            2、服务商
            
     * @return type
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
            1、实验室
            2、服务商
            
     * @param type
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 联系人
     * @return contact
     */
    public String getContact() {
        return contact;
    }

    /**
     * 联系人
     * @param contact
     */
    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    /**
     * 联系电话
     * @return telephone
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 联系电话
     * @param telephone
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 邮箱
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 所在区域
     * @return postcode
     */
    public String getPostcode() {
        return postcode;
    }

    /**
     * 所在区域
     * @param postcode
     */
    public void setPostcode(String postcode) {
        this.postcode = postcode == null ? null : postcode.trim();
    }

    /**
     * 所在区域
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 所在区域
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 详细地址
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
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
     * 邀请二维码图片
     * @return qrcodeImg
     */
    public String getQrcodeImg() {
        return qrcodeImg;
    }

    /**
     * 邀请二维码图片
     * @param qrcodeImg
     */
    public void setQrcodeImg(String qrcodeImg) {
        this.qrcodeImg = qrcodeImg == null ? null : qrcodeImg.trim();
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