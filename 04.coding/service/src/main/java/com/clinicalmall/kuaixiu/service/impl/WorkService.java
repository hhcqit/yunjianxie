package com.clinicalmall.kuaixiu.service.impl;

import java.util.ArrayList;
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
import com.clinicalmall.kuaixiu.persistent.dao.AttachmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.CustomizedMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgMapper;
import com.clinicalmall.kuaixiu.persistent.dao.PlanMapper;
import com.clinicalmall.kuaixiu.persistent.dao.WorkMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Attachment;
import com.clinicalmall.kuaixiu.persistent.domain.Equipment;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.persistent.domain.Work;
import com.clinicalmall.kuaixiu.persistent.domain.WorkExample;
import com.clinicalmall.kuaixiu.persistent.domain.WorkExample.Criteria;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.service.IWorkService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetWorkRequest;
import com.clinicalmall.kuaixiu.vo.GetWorkResponse;
import com.clinicalmall.kuaixiu.vo.WorkExecuteRequest;
import com.clinicalmall.kuaixiu.vo.WorkListRequest;
import com.clinicalmall.kuaixiu.vo.WorkListResponse;
import com.clinicalmall.kuaixiu.vo.WorkSaveRequest;

import redis.clients.jedis.ShardedJedisPool;

@Transactional
@Service
public class WorkService extends AbsService implements IWorkService {
	private static final Logger log = LoggerFactory.getLogger(WorkService.class);
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
	private EquipmentMapper equipmentMapper;
	@Resource
	private PlanMapper planMapper;
	@Resource
	private WorkMapper workMapper;
	@Resource
	private AttachmentMapper attachmentMapper;

	@Override
	public ResponseEntity<CommonResponse> save(ApiRequestBase<WorkSaveRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		WorkSaveRequest workSaveRequest = request.getData();
		Long equipId = workSaveRequest.getEquipId();
		Integer type = workSaveRequest.getType();
		String name = workSaveRequest.getName();
		String content = workSaveRequest.getContent();
		Equipment equipment = equipmentMapper.selectByPrimaryKey(equipId);
		if (equipment == null || equipment.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		Work work = new Work();
		work.setCreateTime(new Date());
		work.setUpdateTime(new Date());
		work.setCreateUser(user.getId());
		work.setUpdateUser(user.getId());
		work.setOrgId(user.getOrgId());
		work.setPlanId(0l);
		work.setEquipId(equipId);
		work.setType(type);
		work.setOrigin(Constants.WORK_ORIGIN_TEMPORARY);
		work.setExecutePermission(Constants.EXECUTE_PERMISSION_INNER);
		work.setPeriodType(Constants.PLAN_PERIOD_TYPE_CUSTOMIZED);
		work.setPeriod(0);
		work.setLabId(equipment.getLabId());
		work.setProviderId(equipment.getProviderId());
		work.setAcceptTime(new Date());
		work.setName(name);
		work.setContent(content);
		work.setRemark("新增作业");
		workMapper.insertSelective(work);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功！", work.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> execute(ApiRequestBase<WorkExecuteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		WorkExecuteRequest workExecuteRequest = request.getData();
		Long id = workExecuteRequest.getId();
		String certificateNo = workExecuteRequest.getCertificateNo();
		String certificateFile = workExecuteRequest.getCertificateFile();
		String result = workExecuteRequest.getResult();
		String attachmentIds = workExecuteRequest.getAttachmentIds();

		Work work = workMapper.selectByPrimaryKey(id);
		if (work == null || work.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| work.getStatus() != Constants.WORK_STATUS_ORIGIN)
			return ResponseEntity.ok(genCommonResponseWithFailed("作业不存在或者作业已完成！"));
		List<Attachment> attachments = new ArrayList<>();
		if (StringUtils.isNoneBlank(attachmentIds)) {
			String[] ids = attachmentIds.split(",");
			for (String attachmentId : ids) {
				if (StringUtils.isNoneBlank(attachmentId)) {
					Attachment attachment = attachmentMapper.selectByPrimaryKey(Long.parseLong(attachmentId));
					if (attachment == null || attachment.getStatus() == Constants.FLAG_TRUE)
						return ResponseEntity.ok(genCommonResponseWithFailed("附件不存在或已经被使用！"));
					attachments.add(attachment);
				}
			}
		}

		work.setExecuteOrgId(user.getOrgId());
		work.setExecuteUser(user.getId());
		work.setExecuteTime(new Date());
		work.setFinishedTime(new Date());
		work.setCertificateNo(certificateNo);
		work.setCertificateFileName(certificateFile);
		work.setResult(result);
		work.setUpdateTime(new Date());
		work.setUpdateUser(user.getId());
		work.setStatus(Constants.WORK_STATUS_FINISHED);
		work.setRemark("执行作业");
		workMapper.updateByPrimaryKeySelective(work);
		for (Attachment attachment : attachments) {
			attachment.setTableId(work.getId().toString());
			attachment.setTableName(Work.class.getSimpleName());
			attachment.setStatus(Constants.FLAG_TRUE);
			attachment.setUpdateUser(user.getId());
			attachment.setUpdateTime(new Date());
			attachmentMapper.updateByPrimaryKeySelective(attachment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("作业执行成功！", null));
	}

	@Override
	public ResponseEntity<WorkListResponse> getList(ApiRequestBase<WorkListRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genWorkListResponseWithInvalidToken());
		}
		Long orgId = user.getOrgId();
		Org org = orgMapper.selectByPrimaryKey(orgId);
		WorkListRequest workListRequest = request.getData();
		Integer pageNumber = workListRequest.getPageNumber();
		Integer pageSize = workListRequest.getPageSize();
		Integer type = workListRequest.getType();
		Long equipId = workListRequest.getEquipId();
		String name = workListRequest.getName();
		Integer status = workListRequest.getStatus();
		// WorkExample example = new WorkExample();
		// // 本组织创建的，执行权限为非外部执行的作业（内部或不限）
		// Criteria criteria =
		// example.createCriteria().andOrgIdEqualTo(user.getOrgId()).andTypeEqualTo(type)
		// .andExecutePermissionNotEqualTo(Constants.EXECUTE_PERMISSION_OUTER);
		// criteria.andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
		// if (equipId != null)
		// criteria.andEquipIdEqualTo(equipId);
		// if (status != null)
		// criteria.andStatusEqualTo(status);
		// if (StringUtils.isNoneBlank(name))
		// criteria.andNameLike(name);
		// // 关联组织创建的，执行权限为非内部执行的作业（外包或不限）
		// Criteria criteria2 =
		// example.createCriteria().andOrgIdNotEqualTo(user.getOrgId()).andTypeEqualTo(type);
		// if (org.getType() == Constants.ORG_TYPE_LAB)
		// criteria2.andLabIdEqualTo(orgId);
		// else
		// criteria2.andProviderIdEqualTo(orgId);
		// criteria2.andExecutePermissionNotEqualTo(Constants.EXECUTE_PERMISSION_INNER);
		// criteria2.andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
		// if (equipId != null)
		// criteria2.andEquipIdEqualTo(equipId);
		// if (status != null)
		// criteria2.andStatusEqualTo(status);
		// if (StringUtils.isNoneBlank(name))
		// criteria2.andNameLike(name);
		// example.or(criteria2);
		// long total = workMapper.countByExample(example);
		// example.setPage(new Page(pageNumber, pageSize));
		// List<Work> works = workMapper.selectByExample(example);
		// List<com.clinicalmall.kuaixiu.vo.Work> data = new ArrayList<>();
		// for (Work work : works) {
		// com.clinicalmall.kuaixiu.vo.Work work2 = new
		// com.clinicalmall.kuaixiu.vo.Work();
		// BeanUtils.copyProperties(work, work2);
		// data.add(work2);
		// }

		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", user.getOrgId());
		where.put("type", type);
		where.put("orgType", org.getType());
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		if (equipId != null)
			where.put("equipId", equipId);
		if (status != null)
			where.put("status", status);
		if (StringUtils.isNoneBlank(name))
			where.put("name", "%" + name + "%");
		long total = customizedMapper.countWork(where);
		where.put("page", new Page(pageNumber, pageSize));
		List<com.clinicalmall.kuaixiu.vo.Work> data = customizedMapper.selectWork(where);

		return ResponseEntity.ok(genWorkListResponseWithSuccessful("查询成功", total, data));
	}

	@Override
	public ResponseEntity<GetWorkResponse> getWork(ApiRequestBase<GetWorkRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(new GetWorkResponse().code(ApiResponseBase.CODE_INVALID_SESSION).msg("用户未登录！"));
		}
		Long id = request.getData().getId();
		Work work = workMapper.selectByPrimaryKey(id);
		if (work == null || work.getDeleteStatus() == Constants.DELETE_STATUS_TRUE)
			return ResponseEntity.ok(new GetWorkResponse().code(ApiResponseBase.CODE_FAILED).msg("作业不存在或已删除！"));
		if (work.getOrgId() != user.getOrgId())
			return ResponseEntity.ok(new GetWorkResponse().code(ApiResponseBase.CODE_FAILED).msg("非本组织作业！"));
		com.clinicalmall.kuaixiu.vo.Work data = new com.clinicalmall.kuaixiu.vo.Work();
		BeanUtils.copyProperties(work, data);
		return ResponseEntity.ok(new GetWorkResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("查询成功！").data(data));
	}

}
