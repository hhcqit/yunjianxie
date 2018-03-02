package com.clinicalmall.kuaixiu.persistent.dao;

import com.clinicalmall.kuaixiu.persistent.domain.Work;
import com.clinicalmall.kuaixiu.persistent.domain.WorkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WorkMapper {
    long countByExample(WorkExample example);

    int deleteByExample(WorkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Work record);

    int insertSelective(Work record);

    List<Work> selectByExample(WorkExample example);

    Work selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByExample(@Param("record") Work record, @Param("example") WorkExample example);

    int updateByPrimaryKeySelective(Work record);

    int updateByPrimaryKey(Work record);
}