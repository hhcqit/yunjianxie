package com.clinicalmall.kuaixiu.service.impl;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.az.common.vo.mybatis.pagination.Page;
import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.common.utils.DateUtils;
import com.clinicalmall.kuaixiu.persistent.dao.CustomizedMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgMapper;
import com.clinicalmall.kuaixiu.persistent.dao.PlanMapper;
import com.clinicalmall.kuaixiu.persistent.dao.WorkMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Equipment;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.Plan;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.persistent.domain.Work;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IPlanService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetPlanRequest;
import com.clinicalmall.kuaixiu.vo.GetPlanResponse;
import com.clinicalmall.kuaixiu.vo.PlanDeleteRequest;
import com.clinicalmall.kuaixiu.vo.PlanListRequest;
import com.clinicalmall.kuaixiu.vo.PlanListResponse;
import com.clinicalmall.kuaixiu.vo.PlanSaveRequest;
import com.clinicalmall.kuaixiu.vo.PlanUpdateStatusRequest;

import redis.clients.jedis.ShardedJedisPool;

@Transactional
@Service
public class PlanService extends AbsService implements IPlanService {
	private static final Logger log = LoggerFactory.getLogger(PlanService.class);
	@Resource
	private ShardedJedisPool shardedJedisPool;
	@Resource
	private ICommonService commonService;
	@Resource
	private IUserService userService;
	@Resource
	private CustomizedMapper customizedMapper;
	@Resource
	private OrgMapper orgMapper;
	@Resource
	private PlanMapper planMapper;
	@Resource
	private WorkMapper workMapper;
	@Resource
	private EquipmentMapper equipmentMapper;

	@Override
	public ResponseEntity<CommonResponse> save(ApiRequestBase<PlanSaveRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		PlanSaveRequest planSaveRequest = request.getData();
		Long id = planSaveRequest.getId();
		Long equipId = planSaveRequest.getEquipId();
		String name = planSaveRequest.getName();
		String content = planSaveRequest.getContent();
		Integer type = planSaveRequest.getType();
		Date startTime = planSaveRequest.getStartTime();
		if (!StringUtils.isNoneBlank(name, content))
			return ResponseEntity.ok(genCommonResponseWithFailed("计划名称或计划内容不能为空！"));
		if (!Constants.planTypeList.contains(type))
			return ResponseEntity.ok(genCommonResponseWithFailed("计划类型不存在！"));
		if (startTime == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("计划开始时间不能为空！"));
		if (DateUtils.formatDate(startTime).compareTo(DateUtils.formatDate(new Date())) <= 0)
			return ResponseEntity.ok(genCommonResponseWithFailed("计划开始时间不能小于当前时间！"));

		if (equipId == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备ID不能为空！"));
		Equipment equipment = equipmentMapper.selectByPrimaryKey(equipId);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者已删除！"));
		if (equipment.getOrgId() == user.getOrgId() || equipment.getLabId() == user.getOrgId()
				|| equipment.getProviderId() == user.getOrgId())
			;
		else
			return ResponseEntity.ok(genCommonResponseWithFailed("设备非本组织设备！"));
		if (id != null) {
			Plan plan = planMapper.selectByPrimaryKey(id);
			if (plan == null || plan.getOrgId() != user.getOrgId())
				return ResponseEntity.ok(genCommonResponseWithFailed("计划不存在或者非本组织计划！"));
		}
		Plan plan = new Plan();
		BeanUtils.copyProperties(planSaveRequest, plan);
		if (plan.getId() == null) {
			plan.setCreateTime(new Date());
			plan.setUpdateTime(new Date());
			plan.setCreateUser(user.getId());
			plan.setUpdateUser(user.getId());
			plan.setOrgId(user.getOrgId());
			plan.setLatestExecuteTime(null);
			planMapper.insertSelective(plan);
		} else {
			plan.setUpdateUser(user.getId());
			plan.setUpdateTime(new Date());
			plan.setRemark("更新计划");
			planMapper.updateByPrimaryKeySelective(plan);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", plan.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> delete(ApiRequestBase<PlanDeleteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		Long id = request.getData().getId();
		Plan plan = planMapper.selectByPrimaryKey(id);
		if (plan == null || plan.getDeleteStatus() == Constants.DELETE_STATUS_TRUE)
			return ResponseEntity.ok(genCommonResponseWithFailed("计划不存在或已删除！"));
		if (plan.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非本组织计划！"));
		plan.setDeleteStatus(Constants.DELETE_STATUS_TRUE);
		plan.setUpdateUser(user.getId());
		plan.setUpdateTime(new Date());
		plan.setRemark("删除计划");
		planMapper.updateByPrimaryKeySelective(plan);

		return ResponseEntity.ok(genCommonResponseWithSuccessful("删除成功！", id.toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> updateStatus(ApiRequestBase<PlanUpdateStatusRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		PlanUpdateStatusRequest planUpdateStatusRequest = request.getData();
		Long id = planUpdateStatusRequest.getId();
		Integer status = planUpdateStatusRequest.getStatus();
		Plan plan = planMapper.selectByPrimaryKey(id);
		if (plan == null || plan.getDeleteStatus() == Constants.DELETE_STATUS_TRUE)
			return ResponseEntity.ok(genCommonResponseWithFailed("计划不存在或已删除！"));
		if (plan.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非本组织计划！"));
		plan.setStatus(status);
		plan.setUpdateUser(user.getId());
		plan.setUpdateTime(new Date());
		plan.setRemark("更新状态");
		return ResponseEntity.ok(genCommonResponseWithSuccessful("更新成功！", plan.getId().toString()));
	}

	@Override
	public ResponseEntity<PlanListResponse> getList(ApiRequestBase<PlanListRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genPlanListResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genPlanListResponseWithFailed("非法操作！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		PlanListRequest planListRequest = request.getData();
		Integer pageNumber = planListRequest.getPageNumber();
		Integer pageSize = planListRequest.getPageSize();
		Integer type = planListRequest.getType();
		Long equipId = planListRequest.getEquipId();
		String name = planListRequest.getName();
		Integer status = planListRequest.getStatus();
		// PlanExample example = new PlanExample();
		// Criteria criteria =
		// example.createCriteria().andOrgIdEqualTo(user.getOrgId()).andTypeEqualTo(type)
		// .andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
		// if (equipId != null)
		// criteria.andEquipIdEqualTo(equipId);
		// if (status != null)
		// criteria.andStatusEqualTo(status);
		// if (StringUtils.isNoneBlank(name))
		// criteria.andNameLike(name);
		// long total = planMapper.countByExample(example);
		// example.setPage(new Page(pageNumber, pageSize));
		// List<Plan> plans = planMapper.selectByExample(example);
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", user.getOrgId());
		where.put("orgType", org.getType());
		where.put("type", type);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		if (equipId != null)
			where.put("equipId", equipId);
		if (status != null)
			where.put("status", status);
		if (StringUtils.isNoneBlank(name))
			where.put("name", "%" + name + "%");
		long total = customizedMapper.countPlan(where);
		where.put("page", new Page(pageNumber, pageSize));
		List<com.clinicalmall.kuaixiu.vo.Plan> data = customizedMapper.selectPlan(where);
		if (data != null)
			for (com.clinicalmall.kuaixiu.vo.Plan plan : data) {
				Date latestExecuteTime = plan.getLatestExecuteTime();
				if (latestExecuteTime == null)
					plan.setNextExecuteTime(plan.getStartTime());
				else {
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(latestExecuteTime);
					calendar.add(Calendar.DAY_OF_MONTH, plan.getPeriod());
					plan.setNextExecuteTime(calendar.getTime());
				}
			}
		// for (Plan plan : plans) {
		// com.clinicalmall.kuaixiu.vo.Plan plan2 = new
		// com.clinicalmall.kuaixiu.vo.Plan();
		// BeanUtils.copyProperties(plan, plan2);
		// data.add(plan2);
		// }
		return ResponseEntity.ok(genPlanListResponseWithSuccessful("查询成功", total, data));
	}

	@Override
	public ResponseEntity<GetPlanResponse> getPlan(ApiRequestBase<GetPlanRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(new GetPlanResponse().code(ApiResponseBase.CODE_INVALID_SESSION).msg("用户未登录！"));
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(new GetPlanResponse().code(ApiResponseBase.CODE_FAILED).msg("非法操作！"));
		}
		Long id = request.getData().getId();
		Plan plan = planMapper.selectByPrimaryKey(id);
		if (plan == null || plan.getDeleteStatus() == Constants.DELETE_STATUS_TRUE)
			return ResponseEntity.ok(new GetPlanResponse().code(ApiResponseBase.CODE_FAILED).msg("计划不存在或已删除！"));
		if (plan.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(new GetPlanResponse().code(ApiResponseBase.CODE_FAILED).msg("非本组织计划！"));
		com.clinicalmall.kuaixiu.vo.Plan data = new com.clinicalmall.kuaixiu.vo.Plan();
		BeanUtils.copyProperties(plan, data);
		return ResponseEntity.ok(new GetPlanResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("查询成功！").data(data));
	}

	@Override
	public void genPlanInstance(Plan plan) {
		Equipment equipment = equipmentMapper.selectByPrimaryKey(plan.getEquipId());
		Work work = new Work();
		work.setCreateTime(new Date());
		work.setUpdateTime(new Date());
		work.setCreateUser(plan.getCreateUser());
		work.setUpdateUser(plan.getUpdateUser());
		work.setOrgId(plan.getOrgId());
		work.setPlanId(plan.getId());
		work.setEquipId(plan.getEquipId());
		work.setType(plan.getType());
		work.setOrigin(Constants.WORK_ORIGIN_PLAN);
		work.setExecutePermission(plan.getExecutePermission());
		work.setPeriodType(plan.getPeriodType());
		work.setPeriod(plan.getPeriod());
		work.setLabId(equipment.getLabId());
		work.setProviderId(equipment.getProviderId());
		work.setAcceptTime(new Date());
		work.setName(plan.getName());
		work.setContent(plan.getContent());
		work.setRemark("由计划生成作业");
		workMapper.insertSelective(work);
		//
		plan.setExecuteCount(plan.getExecuteCount() + 1);
		plan.setLatestExecuteTime(new Date());
		planMapper.updateByPrimaryKeySelective(plan);
	}

}
