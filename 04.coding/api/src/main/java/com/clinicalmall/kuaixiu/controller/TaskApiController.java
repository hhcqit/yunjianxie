package com.clinicalmall.kuaixiu.controller;

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
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;
import java.io.IOException;
import java.util.List;

@Controller
public class TaskApiController implements TaskApi {

    private static final Logger log = LoggerFactory.getLogger(TaskApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TaskApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> accept(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskAcceptRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> cancel(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskCancelRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> close(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskCloseRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> comment(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskCommentRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> delete(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskDeleteRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> examine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskExamineRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> execute(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskExecuteRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<TaskListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<TaskListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"taskRepairs\" : [ {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    }, {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    } ],    \"equipName\" : \"自动贴标签机\",    \"examineDescription\" : \"正常\",    \"canceledReason\" : \"误报\",    \"modifyStatus\" : 0,    \"description\" : \"指示灯异常\",    \"createUserName\" : \"createUserName\",    \"remark\" : \"remark\",    \"orgId\" : 5,    \"examinerUser\" : 2,    \"repairedTime\" : \"2000-01-23\",    \"examineCalibrate\" : \"正常\",    \"examineSample\" : \"正常\",    \"taskModifies\" : [ {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    }, {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    } ],    \"providerId\" : 9,    \"labId\" : 7,    \"examineQc\" : \"正常\",    \"taskNo\" : \"2018010100000001\",    \"id\" : 1,    \"repairDescription\" : \"已替换指示灯\",    \"examineTime\" : \"2000-01-23\",    \"equipId\" : 3,    \"malfunctionDuration\" : 1,    \"sendBackReason\" : \"不属于我的设备\",    \"acceptTime\" : \"2000-01-23\",    \"taskComments\" : [ {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    }, {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    } ],    \"updateUser\" : 2,    \"equipCode\" : \"10001\",    \"updateTime\" : \"2000-01-23\",    \"supplementStatus\" : 0,    \"repairerUser\" : 4,    \"equipUsedDept\" : \"equipUsedDept\",    \"commentStatus\" : 0,    \"taskSupplements\" : [ {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    }, {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    } ],    \"createTime\" : \"2000-01-23\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"sendBackStatus\" : 0,    \"status\" : 10  }, {    \"taskRepairs\" : [ {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    }, {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    } ],    \"equipName\" : \"自动贴标签机\",    \"examineDescription\" : \"正常\",    \"canceledReason\" : \"误报\",    \"modifyStatus\" : 0,    \"description\" : \"指示灯异常\",    \"createUserName\" : \"createUserName\",    \"remark\" : \"remark\",    \"orgId\" : 5,    \"examinerUser\" : 2,    \"repairedTime\" : \"2000-01-23\",    \"examineCalibrate\" : \"正常\",    \"examineSample\" : \"正常\",    \"taskModifies\" : [ {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    }, {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    } ],    \"providerId\" : 9,    \"labId\" : 7,    \"examineQc\" : \"正常\",    \"taskNo\" : \"2018010100000001\",    \"id\" : 1,    \"repairDescription\" : \"已替换指示灯\",    \"examineTime\" : \"2000-01-23\",    \"equipId\" : 3,    \"malfunctionDuration\" : 1,    \"sendBackReason\" : \"不属于我的设备\",    \"acceptTime\" : \"2000-01-23\",    \"taskComments\" : [ {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    }, {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    } ],    \"updateUser\" : 2,    \"equipCode\" : \"10001\",    \"updateTime\" : \"2000-01-23\",    \"supplementStatus\" : 0,    \"repairerUser\" : 4,    \"equipUsedDept\" : \"equipUsedDept\",    \"commentStatus\" : 0,    \"taskSupplements\" : [ {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    }, {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    } ],    \"createTime\" : \"2000-01-23\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"sendBackStatus\" : 0,    \"status\" : 10  } ]}", TaskListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<TaskListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<TaskListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetTaskResponse> getTask(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetTaskRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetTaskResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"taskRepairs\" : [ {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    }, {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    } ],    \"equipName\" : \"自动贴标签机\",    \"examineDescription\" : \"正常\",    \"canceledReason\" : \"误报\",    \"modifyStatus\" : 0,    \"description\" : \"指示灯异常\",    \"createUserName\" : \"createUserName\",    \"remark\" : \"remark\",    \"orgId\" : 5,    \"examinerUser\" : 2,    \"repairedTime\" : \"2000-01-23\",    \"examineCalibrate\" : \"正常\",    \"examineSample\" : \"正常\",    \"taskModifies\" : [ {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    }, {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    } ],    \"providerId\" : 9,    \"labId\" : 7,    \"examineQc\" : \"正常\",    \"taskNo\" : \"2018010100000001\",    \"id\" : 1,    \"repairDescription\" : \"已替换指示灯\",    \"examineTime\" : \"2000-01-23\",    \"equipId\" : 3,    \"malfunctionDuration\" : 1,    \"sendBackReason\" : \"不属于我的设备\",    \"acceptTime\" : \"2000-01-23\",    \"taskComments\" : [ {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    }, {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    } ],    \"updateUser\" : 2,    \"equipCode\" : \"10001\",    \"updateTime\" : \"2000-01-23\",    \"supplementStatus\" : 0,    \"repairerUser\" : 4,    \"equipUsedDept\" : \"equipUsedDept\",    \"commentStatus\" : 0,    \"taskSupplements\" : [ {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    }, {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    } ],    \"createTime\" : \"2000-01-23\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"sendBackStatus\" : 0,    \"status\" : 10  }}", GetTaskResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetTaskResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetTaskResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetTaskResponse> getTaskByTaskNo(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetTaskByTaskNoRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetTaskResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"taskRepairs\" : [ {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    }, {      \"reason\" : \"不属于我的设备\",      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"acceptTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"finishedTime\" : \"2000-01-23\",      \"createUser\" : 6,      \"createUserName\" : \"createUserName\",      \"id\" : 9,      \"taskId\" : 8,      \"status\" : 0    } ],    \"equipName\" : \"自动贴标签机\",    \"examineDescription\" : \"正常\",    \"canceledReason\" : \"误报\",    \"modifyStatus\" : 0,    \"description\" : \"指示灯异常\",    \"createUserName\" : \"createUserName\",    \"remark\" : \"remark\",    \"orgId\" : 5,    \"examinerUser\" : 2,    \"repairedTime\" : \"2000-01-23\",    \"examineCalibrate\" : \"正常\",    \"examineSample\" : \"正常\",    \"taskModifies\" : [ {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    }, {      \"equipId\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 1,      \"createUserName\" : \"createUserName\",      \"id\" : 7,      \"taskId\" : 1    } ],    \"providerId\" : 9,    \"labId\" : 7,    \"examineQc\" : \"正常\",    \"taskNo\" : \"2018010100000001\",    \"id\" : 1,    \"repairDescription\" : \"已替换指示灯\",    \"examineTime\" : \"2000-01-23\",    \"equipId\" : 3,    \"malfunctionDuration\" : 1,    \"sendBackReason\" : \"不属于我的设备\",    \"acceptTime\" : \"2000-01-23\",    \"taskComments\" : [ {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    }, {      \"createTime\" : \"2000-01-23\",      \"service\" : 5,      \"response\" : 5,      \"description\" : \"指示灯异常\",      \"createUser\" : 7,      \"createUserName\" : \"createUserName\",      \"id\" : 6,      \"technology\" : 5,      \"taskId\" : 1    } ],    \"updateUser\" : 2,    \"equipCode\" : \"10001\",    \"updateTime\" : \"2000-01-23\",    \"supplementStatus\" : 0,    \"repairerUser\" : 4,    \"equipUsedDept\" : \"equipUsedDept\",    \"commentStatus\" : 0,    \"taskSupplements\" : [ {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    }, {      \"visibleStatus\" : 1,      \"createTime\" : \"2000-01-23\",      \"description\" : \"指示灯异常\",      \"createUser\" : 5,      \"createUserName\" : \"createUserName\",      \"id\" : 4,      \"taskId\" : 9    } ],    \"createTime\" : \"2000-01-23\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"sendBackStatus\" : 0,    \"status\" : 10  }}", GetTaskResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetTaskResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetTaskResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> modify(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskModifyRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> save(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskSaveRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> sendBack(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskSendBackRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> supplement(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody TaskSupplementRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<CommonResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : \"data\"}", CommonResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<CommonResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<CommonResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

}
