package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetWorkRequest;
import com.clinicalmall.kuaixiu.vo.GetWorkResponse;
import com.clinicalmall.kuaixiu.vo.WorkExecuteRequest;
import com.clinicalmall.kuaixiu.vo.WorkListRequest;
import com.clinicalmall.kuaixiu.vo.WorkListResponse;
import com.clinicalmall.kuaixiu.vo.WorkSaveRequest;
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
public class WorkApiController implements WorkApi {

    private static final Logger log = LoggerFactory.getLogger(WorkApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public WorkApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> execute(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody WorkExecuteRequest body) {
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

    public ResponseEntity<WorkListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody WorkListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<WorkListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"equipName\" : \"自动贴标签机\",    \"origin\" : 1,    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"result\" : \"月底保养\",    \"certificateFilePath\" : \"20180101\",    \"providerId\" : 2,    \"labId\" : 5,    \"planId\" : 2,    \"id\" : 1,    \"equipId\" : 3,    \"period\" : 0,    \"executeUserName\" : \"executeUserName\",    \"acceptTime\" : \"2000-01-23\",    \"updateUser\" : 9,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"certificateNo\" : \"20180101\",    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"certificateFileName\" : \"20180101\",    \"executeOrgId\" : 4,    \"name\" : \"月底保养\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 7,    \"executeUser\" : 7,    \"status\" : 0,    \"executeTime\" : \"2000-01-23\"  }, {    \"equipName\" : \"自动贴标签机\",    \"origin\" : 1,    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"result\" : \"月底保养\",    \"certificateFilePath\" : \"20180101\",    \"providerId\" : 2,    \"labId\" : 5,    \"planId\" : 2,    \"id\" : 1,    \"equipId\" : 3,    \"period\" : 0,    \"executeUserName\" : \"executeUserName\",    \"acceptTime\" : \"2000-01-23\",    \"updateUser\" : 9,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"certificateNo\" : \"20180101\",    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"certificateFileName\" : \"20180101\",    \"executeOrgId\" : 4,    \"name\" : \"月底保养\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 7,    \"executeUser\" : 7,    \"status\" : 0,    \"executeTime\" : \"2000-01-23\"  } ]}", WorkListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<WorkListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<WorkListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetWorkResponse> getWork(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetWorkRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetWorkResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"equipName\" : \"自动贴标签机\",    \"origin\" : 1,    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"result\" : \"月底保养\",    \"certificateFilePath\" : \"20180101\",    \"providerId\" : 2,    \"labId\" : 5,    \"planId\" : 2,    \"id\" : 1,    \"equipId\" : 3,    \"period\" : 0,    \"executeUserName\" : \"executeUserName\",    \"acceptTime\" : \"2000-01-23\",    \"updateUser\" : 9,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"certificateNo\" : \"20180101\",    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"certificateFileName\" : \"20180101\",    \"executeOrgId\" : 4,    \"name\" : \"月底保养\",    \"finishedTime\" : \"2000-01-23\",    \"createUser\" : 7,    \"executeUser\" : 7,    \"status\" : 0,    \"executeTime\" : \"2000-01-23\"  }}", GetWorkResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetWorkResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetWorkResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> save(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody WorkSaveRequest body) {
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
