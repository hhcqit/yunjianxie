/**
 * NOTE: This class is auto generated by the swagger code generator program (1.0.11).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
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

@Api(value = "Org", description = "the Org API")
public interface OrgApi {

    @ApiOperation(value = "绑定组织", nickname = "bind", notes = "绑定组织", response = CommonResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/bind",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> bind(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgBindRequest body);


    @ApiOperation(value = "修改组织管理员", nickname = "changeAdmin", notes = "修改组织管理员", response = CommonResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/changeAdmin",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> changeAdmin(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgChangeAdminRequest body);


    @ApiOperation(value = "获取绑定组织列表", nickname = "getBindList", notes = "获取绑定组织列表", response = OrgListResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrgListResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/getBindList",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<OrgListResponse> getBindList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgBindListRequest body);


    @ApiOperation(value = "获取组织列表", nickname = "getList", notes = "获取组织列表", response = OrgListResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = OrgListResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/getList",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<OrgListResponse> getList(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgListRequest body);


    @ApiOperation(value = "获取组织", nickname = "getOrg", notes = "获取组织", response = GetOrgResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = GetOrgResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/getOrg",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<GetOrgResponse> getOrg(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody GetOrgRequest body);


    @ApiOperation(value = "修改组织", nickname = "modify", notes = "修改组织", response = CommonResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/modify",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> modify(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgModifyRequest body);


    @ApiOperation(value = "组织注册", nickname = "register", notes = "组织注册", response = CommonResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    })
    @RequestMapping(value = "/org/register",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> register(@ApiParam(value = "注册请求消息" ,required=true )  @Valid @RequestBody OrgRegisterRequest body);


    @ApiOperation(value = "解绑组织", nickname = "unbind", notes = "解绑组织", response = CommonResponse.class, tags={ "org", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful operation", response = CommonResponse.class) })
    @ApiImplicitParams({
    @ApiImplicitParam(name = "token", value = "token", required=true, dataType = "String", paramType = "header")
    })
    @RequestMapping(value = "/org/unbind",
        produces = "application/json",
        consumes = "application/json",
        method = RequestMethod.POST)
    ResponseEntity<CommonResponse> unbind(@ApiParam(value = "token" ,required=true) @RequestHeader(value="token", required=true) String token,@ApiParam(value = "请求消息" ,required=true )  @Valid @RequestBody OrgUnbindRequest body);

}
