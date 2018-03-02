package com.clinicalmall.kuaixiu.vo;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.io.Serializable;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Equipment
 */
@Validated

public class Equipment  implements Serializable {
  private static final long serialVersionUID = 1L;

  @JsonProperty("id")
  private Long id = null;

  @JsonProperty("createTime")
  private Date createTime = null;

  @JsonProperty("updateTime")
  private Date updateTime = null;

  @JsonProperty("orgId")
  private Long orgId = null;

  @JsonProperty("labId")
  private Long labId = null;

  @JsonProperty("providerId")
  private Long providerId = null;

  @JsonProperty("labName")
  private String labName = null;

  @JsonProperty("providerName")
  private String providerName = null;

  @JsonProperty("createUser")
  private Long createUser = null;

  @JsonProperty("updateUser")
  private Long updateUser = null;

  @JsonProperty("userType")
  private Integer userType = null;

  @JsonProperty("code")
  private String code = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("status")
  private Integer status = null;

  @JsonProperty("checkPermission")
  private Integer checkPermission = null;

  @JsonProperty("checkPeriod")
  private Integer checkPeriod = null;

  @JsonProperty("area")
  private String area = null;

  @JsonProperty("address")
  private String address = null;

  @JsonProperty("place")
  private String place = null;

  @JsonProperty("model")
  private String model = null;

  @JsonProperty("category")
  private String category = null;

  @JsonProperty("supplier")
  private String supplier = null;

  @JsonProperty("supplierContact")
  private String supplierContact = null;

  @JsonProperty("supplierTelephone")
  private String supplierTelephone = null;

  @JsonProperty("manufacturer")
  private String manufacturer = null;

  @JsonProperty("manufacturerContact")
  private String manufacturerContact = null;

  @JsonProperty("manufacturerTelephone")
  private String manufacturerTelephone = null;

  @JsonProperty("madeArea")
  private String madeArea = null;

  @JsonProperty("madeTime")
  private Date madeTime = null;

  @JsonProperty("batchNo")
  private String batchNo = null;

  @JsonProperty("madeNo")
  private String madeNo = null;

  @JsonProperty("barcode")
  private String barcode = null;

  @JsonProperty("usedDept")
  private String usedDept = null;

  @JsonProperty("owner")
  private String owner = null;

  @JsonProperty("barcodeImg")
  private String barcodeImg = null;

  @JsonProperty("img")
  private String img = null;

  @JsonProperty("purchasedTime")
  private Date purchasedTime = null;

  @JsonProperty("usedTime")
  private Date usedTime = null;

  @JsonProperty("remark")
  private String remark = null;

  public Equipment id(Long id) {
    this.id = id;
    return this;
  }

   /**
   * 设备主键
   * @return id
  **/
  @ApiModelProperty(value = "设备主键")


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Equipment createTime(Date createTime) {
    this.createTime = createTime;
    return this;
  }

   /**
   * 创建时间
   * @return createTime
  **/
  @ApiModelProperty(value = "创建时间")

  @Valid

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Equipment updateTime(Date updateTime) {
    this.updateTime = updateTime;
    return this;
  }

   /**
   * 更新时间
   * @return updateTime
  **/
  @ApiModelProperty(value = "更新时间")

  @Valid

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Equipment orgId(Long orgId) {
    this.orgId = orgId;
    return this;
  }

   /**
   * 组织主键
   * @return orgId
  **/
  @ApiModelProperty(value = "组织主键")


  public Long getOrgId() {
    return orgId;
  }

  public void setOrgId(Long orgId) {
    this.orgId = orgId;
  }

  public Equipment labId(Long labId) {
    this.labId = labId;
    return this;
  }

   /**
   * 实验室主键
   * @return labId
  **/
  @ApiModelProperty(value = "实验室主键")


  public Long getLabId() {
    return labId;
  }

  public void setLabId(Long labId) {
    this.labId = labId;
  }

  public Equipment providerId(Long providerId) {
    this.providerId = providerId;
    return this;
  }

   /**
   * 服务商主键
   * @return providerId
  **/
  @ApiModelProperty(value = "服务商主键")


  public Long getProviderId() {
    return providerId;
  }

  public void setProviderId(Long providerId) {
    this.providerId = providerId;
  }

  public Equipment labName(String labName) {
    this.labName = labName;
    return this;
  }

   /**
   * 实验室名称
   * @return labName
  **/
  @ApiModelProperty(example = "艾迪康", value = "实验室名称")


  public String getLabName() {
    return labName;
  }

  public void setLabName(String labName) {
    this.labName = labName;
  }

  public Equipment providerName(String providerName) {
    this.providerName = providerName;
    return this;
  }

   /**
   * 服务商名称
   * @return providerName
  **/
  @ApiModelProperty(example = "艾迪康", value = "服务商名称")


  public String getProviderName() {
    return providerName;
  }

  public void setProviderName(String providerName) {
    this.providerName = providerName;
  }

  public Equipment createUser(Long createUser) {
    this.createUser = createUser;
    return this;
  }

   /**
   * 创建用户
   * @return createUser
  **/
  @ApiModelProperty(value = "创建用户")


  public Long getCreateUser() {
    return createUser;
  }

  public void setCreateUser(Long createUser) {
    this.createUser = createUser;
  }

  public Equipment updateUser(Long updateUser) {
    this.updateUser = updateUser;
    return this;
  }

   /**
   * 更新用户
   * @return updateUser
  **/
  @ApiModelProperty(value = "更新用户")


  public Long getUpdateUser() {
    return updateUser;
  }

  public void setUpdateUser(Long updateUser) {
    this.updateUser = updateUser;
  }

  public Equipment userType(Integer userType) {
    this.userType = userType;
    return this;
  }

   /**
   * 用户类型<br>0、系统管理员  1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户
   * @return userType
  **/
  @ApiModelProperty(example = "1", value = "用户类型<br>0、系统管理员  1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户")


  public Integer getUserType() {
    return userType;
  }

  public void setUserType(Integer userType) {
    this.userType = userType;
  }

  public Equipment code(String code) {
    this.code = code;
    return this;
  }

   /**
   * 设备编号
   * @return code
  **/
  @ApiModelProperty(example = "10001", value = "设备编号")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Equipment name(String name) {
    this.name = name;
    return this;
  }

   /**
   * 设备名称
   * @return name
  **/
  @ApiModelProperty(example = "自动贴标签机", value = "设备名称")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Equipment status(Integer status) {
    this.status = status;
    return this;
  }

   /**
   * 状态<br>0、未启用  1、已启用
   * @return status
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、未启用  1、已启用")


  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public Equipment checkPermission(Integer checkPermission) {
    this.checkPermission = checkPermission;
    return this;
  }

   /**
   * 状态<br>0、无限制  1、实验室 2、服务商
   * @return checkPermission
  **/
  @ApiModelProperty(example = "0", value = "状态<br>0、无限制  1、实验室 2、服务商")


  public Integer getCheckPermission() {
    return checkPermission;
  }

  public void setCheckPermission(Integer checkPermission) {
    this.checkPermission = checkPermission;
  }

  public Equipment checkPeriod(Integer checkPeriod) {
    this.checkPeriod = checkPeriod;
    return this;
  }

   /**
   * 检定周期，单位天
   * @return checkPeriod
  **/
  @ApiModelProperty(example = "1", value = "检定周期，单位天")


  public Integer getCheckPeriod() {
    return checkPeriod;
  }

  public void setCheckPeriod(Integer checkPeriod) {
    this.checkPeriod = checkPeriod;
  }

  public Equipment area(String area) {
    this.area = area;
    return this;
  }

   /**
   * 设备所在区域
   * @return area
  **/
  @ApiModelProperty(value = "设备所在区域")


  public String getArea() {
    return area;
  }

  public void setArea(String area) {
    this.area = area;
  }

  public Equipment address(String address) {
    this.address = address;
    return this;
  }

   /**
   * 设备所在详细地址
   * @return address
  **/
  @ApiModelProperty(value = "设备所在详细地址")


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public Equipment place(String place) {
    this.place = place;
    return this;
  }

   /**
   * 设备安装位置
   * @return place
  **/
  @ApiModelProperty(value = "设备安装位置")


  public String getPlace() {
    return place;
  }

  public void setPlace(String place) {
    this.place = place;
  }

  public Equipment model(String model) {
    this.model = model;
    return this;
  }

   /**
   * 设备型号
   * @return model
  **/
  @ApiModelProperty(value = "设备型号")


  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public Equipment category(String category) {
    this.category = category;
    return this;
  }

   /**
   * 设备类型
   * @return category
  **/
  @ApiModelProperty(value = "设备类型")


  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public Equipment supplier(String supplier) {
    this.supplier = supplier;
    return this;
  }

   /**
   * 供应商
   * @return supplier
  **/
  @ApiModelProperty(value = "供应商")


  public String getSupplier() {
    return supplier;
  }

  public void setSupplier(String supplier) {
    this.supplier = supplier;
  }

  public Equipment supplierContact(String supplierContact) {
    this.supplierContact = supplierContact;
    return this;
  }

   /**
   * 供应商联系人
   * @return supplierContact
  **/
  @ApiModelProperty(value = "供应商联系人")


  public String getSupplierContact() {
    return supplierContact;
  }

  public void setSupplierContact(String supplierContact) {
    this.supplierContact = supplierContact;
  }

  public Equipment supplierTelephone(String supplierTelephone) {
    this.supplierTelephone = supplierTelephone;
    return this;
  }

   /**
   * 供应商联系电话
   * @return supplierTelephone
  **/
  @ApiModelProperty(value = "供应商联系电话")


  public String getSupplierTelephone() {
    return supplierTelephone;
  }

  public void setSupplierTelephone(String supplierTelephone) {
    this.supplierTelephone = supplierTelephone;
  }

  public Equipment manufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
    return this;
  }

   /**
   * 制造商
   * @return manufacturer
  **/
  @ApiModelProperty(value = "制造商")


  public String getManufacturer() {
    return manufacturer;
  }

  public void setManufacturer(String manufacturer) {
    this.manufacturer = manufacturer;
  }

  public Equipment manufacturerContact(String manufacturerContact) {
    this.manufacturerContact = manufacturerContact;
    return this;
  }

   /**
   * 制造商联系人
   * @return manufacturerContact
  **/
  @ApiModelProperty(value = "制造商联系人")


  public String getManufacturerContact() {
    return manufacturerContact;
  }

  public void setManufacturerContact(String manufacturerContact) {
    this.manufacturerContact = manufacturerContact;
  }

  public Equipment manufacturerTelephone(String manufacturerTelephone) {
    this.manufacturerTelephone = manufacturerTelephone;
    return this;
  }

   /**
   * 制造商联系电话
   * @return manufacturerTelephone
  **/
  @ApiModelProperty(value = "制造商联系电话")


  public String getManufacturerTelephone() {
    return manufacturerTelephone;
  }

  public void setManufacturerTelephone(String manufacturerTelephone) {
    this.manufacturerTelephone = manufacturerTelephone;
  }

  public Equipment madeArea(String madeArea) {
    this.madeArea = madeArea;
    return this;
  }

   /**
   * 产地
   * @return madeArea
  **/
  @ApiModelProperty(value = "产地")


  public String getMadeArea() {
    return madeArea;
  }

  public void setMadeArea(String madeArea) {
    this.madeArea = madeArea;
  }

  public Equipment madeTime(Date madeTime) {
    this.madeTime = madeTime;
    return this;
  }

   /**
   * 出厂日期
   * @return madeTime
  **/
  @ApiModelProperty(value = "出厂日期")

  @Valid

  public Date getMadeTime() {
    return madeTime;
  }

  public void setMadeTime(Date madeTime) {
    this.madeTime = madeTime;
  }

  public Equipment batchNo(String batchNo) {
    this.batchNo = batchNo;
    return this;
  }

   /**
   * 批次编号
   * @return batchNo
  **/
  @ApiModelProperty(value = "批次编号")


  public String getBatchNo() {
    return batchNo;
  }

  public void setBatchNo(String batchNo) {
    this.batchNo = batchNo;
  }

  public Equipment madeNo(String madeNo) {
    this.madeNo = madeNo;
    return this;
  }

   /**
   * 出厂编号
   * @return madeNo
  **/
  @ApiModelProperty(value = "出厂编号")


  public String getMadeNo() {
    return madeNo;
  }

  public void setMadeNo(String madeNo) {
    this.madeNo = madeNo;
  }

  public Equipment barcode(String barcode) {
    this.barcode = barcode;
    return this;
  }

   /**
   * 设备条码
   * @return barcode
  **/
  @ApiModelProperty(value = "设备条码")


  public String getBarcode() {
    return barcode;
  }

  public void setBarcode(String barcode) {
    this.barcode = barcode;
  }

  public Equipment usedDept(String usedDept) {
    this.usedDept = usedDept;
    return this;
  }

   /**
   * 设备使用部门
   * @return usedDept
  **/
  @ApiModelProperty(value = "设备使用部门")


  public String getUsedDept() {
    return usedDept;
  }

  public void setUsedDept(String usedDept) {
    this.usedDept = usedDept;
  }

  public Equipment owner(String owner) {
    this.owner = owner;
    return this;
  }

   /**
   * 设备责任人
   * @return owner
  **/
  @ApiModelProperty(value = "设备责任人")


  public String getOwner() {
    return owner;
  }

  public void setOwner(String owner) {
    this.owner = owner;
  }

  public Equipment barcodeImg(String barcodeImg) {
    this.barcodeImg = barcodeImg;
    return this;
  }

   /**
   * 设备条码图片
   * @return barcodeImg
  **/
  @ApiModelProperty(value = "设备条码图片")


  public String getBarcodeImg() {
    return barcodeImg;
  }

  public void setBarcodeImg(String barcodeImg) {
    this.barcodeImg = barcodeImg;
  }

  public Equipment img(String img) {
    this.img = img;
    return this;
  }

   /**
   * 设备图片
   * @return img
  **/
  @ApiModelProperty(value = "设备图片")


  public String getImg() {
    return img;
  }

  public void setImg(String img) {
    this.img = img;
  }

  public Equipment purchasedTime(Date purchasedTime) {
    this.purchasedTime = purchasedTime;
    return this;
  }

   /**
   * 购进日期
   * @return purchasedTime
  **/
  @ApiModelProperty(value = "购进日期")

  @Valid

  public Date getPurchasedTime() {
    return purchasedTime;
  }

  public void setPurchasedTime(Date purchasedTime) {
    this.purchasedTime = purchasedTime;
  }

  public Equipment usedTime(Date usedTime) {
    this.usedTime = usedTime;
    return this;
  }

   /**
   * 投用日期
   * @return usedTime
  **/
  @ApiModelProperty(value = "投用日期")

  @Valid

  public Date getUsedTime() {
    return usedTime;
  }

  public void setUsedTime(Date usedTime) {
    this.usedTime = usedTime;
  }

  public Equipment remark(String remark) {
    this.remark = remark;
    return this;
  }

   /**
   * 备注
   * @return remark
  **/
  @ApiModelProperty(value = "备注")


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Equipment equipment = (Equipment) o;
    return Objects.equals(this.id, equipment.id) &&
        Objects.equals(this.createTime, equipment.createTime) &&
        Objects.equals(this.updateTime, equipment.updateTime) &&
        Objects.equals(this.orgId, equipment.orgId) &&
        Objects.equals(this.labId, equipment.labId) &&
        Objects.equals(this.providerId, equipment.providerId) &&
        Objects.equals(this.labName, equipment.labName) &&
        Objects.equals(this.providerName, equipment.providerName) &&
        Objects.equals(this.createUser, equipment.createUser) &&
        Objects.equals(this.updateUser, equipment.updateUser) &&
        Objects.equals(this.userType, equipment.userType) &&
        Objects.equals(this.code, equipment.code) &&
        Objects.equals(this.name, equipment.name) &&
        Objects.equals(this.status, equipment.status) &&
        Objects.equals(this.checkPermission, equipment.checkPermission) &&
        Objects.equals(this.checkPeriod, equipment.checkPeriod) &&
        Objects.equals(this.area, equipment.area) &&
        Objects.equals(this.address, equipment.address) &&
        Objects.equals(this.place, equipment.place) &&
        Objects.equals(this.model, equipment.model) &&
        Objects.equals(this.category, equipment.category) &&
        Objects.equals(this.supplier, equipment.supplier) &&
        Objects.equals(this.supplierContact, equipment.supplierContact) &&
        Objects.equals(this.supplierTelephone, equipment.supplierTelephone) &&
        Objects.equals(this.manufacturer, equipment.manufacturer) &&
        Objects.equals(this.manufacturerContact, equipment.manufacturerContact) &&
        Objects.equals(this.manufacturerTelephone, equipment.manufacturerTelephone) &&
        Objects.equals(this.madeArea, equipment.madeArea) &&
        Objects.equals(this.madeTime, equipment.madeTime) &&
        Objects.equals(this.batchNo, equipment.batchNo) &&
        Objects.equals(this.madeNo, equipment.madeNo) &&
        Objects.equals(this.barcode, equipment.barcode) &&
        Objects.equals(this.usedDept, equipment.usedDept) &&
        Objects.equals(this.owner, equipment.owner) &&
        Objects.equals(this.barcodeImg, equipment.barcodeImg) &&
        Objects.equals(this.img, equipment.img) &&
        Objects.equals(this.purchasedTime, equipment.purchasedTime) &&
        Objects.equals(this.usedTime, equipment.usedTime) &&
        Objects.equals(this.remark, equipment.remark);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, createTime, updateTime, orgId, labId, providerId, labName, providerName, createUser, updateUser, userType, code, name, status, checkPermission, checkPeriod, area, address, place, model, category, supplier, supplierContact, supplierTelephone, manufacturer, manufacturerContact, manufacturerTelephone, madeArea, madeTime, batchNo, madeNo, barcode, usedDept, owner, barcodeImg, img, purchasedTime, usedTime, remark);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Equipment {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    createTime: ").append(toIndentedString(createTime)).append("\n");
    sb.append("    updateTime: ").append(toIndentedString(updateTime)).append("\n");
    sb.append("    orgId: ").append(toIndentedString(orgId)).append("\n");
    sb.append("    labId: ").append(toIndentedString(labId)).append("\n");
    sb.append("    providerId: ").append(toIndentedString(providerId)).append("\n");
    sb.append("    labName: ").append(toIndentedString(labName)).append("\n");
    sb.append("    providerName: ").append(toIndentedString(providerName)).append("\n");
    sb.append("    createUser: ").append(toIndentedString(createUser)).append("\n");
    sb.append("    updateUser: ").append(toIndentedString(updateUser)).append("\n");
    sb.append("    userType: ").append(toIndentedString(userType)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    checkPermission: ").append(toIndentedString(checkPermission)).append("\n");
    sb.append("    checkPeriod: ").append(toIndentedString(checkPeriod)).append("\n");
    sb.append("    area: ").append(toIndentedString(area)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    place: ").append(toIndentedString(place)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    supplier: ").append(toIndentedString(supplier)).append("\n");
    sb.append("    supplierContact: ").append(toIndentedString(supplierContact)).append("\n");
    sb.append("    supplierTelephone: ").append(toIndentedString(supplierTelephone)).append("\n");
    sb.append("    manufacturer: ").append(toIndentedString(manufacturer)).append("\n");
    sb.append("    manufacturerContact: ").append(toIndentedString(manufacturerContact)).append("\n");
    sb.append("    manufacturerTelephone: ").append(toIndentedString(manufacturerTelephone)).append("\n");
    sb.append("    madeArea: ").append(toIndentedString(madeArea)).append("\n");
    sb.append("    madeTime: ").append(toIndentedString(madeTime)).append("\n");
    sb.append("    batchNo: ").append(toIndentedString(batchNo)).append("\n");
    sb.append("    madeNo: ").append(toIndentedString(madeNo)).append("\n");
    sb.append("    barcode: ").append(toIndentedString(barcode)).append("\n");
    sb.append("    usedDept: ").append(toIndentedString(usedDept)).append("\n");
    sb.append("    owner: ").append(toIndentedString(owner)).append("\n");
    sb.append("    barcodeImg: ").append(toIndentedString(barcodeImg)).append("\n");
    sb.append("    img: ").append(toIndentedString(img)).append("\n");
    sb.append("    purchasedTime: ").append(toIndentedString(purchasedTime)).append("\n");
    sb.append("    usedTime: ").append(toIndentedString(usedTime)).append("\n");
    sb.append("    remark: ").append(toIndentedString(remark)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

