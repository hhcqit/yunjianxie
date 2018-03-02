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
import com.clinicalmall.kuaixiu.persistent.dao.TaskCommentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.TaskMapper;
import com.clinicalmall.kuaixiu.persistent.dao.TaskModifyMapper;
import com.clinicalmall.kuaixiu.persistent.dao.TaskRepairMapper;
import com.clinicalmall.kuaixiu.persistent.dao.TaskSupplementMapper;
import com.clinicalmall.kuaixiu.persistent.dao.WorkMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Attachment;
import com.clinicalmall.kuaixiu.persistent.domain.Equipment;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.Task;
import com.clinicalmall.kuaixiu.persistent.domain.TaskComment;
import com.clinicalmall.kuaixiu.persistent.domain.TaskModify;
import com.clinicalmall.kuaixiu.persistent.domain.TaskRepair;
import com.clinicalmall.kuaixiu.persistent.domain.TaskRepairExample;
import com.clinicalmall.kuaixiu.persistent.domain.TaskSupplement;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.ITaskService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.service.redis.IDGenerator;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetTaskByTaskNoRequest;
import com.clinicalmall.kuaixiu.vo.GetTaskRequest;
import com.clinicalmall.kuaixiu.vo.GetTaskResponse;
import com.clinicalmall.kuaixiu.vo.TaskAcceptRequest;
import com.clinicalmall.kuaixiu.vo.TaskCancelRequest;
import com.clinicalmall.kuaixiu.vo.TaskCloseRequest;
import com.clinicalmall.kuaixiu.vo.TaskCommentRequest;
import com.clinicalmall.kuaixiu.vo.TaskDeleteRequest;
import com.clinicalmall.kuaixiu.vo.TaskExamineRequest;
import com.clinicalmall.kuaixiu.vo.TaskExecuteRequest;
import com.clinicalmall.kuaixiu.vo.TaskListRequest;
import com.clinicalmall.kuaixiu.vo.TaskListResponse;
import com.clinicalmall.kuaixiu.vo.TaskModifyRequest;
import com.clinicalmall.kuaixiu.vo.TaskSaveRequest;
import com.clinicalmall.kuaixiu.vo.TaskSendBackRequest;
import com.clinicalmall.kuaixiu.vo.TaskSupplementRequest;

import redis.clients.jedis.ShardedJedisPool;

@Transactional
@Service
public class TaskService extends AbsService implements ITaskService {
	private static final Logger log = LoggerFactory.getLogger(TaskService.class);
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
	private TaskMapper taskMapper;
	@Resource
	private TaskModifyMapper taskModifyMapper;
	@Resource
	private TaskSupplementMapper taskSupplementMapper;
	@Resource
	private TaskRepairMapper taskRepairMapper;
	@Resource
	private TaskCommentMapper taskCommentMapper;
	@Resource
	private AttachmentMapper attachmentMapper;

	@Override
	public ResponseEntity<TaskListResponse> getList(ApiRequestBase<TaskListRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(new TaskListResponse().code(ApiResponseBase.CODE_INVALID_SESSION).msg("用户未登录！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		TaskListRequest taskListRequest = request.getData();
		Integer own = taskListRequest.getOwn();
		Integer pageNumber = taskListRequest.getPageNumber();
		Integer pageSize = taskListRequest.getPageSize();
		Integer status = taskListRequest.getStatus();
		Map<String, Object> where = new HashMap<String, Object>();
		if (own != null && own == 1)
			where.put("userId", user.getId());
		where.put("orgId", user.getOrgId());
		where.put("orgType", org.getType());
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		where.put("status", status);
		Long total = customizedMapper.countTask(where);
		where.put("page", new Page(pageNumber, pageSize));
		List<com.clinicalmall.kuaixiu.vo.Task> data = customizedMapper.selectTask(where);
		return ResponseEntity.ok(
				new TaskListResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("查询成功！").totalRow(total).data(data));
	}

	@Override
	public ResponseEntity<GetTaskResponse> getTask(ApiRequestBase<GetTaskRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_INVALID_SESSION).msg("用户未登录！"));
		}
		GetTaskRequest getTaskRequest = request.getData();
		Long id = getTaskRequest.getId();
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("id", id);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		List<com.clinicalmall.kuaixiu.vo.Task> data = customizedMapper.selectTask(where);
		com.clinicalmall.kuaixiu.vo.Task task = null;
		if (data != null && data.size() > 0)
			task = data.get(0);
		if (task == null)
			return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_FAILED).msg("任务不存在或已删除！"));
		where.clear();
		where.put("taskId", task.getId());
		List<com.clinicalmall.kuaixiu.vo.TaskModify> taskModifies = customizedMapper.selectTaskModify(where);
		task.setTaskModifies(taskModifies);
		List<com.clinicalmall.kuaixiu.vo.TaskComment> taskComments = customizedMapper.selectTaskComment(where);
		task.setTaskComments(taskComments);
		List<com.clinicalmall.kuaixiu.vo.TaskSupplement> taskSupplements = customizedMapper.selectTaskSupplement(where);
		task.setTaskSupplements(taskSupplements);
		List<com.clinicalmall.kuaixiu.vo.TaskRepair> taskRepairs = customizedMapper.selectTaskRepair(where);
		task.setTaskRepairs(taskRepairs);
		return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("查询成功！").data(task));
	}

	@Override
	public ResponseEntity<GetTaskResponse> getTaskByTaskNo(ApiRequestBase<GetTaskByTaskNoRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_INVALID_SESSION).msg("用户未登录！"));
		}
		GetTaskByTaskNoRequest taskByTaskNoRequest = request.getData();
		String taskNo = taskByTaskNoRequest.getTaskNo();
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("taskNo", taskNo);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);// 只查询未删除的
		List<com.clinicalmall.kuaixiu.vo.Task> data = customizedMapper.selectTask(where);
		com.clinicalmall.kuaixiu.vo.Task task = null;
		if (data != null && data.size() > 0)
			task = data.get(0);
		if (task == null)
			return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_FAILED).msg("任务不存在或已删除！"));
		where.clear();
		where.put("taskId", task.getId());
		List<com.clinicalmall.kuaixiu.vo.TaskModify> taskModifies = customizedMapper.selectTaskModify(where);
		task.setTaskModifies(taskModifies);
		List<com.clinicalmall.kuaixiu.vo.TaskComment> taskComments = customizedMapper.selectTaskComment(where);
		task.setTaskComments(taskComments);
		List<com.clinicalmall.kuaixiu.vo.TaskSupplement> taskSupplements = customizedMapper.selectTaskSupplement(where);
		task.setTaskSupplements(taskSupplements);
		List<com.clinicalmall.kuaixiu.vo.TaskRepair> taskRepairs = customizedMapper.selectTaskRepair(where);
		task.setTaskRepairs(taskRepairs);
		return ResponseEntity.ok(new GetTaskResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("查询成功！").data(task));
	}

	@Override
	public ResponseEntity<CommonResponse> save(ApiRequestBase<TaskSaveRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskSaveRequest taskSaveRequest = request.getData();
		Long equipId = taskSaveRequest.getEquipId();
		String description = taskSaveRequest.getDescription();
		String attachmentIds = taskSaveRequest.getAttachmentIds();
		Equipment equipment = equipmentMapper.selectByPrimaryKey(equipId);
		if (equipment == null || equipment.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| !(user.getOrgId() == equipment.getLabId() || user.getOrgId() == equipment.getProviderId()))
			return ResponseEntity.ok(genCommonResponseWithFailed("设备不存在或者非本组织设备！"));
		if (equipment.getLabId() == null || equipment.getProviderId() == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("设备没有关联实验室或服务商！"));
		if (StringUtils.isBlank(description))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务描述不能为空！"));
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
		Task task = new Task();
		task.setTaskNo(IDGenerator.gen(null, IDGenerator.PATTERN_YYYYMMDD, 8, "task_no"));
		task.setOrgId(user.getOrgId());
		task.setCreateTime(new Date());
		task.setCreateUser(user.getId());
		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setEquipId(equipId);
		task.setDescription(description);
		task.setLabId(equipment.getLabId());
		task.setProviderId(equipment.getProviderId());
		task.setStatus(Constants.TASK_STATUS_TO_BE_ACCEPT);
		taskMapper.insertSelective(task);
		TaskModify taskModify = new TaskModify();
		taskModify.setTaskId(task.getId());
		taskModify.setCreateTime(new Date());
		taskModify.setCreateUser(user.getId());
		taskModify.setDescription(description);
		taskModify.setEquipId(equipId);
		taskModify.setEquipName(equipment.getName());
		taskModify.setEquipCode(equipment.getCode());
		taskModifyMapper.insertSelective(taskModify);
		for (Attachment attachment : attachments) {
			attachment.setTableId(taskModify.getId().toString());
			attachment.setTableName(TaskModify.class.getSimpleName());
			attachment.setStatus(Constants.FLAG_TRUE);
			attachment.setUpdateUser(user.getId());
			attachment.setUpdateTime(new Date());
			attachmentMapper.updateByPrimaryKeySelective(attachment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("保存成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> modify(ApiRequestBase<TaskModifyRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskModifyRequest taskModifyRequest = request.getData();
		Long id = taskModifyRequest.getId();
		String description = taskModifyRequest.getDescription();
		String attachmentIds = taskModifyRequest.getAttachmentIds();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| !(task.getStatus() == Constants.TASK_STATUS_TO_BE_ACCEPT
						|| task.getStatus() == Constants.TASK_STATUS_TO_BE_REPAIR))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或不允许修改！"));

		if (task.getCreateUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务创建用户！"));
		if (StringUtils.isBlank(description))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务描述不能为空！"));
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
		Equipment equipment = equipmentMapper.selectByPrimaryKey(task.getEquipId());
		task.setDescription(description);
		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setModifyStatus(Constants.FLAG_TRUE);
		taskMapper.updateByPrimaryKeySelective(task);
		TaskModify taskModify = new TaskModify();
		taskModify.setTaskId(task.getId());
		taskModify.setCreateTime(new Date());
		taskModify.setCreateUser(user.getId());
		taskModify.setDescription(description);
		taskModify.setEquipId(equipment.getId());
		taskModify.setEquipName(equipment.getName());
		taskModify.setEquipCode(equipment.getCode());
		taskModifyMapper.insertSelective(taskModify);
		for (Attachment attachment : attachments) {
			attachment.setTableId(taskModify.getId().toString());
			attachment.setTableName(TaskModify.class.getSimpleName());
			attachment.setStatus(Constants.FLAG_TRUE);
			attachment.setUpdateUser(user.getId());
			attachment.setUpdateTime(new Date());
			attachmentMapper.updateByPrimaryKeySelective(attachment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("修改成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> cancel(ApiRequestBase<TaskCancelRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskCancelRequest taskCancelRequest = request.getData();
		Long id = taskCancelRequest.getId();
		String reason = taskCancelRequest.getReason();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| !(task.getStatus() == Constants.TASK_STATUS_TO_BE_ACCEPT
						|| task.getStatus() == Constants.TASK_STATUS_TO_BE_REPAIR))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或不允许取消！"));
		if (task.getCreateUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务创建用户！"));
		if (StringUtils.isBlank(reason))
			return ResponseEntity.ok(genCommonResponseWithFailed("取消原因不能为空！"));
		task.setCanceledReason(reason);
		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setStatus(Constants.TASK_STATUS_CREATOR_CANCEL);
		taskMapper.updateByPrimaryKeySelective(task);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("取消成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> examine(ApiRequestBase<TaskExamineRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskExamineRequest taskExamineRequest = request.getData();
		Long id = taskExamineRequest.getId();
		String action = taskExamineRequest.getAction();
		String examineCalibrate = taskExamineRequest.getExamineCalibrate();
		String examineDescription = taskExamineRequest.getExamineDescription();
		String examineQc = taskExamineRequest.getExamineQc();
		String examineSample = taskExamineRequest.getExamineSample();
		Integer malfunctionDuration = taskExamineRequest.getMalfunctionDuration();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| task.getStatus() != Constants.TASK_STATUS_TO_BE_CONFIRMED)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或未被受理！"));
		if (task.getCreateUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务创建用户！"));
		if (StringUtils.isBlank(action))
			return ResponseEntity.ok(genCommonResponseWithFailed("验收动作不能为空！"));

		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		if (action.equals("0"))
			task.setStatus(Constants.TASK_STATUS_TO_BE_REPAIR);
		else
			task.setStatus(Constants.TASK_STATUS_FINISHED);
		task.setExaminerUser(user.getId());
		task.setExamineTime(new Date());
		task.setExamineCalibrate(examineCalibrate);
		task.setExamineDescription(examineDescription);
		task.setExamineQc(examineQc);
		task.setExamineSample(examineSample);
		task.setMalfunctionDuration(malfunctionDuration);
		task.setRemark("验收任务");
		taskMapper.updateByPrimaryKey(task);

		return ResponseEntity.ok(genCommonResponseWithSuccessful("验收成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> comment(ApiRequestBase<TaskCommentRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskCommentRequest taskCommentRequest = request.getData();
		Long id = taskCommentRequest.getId();
		String description = taskCommentRequest.getDescription();
		Integer response = taskCommentRequest.getResponse();
		Integer service = taskCommentRequest.getService();
		Integer technology = taskCommentRequest.getTechnology();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| !(task.getStatus() == Constants.TASK_STATUS_FINISHED
						|| task.getStatus() == Constants.TASK_STATUS_CLOSED))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或还未完成！"));
		if (task.getCommentStatus() == Constants.FLAG_TRUE)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务已评价！"));
		if (task.getCreateUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务创建用户！"));
		if (StringUtils.isBlank(description))
			return ResponseEntity.ok(genCommonResponseWithFailed("评价描述不能为空！"));

		task.setDescription(description);
		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setCommentStatus(Constants.FLAG_TRUE);
		taskMapper.updateByPrimaryKeySelective(task);
		TaskComment taskComment = new TaskComment();
		taskComment.setTaskId(task.getId());
		taskComment.setCreateTime(new Date());
		taskComment.setCreateUser(user.getId());
		taskComment.setDescription(description);
		taskComment.setService(service);
		taskComment.setResponse(response);
		taskComment.setTechnology(technology);
		taskCommentMapper.insertSelective(taskComment);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("评价成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> accept(ApiRequestBase<TaskAcceptRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskAcceptRequest taskAcceptRequest = request.getData();
		Long id = taskAcceptRequest.getId();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| task.getStatus() != Constants.TASK_STATUS_TO_BE_ACCEPT)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或已被受理！"));
		if (task.getProviderId() != user.getOrgId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非本组织任务！"));
		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setAcceptTime(new Date());
		task.setRepairerUser(user.getId());
		task.setStatus(Constants.TASK_STATUS_TO_BE_REPAIR);
		taskMapper.updateByPrimaryKeySelective(task);
		TaskRepair taskRepair = new TaskRepair();
		taskRepair.setTaskId(task.getId());
		taskRepair.setCreateTime(new Date());
		taskRepair.setCreateUser(user.getId());
		taskRepair.setAcceptTime(new Date());
		taskRepairMapper.insertSelective(taskRepair);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("受理成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> sendBack(ApiRequestBase<TaskSendBackRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskSendBackRequest taskSendBackRequest = request.getData();
		Long id = taskSendBackRequest.getId();
		String reason = taskSendBackRequest.getReason();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| task.getStatus() != Constants.TASK_STATUS_TO_BE_REPAIR)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或未被受理！"));
		if (task.getRepairerUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务受理用户！"));
		if (StringUtils.isBlank(reason))
			return ResponseEntity.ok(genCommonResponseWithFailed("退回原因不能为空！"));
		TaskRepairExample example = new TaskRepairExample();
		example.createCriteria().andTaskIdEqualTo(task.getId()).andCreateUserEqualTo(user.getId())
				.andStatusEqualTo(Constants.TASK_REPAIR_STATUS_ORIGINAL);
		List<TaskRepair> taskRepairs = taskRepairMapper.selectByExample(example);
		if (taskRepairs == null || taskRepairs.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("任务维修记录不存在！"));

		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setAcceptTime(null);
		task.setRepairerUser(null);
		task.setStatus(Constants.TASK_STATUS_TO_BE_ACCEPT);
		task.setSendBackStatus(Constants.FLAG_TRUE);
		task.setSendBackReason(reason);
		taskMapper.updateByPrimaryKey(task);

		TaskRepair taskRepair = taskRepairs.get(0);
		taskRepair.setStatus(Constants.TASK_REPAIR_STATUS_REJECT);
		taskRepair.setReason(reason);
		taskRepair.setFinishedTime(new Date());
		taskRepairMapper.updateByPrimaryKeySelective(taskRepair);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("退回成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> supplement(ApiRequestBase<TaskSupplementRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskSupplementRequest taskSupplementRequest = request.getData();
		Long id = taskSupplementRequest.getId();
		String description = taskSupplementRequest.getDescription();
		Integer visibleStatus = taskSupplementRequest.getVisibleStatus();
		String attachmentIds = taskSupplementRequest.getAttachmentIds();

		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| task.getStatus() != Constants.TASK_STATUS_TO_BE_REPAIR)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或未被受理！"));
		if (task.getRepairerUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务受理用户！"));
		if (StringUtils.isBlank(description))
			return ResponseEntity.ok(genCommonResponseWithFailed("补充描述不能为空！"));
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

		task.setSupplementStatus(Constants.FLAG_TRUE);
		taskMapper.updateByPrimaryKey(task);

		TaskSupplement taskSupplement = new TaskSupplement();
		taskSupplement.setTaskId(task.getId());
		taskSupplement.setCreateTime(new Date());
		taskSupplement.setCreateUser(user.getId());
		taskSupplement.setDescription(description);
		taskSupplement.setVisibleStatus(visibleStatus);
		taskSupplementMapper.insertSelective(taskSupplement);
		for (Attachment attachment : attachments) {
			attachment.setTableId(taskSupplement.getId().toString());
			attachment.setTableName(TaskSupplement.class.getSimpleName());
			attachment.setStatus(Constants.FLAG_TRUE);
			attachment.setUpdateUser(user.getId());
			attachment.setUpdateTime(new Date());
			attachmentMapper.updateByPrimaryKeySelective(attachment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("补充成功", taskSupplement.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> execute(ApiRequestBase<TaskExecuteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskExecuteRequest taskExecuteRequest = request.getData();
		Long id = taskExecuteRequest.getId();
		String description = taskExecuteRequest.getDescription();
		Integer visibleStatus = taskExecuteRequest.getVisibleStatus();
		String attachmentIds = taskExecuteRequest.getAttachmentIds();
		Task task = taskMapper.selectByPrimaryKey(id);
		if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
				|| task.getStatus() != Constants.TASK_STATUS_TO_BE_REPAIR)
			return ResponseEntity.ok(genCommonResponseWithFailed("任务不存在或未被受理！"));
		if (task.getRepairerUser() != user.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("非任务受理用户！"));
		if (StringUtils.isBlank(description))
			return ResponseEntity.ok(genCommonResponseWithFailed("维修描述不能为空！"));
		TaskRepairExample example = new TaskRepairExample();
		example.createCriteria().andTaskIdEqualTo(task.getId()).andCreateUserEqualTo(user.getId())
				.andStatusEqualTo(Constants.TASK_REPAIR_STATUS_ORIGINAL);
		List<TaskRepair> taskRepairs = taskRepairMapper.selectByExample(example);
		if (taskRepairs == null || taskRepairs.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("任务维修记录不存在！"));
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

		task.setUpdateTime(new Date());
		task.setUpdateUser(user.getId());
		task.setStatus(Constants.TASK_STATUS_TO_BE_CONFIRMED);
		task.setRepairDescription(description);
		task.setRepairedTime(new Date());
		taskMapper.updateByPrimaryKey(task);

		TaskRepair taskRepair = taskRepairs.get(0);
		taskRepair.setStatus(Constants.TASK_REPAIR_STATUS_FINISHED);
		taskRepair.setDescription(description);
		taskRepair.setVisibleStatus(visibleStatus);
		taskRepair.setFinishedTime(new Date());
		taskRepairMapper.updateByPrimaryKeySelective(taskRepair);

		for (Attachment attachment : attachments) {
			attachment.setTableId(taskRepair.getId().toString());
			attachment.setTableName(TaskRepair.class.getSimpleName());
			attachment.setStatus(Constants.FLAG_TRUE);
			attachment.setUpdateUser(user.getId());
			attachment.setUpdateTime(new Date());
			attachmentMapper.updateByPrimaryKeySelective(attachment);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("修理成功", task.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> close(ApiRequestBase<TaskCloseRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskCloseRequest taskCloseRequest = request.getData();
		String ids = taskCloseRequest.getIds();
		if (StringUtils.isBlank(ids))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务ID不能为空！"));
		String[] taskIds = ids.split(",");
		List<Task> tasks = new ArrayList<>();
		for (String taskId : taskIds) {
			Task task = taskMapper.selectByPrimaryKey(Long.parseLong(taskId));
			if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
					|| task.getStatus() != Constants.TASK_STATUS_FINISHED) {
				return ResponseEntity.ok(genCommonResponseWithFailed("任务[" + taskId + "]不存在或还未完成！"));
			}
			tasks.add(task);
		}
		for (Task task : tasks) {
			task.setStatus(Constants.TASK_STATUS_CLOSED);
			task.setUpdateUser(user.getId());
			task.setUpdateTime(new Date());
			task.setRemark("关闭任务");
			taskMapper.updateByPrimaryKeySelective(task);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("关闭成功"));
	}

	@Override
	public ResponseEntity<CommonResponse> delete(ApiRequestBase<TaskDeleteRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		TaskDeleteRequest taskDeleteRequest = request.getData();
		String ids = taskDeleteRequest.getIds();
		if (StringUtils.isBlank(ids))
			return ResponseEntity.ok(genCommonResponseWithFailed("任务ID不能为空！"));
		String[] taskIds = ids.split(",");
		List<Task> tasks = new ArrayList<>();
		for (String taskId : taskIds) {
			Task task = taskMapper.selectByPrimaryKey(Long.parseLong(taskId));
			if (task == null || task.getDeleteStatus() == Constants.DELETE_STATUS_TRUE
					|| task.getStatus() != Constants.TASK_STATUS_CLOSED) {
				return ResponseEntity.ok(genCommonResponseWithFailed("任务[" + taskId + "]不存在或当前状态不允许删除！"));
			}
			tasks.add(task);
		}
		for (Task task : tasks) {
			task.setDeleteStatus(Constants.DELETE_STATUS_TRUE);
			task.setUpdateUser(user.getId());
			task.setUpdateTime(new Date());
			task.setRemark("删除任务");
			taskMapper.updateByPrimaryKeySelective(task);
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("删除成功"));
	}

}
