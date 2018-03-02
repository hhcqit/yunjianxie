package com.clinicalmall.kuaixiu.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.clinicalmall.kuaixiu.service.ITaskService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
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
import com.fasterxml.jackson.databind.ObjectMapper;

import io.swagger.annotations.ApiParam;

@Controller
public class TaskApiController implements TaskApi {

	private static final Logger log = LoggerFactory.getLogger(TaskApiController.class);

	private final ObjectMapper objectMapper;

	private final HttpServletRequest request;

	@Resource
	private ITaskService taskService;

	@org.springframework.beans.factory.annotation.Autowired
	public TaskApiController(ObjectMapper objectMapper, HttpServletRequest request) {
		this.objectMapper = objectMapper;
		this.request = request;
	}

	@Override
	public ResponseEntity<CommonResponse> accept(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskAcceptRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.accept(new ApiRequestBase<TaskAcceptRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> cancel(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskCancelRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.cancel(new ApiRequestBase<TaskCancelRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> close(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskCloseRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.close(new ApiRequestBase<TaskCloseRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> comment(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskCommentRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.comment(new ApiRequestBase<TaskCommentRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> delete(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskDeleteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.delete(new ApiRequestBase<TaskDeleteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> examine(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskExamineRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.examine(new ApiRequestBase<TaskExamineRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> execute(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskExecuteRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.execute(new ApiRequestBase<TaskExecuteRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<TaskListResponse> getList(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskListRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.getList(new ApiRequestBase<TaskListRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<TaskListResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetTaskResponse> getTask(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetTaskRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.getTask(new ApiRequestBase<GetTaskRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<GetTaskResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<GetTaskResponse> getTaskByTaskNo(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody GetTaskByTaskNoRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.getTaskByTaskNo(new ApiRequestBase<GetTaskByTaskNoRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<GetTaskResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> modify(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskModifyRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.modify(new ApiRequestBase<TaskModifyRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> save(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskSaveRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.save(new ApiRequestBase<TaskSaveRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> sendBack(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskSendBackRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.sendBack(new ApiRequestBase<TaskSendBackRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

	@Override
	public ResponseEntity<CommonResponse> supplement(
			@ApiParam(value = "token", required = true) @RequestHeader(value = "token", required = true) String token,
			@ApiParam(value = "请求消息", required = true) @Valid @RequestBody TaskSupplementRequest body) {
		String accept = request.getHeader("Accept");
		if (accept != null && accept.contains("application/json")) {
			return taskService.supplement(new ApiRequestBase<TaskSupplementRequest>(
					StringUtils.isNoneBlank(token) ? token : (String) request.getSession().getAttribute("token"),
					body));
		}

		return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
	}

}
