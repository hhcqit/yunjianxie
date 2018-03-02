package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamine;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentExamineMapper {
    long countByExample(EquipmentExamineExample example);

    int deleteByExample(EquipmentExamineExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EquipmentExamine record);

    int insertSelective(EquipmentExamine record);

    List<EquipmentExamine> selectByExample(EquipmentExamineExample example);

    EquipmentExamine selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EquipmentExamine record, @Param("example") EquipmentExamineExample example);

    int updateByExample(@Param("record") EquipmentExamine record, @Param("example") EquipmentExamineExample example);

    int updateByPrimaryKeySelective(EquipmentExamine record);

    int updateByPrimaryKey(EquipmentExamine record);
}