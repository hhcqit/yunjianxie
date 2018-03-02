package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetOrgRequest;
import com.clinicalmall.kuaixiu.vo.GetOrgResponse;
import com.clinicalmall.kuaixiu.vo.OrgBindListRequest;
import com.clinicalmall.kuaixiu.vo.OrgBindRequest;
import com.clinicalmall.kuaixiu.vo.OrgChangeAdminRequest;
import com.clinicalmall.kuaixiu.vo.OrgListRequest;
import com.clinicalmall.kuaixiu.vo.OrgListResponse;
import com.clinicalmall.kuaixiu.vo.OrgModifyRequest;
import com.clinicalmall.kuaixiu.vo.OrgRegisterRequest;
import com.clinicalmall.kuaixiu.vo.OrgUnbindRequest;
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
public class OrgApiController implements OrgApi {

    private static final Logger log = LoggerFactory.getLogger(OrgApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public OrgApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> bind(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgBindRequest body) {
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

    public ResponseEntity<CommonResponse> changeAdmin(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgChangeAdminRequest body) {
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

    public ResponseEntity<OrgListResponse> getBindList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgBindListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"owner\" : 5,    \"area\" : \"area\",    \"address\" : \"address\",    \"postcode\" : \"postcode\",    \"updateTime\" : \"2000-01-23\",    \"telephone\" : \"telephone\",    \"remark\" : \"remark\",    \"qrcodeImg\" : \"qrcodeImg\",    \"type\" : 1,    \"createTime\" : \"2000-01-23\",    \"contact\" : \"contact\",    \"name\" : \"艾迪康\",    \"id\" : 1,    \"email\" : \"email\"  }, {    \"owner\" : 5,    \"area\" : \"area\",    \"address\" : \"address\",    \"postcode\" : \"postcode\",    \"updateTime\" : \"2000-01-23\",    \"telephone\" : \"telephone\",    \"remark\" : \"remark\",    \"qrcodeImg\" : \"qrcodeImg\",    \"type\" : 1,    \"createTime\" : \"2000-01-23\",    \"contact\" : \"contact\",    \"name\" : \"艾迪康\",    \"id\" : 1,    \"email\" : \"email\"  } ]}", OrgListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OrgListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<OrgListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<OrgListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"owner\" : 5,    \"area\" : \"area\",    \"address\" : \"address\",    \"postcode\" : \"postcode\",    \"updateTime\" : \"2000-01-23\",    \"telephone\" : \"telephone\",    \"remark\" : \"remark\",    \"qrcodeImg\" : \"qrcodeImg\",    \"type\" : 1,    \"createTime\" : \"2000-01-23\",    \"contact\" : \"contact\",    \"name\" : \"艾迪康\",    \"id\" : 1,    \"email\" : \"email\"  }, {    \"owner\" : 5,    \"area\" : \"area\",    \"address\" : \"address\",    \"postcode\" : \"postcode\",    \"updateTime\" : \"2000-01-23\",    \"telephone\" : \"telephone\",    \"remark\" : \"remark\",    \"qrcodeImg\" : \"qrcodeImg\",    \"type\" : 1,    \"createTime\" : \"2000-01-23\",    \"contact\" : \"contact\",    \"name\" : \"艾迪康\",    \"id\" : 1,    \"email\" : \"email\"  } ]}", OrgListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<OrgListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<OrgListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<GetOrgResponse> getOrg(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetOrgRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetOrgResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"owner\" : 5,    \"area\" : \"area\",    \"address\" : \"address\",    \"postcode\" : \"postcode\",    \"updateTime\" : \"2000-01-23\",    \"telephone\" : \"telephone\",    \"remark\" : \"remark\",    \"qrcodeImg\" : \"qrcodeImg\",    \"type\" : 1,    \"createTime\" : \"2000-01-23\",    \"contact\" : \"contact\",    \"name\" : \"艾迪康\",    \"id\" : 1,    \"email\" : \"email\"  }}", GetOrgResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetOrgResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetOrgResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> modify(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgModifyRequest body) {
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

    public ResponseEntity<CommonResponse> register(@ApiParam(value = "注册请求消息" ,required=true )  @Valid @RequestBody OrgRegisterRequest body) {
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

    public ResponseEntity<CommonResponse> unbind(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgUnbindRequest body) {
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
