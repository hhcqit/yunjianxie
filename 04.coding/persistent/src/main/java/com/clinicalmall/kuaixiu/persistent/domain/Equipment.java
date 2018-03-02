package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table equipment
 * @date 2018-01-02
 * @author jiff
 */
public class Equipment {
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

    /**  */
    private Long labId;

    /** 关联组织(可选项) */
    private Long providerId;

    /** 创建用户(必填项) */
    private Long createUser;

    /** 更新用户(必填项) */
    private Long updateUser;

    /** 设备编号(必填项) */
    private String code;

    /** 设备名称(必填项) */
    private String name;

    /** 状态
            0、未启用
            1、启用(必填项)  (默认值: 0) */
    private Integer status;

    /** 检定权限
            0、无限制
            1、实验室
            2、服务商(必填项)  (默认值: 0) */
    private Integer checkPermission;

    /** 检定周期，单位天(必填项)  (默认值: 0) */
    private Integer checkPeriod;

    /** 设备所在区域(可选项) */
    private String area;

    /** 设备所在详细地址(可选项) */
    private String address;

    /** 设备安装位置(可选项) */
    private String place;

    /** 型号(可选项) */
    private String model;

    /** 设备类型(可选项) */
    private String category;

    /** 供应商(可选项) */
    private String supplier;

    /** 供应商联系人(可选项) */
    private String supplierContact;

    /** 供应商联系人(可选项) */
    private String supplierTelephone;

    /** 制造商(可选项) */
    private String manufacturer;

    /** 制造商联系人(可选项) */
    private String manufacturerContact;

    /** 制造商联系人(可选项) */
    private String manufacturerTelephone;

    /** 产地(可选项) */
    private String madeArea;

    /** 出厂日期(可选项) */
    private Date madeTime;

    /** 批次编号(可选项) */
    private String batchNo;

    /** 出厂编号(可选项) */
    private String madeNo;

    /** 设备条码(可选项) */
    private String barcode;

    /** 使用部门(可选项) */
    private String usedDept;

    /** 责任人(可选项) */
    private String owner;

    /** 条码图片(可选项) */
    private String barcodeImg;

    /** 设备图片(可选项) */
    private String img;

    /** 购买日期(可选项) */
    private Date purchasedTime;

    /** 投用日期(可选项) */
    private Date usedTime;

    /** 更新时间(必填项) */
    private Date updateTime;

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
     * 
     * @return labId
     */
    public Long getLabId() {
        return labId;
    }

    /**
     * 
     * @param labId
     */
    public void setLabId(Long labId) {
        this.labId = labId;
    }

    /**
     * 关联组织
     * @return providerId
     */
    public Long getProviderId() {
        return providerId;
    }

    /**
     * 关联组织
     * @param providerId
     */
    public void setProviderId(Long providerId) {
        this.providerId = providerId;
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
     * 设备编号
     * @return code
     */
    public String getCode() {
        return code;
    }

    /**
     * 设备编号
     * @param code
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 设备名称
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设备名称
     * @param name
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 状态
            0、未启用
            1、启用
     * @return status
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态
            0、未启用
            1、启用
     * @param status
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 检定权限
            0、无限制
            1、实验室
            2、服务商
     * @return checkPermission
     */
    public Integer getCheckPermission() {
        return checkPermission;
    }

    /**
     * 检定权限
            0、无限制
            1、实验室
            2、服务商
     * @param checkPermission
     */
    public void setCheckPermission(Integer checkPermission) {
        this.checkPermission = checkPermission;
    }

    /**
     * 检定周期，单位天
     * @return checkPeriod
     */
    public Integer getCheckPeriod() {
        return checkPeriod;
    }

    /**
     * 检定周期，单位天
     * @param checkPeriod
     */
    public void setCheckPeriod(Integer checkPeriod) {
        this.checkPeriod = checkPeriod;
    }

    /**
     * 设备所在区域
     * @return area
     */
    public String getArea() {
        return area;
    }

    /**
     * 设备所在区域
     * @param area
     */
    public void setArea(String area) {
        this.area = area == null ? null : area.trim();
    }

    /**
     * 设备所在详细地址
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设备所在详细地址
     * @param address
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 设备安装位置
     * @return place
     */
    public String getPlace() {
        return place;
    }

    /**
     * 设备安装位置
     * @param place
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * 型号
     * @return model
     */
    public String getModel() {
        return model;
    }

    /**
     * 型号
     * @param model
     */
    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    /**
     * 设备类型
     * @return category
     */
    public String getCategory() {
        return category;
    }

    /**
     * 设备类型
     * @param category
     */
    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    /**
     * 供应商
     * @return supplier
     */
    public String getSupplier() {
        return supplier;
    }

    /**
     * 供应商
     * @param supplier
     */
    public void setSupplier(String supplier) {
        this.supplier = supplier == null ? null : supplier.trim();
    }

    /**
     * 供应商联系人
     * @return supplierContact
     */
    public String getSupplierContact() {
        return supplierContact;
    }

    /**
     * 供应商联系人
     * @param supplierContact
     */
    public void setSupplierContact(String supplierContact) {
        this.supplierContact = supplierContact == null ? null : supplierContact.trim();
    }

    /**
     * 供应商联系人
     * @return supplierTelephone
     */
    public String getSupplierTelephone() {
        return supplierTelephone;
    }

    /**
     * 供应商联系人
     * @param supplierTelephone
     */
    public void setSupplierTelephone(String supplierTelephone) {
        this.supplierTelephone = supplierTelephone == null ? null : supplierTelephone.trim();
    }

    /**
     * 制造商
     * @return manufacturer
     */
    public String getManufacturer() {
        return manufacturer;
    }

    /**
     * 制造商
     * @param manufacturer
     */
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer == null ? null : manufacturer.trim();
    }

    /**
     * 制造商联系人
     * @return manufacturerContact
     */
    public String getManufacturerContact() {
        return manufacturerContact;
    }

    /**
     * 制造商联系人
     * @param manufacturerContact
     */
    public void setManufacturerContact(String manufacturerContact) {
        this.manufacturerContact = manufacturerContact == null ? null : manufacturerContact.trim();
    }

    /**
     * 制造商联系人
     * @return manufacturerTelephone
     */
    public String getManufacturerTelephone() {
        return manufacturerTelephone;
    }

    /**
     * 制造商联系人
     * @param manufacturerTelephone
     */
    public void setManufacturerTelephone(String manufacturerTelephone) {
        this.manufacturerTelephone = manufacturerTelephone == null ? null : manufacturerTelephone.trim();
    }

    /**
     * 产地
     * @return madeArea
     */
    public String getMadeArea() {
        return madeArea;
    }

    /**
     * 产地
     * @param madeArea
     */
    public void setMadeArea(String madeArea) {
        this.madeArea = madeArea == null ? null : madeArea.trim();
    }

    /**
     * 出厂日期
     * @return madeTime
     */
    public Date getMadeTime() {
        return madeTime;
    }

    /**
     * 出厂日期
     * @param madeTime
     */
    public void setMadeTime(Date madeTime) {
        this.madeTime = madeTime;
    }

    /**
     * 批次编号
     * @return batchNo
     */
    public String getBatchNo() {
        return batchNo;
    }

    /**
     * 批次编号
     * @param batchNo
     */
    public void setBatchNo(String batchNo) {
        this.batchNo = batchNo == null ? null : batchNo.trim();
    }

    /**
     * 出厂编号
     * @return madeNo
     */
    public String getMadeNo() {
        return madeNo;
    }

    /**
     * 出厂编号
     * @param madeNo
     */
    public void setMadeNo(String madeNo) {
        this.madeNo = madeNo == null ? null : madeNo.trim();
    }

    /**
     * 设备条码
     * @return barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * 设备条码
     * @param barcode
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    /**
     * 使用部门
     * @return usedDept
     */
    public String getUsedDept() {
        return usedDept;
    }

    /**
     * 使用部门
     * @param usedDept
     */
    public void setUsedDept(String usedDept) {
        this.usedDept = usedDept == null ? null : usedDept.trim();
    }

    /**
     * 责任人
     * @return owner
     */
    public String getOwner() {
        return owner;
    }

    /**
     * 责任人
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    /**
     * 条码图片
     * @return barcodeImg
     */
    public String getBarcodeImg() {
        return barcodeImg;
    }

    /**
     * 条码图片
     * @param barcodeImg
     */
    public void setBarcodeImg(String barcodeImg) {
        this.barcodeImg = barcodeImg == null ? null : barcodeImg.trim();
    }

    /**
     * 设备图片
     * @return img
     */
    public String getImg() {
        return img;
    }

    /**
     * 设备图片
     * @param img
     */
    public void setImg(String img) {
        this.img = img == null ? null : img.trim();
    }

    /**
     * 购买日期
     * @return purchasedTime
     */
    public Date getPurchasedTime() {
        return purchasedTime;
    }

    /**
     * 购买日期
     * @param purchasedTime
     */
    public void setPurchasedTime(Date purchasedTime) {
        this.purchasedTime = purchasedTime;
    }

    /**
     * 投用日期
     * @return usedTime
     */
    public Date getUsedTime() {
        return usedTime;
    }

    /**
     * 投用日期
     * @param usedTime
     */
    public void setUsedTime(Date usedTime) {
        this.usedTime = usedTime;
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