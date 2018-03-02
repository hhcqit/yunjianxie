package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentExamineItemMapper {
    long countByExample(EquipmentExamineItemExample example);

    int deleteByExample(EquipmentExamineItemExample example);

    int deleteByPrimaryKey(Long id);

    int insert(EquipmentExamineItem record);

    int insertSelective(EquipmentExamineItem record);

    List<EquipmentExamineItem> selectByExample(EquipmentExamineItemExample example);

    EquipmentExamineItem selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") EquipmentExamineItem record, @Param("example") EquipmentExamineItemExample example);

    int updateByExample(@Param("record") EquipmentExamineItem record, @Param("example") EquipmentExamineItemExample example);

    int updateByPrimaryKeySelective(EquipmentExamineItem record);

    int updateByPrimaryKey(EquipmentExamineItem record);
}