package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.OrgOption;
import com.clinicalmall.kuaixiu.persistent.domain.OrgOptionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgOptionMapper {
    long countByExample(OrgOptionExample example);

    int deleteByExample(OrgOptionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgOption record);

    int insertSelective(OrgOption record);

    List<OrgOption> selectByExample(OrgOptionExample example);

    OrgOption selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgOption record, @Param("example") OrgOptionExample example);

    int updateByExample(@Param("record") OrgOption record, @Param("example") OrgOptionExample example);

    int updateByPrimaryKeySelective(OrgOption record);

    int updateByPrimaryKey(OrgOption record);
}