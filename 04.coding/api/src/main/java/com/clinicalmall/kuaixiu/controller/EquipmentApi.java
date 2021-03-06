/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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
import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Optional;

@Api(value = "Equipment", description = "the Equipment API")
public interface EquipmentApi {

    @ApiOperation(value = "归档设备验收信息", nickname = "archiveExamine", notes = "归档设备验收信息，归档后不允许再增删改验收记录", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/archiveExamine",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> archiveExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineSaveRequest body);


    @ApiOperation(value = "绑定关联组织", nickname = "bindOrg", notes = "绑定关联组织", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/bindOrg",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> bindOrg(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentBindOrgRequest body);


    @ApiOperation(value = "删除设备", nickname = "delete", notes = "删除设备", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/delete",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> delete(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentDeleteRequest body);


    @ApiOperation(value = "删除设备验收项目", nickname = "deleteExamineItem", notes = "删除设备验收项目", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/deleteExamineItem",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> deleteExamineItem(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItemDeleteRequest body);


    @ApiOperation(value = "获取设备", nickname = "getEquipment", notes = "获取设备", response = GetEquipmentResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = GetEquipmentResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/getEquipment",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<GetEquipmentResponse> getEquipment(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetEquipmentRequest body);


    @ApiOperation(value = "获取设备验收信息", nickname = "getExamine", notes = "获取设备验收信息，返回设备验收项目列表", response = EquipmentExamineItemListResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = EquipmentExamineItemListResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/getExamine",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<EquipmentExamineItemListResponse> getExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItemListRequest body);


    @ApiOperation(value = "获取设备验收列表", nickname = "getExamineList", notes = "获取设备验收列表", response = EquipmentExamineListResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = EquipmentExamineListResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/getExamineList",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<EquipmentExamineListResponse> getExamineList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineListRequest body);


    @ApiOperation(value = "获取设备列表", nickname = "getList", notes = "获取设备列表", response = EquipmentListResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = EquipmentListResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/getList",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<EquipmentListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentListRequest body);


    @ApiOperation(value = "创建/更新设备", nickname = "save", notes = "创建/更新设备", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/save",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> save(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody Equipment body);


    @ApiOperation(value = "创建/更新备验收信息", nickname = "saveExamine", notes = "创建/更新设备验收信息", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/saveExamine",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> saveExamine(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineSaveRequest body);


    @ApiOperation(value = "创建/更新设备验收项目", nickname = "saveExamineItem", notes = "创建/更新设备验收项目", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/saveExamineItem",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> saveExamineItem(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentExamineItem body);


    @ApiOperation(value = "更新设备状态", nickname = "updateStatus", notes = "更新设备状态", response = CommonResponse.class, tags={ "equipment", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/equipment/updateStatus",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> updateStatus(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody EquipmentUpdateStatusRequest body);

}
