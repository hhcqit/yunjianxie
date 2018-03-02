package com.clinicalmall.kuaixiu.service.impl;

import java.util.Arrays;
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
import com.clinicalmall.kuaixiu.persistent.dao.CustomizedMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentExamineItemMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentExamineMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgRelationMapper;
import com.clinicalmall.kuaixiu.persistent.dao.PlanMapper;
import com.clinicalmall.kuaixiu.persistent.dao.TaskMapper;
import com.clinicalmall.kuaixiu.persistent.dao.UserMapper;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamine;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineExample;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItemExample;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExample;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.OrgRelation;
import com.clinicalmall.kuaixiu.persistent.domain.OrgRelationExample;
import com.clinicalmall.kuaixiu.persistent.domain.PlanExample;
import com.clinicalmall.kuaixiu.persistent.domain.TaskExample;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IEquipmentService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.EquipmentBindOrgRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItem;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineSaveRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentUpdateStatusRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentResponse;

import redis.clients.jedis.ShardedJedisPool;

@Transactional
@Service
public class EquipmentService extends AbsService implements IEquipmentService {
	private static final Logger log = LoggerFactory.getLogger(EquipmentService.class);
	@Resource
	private ShardedJedisPool shardedJedisPool;
	@Resource
	private ICommonService commonService;
	@Resource
	private OrgMapper orgMapper;
	@Resource
	private OrgRelationMapper orgRelationMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private IUserService userService;
	@Resource
	private CustomizedMapper customizedMapper;
	@Resource
	private EquipmentMapper equipmentMapper;
	@Resource
	private EquipmentExamineMapper equipmentExamineMapper;
	@Resource
	private EquipmentExamineItemMapper equipmentExamineItemMapper;
	@Resource
	private PlanMapper planMapper;
	@Resource
	private TaskMapper taskMapper;

	@Override
	public ResponseEntity<CommonResponse> save(ApiRequestBase<Equipment> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		Equipment equipment2 = request.getData();
		Long id = equipment2.getId();
		String code = equipment2.getCode();
		EquipmentExample example = new EquipmentExample();
		example.createCriteria().andOrgIdEqualTo(user.getOrgId()).andCodeEqualTo(code);
		List<com.clinicalmall.kuaixiu.persistent.domain.Equipment> equipments = equipmentMapper
				.selectByExample(example);
		if (!equipments.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备编号已经存在！"));
		if (id != null) {
			com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
			if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
					|| equipment.getOrgId() != user.getOrgId())
				return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		}
		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = new com.clinicalmall.kuaixiu.persistent.domain.Equipment();
		BeanUtils.copyProperties(equipment2, equipment);
		if (equipment.getId() == null) {
			equipment.setCreateTime(new Date());
			equipment.setUpdateTime(new Date());
			equipment.setCreateUser(user.getId());
			equipment.setUpdateUser(user.getId());
			equipment.setOrgId(user.getOrgId());
			if (org.getType() == Constants.ORG_TYPE_LAB)
				equipment.setLabId(org.getId());
			else
				equipment.setProviderId(org.getId());
			equipmentMapper.insertSelective(equipment);
		} else {
			equipment.setUpdateUser(user.getId());
			equipment.setUpdateTime(new Date());
			equipment.setRemark("更新设备");
			equipmentMapper.updateByPrimaryKeySelective(equipment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", equipment.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> delete(ApiRequestBase<EquipmentDeleteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}

		EquipmentDeleteRequest equipmentDeleteRequest = request.getData();
		Long id = equipmentDeleteRequest.getId();
		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE) {
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在！"));
		}
		if (equipment.getOrgId() != user.getOrgId()) {
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不属于用户所在组织！"));
		}
		PlanExample example = new PlanExample();
		example.createCriteria().andEquipIdEqualTo(equipment.getId())
				.andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
		if (planMapper.countByExample(example) > 0l)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备还有在执行的计划！"));
		TaskExample taskExample = new TaskExample();
		example.createCriteria().andEquipIdEqualTo(equipment.getId())
				.andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE)
				.andStatusIn(Arrays.asList(Constants.TASK_STATUS_TO_BE_ACCEPT, Constants.TASK_STATUS_TO_BE_REPAIR,
						Constants.TASK_STATUS_TO_BE_CONFIRMED));
		if (taskMapper.countByExample(taskExample) > 0l)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备还有在执行的维修任务！"));
		equipment.setDeleteStatus(Constants.DELETE_STATUS_TRUE);
		equipment.setUpdateTime(new Date());
		equipment.setUpdateUser(user.getId());
		equipment.setRemark("删除设备");
		equipmentMapper.updateByPrimaryKeySelective(equipment);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("删除成功！"));
	}

	@Override
	public ResponseEntity<CommonResponse> updateStatus(ApiRequestBase<EquipmentUpdateStatusRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		EquipmentUpdateStatusRequest equipmentUpdateStatusRequest = request.getData();
		Long id = equipmentUpdateStatusRequest.getId();
		Integer status = equipmentUpdateStatusRequest.getStatus();
		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE) {
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在！"));
		}
		if (equipment.getOrgId() != user.getOrgId()) {
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不属于用户所在组织！"));
		}
		equipment.setStatus(status);
		equipment.setUpdateTime(new Date());
		equipment.setUpdateUser(user.getId());
		equipment.setRemark("修改设备状态");
		equipmentMapper.updateByPrimaryKeySelective(equipment);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("修改成功！"));
	}

	@Override
	public ResponseEntity<EquipmentListResponse> getList(ApiRequestBase<EquipmentListRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genEquipmentListResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genEquipmentListResponseWithFailed("非法操作！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		EquipmentListRequest equipmentListRequest = request.getData();
		Long labId = equipmentListRequest.getLabId();
		Long providerId = equipmentListRequest.getProviderId();
		Integer own = equipmentListRequest.getOwn();
		Integer bind = equipmentListRequest.getBind();
		String code = equipmentListRequest.getCode();
		String name = equipmentListRequest.getName();
		Integer status = equipmentListRequest.getStatus();
		Integer pageNumber = equipmentListRequest.getPageNumber();
		Integer pageSize = equipmentListRequest.getPageSize();
		// EquipmentExample example = new EquipmentExample();
		// Criteria criteria =
		// example.createCriteria().andOrgIdEqualTo(user.getOrgId());
		// if (own == null || own == 0) {
		// if (org.getType() == Constants.ORG_TYPE_LAB)
		// criteria.andLabIdEqualTo(user.getOrgId());
		// else
		// criteria.andProviderIdEqualTo(user.getOrgId());
		// } else
		// criteria.andOrgIdEqualTo(user.getOrgId());
		// //
		// if (bind != null) {
		// criteria.andLabIdIsNotNull();
		// }
		// if (status != null)
		// criteria.andStatusEqualTo(status);
		// if (StringUtils.isNoneBlank(code))
		// criteria.andCodeLike(code);
		// if (StringUtils.isNoneBlank(name))
		// criteria.andNameLike(name);
		// long total = equipmentMapper.countByExample(example);
		// example.setPage(new Page(pageNumber, pageSize));
		// List<com.clinicalmall.kuaixiu.persistent.domain.Equipment> equipments
		// =
		// equipmentMapper
		// .selectByExample(example);
		// List<Equipment> data = new ArrayList<Equipment>();
		// for (com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment :
		// equipments) {
		// Equipment equipment1 = new Equipment();
		// BeanUtils.copyProperties(equipment, equipment1);
		// data.add(equipment1);
		// }
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		if (own == null || own == 0) { // 所有
			if (org.getType() == Constants.ORG_TYPE_LAB)
				where.put("labId", user.getOrgId());
			else
				where.put("providerId", user.getOrgId());
		} else {// 只查询自己维护的
			where.put("orgId", user.getOrgId());

		}
		if (org.getType() == Constants.ORG_TYPE_LAB)// 当前用户为实验室时允许限定服务商
			where.put("providerId", providerId);
		else
			// 当前用户为服务商时允许限定实验室
			where.put("labId", labId);

		// 是否绑定实验室/服务商
		if (bind != null) {
			where.put("bind", bind);
			if (org.getType() == Constants.ORG_TYPE_LAB)
				where.put("bindType", Constants.ORG_TYPE_PROVIDER);
			else
				where.put("bindType", Constants.ORG_TYPE_LAB);
		}
		if (StringUtils.isNoneBlank(code))
			where.put("code", code);
		if (StringUtils.isNoneBlank(name))
			where.put("name", "%" + name + "%");
		if (status != null)
			where.put("status", status);
		long total = customizedMapper.countEquipment(where);
		where.put("page", new Page(pageNumber, pageSize));
		List<Equipment> equipments = customizedMapper.selectEquipment(where);

		return ResponseEntity.ok(genEquipmentListResponseWithSuccessful("查询成功", total, equipments));
	}

	@Override
	public ResponseEntity<GetEquipmentResponse> getEquipment(ApiRequestBase<GetEquipmentRequest> request) {
		GetEquipmentResponse getEquipmentResponse = new GetEquipmentResponse();
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			getEquipmentResponse.setCode(ApiResponseBase.CODE_INVALID_SESSION);
			getEquipmentResponse.setMsg("用户未登录！");
			return ResponseEntity.ok(getEquipmentResponse);
		}
		Long id = request.getData().getId();
		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(id);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE) {
			getEquipmentResponse.setCode(ApiResponseBase.CODE_FAILED);
			getEquipmentResponse.setMsg("设备不存在！");
			return ResponseEntity.ok(getEquipmentResponse);
		}
		if (equipment.getLabId() == user.getOrgId() || equipment.getProviderId() == user.getOrgId()) {// 检查设备归属的实验室或服务商是否为当前用户所在组织
			getEquipmentResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
			com.clinicalmall.kuaixiu.vo.Equipment equipment1 = new com.clinicalmall.kuaixiu.vo.Equipment();
			BeanUtils.copyProperties(equipment, equipment1);
			Org lab = orgMapper.selectByPrimaryKey(equipment.getLabId());
			Org provider = orgMapper.selectByPrimaryKey(equipment.getProviderId());
			equipment1.setLabName(lab.getName());
			equipment1.setProviderName(provider.getName());
			getEquipmentResponse.setData(equipment1);
		} else {
			getEquipmentResponse.setCode(ApiResponseBase.CODE_FAILED);
			getEquipmentResponse.setMsg("设备不属于你所在的组织！");
		}
		return ResponseEntity.ok(getEquipmentResponse);
	}

	@Override
	public ResponseEntity<CommonResponse> bindOrg(ApiRequestBase<EquipmentBindOrgRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		EquipmentBindOrgRequest equipmentBindOrgRequest = request.getData();
		Long id = equipmentBindOrgRequest.getId();
		Long relatedOrgId = equipmentBindOrgRequest.getRelatedOrgId();
		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = null;
		if (id != null) {
			equipment = equipmentMapper.selectByPrimaryKey(id);
		}
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| equipment.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		Org relatedOrg = orgMapper.selectByPrimaryKey(relatedOrgId);
		if (relatedOrg == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("绑定的组织不存在！"));
		if (org.getType() == relatedOrg.getType())
			return ResponseEntity.ok(genCommonResponseWithFailed("绑定的组织不能和用户所在组织类型一样！"));

		OrgRelationExample example = new OrgRelationExample();
		if (org.getType() == Constants.ORG_TYPE_LAB)
			example.createCriteria().andLabIdEqualTo(org.getId()).andProviderIdEqualTo(relatedOrg.getId());
		else
			example.createCriteria().andProviderIdEqualTo(org.getId()).andLabIdEqualTo(relatedOrg.getId());
		List<OrgRelation> orgRelations = orgRelationMapper.selectByExample(example);
		if (orgRelations == null || orgRelations.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("用户所在组织没有绑定关联组织！"));

		if (relatedOrg.getType() == Constants.ORG_TYPE_LAB)
			equipment.setLabId(relatedOrgId);
		else
			equipment.setProviderId(relatedOrgId);
		equipment.setUpdateTime(new Date());
		equipment.setUpdateUser(user.getId());
		equipment.setRemark("绑定关联组织");
		equipmentMapper.updateByPrimaryKeySelective(equipment);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("绑定成功！"));
	}

	@Override
	public ResponseEntity<CommonResponse> saveExamine(ApiRequestBase<EquipmentExamineSaveRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		EquipmentExamineSaveRequest equipmentExamineSaveRequest = request.getData();
		Long id = equipmentExamineSaveRequest.getId();
		Long equipId = equipmentExamineSaveRequest.getEquipId();
		String conclusion = equipmentExamineSaveRequest.getConclusion();
		String reference = equipmentExamineSaveRequest.getReference();
		Date examineTime = equipmentExamineSaveRequest.getExamineTime();
		List<EquipmentExamineItem> examineItems = equipmentExamineSaveRequest.getExamineItems();

		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(equipId);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| equipment.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		EquipmentExamine equipmentExamine = null;
		if (id == null) {// 新增时验证是否已经有验收
			EquipmentExamineExample example = new EquipmentExamineExample();
			example.createCriteria().andEquipIdEqualTo(equipId);
			List<EquipmentExamine> equipmentExamines = equipmentExamineMapper.selectByExample(example);
			if (equipmentExamines != null && equipmentExamines.size() > 0)
				return ResponseEntity.ok(genCommonResponseWithFailed("设备验收记录已存在！"));
		} else {
			equipmentExamine = equipmentExamineMapper.selectByPrimaryKey(id);
			if (equipmentExamine == null || equipmentExamine.getStatus() == Constants.EQUIPMENT_EXAMINE_STATUS_ARCHIVED
					|| equipmentExamine.getOrgId() != user.getOrgId())
				return ResponseEntity.ok(genCommonResponseWithFailed("设备验收不存在或已归档或不属于本组织！"));
		}

		if (equipmentExamine == null) {
			equipmentExamine = new EquipmentExamine();
			equipmentExamine.setCreateTime(new Date());
			equipmentExamine.setCreateUser(user.getId());
			equipmentExamine.setOrgId(user.getOrgId());
			equipmentExamine.setEquipId(equipId);
		}
		equipmentExamine.setUpdateTime(new Date());
		equipmentExamine.setUpdateUser(user.getId());
		equipmentExamine.setConclusion(conclusion);
		equipmentExamine.setReference(reference);
		equipmentExamine.setExamineTime(examineTime);
		if (id == null)
			equipmentExamineMapper.insertSelective(equipmentExamine);
		else
			equipmentExamineMapper.updateByPrimaryKeySelective(equipmentExamine);
		if (examineItems != null)
			for (EquipmentExamineItem equipmentExamineItem : examineItems) {
				Long id2 = equipmentExamineItem.getId();
				com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem2 = new com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem();
				BeanUtils.copyProperties(equipmentExamineItem, equipmentExamineItem2);
				equipmentExamineItem2.setUpdateTime(new Date());
				equipmentExamineItem2.setUpdateUser(user.getId());
				equipmentExamineItem2.setExamineId(equipmentExamine.getId());
				if (id2 == null) {
					equipmentExamineItem2.setCreateUser(user.getId());
					equipmentExamineItem2.setCreateTime(new Date());
					equipmentExamineItemMapper.insertSelective(equipmentExamineItem2);
				} else {
					equipmentExamineItem2.setCreateUser(null);
					equipmentExamineItem2.setCreateTime(null);
					equipmentExamineItemMapper.updateByPrimaryKeySelective(equipmentExamineItem2);
				}
			}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", equipmentExamine.getId().toString()));
	}

	@Override
	public ResponseEntity<EquipmentExamineListResponse> getExamineList(
			ApiRequestBase<EquipmentExamineListRequest> request) {
		EquipmentExamineListRequest equipmentExamineListRequest = request.getData();
		Long id = equipmentExamineListRequest.getId();
		EquipmentExamineExample example = new EquipmentExamineExample();
		example.createCriteria().andEquipIdEqualTo(id);
		List<EquipmentExamine> equipmentExamines = equipmentExamineMapper.selectByExample(example);
		EquipmentExamineListResponse equipmentExamineListResponse = new EquipmentExamineListResponse();
		equipmentExamineListResponse.code(ApiResponseBase.CODE_SUCCESSFUL);
		for (EquipmentExamine equipmentExamine : equipmentExamines) {
			com.clinicalmall.kuaixiu.vo.EquipmentExamine dataItem = new com.clinicalmall.kuaixiu.vo.EquipmentExamine();
			BeanUtils.copyProperties(equipmentExamine, dataItem);
			equipmentExamineListResponse.addDataItem(dataItem);
		}
		return ResponseEntity.ok(equipmentExamineListResponse);
	}

	@Override
	public ResponseEntity<EquipmentExamineItemListResponse> getExamineItemList(
			ApiRequestBase<EquipmentExamineItemListRequest> request) {
		EquipmentExamineItemListRequest equipmentExamineItemListRequest = request.getData();
		Long id = equipmentExamineItemListRequest.getId();
		EquipmentExamineItemExample example = new EquipmentExamineItemExample();
		example.createCriteria().andExamineIdEqualTo(id);
		List<com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem> exEquipmentExamineItems = equipmentExamineItemMapper
				.selectByExample(example);
		EquipmentExamineItemListResponse equipmentExamineItemListResponse = new EquipmentExamineItemListResponse();
		equipmentExamineItemListResponse.code(ApiResponseBase.CODE_SUCCESSFUL);
		for (com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem : exEquipmentExamineItems) {
			com.clinicalmall.kuaixiu.vo.EquipmentExamineItem dataItem = new com.clinicalmall.kuaixiu.vo.EquipmentExamineItem();
			BeanUtils.copyProperties(equipmentExamineItem, dataItem);
			equipmentExamineItemListResponse.addDataItem(dataItem);
		}
		return ResponseEntity.ok(equipmentExamineItemListResponse);
	}

	@Override
	public ResponseEntity<CommonResponse> archiveExamine(ApiRequestBase<EquipmentExamineSaveRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		EquipmentExamineSaveRequest equipmentExamineSaveRequest = request.getData();
		Long id = equipmentExamineSaveRequest.getId();
		Long equipId = equipmentExamineSaveRequest.getEquipId();
		String conclusion = equipmentExamineSaveRequest.getConclusion();
		String reference = equipmentExamineSaveRequest.getReference();
		Date examineTime = equipmentExamineSaveRequest.getExamineTime();
		List<EquipmentExamineItem> examineItems = equipmentExamineSaveRequest.getExamineItems();

		com.clinicalmall.kuaixiu.persistent.domain.Equipment equipment = equipmentMapper.selectByPrimaryKey(equipId);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| equipment.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		EquipmentExamine equipmentExamine = null;
		if (id == null) {// 新增时验证是否已经有验收
			EquipmentExamineExample example = new EquipmentExamineExample();
			example.createCriteria().andEquipIdEqualTo(equipId);
			List<EquipmentExamine> equipmentExamines = equipmentExamineMapper.selectByExample(example);
			if (equipmentExamines != null && equipmentExamines.size() > 0)
				return ResponseEntity.ok(genCommonResponseWithFailed("设备验收记录已存在！"));
		} else {
			equipmentExamine = equipmentExamineMapper.selectByPrimaryKey(id);
			if (equipmentExamine == null || equipmentExamine.getStatus() == Constants.EQUIPMENT_EXAMINE_STATUS_ARCHIVED
					|| equipmentExamine.getOrgId() != user.getOrgId())
				return ResponseEntity.ok(genCommonResponseWithFailed("设备验收不存在或已归档或不属于本组织！"));
		}

		if (equipmentExamine == null) {
			equipmentExamine = new EquipmentExamine();
			equipmentExamine.setCreateTime(new Date());
			equipmentExamine.setCreateUser(user.getId());
			equipmentExamine.setOrgId(user.getOrgId());
			equipmentExamine.setEquipId(equipId);
		}
		equipmentExamine.setUpdateTime(new Date());
		equipmentExamine.setUpdateUser(user.getId());
		equipmentExamine.setConclusion(conclusion);
		equipmentExamine.setReference(reference);
		equipmentExamine.setExamineTime(examineTime);
		equipmentExamine.setStatus(Constants.EQUIPMENT_EXAMINE_STATUS_ARCHIVED);
		if (id == null)
			equipmentExamineMapper.insertSelective(equipmentExamine);
		else
			equipmentExamineMapper.updateByPrimaryKeySelective(equipmentExamine);
		if (examineItems != null)
			for (EquipmentExamineItem equipmentExamineItem : examineItems) {
				Long id2 = equipmentExamineItem.getId();
				com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem2 = new com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem();
				BeanUtils.copyProperties(equipmentExamineItem, equipmentExamineItem2);
				equipmentExamineItem2.setUpdateTime(new Date());
				equipmentExamineItem2.setUpdateUser(user.getId());
				equipmentExamineItem2.setExamineId(equipmentExamine.getId());
				if (id2 == null) {
					equipmentExamineItem2.setCreateUser(user.getId());
					equipmentExamineItem2.setCreateTime(new Date());
					equipmentExamineItemMapper.insertSelective(equipmentExamineItem2);
				} else {
					equipmentExamineItem2.setCreateUser(null);
					equipmentExamineItem2.setCreateTime(null);
					equipmentExamineItemMapper.updateByPrimaryKeySelective(equipmentExamineItem2);
				}
			}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", equipmentExamine.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> saveExamineItem(ApiRequestBase<EquipmentExamineItem> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		EquipmentExamineItem data = request.getData();
		Long id = data.getId();
		Long examineId = data.getExamineId();
		if (examineId == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备验收ID不能为空！"));
		EquipmentExamine equipmentExamine = equipmentExamineMapper.selectByPrimaryKey(examineId);
		if (equipmentExamine == null || equipmentExamine.getStatus() == Constants.EQUIPMENT_EXAMINE_STATUS_ARCHIVED
				|| equipmentExamine.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备验收记录不存在或已归档或不属于本组织！"));
		if (id == null) {// 新增
			com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem = new com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem();
			BeanUtils.copyProperties(data, equipmentExamineItem);
			equipmentExamineItem.setCreateUser(user.getId());
			equipmentExamineItem.setCreateTime(new Date());
			equipmentExamineItem.setUpdateUser(user.getId());
			equipmentExamineItem.setUpdateTime(new Date());
			equipmentExamineItemMapper.insertSelective(equipmentExamineItem);
		} else {// 更新
			com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem = equipmentExamineItemMapper
					.selectByPrimaryKey(id);
			if (equipmentExamineItem == null || equipmentExamineItem.getExamineId() != examineId)
				return ResponseEntity.ok(genCommonResponseWithFailed("设备验收项目不存在或不属于给定的设备验收记录！"));
			BeanUtils.copyProperties(data, equipmentExamineItem, "createUser", "createTime");
			equipmentExamineItem.setUpdateUser(user.getId());
			equipmentExamineItem.setUpdateTime(new Date());
			equipmentExamineItemMapper.updateByPrimaryKeySelective(equipmentExamineItem);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", id.toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> deleteExamineItem(ApiRequestBase<EquipmentExamineItemDeleteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		Long id = request.getData().getId();
		com.clinicalmall.kuaixiu.persistent.domain.EquipmentExamineItem equipmentExamineItem = equipmentExamineItemMapper
				.selectByPrimaryKey(id);
		EquipmentExamine equipmentExamine = equipmentExamineMapper
				.selectByPrimaryKey(equipmentExamineItem.getExamineId());
		if (equipmentExamine == null || equipmentExamine.getStatus() == Constants.EQUIPMENT_EXAMINE_STATUS_ARCHIVED
				|| equipmentExamine.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备验收记录不存在或已归档或不属于本组织！"));
		equipmentExamineItemMapper.deleteByPrimaryKey(id);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("删除成功！", equipmentExamineItem.getId().toString()));
	}

}
