package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetPlanRequest;
import com.clinicalmall.kuaixiu.vo.GetPlanResponse;
import com.clinicalmall.kuaixiu.vo.PlanDeleteRequest;
import com.clinicalmall.kuaixiu.vo.PlanListRequest;
import com.clinicalmall.kuaixiu.vo.PlanListResponse;
import com.clinicalmall.kuaixiu.vo.PlanSaveRequest;
import com.clinicalmall.kuaixiu.vo.PlanUpdateStatusRequest;
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
public class PlanApiController implements PlanApi {

    private static final Logger log = LoggerFactory.getLogger(PlanApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public PlanApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> delete(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody PlanDeleteRequest body) {
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

    public ResponseEntity<PlanListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody PlanListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<PlanListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"equipId\" : 7,    \"equipName\" : \"自动贴标签机\",    \"period\" : 0,    \"latestExecuteTime\" : \"2000-01-23\",    \"updateUser\" : 2,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"executeCount\" : 0,    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"nextExecuteTime\" : \"2000-01-23\",    \"name\" : \"月底保养\",    \"createUser\" : 5,    \"startTime\" : \"2000-01-23\",    \"id\" : 1,    \"status\" : 0  }, {    \"equipId\" : 7,    \"equipName\" : \"自动贴标签机\",    \"period\" : 0,    \"latestExecuteTime\" : \"2000-01-23\",    \"updateUser\" : 2,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"executeCount\" : 0,    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"nextExecuteTime\" : \"2000-01-23\",    \"name\" : \"月底保养\",    \"createUser\" : 5,    \"startTime\" : \"2000-01-23\",    \"id\" : 1,    \"status\" : 0  } ]}", PlanListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<PlanListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<PlanListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetPlanResponse> getPlan(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetPlanRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetPlanResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"equipId\" : 7,    \"equipName\" : \"自动贴标签机\",    \"period\" : 0,    \"latestExecuteTime\" : \"2000-01-23\",    \"updateUser\" : 2,    \"executePermission\" : 0,    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"type\" : 1,    \"orgId\" : 5,    \"content\" : \"月底保养\",    \"executeCount\" : 0,    \"periodType\" : 0,    \"warnDay\" : 0,    \"createTime\" : \"2000-01-23\",    \"nextExecuteTime\" : \"2000-01-23\",    \"name\" : \"月底保养\",    \"createUser\" : 5,    \"startTime\" : \"2000-01-23\",    \"id\" : 1,    \"status\" : 0  }}", GetPlanResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetPlanResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetPlanResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> save(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody PlanSaveRequest body) {
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

    public ResponseEntity<CommonResponse> updateStatus(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody PlanUpdateStatusRequest body) {
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
