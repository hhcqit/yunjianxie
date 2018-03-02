package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetUserRequest;
import com.clinicalmall.kuaixiu.vo.GetUserResponse;
import com.clinicalmall.kuaixiu.vo.LoginRequest;
import com.clinicalmall.kuaixiu.vo.LoginResponse;
import com.clinicalmall.kuaixiu.vo.UserFindPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserListRequest;
import com.clinicalmall.kuaixiu.vo.UserListResponse;
import com.clinicalmall.kuaixiu.vo.UserModifyHeadImgRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyTypeRequest;
import com.clinicalmall.kuaixiu.vo.UserRegisterRequest;
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
public class UserApiController implements UserApi {

    private static final Logger log = LoggerFactory.getLogger(UserApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UserApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> findPwd(@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserFindPwdRequest body) {
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

    public ResponseEntity<UserListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<UserListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"dept\" : \"dept\",    \"userName\" : \"13588441519\",    \"orgId\" : 1,    \"realName\" : \"realName\",    \"password\" : \"password\",    \"headImgUrl\" : \"headImgUrl\",    \"createTime\" : \"2000-01-23\",    \"blacklistFlag\" : 5,    \"id\" : 6,    \"userType\" : 1,    \"email\" : \"email\"  }, {    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"dept\" : \"dept\",    \"userName\" : \"13588441519\",    \"orgId\" : 1,    \"realName\" : \"realName\",    \"password\" : \"password\",    \"headImgUrl\" : \"headImgUrl\",    \"createTime\" : \"2000-01-23\",    \"blacklistFlag\" : 5,    \"id\" : 6,    \"userType\" : 1,    \"email\" : \"email\"  } ]}", UserListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<UserListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<UserListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetUserResponse> getUser(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetUserRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetUserResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"dept\" : \"dept\",    \"userName\" : \"13588441519\",    \"orgId\" : 1,    \"realName\" : \"realName\",    \"password\" : \"password\",    \"headImgUrl\" : \"headImgUrl\",    \"createTime\" : \"2000-01-23\",    \"blacklistFlag\" : 5,    \"id\" : 6,    \"userType\" : 1,    \"email\" : \"email\"  }}", GetUserResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetUserResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetUserResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<LoginResponse> login(@ApiParam(value = "登录请求消息" ,required=true )  @Valid @RequestBody LoginRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<LoginResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"org\" : {      \"owner\" : 5,      \"area\" : \"area\",      \"address\" : \"address\",      \"postcode\" : \"postcode\",      \"updateTime\" : \"2000-01-23\",      \"telephone\" : \"telephone\",      \"remark\" : \"remark\",      \"qrcodeImg\" : \"qrcodeImg\",      \"type\" : 1,      \"createTime\" : \"2000-01-23\",      \"contact\" : \"contact\",      \"name\" : \"艾迪康\",      \"id\" : 1,      \"email\" : \"email\"    },    \"user\" : {      \"updateTime\" : \"2000-01-23\",      \"remark\" : \"remark\",      \"dept\" : \"dept\",      \"userName\" : \"13588441519\",      \"orgId\" : 1,      \"realName\" : \"realName\",      \"password\" : \"password\",      \"headImgUrl\" : \"headImgUrl\",      \"createTime\" : \"2000-01-23\",      \"blacklistFlag\" : 5,      \"id\" : 6,      \"userType\" : 1,      \"email\" : \"email\"    },    \"token\" : \"token\"  }}", LoginResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<LoginResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<LoginResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> modify(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserModifyRequest body) {
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

    public ResponseEntity<CommonResponse> modifyHeadImg(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserModifyHeadImgRequest body) {
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

    public ResponseEntity<CommonResponse> modifyPwd(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserModifyPwdRequest body) {
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

    public ResponseEntity<CommonResponse> modifyType(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody UserModifyTypeRequest body) {
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

    public ResponseEntity<CommonResponse> register(@ApiParam(value = "注册请求消息" ,required=true )  @Valid @RequestBody UserRegisterRequest body) {
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
