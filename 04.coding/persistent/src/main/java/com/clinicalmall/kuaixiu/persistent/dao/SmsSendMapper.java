package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.SmsSend;
import com.clinicalmall.kuaixiu.persistent.domain.SmsSendExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SmsSendMapper {
    long countByExample(SmsSendExample example);

    int deleteByExample(SmsSendExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SmsSend record);

    int insertSelective(SmsSend record);

    List<SmsSend> selectByExample(SmsSendExample example);

    SmsSend selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SmsSend record, @Param("example") SmsSendExample example);

    int updateByExample(@Param("record") SmsSend record, @Param("example") SmsSendExample example);

    int updateByPrimaryKeySelective(SmsSend record);

    int updateByPrimaryKey(SmsSend record);
}