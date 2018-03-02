package com.clinicalmall.kuaixiu.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import com.az.common.vo.mybatis.pagination.Page;
import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.common.constants.RedisKeyPrefix;
import com.clinicalmall.kuaixiu.common.utils.CryptUtils;
import com.clinicalmall.kuaixiu.persistent.dao.MessageNotifyOptionMapper;
import com.clinicalmall.kuaixiu.persistent.dao.OrgMapper;
import com.clinicalmall.kuaixiu.persistent.dao.UserMapper;
import com.clinicalmall.kuaixiu.persistent.domain.MessageNotifyOption;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.persistent.domain.UserExample;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.GetUserRequest;
import com.clinicalmall.kuaixiu.vo.GetUserResponse;
import com.clinicalmall.kuaixiu.vo.LoginRequest;
import com.clinicalmall.kuaixiu.vo.LoginResponse;
import com.clinicalmall.kuaixiu.vo.LoginUser;
import com.clinicalmall.kuaixiu.vo.UserDeleteRequest;
import com.clinicalmall.kuaixiu.vo.UserFindPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserListRequest;
import com.clinicalmall.kuaixiu.vo.UserListResponse;
import com.clinicalmall.kuaixiu.vo.UserModifyHeadImgRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyPwdRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyRequest;
import com.clinicalmall.kuaixiu.vo.UserModifyTypeRequest;
import com.clinicalmall.kuaixiu.vo.UserRegisterRequest;

@Transactional
@Service
public class UserService extends AbsService implements IUserService {
	private static final Logger log = LoggerFactory.getLogger(OrgService.class);

	@Resource
	private ShardedJedisPool shardedJedisPool;
	@Resource
	private ICommonService commonService;
	@Resource
	private UserMapper userMapper;
	@Resource
	private MessageNotifyOptionMapper messageNotifyOptionMapper;
	@Resource
	private OrgMapper orgMapper;

	@Override
	public ResponseEntity<CommonResponse> register(ApiRequestBase<UserRegisterRequest> request) {
		UserRegisterRequest userRegisterRequest = request.getData();
		Long orgId = userRegisterRequest.getOrgId();
		String mobile = userRegisterRequest.getMobile();
		String password = userRegisterRequest.getPassword();
		String code = userRegisterRequest.getCode();
		if (!StringUtils.isNoneBlank(mobile, password, code) || orgId == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("请求参数错误！"));
		if (!commonService.checkSmsCode(mobile, code)) {
			return ResponseEntity.ok(genCommonResponseWithFailed("验证码错误！"));
		}
		Org org = orgMapper.selectByPrimaryKey(orgId);
		if (org == null) {
			return ResponseEntity.ok(genCommonResponseWithFailed("组织不存在！"));
		}
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(mobile);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.isEmpty()) {
			//
			User user = new User();
			user.setCreateTime(new Date());
			user.setUpdateTime(new Date());
			user.setOrgId(org.getId());
			user.setUserName(mobile);
			user.setPassword(CryptUtils.md5Digest(password));
			user.setUserType(Constants.USER_TYPE_NORMAL);
			user.setRealName(mobile);// 默认先填用户名
			userMapper.insertSelective(user);
			//
			MessageNotifyOption messageNotifyOption = new MessageNotifyOption();
			messageNotifyOption.setCreateTime(new Date());
			messageNotifyOption.setUpdateTime(new Date());
			messageNotifyOption.setUserId(user.getId());
			messageNotifyOptionMapper.insertSelective(messageNotifyOption);
			//
			return ResponseEntity
					.ok(genCommonResponseWithSuccessful("register successful", String.valueOf(user.getId())));
		} else {
			return ResponseEntity.ok(genCommonResponseWithFailed("手机号码已经存在！"));
		}
	}

	@Override
	public ResponseEntity<LoginResponse> login(ApiRequestBase<LoginRequest> request) {
		LoginRequest loginRequest = request.getData();
		String mobile = loginRequest.getMobile();
		String password = loginRequest.getPassword();

		User user = null;
		UserExample example = new UserExample();
		example.createCriteria().andUserNameEqualTo(mobile);
		List<User> users = userMapper.selectByExample(example);
		if (users.size() > 0)
			user = users.get(0);
		if (user == null || user.getDeleteStatus() == Constants.DELETE_STATUS_TRUE) {
			return ResponseEntity.ok(genLoginResponseWithFailed("用户不存在！"));
		}
		String password2 = user.getPassword();
		if (password2.equals(CryptUtils.md5Digest(password))) {
			String token = mobile;
			// 保存token
			ShardedJedis shardedJedis = shardedJedisPool.getResource();
			try {
				shardedJedis.setex(RedisKeyPrefix.USER_LOGIN_TOKEN + token,
						commonService.getUserTokenExpiry(user.getUserType()), user.getId().toString());
			} finally {
				if (shardedJedis != null)
					shardedJedis.close();
			}
			LoginUser loginUser = new LoginUser();
			loginUser.setToken(token);
			com.clinicalmall.kuaixiu.vo.User user2 = new com.clinicalmall.kuaixiu.vo.User();
			BeanUtils.copyProperties(user, user2);
			loginUser.setUser(user2);
			Org org = orgMapper.selectByPrimaryKey(user.getOrgId());
			com.clinicalmall.kuaixiu.vo.Org org2 = new com.clinicalmall.kuaixiu.vo.Org();
			BeanUtils.copyProperties(org, org2);
			loginUser.setOrg(org2);
			return ResponseEntity.ok(genLoginResponseWithSuccessful("登录成功！", loginUser));
		} else {
			return ResponseEntity.ok(genLoginResponseWithFailed("密码错误！"));
		}
	}

	@Override
	public ResponseEntity<UserListResponse> getList(ApiRequestBase<UserListRequest> request) {
		UserListRequest userListRequest = request.getData();
		Integer pageNumber = userListRequest.getPageNumber();
		Integer pageSize = userListRequest.getPageSize();
		Long orgId = userListRequest.getOrgId();
		UserExample example = new UserExample();
		example.createCriteria().andOrgIdEqualTo(orgId);
		long total = userMapper.countByExample(example);
		example.setPage(new Page(pageNumber, pageSize));
		List<User> users = userMapper.selectByExample(example);
		UserListResponse userListResponse = new UserListResponse();
		userListResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
		List<com.clinicalmall.kuaixiu.vo.User> data = new ArrayList<com.clinicalmall.kuaixiu.vo.User>();
		for (User user : users) {
			com.clinicalmall.kuaixiu.vo.User user1 = new com.clinicalmall.kuaixiu.vo.User();
			BeanUtils.copyProperties(user, user1);
			data.add(user1);
		}
		userListResponse.setTotalRow(total);
		userListResponse.setData(data);
		return ResponseEntity.ok(userListResponse);
	}

	@Override
	public ResponseEntity<GetUserResponse> getUser(ApiRequestBase<GetUserRequest> request) {
		GetUserResponse getUserResponse = new GetUserResponse();
		Long id = request.getData().getId();
		User user = userMapper.selectByPrimaryKey(id);
		if (user == null) {
			getUserResponse.setCode(ApiResponseBase.CODE_FAILED);
			getUserResponse.setMsg("用户不存在！");
		} else {
			getUserResponse.setCode(ApiResponseBase.CODE_SUCCESSFUL);
			com.clinicalmall.kuaixiu.vo.User user1 = new com.clinicalmall.kuaixiu.vo.User();
			BeanUtils.copyProperties(user, user1);
			getUserResponse.setData(user1);
		}
		return ResponseEntity.ok(getUserResponse);
	}

	@Override
	public ResponseEntity<CommonResponse> modifyPwd(ApiRequestBase<UserModifyPwdRequest> request) {
		String token = request.getToken();
		User user = getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		UserModifyPwdRequest userModifyPwdRequest = request.getData();
		String newPassword = userModifyPwdRequest.getNewPassword();
		String oldPassword = userModifyPwdRequest.getOldPassword();
		if (user.getPassword().equals(CryptUtils.md5Digest(oldPassword))) {
			user.setPassword(CryptUtils.md5Digest(newPassword));
			user.setUpdateTime(new Date());
			user.setRemark("修改密码");
			userMapper.updateByPrimaryKeySelective(user);
			return ResponseEntity.ok(genCommonResponseWithSuccessful("密码修改成功！"));
		} else
			return ResponseEntity.ok(genCommonResponseWithFailed("原密码错误！"));
	}

	@Override
	public ResponseEntity<CommonResponse> findPwd(ApiRequestBase<UserFindPwdRequest> request) {
		UserFindPwdRequest userFindPwdRequest = request.getData();
		String mobile = userFindPwdRequest.getMobile();
		String password = userFindPwdRequest.getPassword();
		String code = userFindPwdRequest.getCode();
		if (!commonService.checkSmsCode(mobile, code)) {
			return ResponseEntity.ok(genCommonResponseWithFailed("验证码错误！"));
		}
		UserExample userExample = new UserExample();
		userExample.createCriteria().andUserNameEqualTo(mobile);
		List<User> users = userMapper.selectByExample(userExample);
		if (users.isEmpty()) {
			return ResponseEntity.ok(genCommonResponseWithFailed("用户不存在！"));
		}
		User user = users.get(0);
		user.setPassword(CryptUtils.md5Digest(password));
		user.setUpdateTime(new Date());
		user.setRemark("找回密码");
		userMapper.updateByPrimaryKeySelective(user);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("密码修改成功！"));
	}

	@Override
	public ResponseEntity<CommonResponse> modify(ApiRequestBase<UserModifyRequest> request) {
		String token = request.getToken();
		User user = getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		UserModifyRequest userModifyRequest = request.getData();
		String realName = userModifyRequest.getRealName();
		String email = userModifyRequest.getEmail();
		String dept = userModifyRequest.getDept();

		user.setRealName(realName);
		user.setEmail(email);
		user.setDept(dept);
		user.setUpdateTime(new Date());
		user.setRemark("修改用户信息");
		userMapper.updateByPrimaryKeySelective(user);
		return ResponseEntity.ok(genCommonResponseWithSuccessful("用户信息修改成功！"));
	}

	@Override
	public ResponseEntity<CommonResponse> modifyHeadImg(ApiRequestBase<UserModifyHeadImgRequest> request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<CommonResponse> modifyType(ApiRequestBase<UserModifyTypeRequest> request) {
		String token = request.getToken();
		User user = getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		if (user.getUserType() != Constants.USER_TYPE_ORG_ADMIN) {
			return ResponseEntity.ok(genCommonResponseWithFailed("非法操作！"));
		}
		UserModifyTypeRequest userModifyTypeRequest = request.getData();
		Long id = userModifyTypeRequest.getId();
		Integer userType = userModifyTypeRequest.getUserType();
		user = userMapper.selectByPrimaryKey(id);
		if (user == null)
			return ResponseEntity.ok(genCommonResponseWithFailed("用户不存在！"));
		if (userType == Constants.USER_TYPE_OPERATION_ADMIN || userType == Constants.USER_TYPE_NORMAL) {
			user.setUserType(userType);
			user.setUpdateTime(new Date());
			user.setRemark("修改用户类型");
			userMapper.updateByPrimaryKeySelective(user);
			return ResponseEntity.ok(genCommonResponseWithSuccessful("用户类型修改成功！"));
		} else
			return ResponseEntity.ok(genCommonResponseWithFailed("非法的用户类型！"));
	}

	@Override
	public ResponseEntity<CommonResponse> delete(ApiRequestBase<UserDeleteRequest> request) {
		// TODO Auto-generated method stub
		UserDeleteRequest userDeleteRequest = request.getData();
		Long id = userDeleteRequest.getId();
		User user = userMapper.selectByPrimaryKey(id);

		return null;
	}

	@Override
	public boolean checkToken(String token) {
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		try {
			if (shardedJedis.exists(RedisKeyPrefix.USER_LOGIN_TOKEN + token))
				return true;
		} finally {
			if (shardedJedis != null)
				shardedJedis.close();
		}
		return false;
	}

	@Override
	public User getUserByToken(String token) {
		String id = null;
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		try {
			id = shardedJedis.get(RedisKeyPrefix.USER_LOGIN_TOKEN + token);
		} finally {
			if (shardedJedis != null)
				shardedJedis.close();
		}
		if (StringUtils.isNoneBlank(id)) {
			return userMapper.selectByPrimaryKey(Long.parseLong(id));
		}
		return null;
	}
}
