package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.Equipment;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EquipmentMapper {
    long countByExample(EquipmentExample example);

    int deleteByExample(EquipmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Equipment record);

    int insertSelective(Equipment record);

    List<Equipment> selectByExample(EquipmentExample example);

    Equipment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByExample(@Param("record") Equipment record, @Param("example") EquipmentExample example);

    int updateByPrimaryKeySelective(Equipment record);

    int updateByPrimaryKey(Equipment record);
}