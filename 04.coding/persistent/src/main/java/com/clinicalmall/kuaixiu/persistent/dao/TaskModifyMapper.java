package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.TaskModify;
import com.clinicalmall.kuaixiu.persistent.domain.TaskModifyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskModifyMapper {
    long countByExample(TaskModifyExample example);

    int deleteByExample(TaskModifyExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskModify record);

    int insertSelective(TaskModify record);

    List<TaskModify> selectByExample(TaskModifyExample example);

    TaskModify selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskModify record, @Param("example") TaskModifyExample example);

    int updateByExample(@Param("record") TaskModify record, @Param("example") TaskModifyExample example);

    int updateByPrimaryKeySelective(TaskModify record);

    int updateByPrimaryKey(TaskModify record);
}