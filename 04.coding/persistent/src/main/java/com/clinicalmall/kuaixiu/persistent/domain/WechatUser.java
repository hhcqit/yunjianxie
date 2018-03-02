package com.clinicalmall.kuaixiu.persistent.domain;

import java.util.Date;

/**
 * @table wechat_user
 * @date 2017-12-22
 * @author jiff
 */
public class WechatUser {
    /**  */
    private Long id;

    /**   (默认值: CURRENT_TIMESTAMP) */
    private Date createTime;

    /** 删除状态
            0、未删除
            1、已删除(必填项) */
    private Integer deleteStatus;

    /** 用户的唯一标识(必填项) */
    private String openId;

    /** 公司主键(可选项) */
    private Long orgId;

    /** 用户主键(可选项) */
    private Long userId;

    /** 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。(可选项) */
    private String unionId;

    /** 用户昵称(可选项) */
    private String nickname;

    /** 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知(可选项) */
    private Integer sex;

    /** 国家，如中国为CN(可选项) */
    private String country;

    /** 用户个人资料填写的省份(可选项) */
    private String province;

    /** 普通用户个人资料填写的城市(可选项) */
    private String city;

    /** 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。(可选项) */
    private String headImgUrl;

    /** 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）(可选项) */
    private String privilege;

    /** 关注状态
            0：未关注
            1：已关注(可选项) */
    private Integer subscribeStatus;

    /** 更新时间(可选项) */
    private Date updateTime;

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
     * 
     * @return createTime
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 
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
     * 用户的唯一标识
     * @return openId
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 用户的唯一标识
     * @param openId
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    /**
     * 公司主键
     * @return orgId
     */
    public Long getOrgId() {
        return orgId;
    }

    /**
     * 公司主键
     * @param orgId
     */
    public void setOrgId(Long orgId) {
        this.orgId = orgId;
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
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     * @return unionId
     */
    public String getUnionId() {
        return unionId;
    }

    /**
     * 只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。
     * @param unionId
     */
    public void setUnionId(String unionId) {
        this.unionId = unionId == null ? null : unionId.trim();
    }

    /**
     * 用户昵称
     * @return nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 用户昵称
     * @param nickname
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     * @return sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 用户的性别，值为1时是男性，值为2时是女性，值为0时是未知
     * @param sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 国家，如中国为CN
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * 国家，如中国为CN
     * @param country
     */
    public void setCountry(String country) {
        this.country = country == null ? null : country.trim();
    }

    /**
     * 用户个人资料填写的省份
     * @return province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 用户个人资料填写的省份
     * @param province
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 普通用户个人资料填写的城市
     * @return city
     */
    public String getCity() {
        return city;
    }

    /**
     * 普通用户个人资料填写的城市
     * @param city
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     * @return headImgUrl
     */
    public String getHeadImgUrl() {
        return headImgUrl;
    }

    /**
     * 用户头像，最后一个数值代表正方形头像大小（有0、46、64、96、132数值可选，0代表640*640正方形头像），用户没有头像时该项为空。若用户更换头像，原有头像URL将失效。
     * @param headImgUrl
     */
    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl == null ? null : headImgUrl.trim();
    }

    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     * @return privilege
     */
    public String getPrivilege() {
        return privilege;
    }

    /**
     * 用户特权信息，json 数组，如微信沃卡用户为（chinaunicom）
     * @param privilege
     */
    public void setPrivilege(String privilege) {
        this.privilege = privilege == null ? null : privilege.trim();
    }

    /**
     * 关注状态
            0：未关注
            1：已关注
     * @return subscribeStatus
     */
    public Integer getSubscribeStatus() {
        return subscribeStatus;
    }

    /**
     * 关注状态
            0：未关注
            1：已关注
     * @param subscribeStatus
     */
    public void setSubscribeStatus(Integer subscribeStatus) {
        this.subscribeStatus = subscribeStatus;
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
}