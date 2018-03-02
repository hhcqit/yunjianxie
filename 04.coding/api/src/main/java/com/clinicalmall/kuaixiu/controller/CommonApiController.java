package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import org.springframework.core.io.Resource;
import com.clinicalmall.kuaixiu.vo.SendSmsCodeRequest;
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
public class CommonApiController implements CommonApi {

    private static final Logger log = LoggerFactory.getLogger(CommonApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public CommonApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<Void> getAttachment(@ApiParam(value = "附件ID",required=true) @PathVariable("attachmentId") String attachmentId) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> sendSmsCode(@ApiParam(value = "发送短信验证码" ,required=true )  @Valid @RequestBody SendSmsCodeRequest body) {
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

    public ResponseEntity<CommonResponse> uploadAttachment(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "file detail") @Valid @RequestPart("file") MultipartFile file,@ApiParam(value = "文件类型<br>0、未定义  1、图片 2、语音 3、文件") @RequestPart(value="type", required=false)  Integer type) {
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
