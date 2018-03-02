package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.TaskComment;
import com.clinicalmall.kuaixiu.persistent.domain.TaskCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TaskCommentMapper {
    long countByExample(TaskCommentExample example);

    int deleteByExample(TaskCommentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskComment record);

    int insertSelective(TaskComment record);

    List<TaskComment> selectByExample(TaskCommentExample example);

    TaskComment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskComment record, @Param("example") TaskCommentExample example);

    int updateByExample(@Param("record") TaskComment record, @Param("example") TaskCommentExample example);

    int updateByPrimaryKeySelective(TaskComment record);

    int updateByPrimaryKey(TaskComment record);
}