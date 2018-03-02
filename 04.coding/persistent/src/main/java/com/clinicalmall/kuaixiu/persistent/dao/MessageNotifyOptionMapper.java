package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.MessageNotifyOption;
import com.clinicalmall.kuaixiu.persistent.domain.MessageNotifyOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageNotifyOptionMapper {
    long countByExample(MessageNotifyOptionExample example);

    int deleteByExample(MessageNotifyOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MessageNotifyOption record);

    int insertSelective(MessageNotifyOption record);

    List<MessageNotifyOption> selectByExample(MessageNotifyOptionExample example);

    MessageNotifyOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MessageNotifyOption record, @Param("example") MessageNotifyOptionExample example);

    int updateByExample(@Param("record") MessageNotifyOption record, @Param("example") MessageNotifyOptionExample example);

    int updateByPrimaryKeySelective(MessageNotifyOption record);

    int updateByPrimaryKey(MessageNotifyOption record);
}