package com.clinicalmall.kuaixiu.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.common.constants.RedisKeyPrefix;
import com.clinicalmall.kuaixiu.common.utils.CryptUtils;
import com.clinicalmall.kuaixiu.common.utils.RandomCodeGenerator;
import com.clinicalmall.kuaixiu.persistent.dao.AttachmentMapper;
import com.clinicalmall.kuaixiu.persistent.dao.CustomizedMapper;
import com.clinicalmall.kuaixiu.persistent.dao.SmsCodeMapper;
import com.clinicalmall.kuaixiu.persistent.dao.SmsSendMapper;
import com.clinicalmall.kuaixiu.persistent.dao.UserMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Attachment;
import com.clinicalmall.kuaixiu.persistent.domain.SmsCode;
import com.clinicalmall.kuaixiu.persistent.domain.SmsSend;
import com.clinicalmall.kuaixiu.persistent.domain.User;
import com.clinicalmall.kuaixiu.persistent.domain.UserExample;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.IUserService;
import com.clinicalmall.kuaixiu.vo.ApiRequestBase;
import com.clinicalmall.kuaixiu.vo.ApiResponseBase;
import com.clinicalmall.kuaixiu.vo.CommonResponse;
import com.clinicalmall.kuaixiu.vo.SendSmsCodeRequest;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Transactional
@Service
public class CommonService extends AbsService implements ICommonService {
	private static final Logger log = LoggerFactory.getLogger(CommonService.class);
	// redis
	@Value("${redis.host}")
	private String redisHost;
	@Value("${redis.port}")
	private String redisPort;
	@Value("${redis.password}")
	private String redisPassword;

	// 短信配置
	@Value("${app.sms.comName}")
	private String comName;
	@Value("${app.sms.comPwd}")
	private String comPwd;
	@Value("${app.sms.Server}")
	private String Server;

	@Resource
	private ShardedJedisPool shardedJedisPool;
	@Resource
	private CustomizedMapper customizedMapper;
	@Resource
	private UserMapper userMapper;
	@Resource
	private SmsCodeMapper smsCodeMapper;
	@Resource
	private SmsSendMapper smsSendMapper;
	@Resource
	private AttachmentMapper attachmentMapper;
	@Resource
	private IUserService userService;

	private RedissonClient redissonClient;

	@PostConstruct
	public void init() {
		// 创建配置信息
		Config config = new Config();
		config.useSingleServer().setAddress(redisHost + ":" + redisPort).setPassword(redisPassword)
				.setConnectionPoolSize(10);
		redissonClient = Redisson.create(config);
	}

	@PreDestroy
	public void destroy() {
		if (redissonClient != null && !redissonClient.isShuttingDown())
			redissonClient.shutdown();
	}

	@Override
	public RedissonClient getRedissonClient() {
		return redissonClient;
	}

	@Override
	public ResponseEntity<CommonResponse> sendSmsCode(ApiRequestBase<SendSmsCodeRequest> request) {

		SendSmsCodeRequest sendSmsCodeRequest = request.getData();
		Integer type = sendSmsCodeRequest.getType();
		String mobile = sendSmsCodeRequest.getMobile();
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		try {
			if (shardedJedis.exists(RedisKeyPrefix.COMMON_SMS_CODE + mobile)) {
				return ResponseEntity.ok(genCommonResponseWithSuccessful());
			}
		} catch (Exception e) {
		} finally {
			if (shardedJedis != null)
				shardedJedis.close();
		}
		User user = null;
		if (type == Constants.SMS_TYPE_REGISTER || type == Constants.SMS_TYPE_FIND_PWD
				|| type == Constants.SMS_TYPE_DYNAMIC_PWD) {// 注册或者找回密码，否则返回失败
			UserExample example = new UserExample();
			example.createCriteria().andUserNameEqualTo(mobile);
			List<User> users = userMapper.selectByExample(example);
			if (type == Constants.SMS_TYPE_REGISTER) {// 注册，已注册过的用户不能发验证码
				if (!users.isEmpty()) {
					return ResponseEntity.ok(genCommonResponseWithFailed("用户已存在！"));
				}
			} else {// 找回密码，需要验证用户是否存在
				if (users.isEmpty()) {
					return ResponseEntity.ok(genCommonResponseWithFailed("用户不存在！"));
				}
				user = users.get(0);
			}
		} else {
			return ResponseEntity.ok(genCommonResponseWithFailed("类型不存在！"));
		}
		String code = String.valueOf(RandomCodeGenerator.numericCode(6));
		int period = 3;
		boolean sendResult = sendSms(mobile, "你的验证码是：" + code + "，请在3分钟内使用！", type,
				user == null ? null : user.getId().toString());
		if (sendResult) {
			SmsCode smsCode = new SmsCode();
			smsCode.setCreateTime(new Date());
			smsCode.setMobile(mobile);
			smsCode.setCode(code);
			smsCode.setType(type);
			smsCode.setUsedStatus(false);
			smsCode.setExpiresTime(new Date(System.currentTimeMillis() + period * 60 * 1000l));
			smsCodeMapper.insertSelective(smsCode);
			shardedJedis = shardedJedisPool.getResource();
			try {
				shardedJedis.setex(RedisKeyPrefix.COMMON_SMS_CODE + mobile, period * 60, code);
			} catch (Exception e) {
			} finally {
				if (shardedJedis != null)
					shardedJedis.close();
			}
		} else {
			log.warn("短信接口调用失败：statusCode=" + sendResult + ", statusMsg=");
			return ResponseEntity.ok(genCommonResponseWithFailed("短信验证码发送失败！请检查手机号码或联系客服处理！"));
		}
		return ResponseEntity.ok(genCommonResponseWithSuccessful());
	}

	@Override
	public boolean checkSmsCode(String mobile, String code) {
		ShardedJedis shardedJedis = shardedJedisPool.getResource();
		try {
			String vaildCode = shardedJedis.get(RedisKeyPrefix.COMMON_SMS_CODE + mobile);
			if (StringUtils.isNotBlank(vaildCode) && vaildCode.equals(code))
				return true;
		} finally {
			if (shardedJedis != null)
				shardedJedis.close();
		}
		return false;
	}

	/**
	 * 
	 * @param mobile
	 *            {@link SmsSend#getMobile()}
	 * @param content
	 *            {@link SmsSend#getContent()}
	 * @param type
	 *            {@link SmsSend#getType()}
	 * @param relateId
	 *            {@link SmsSend#getRelateId()}
	 * @return
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean sendSms(String mobile, String content, int type, String relateId) {
		boolean result = true;
		String returnCode = "";
		String encode = null;
		try {
			returnCode = smsSend(mobile, content, "", "");// 短信发送
			encode = new String(returnCode.getBytes("GBK"), "GB2312");
			String[] ary = encode.split("&");
			String[] str = ary[0].split("=");
			if (Integer.parseInt(str[1]) == 0) {
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == true) {
			String sid = null;
			int send = 0;
			/* 保存短信内容 */
			SmsSend smsSend = new SmsSend();
			smsSend.setCreateTime(new Date());
			smsSend.setMobile(mobile);
			smsSend.setContent(content);
			smsSend.setType(type);
			smsSend.setRelateId(relateId);
			smsSend.setSid(sid);
			smsSend.setSend(send);
			smsSend.setResponse(returnCode);
			smsSendMapper.insertSelective(smsSend);
		}
		return result;
	}

	@Override
	public int getUserTokenExpiry(int userType) {
		return Constants.USER_TOKEN_EXPIRY;
	}

	/*
	 * 参数说明： dst - 手机号之间用英文逗号分割,最后一个手机号后不加逗号, 必填, 小灵通号码发送请和手机号码分离单独作为一组发送。请少于100个号码。
	 * msg - 短信内容，为不超过60个汉字、字符、数字的字符串，小灵通号码不超过40个字。超过的字符自动截掉。如果是超长短信，不能超过240个字符。
	 * time - 定时时间(可不填)，例如“200505241713”表示此条短信定时在2005年5月24日17点13分发出。 格式:
	 * YYYYMMDDHHMM；12位时间表示，不符合规则的将立即进行发送。 subNo -
	 * 子号码(可不填)，例如您的特服代码为0888008，想让此条短信的发送者为088800800，则sender=00即可； 值为空则默认为您的特服代码。
	 */
	public String smsSend(String dst, String msg, String time, String subNo) throws UnsupportedEncodingException {
		String sUrl = null;
		try {
			sUrl = this.Server + "/send/gsend.asp?name=" + this.comName + "&pwd=" + this.comPwd + "&dst=" + dst
					+ "&msg=" + URLEncoder.encode(msg, "GB2312") + "&time=" + time + "&sender=" + subNo;// 这里必须GB2312否则发到手机乱码
		} catch (UnsupportedEncodingException uee) {
			// System.out.println(uee.toString());
			uee.printStackTrace();
		}
		return getUrlMsg(sUrl);
	}

	/*
	 * 发送短信并且回传数据
	 * 
	 */
	public String getUrlMsg(String urlString) throws UnsupportedEncodingException {
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL(urlString);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			for (String line = null; (line = reader.readLine()) != null;)
				sb.append(line + "\n");

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
			// System.out.println(e.toString());
		}
		String msg = sb.toString();
		return new String(msg.getBytes("GBK"), "GB2312");
	}

	@Override
	public ResponseEntity<CommonResponse> uploadAttachment(String token, Integer type, MultipartFile multipartFile,
			HttpServletRequest httpServletRequest) {
		User user = userService.getUserByToken(token);
		if (user == null) {
			return ResponseEntity.ok(genCommonResponseWithInvalidToken());
		}
		String uploadPath = httpServletRequest.getSession().getServletContext().getRealPath("/upload");
		String fileName = multipartFile.getOriginalFilename();
		String suffix = "";
		if (fileName.lastIndexOf(".") > -1)
			suffix = fileName.substring(fileName.lastIndexOf("."));
		fileName = CryptUtils.md5Digest(fileName + System.currentTimeMillis() + user.getId() + user.getOrgId())
				+ suffix;
		log.info("存储路径：{}，文件名：{}，文件类型：{}，文件名：{}，文件大小：{}", uploadPath, fileName, multipartFile.getContentType(),
				multipartFile.getName(), multipartFile.getSize());
		File attachmentFile = new File(uploadPath, fileName);
		if (!attachmentFile.exists()) {
			attachmentFile.mkdirs();
		}
		try {
			multipartFile.transferTo(attachmentFile);
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
			return ResponseEntity.ok(genCommonResponseWithFailed("文件保存失败！"));

		}
		Attachment attachment = new Attachment();
		attachment.setCreateUser(user.getId());
		attachment.setCreateTime(new Date());
		attachment.setUpdateUser(user.getId());
		attachment.setUpdateTime(new Date());
		attachment.setOrgId(user.getOrgId());
		attachment.setType(type == null ? 0 : type);
		attachment.setSize((int) multipartFile.getSize());
		attachment.setName(fileName);
		attachment.setPath("/upload" + fileName);
		attachment.setUrl(attachment.getPath());
		attachment.setMediaId("0");
		attachmentMapper.insertSelective(attachment);
		return ResponseEntity.ok(new CommonResponse().code(ApiResponseBase.CODE_SUCCESSFUL).msg("上传成功！")
				.data(attachment.getId().toString()));
	}
}
