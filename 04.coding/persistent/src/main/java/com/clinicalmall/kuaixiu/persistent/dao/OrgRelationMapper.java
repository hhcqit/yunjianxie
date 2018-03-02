package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.OrgRelation;
import com.clinicalmall.kuaixiu.persistent.domain.OrgRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrgRelationMapper {
    long countByExample(OrgRelationExample example);

    int deleteByExample(OrgRelationExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrgRelation record);

    int insertSelective(OrgRelation record);

    List<OrgRelation> selectByExample(OrgRelationExample example);

    OrgRelation selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrgRelation record, @Param("example") OrgRelationExample example);

    int updateByExample(@Param("record") OrgRelation record, @Param("example") OrgRelationExample example);

    int updateByPrimaryKeySelective(OrgRelation record);

    int updateByPrimaryKey(OrgRelation record);
}