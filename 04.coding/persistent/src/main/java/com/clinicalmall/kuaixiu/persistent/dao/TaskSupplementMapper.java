package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.TaskSupplement;
import com.clinicalmall.kuaixiu.persistent.domain.TaskSupplementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskSupplementMapper {
    long countByExample(TaskSupplementExample example);

    int deleteByExample(TaskSupplementExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskSupplement record);

    int insertSelective(TaskSupplement record);

    List<TaskSupplement> selectByExample(TaskSupplementExample example);

    TaskSupplement selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskSupplement record, @Param("example") TaskSupplementExample example);

    int updateByExample(@Param("record") TaskSupplement record, @Param("example") TaskSupplementExample example);

    int updateByPrimaryKeySelective(TaskSupplement record);

    int updateByPrimaryKey(TaskSupplement record);
}