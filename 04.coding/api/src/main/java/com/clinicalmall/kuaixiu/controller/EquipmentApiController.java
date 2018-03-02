package com.clinicalmall.kuaixiu.controller;

import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.EquipmentBindOrgRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItem;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemDeleteRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineItemListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentExamineSaveRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListRequest;
import com.clinicalmall.kuaixiu.vo.EquipmentListResponse;
import com.clinicalmall.kuaixiu.vo.EquipmentUpdateStatusRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentRequest;
import com.clinicalmall.kuaixiu.vo.GetEquipmentResponse;
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
public class EquipmentApiController implements EquipmentApi {

    private static final Logger log = LoggerFactory.getLogger(EquipmentApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public EquipmentApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<CommonResponse> archiveExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineSaveRequest body) {
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

    public ResponseEntity<CommonResponse> bindOrg(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentBindOrgRequest body) {
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

    public ResponseEntity<CommonResponse> delete(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentDeleteRequest body) {
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

    public ResponseEntity<CommonResponse> deleteExamineItem(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItemDeleteRequest body) {
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

    public ResponseEntity<GetEquipmentResponse> getEquipment(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetEquipmentRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<GetEquipmentResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : {    \"img\" : \"img\",    \"code\" : \"10001\",    \"manufacturerContact\" : \"manufacturerContact\",    \"labName\" : \"艾迪康\",    \"remark\" : \"remark\",    \"orgId\" : 6,    \"manufacturer\" : \"manufacturer\",    \"checkPermission\" : 0,    \"providerId\" : 5,    \"labId\" : 1,    \"supplier\" : \"supplier\",    \"barcodeImg\" : \"barcodeImg\",    \"model\" : \"model\",    \"id\" : 0,    \"place\" : \"place\",    \"manufacturerTelephone\" : \"manufacturerTelephone\",    \"barcode\" : \"barcode\",    \"providerName\" : \"艾迪康\",    \"area\" : \"area\",    \"owner\" : \"owner\",    \"batchNo\" : \"batchNo\",    \"address\" : \"address\",    \"updateUser\" : 2,    \"updateTime\" : \"2000-01-23\",    \"supplierTelephone\" : \"supplierTelephone\",    \"madeArea\" : \"madeArea\",    \"madeNo\" : \"madeNo\",    \"usedTime\" : \"2000-01-23\",    \"usedDept\" : \"usedDept\",    \"createTime\" : \"2000-01-23\",    \"checkPeriod\" : 1,    \"name\" : \"自动贴标签机\",    \"createUser\" : 5,    \"madeTime\" : \"2000-01-23\",    \"userType\" : 1,    \"category\" : \"category\",    \"supplierContact\" : \"supplierContact\",    \"status\" : 0,    \"purchasedTime\" : \"2000-01-23\"  }}", GetEquipmentResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<GetEquipmentResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<GetEquipmentResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EquipmentExamineItemListResponse> getExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItemListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EquipmentExamineItemListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : [ {    \"standardValue\" : \"standardValue\",    \"updateUser\" : 5,    \"isQualified\" : 2,    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"measureValue\" : \"measureValue\",    \"unit\" : \"unit\",    \"createTime\" : \"2000-01-23\",    \"deviationValue\" : \"deviationValue\",    \"examineId\" : 5,    \"name\" : \"name\",    \"createUser\" : 1,    \"id\" : 6  }, {    \"standardValue\" : \"standardValue\",    \"updateUser\" : 5,    \"isQualified\" : 2,    \"updateTime\" : \"2000-01-23\",    \"remark\" : \"remark\",    \"measureValue\" : \"measureValue\",    \"unit\" : \"unit\",    \"createTime\" : \"2000-01-23\",    \"deviationValue\" : \"deviationValue\",    \"examineId\" : 5,    \"name\" : \"name\",    \"createUser\" : 1,    \"id\" : 6  } ]}", EquipmentExamineItemListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EquipmentExamineItemListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EquipmentExamineItemListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EquipmentExamineListResponse> getExamineList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EquipmentExamineListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"code\" : 0,  \"data\" : [ {    \"equipId\" : 1,    \"reference\" : \"reference\",    \"conclusion\" : \"conclusion\",    \"createTime\" : \"2000-01-23\",    \"updateUser\" : 2,    \"updateTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"id\" : 6,    \"orgId\" : 5,    \"examineTime\" : \"2000-01-23\",    \"status\" : 7  }, {    \"equipId\" : 1,    \"reference\" : \"reference\",    \"conclusion\" : \"conclusion\",    \"createTime\" : \"2000-01-23\",    \"updateUser\" : 2,    \"updateTime\" : \"2000-01-23\",    \"createUser\" : 5,    \"id\" : 6,    \"orgId\" : 5,    \"examineTime\" : \"2000-01-23\",    \"status\" : 7  } ]}", EquipmentExamineListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EquipmentExamineListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EquipmentExamineListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<EquipmentListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentListRequest body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<EquipmentListResponse>(objectMapper.readValue("{  \"msg\" : \"msg\",  \"totalRow\" : 6,  \"code\" : 0,  \"data\" : [ {    \"img\" : \"img\",    \"code\" : \"10001\",    \"manufacturerContact\" : \"manufacturerContact\",    \"labName\" : \"艾迪康\",    \"remark\" : \"remark\",    \"orgId\" : 6,    \"manufacturer\" : \"manufacturer\",    \"checkPermission\" : 0,    \"providerId\" : 5,    \"labId\" : 1,    \"supplier\" : \"supplier\",    \"barcodeImg\" : \"barcodeImg\",    \"model\" : \"model\",    \"id\" : 0,    \"place\" : \"place\",    \"manufacturerTelephone\" : \"manufacturerTelephone\",    \"barcode\" : \"barcode\",    \"providerName\" : \"艾迪康\",    \"area\" : \"area\",    \"owner\" : \"owner\",    \"batchNo\" : \"batchNo\",    \"address\" : \"address\",    \"updateUser\" : 2,    \"updateTime\" : \"2000-01-23\",    \"supplierTelephone\" : \"supplierTelephone\",    \"madeArea\" : \"madeArea\",    \"madeNo\" : \"madeNo\",    \"usedTime\" : \"2000-01-23\",    \"usedDept\" : \"usedDept\",    \"createTime\" : \"2000-01-23\",    \"checkPeriod\" : 1,    \"name\" : \"自动贴标签机\",    \"createUser\" : 5,    \"madeTime\" : \"2000-01-23\",    \"userType\" : 1,    \"category\" : \"category\",    \"supplierContact\" : \"supplierContact\",    \"status\" : 0,    \"purchasedTime\" : \"2000-01-23\"  }, {    \"img\" : \"img\",    \"code\" : \"10001\",    \"manufacturerContact\" : \"manufacturerContact\",    \"labName\" : \"艾迪康\",    \"remark\" : \"remark\",    \"orgId\" : 6,    \"manufacturer\" : \"manufacturer\",    \"checkPermission\" : 0,    \"providerId\" : 5,    \"labId\" : 1,    \"supplier\" : \"supplier\",    \"barcodeImg\" : \"barcodeImg\",    \"model\" : \"model\",    \"id\" : 0,    \"place\" : \"place\",    \"manufacturerTelephone\" : \"manufacturerTelephone\",    \"barcode\" : \"barcode\",    \"providerName\" : \"艾迪康\",    \"area\" : \"area\",    \"owner\" : \"owner\",    \"batchNo\" : \"batchNo\",    \"address\" : \"address\",    \"updateUser\" : 2,    \"updateTime\" : \"2000-01-23\",    \"supplierTelephone\" : \"supplierTelephone\",    \"madeArea\" : \"madeArea\",    \"madeNo\" : \"madeNo\",    \"usedTime\" : \"2000-01-23\",    \"usedDept\" : \"usedDept\",    \"createTime\" : \"2000-01-23\",    \"checkPeriod\" : 1,    \"name\" : \"自动贴标签机\",    \"createUser\" : 5,    \"madeTime\" : \"2000-01-23\",    \"userType\" : 1,    \"category\" : \"category\",    \"supplierContact\" : \"supplierContact\",    \"status\" : 0,    \"purchasedTime\" : \"2000-01-23\"  } ]}", EquipmentListResponse.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<EquipmentListResponse>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<EquipmentListResponse>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<CommonResponse> save(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody Equipment body) {
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

    public ResponseEntity<CommonResponse> saveExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineSaveRequest body) {
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

    public ResponseEntity<CommonResponse> saveExamineItem(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItem body) {
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

    public ResponseEntity<CommonResponse> updateStatus(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentUpdateStatusRequest body) {
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
