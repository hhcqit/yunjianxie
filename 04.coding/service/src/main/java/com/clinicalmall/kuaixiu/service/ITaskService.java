package com.clinicalmall.kuaixiu.service;

import org.springframework.http.ResponseEntity;

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

public interface ITaskService {

	ResponseEntity<TaskListResponse> getList(ApiRequestBase<TaskListRequest> request);

	ResponseEntity<GetTaskResponse> getTask(ApiRequestBase<GetTaskRequest> request);

	ResponseEntity<GetTaskResponse> getTaskByTaskNo(ApiRequestBase<GetTaskByTaskNoRequest> request);

	ResponseEntity<CommonResponse> save(ApiRequestBase<TaskSaveRequest> request);

	ResponseEntity<CommonResponse> modify(ApiRequestBase<TaskModifyRequest> request);

	ResponseEntity<CommonResponse> cancel(ApiRequestBase<TaskCancelRequest> request);

	ResponseEntity<CommonResponse> examine(ApiRequestBase<TaskExamineRequest> request);

	ResponseEntity<CommonResponse> comment(ApiRequestBase<TaskCommentRequest> request);

	ResponseEntity<CommonResponse> accept(ApiRequestBase<TaskAcceptRequest> request);

	ResponseEntity<CommonResponse> sendBack(ApiRequestBase<TaskSendBackRequest> request);

	ResponseEntity<CommonResponse> supplement(ApiRequestBase<TaskSupplementRequest> request);

	ResponseEntity<CommonResponse> execute(ApiRequestBase<TaskExecuteRequest> request);

	ResponseEntity<CommonResponse> close(ApiRequestBase<TaskCloseRequest> request);

	ResponseEntity<CommonResponse> delete(ApiRequestBase<TaskDeleteRequest> request);

}
