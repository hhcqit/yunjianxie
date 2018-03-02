package com.clinicalmall.kuaixiu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.ShardedJedisPool;

import com.az.common.vo.mybatis.pagination.Page;
import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.common.utils.CryptUtils;
import com.clinicalmall.kuaixiu.persistent.dao.CustomizedMapper;
import com.clinicalmall.kuaixiu.persistent.dao.EquipmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.MessageNotifyOptionMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgOptionMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgRelationMapper;
import com.clinicalmall.kuaixiu.persistent.dao.UserMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Equipment;
import com.clinicalmall.kuaixiu.persistent.domain.EquipmentExample;
import com.clinicalmall.kuaixiu.persistent.domain.MessageNotifyOption;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.OrgExample;
import com.clinicalmall.kuaixiu.persistent.domain.OrgOption;
import com.clinicalmall.kuaixiu.persistent.domain.OrgRelation;
import com.clinicalmall.kuaixiu.persistent.domain.OrgRelationExample;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.persistent.domain.UserExample;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IOrgService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
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

@Transactional
@Service
public class OrgService extends AbsService implements IOrgService {
	private static final Logger log = LoggerFactory.getLogger(OrgService.class);
	@Resource
	private ShardedJedisPool shardedJedisPool;
	@Resource
	private ICommonService commonService;
	@Resource
	private IUserService userService;
	@Resource
	private CustomizedMapper customizedMapper;
	@Resource
	private OrgMapper orgMapper;
	@Resource
	private OrgOptionMapper orgOptionMapper;
	@Resource
	private OrgRelationMapper orgRelationMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private MessageNotifyOptionMapper messageNotifyOptionMapper;
	@Resource
	private EquipmentMapper equipmentMapper;

	@Override
	public ResponseEntity<CommonResponse> register(ApiRequestBase<OrgRegisterRequest> request) {
		OrgRegisterRequest orgRegisterRequest = request.getData();
		String mobile = orgRegisterRequest.getMobile();
		String name = orgRegisterRequest.getName();
		String password = orgRegisterRequest.getPassword();
		Integer type = orgRegisterRequest.getType();
		String code = orgRegisterRequest.getCode();
		if (!StringUtils.isNoneBlank(mobile, name, password, code) || type == null
				|| !Constants.orgTypeList.contains(type))
			return ResponseEntity.ok(genCommonResponseWithFailed("请求参数错误！"));

		if (!commonService.checkSmsCode(mobile, code)) {
			return ResponseEntity.ok(genCommonResponseWithFailed("验证码错误！"));
		}
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(mobile);
		List<User> users = userMapper.selectByExample(userExample);
		if (!users.isEmpty()) {
			return ResponseEntity.ok(genCommonResponseWithFailed("手机号码已经存在！"));
		}
		OrgExample example = new OrgExample();
		example.createCriteria().andNameEqualTo(name.trim());
		List<Org> orgs = orgMapper.selectByExample(example);
		if (orgs != null && !orgs.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("组织名称已经存在！"));

		Org org = new Org();
		org.setType(type);
		org.setName(name);
		org.setTelephone(mobile);
		org.setCreateTime(new Date());
		org.setUpdateTime(new Date());
		org.setOwner(0l);
		orgMapper.insertSelective(org);
		OrgOption orgOption = new OrgOption();
		orgOption.setOrgId(org.getId());
		orgOption.setCreateTime(new Date());
		orgOption.setUpdateTime(new Date());
		orgOptionMapper.insertSelective(orgOption);
		//
		User user = new User();
		user.setCreateTime(new Date());
		user.setUpdateTime(new Date());
		user.setOrgId(org.getId());
		user.setUserName(mobile);
		user.setPassword(CryptUtils.md5Digest(password));
		user.setUserType(Constants.USER_TYPE_ORG_ADMIN);
		user.setRealName(mobile);// 默认先填用户名
		userMapper.insertSelective(user);
		//
		MessageNotifyOption messageNotifyOption = new MessageNotifyOption();
		messageNotifyOption.setCreateTime(new Date());
		messageNotifyOption.setUpdateTime(new Date());
		messageNotifyOption.setUserId(user.getId());
		messageNotifyOptionMapper.insertSelective(messageNotifyOption);
		//
		org.setOwner(user.getId());
		orgMapper.updateByPrimaryKeySelective(org);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("register successful", String.valueOf(org.getId())));

	}

	@Override
	public ResponseEntity<CommonResponse> modify(ApiRequestBase<OrgModifyRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		OrgModifyRequest orgModifyRequest = request.getData();
		Long id = orgModifyRequest.getId();
		String name = orgModifyRequest.getName();
		String contact = orgModifyRequest.getContact();
		String telephone = orgModifyRequest.getTelephone();
		String email = orgModifyRequest.getEmail();
		String area = orgModifyRequest.getArea();
		String address = orgModifyRequest.getAddress();
		String postcode = orgModifyRequest.getPostcode();
		OrgExample example = new OrgExample();
		example.createCriteria().andNameEqualTo(name);
		List<Org> orgs = orgMapper.selectByExample(example);
		if (orgs != null && !orgs.isEmpty())
			return ResponseEntity.ok(genCommonResponseWithFailed("组织名称已经存在！"));

		Org org = new Org();
		org.setId(id);
		org.setName(name);
		org.setContact(contact);
		org.setTelephone(telephone);
		org.setEmail(email);
		org.setArea(area);
		org.setAddress(address);
		org.setPostcode(postcode);
		int result = orgMapper.updateByPrimaryKeySelective(org);
		if (result > 0) {
			return ResponseEntity.ok(genCommonResponseWithSuccessful("更新成功！"));
		} else {
			return ResponseEntity.ok(genCommonResponseWithFailed("更新失败！"));
		}
	}

	@Override
	public ResponseEntity<CommonResponse> changeAdmin(ApiRequestBase<OrgChangeAdminRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		OrgChangeAdminRequest orgChangeAdminRequest = request.getData();
		Long id = orgChangeAdminRequest.getId();
		Long adminId = orgChangeAdminRequest.getAdminId();
		Org org = orgMapper.selectByPrimaryKey(id);
		if (org == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("组织不存在！"));
		User adminUser = userMapper.selectByPrimaryKey(adminId);
		if (adminUser == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("用户不存在！"));
		if (adminUser.getOrgId() != org.getId())
			return ResponseEntity.ok(genCommonResponseWithFailed("用户不属于该组织！"));
		Long owner = org.getOwner();
		User user2 = userMapper.selectByPrimaryKey(owner);
		user2.setUserType(Constants.USER_TYPE_NORMAL);
		userMapper.updateByPrimaryKey(user2);
		adminUser.setUserType(Constants.USER_TYPE_ORG_ADMIN);
		userMapper.updateByPrimaryKey(user);
		org.setOwner(user.getId());
		orgMapper.updateByPrimaryKey(org);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("更改成功！"));
	}

	@Override
	public ResponseEntity<OrgListResponse> getList(ApiRequestBase<OrgListRequest> request) {
		OrgListRequest orgListRequest = request.getData();
		Integer pageNumber = orgListRequest.getPageNumber();
		Integer pageSize = orgListRequest.getPageSize();
		String name = orgListRequest.getName();
		Integer type = orgListRequest.getType();
		OrgExample example = new OrgExample();

		OrgExample.Criteria criteria = example.createCriteria();
		if (type != null && (type == Constants.ORG_TYPE_LAB || type == Constants.ORG_TYPE_PROVIDER))
			criteria.andTypeEqualTo(type);
		if (StringUtils.isNoneBlank(name))
			criteria.andNameLike("%" + name + "%");
		long total = orgMapper.countByExample(example);
		example.setPage(new Page(pageNumber, pageSize));
		List<Org> orgs = orgMapper.selectByExample(example);
		OrgListResponse orgListResponse = new OrgListResponse();
		orgListResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
		List<com.clinicalmall.kuaixiu.vo.Org> data = new ArrayList<com.clinicalmall.kuaixiu.vo.Org>();
		for (Org org : orgs) {
			com.clinicalmall.kuaixiu.vo.Org org2 = new com.clinicalmall.kuaixiu.vo.Org();
			BeanUtils.copyProperties(org, org2);
			data.add(org2);
		}
		orgListResponse.setTotalRow(total);
		orgListResponse.setData(data);
		return ResponseEntity.ok(orgListResponse);
	}

	@Override
	public ResponseEntity<CommonResponse> bind(ApiRequestBase<OrgBindRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		OrgBindRequest orgBindRequest = request.getData();
		Long relateOrgId = orgBindRequest.getRelateOrgId();
		Org relateOrg = orgMapper.selectByPrimaryKey(relateOrgId);
		if (org.getType() == relateOrg.getType()) {
			return ResponseEntity.ok(genCommonResponseWithFailed("不能绑定相同类型的组织！"));
		}
		Long labId = null;
		Long providerId = null;
		if (org.getType() == Constants.ORG_TYPE_LAB) {
			labId = org.getId();
			providerId = relateOrg.getId();
		} else {
			labId = relateOrg.getId();
			providerId = org.getId();
		}
		OrgRelationExample example = new OrgRelationExample();
		example.createCriteria().andLabIdEqualTo(labId).andProviderIdEqualTo(providerId);
		List<OrgRelation> orgRelations = orgRelationMapper.selectByExample(example);
		if (orgRelations != null && orgRelations.size() > 0)
			return ResponseEntity.ok(genCommonResponseWithFailed("绑定关系已存在！"));

		OrgRelation orgRelation = new OrgRelation();
		orgRelation.setCreateTime(new Date());
		orgRelation.setUpdateTime(new Date());
		orgRelation.setOrgId(org.getId());
		orgRelation.setCreateUser(user.getId());
		orgRelation.setUpdateUser(user.getId());
		orgRelation.setLabId(labId);
		orgRelation.setProviderId(providerId);
		orgRelationMapper.insertSelective(orgRelation);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("绑定成功！", orgRelation.getId().toString()));
	}

	@Override
	public ResponseEntity<CommonResponse> unbind(ApiRequestBase<OrgUnbindRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		OrgUnbindRequest orgUnbindRequest = request.getData();
		Long id = orgUnbindRequest.getId();
		OrgRelation orgRelation = orgRelationMapper.selectByPrimaryKey(id);
		if (orgRelation == null) {
			return ResponseEntity.ok(genCommonResponseWithFailed("绑定关系不存在！"));
		}
		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		if (org.getId() == orgRelation.getOrgId() || org.getId() == orgRelation.getLabId()
				|| org.getId() == orgRelation.getProviderId()) {// 任何一方都可以解绑关联关系
			EquipmentExample example = new EquipmentExample();
			example.createCriteria().andLabIdEqualTo(orgRelation.getLabId())
					.andProviderIdEqualTo(orgRelation.getProviderId())
					.andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
			List<Equipment> equipments = equipmentMapper.selectByExample(example);
			if (equipments.isEmpty())
				orgRelationMapper.deleteByPrimaryKey(orgRelation.getId());
			else
				return ResponseEntity.ok(genCommonResponseWithFailed("还有关联设备未解绑！"));
		} else {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful("解绑定成功！", orgRelation.getId().toString()));
	}

	@Override
	public ResponseEntity<OrgListResponse> getBindList(ApiRequestBase<OrgBindListRequest> request) {
		String token = request.getToken();
		User user = userService.getUserByToken(token);
		if (user == null) {
			CommonResponse commonResponse = genCommonResponseWithInvalidToken();
			OrgListResponse response = new OrgListResponse();
			BeanUtils.copyProperties(commonResponse, response);
			return ResponseEntity.ok(response);
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			CommonResponse commonResponse = genCommonResponseWithFailed("非法操作！");
			OrgListResponse response = new OrgListResponse();
			BeanUtils.copyProperties(commonResponse, response);
			return ResponseEntity.ok(response);
		}

		Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
		OrgBindListRequest orgBindListRequest = request.getData();
		Integer pageNumber = orgBindListRequest.getPageNumber();
		Integer pageSize = orgBindListRequest.getPageSize();
		String name = orgBindListRequest.getName();

		Map<String, Object> where = new HashMap<String, Object>();
		where.put("id", org.getId());
		where.put("type", org.getType());
		if (StringUtils.isNoneBlank(name))
			where.put("name", "%" + name + "%");
		long total = customizedMapper.countOrgBind(where);
		where.put("page", new Page(pageNumber, pageSize));
		List<Org> orgs = customizedMapper.selectOrgBind(where);
		OrgListResponse orgListResponse = new OrgListResponse();
		orgListResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
		List<com.clinicalmall.kuaixiu.vo.Org> data = new ArrayList<com.clinicalmall.kuaixiu.vo.Org>();
		for (Org org1 : orgs) {
			com.clinicalmall.kuaixiu.vo.Org org2 = new com.clinicalmall.kuaixiu.vo.Org();
			BeanUtils.copyProperties(org1, org2);
			data.add(org2);
		}
		orgListResponse.setTotalRow(total);
		orgListResponse.setData(data);
		return ResponseEntity.ok(orgListResponse);
	}

	@Override
	public ResponseEntity<GetOrgResponse> getOrg(ApiRequestBase<GetOrgRequest> request) {
		GetOrgResponse getOrgResponse = new GetOrgResponse();
		GetOrgRequest getOrgRequest = request.getData();
		Long id = getOrgRequest.getId();
		Org org = orgMapper.selectByPrimaryKey(id);
		if (org == null) {
			getOrgResponse.setCode(ApiResponseBase.CODE_FAILED);
			getOrgResponse.setMsg("组织不存在！");
		} else {
			getOrgResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
			com.clinicalmall.kuaixiu.vo.Org org1 = new com.clinicalmall.kuaixiu.vo.Org();
			BeanUtils.copyProperties(org, org1);
			getOrgResponse.setData(org1);
		}
		return ResponseEntity.ok(getOrgResponse);
	}
}
