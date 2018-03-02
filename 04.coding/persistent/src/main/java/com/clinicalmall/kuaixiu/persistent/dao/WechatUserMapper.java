package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.WechatUser;
import com.clinicalmall.kuaixiu.persistent.domain.WechatUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WechatUserMapper {
    long countByExample(WechatUserExample example);

    int deleteByExample(WechatUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WechatUser record);

    int insertSelective(WechatUser record);

    List<WechatUser> selectByExample(WechatUserExample example);

    WechatUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByExample(@Param("record") WechatUser record, @Param("example") WechatUserExample example);

    int updateByPrimaryKeySelective(WechatUser record);

    int updateByPrimaryKey(WechatUser record);
}