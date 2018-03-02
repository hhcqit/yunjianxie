package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.TaskRepair;
import com.clinicalmall.kuaixiu.persistent.domain.TaskRepairExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskRepairMapper {
    long countByExample(TaskRepairExample example);

    int deleteByExample(TaskRepairExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskRepair record);

    int insertSelective(TaskRepair record);

    List<TaskRepair> selectByExample(TaskRepairExample example);

    TaskRepair selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskRepair record, @Param("example") TaskRepairExample example);

    int updateByExample(@Param("record") TaskRepair record, @Param("example") TaskRepairExample example);

    int updateByPrimaryKeySelective(TaskRepair record);

    int updateByPrimaryKey(TaskRepair record);
}