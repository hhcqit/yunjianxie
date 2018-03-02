package com.clinicalmall.kuaixiu.persistent.dao;

import java.util.List;
import java.util.Map;

import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.Plan;
import com.clinicalmall.kuaixiu.vo.Task;
import com.clinicalmall.kuaixiu.vo.TaskComment;
import com.clinicalmall.kuaixiu.vo.TaskModify;
import com.clinicalmall.kuaixiu.vo.TaskRepair;
import com.clinicalmall.kuaixiu.vo.TaskSupplement;
import com.clinicalmall.kuaixiu.vo.Work;

public interface CustomizedMapper {
	long countOrgBind(Map<String, Object> where);

	List<Org> selectOrgBind(Map<String, Object> where);

	long countEquipment(Map<String, Object> where);

	List<Equipment> selectEquipment(Map<String, Object> where);

	long countPlan(Map<String, Object> where);

	List<Plan> selectPlan(Map<String, Object> where);

	long countWork(Map<String, Object> where);

	List<Work> selectWork(Map<String, Object> where);

	long countTask(Map<String, Object> where);

	List<Task> selectTask(Map<String, Object> where);

	List<TaskModify> selectTaskModify(Map<String, Object> where);

	List<TaskComment> selectTaskComment(Map<String, Object> where);

	List<TaskSupplement> selectTaskSupplement(Map<String, Object> where);

	List<TaskRepair> selectTaskRepair(Map<String, Object> where);
}