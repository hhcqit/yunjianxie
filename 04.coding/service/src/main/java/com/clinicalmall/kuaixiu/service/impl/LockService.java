package com.clinicalmall.kuaixiu.service.impl;

import javax.annotation.Resource;

import org.redisson.RedissonClient;
import org.redisson.core.RLock;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.clinicalmall.kuaixiu.common.constants.RedisKeyPrefix;
import com.clinicalmall.kuaixiu.service.ICommonService;
import com.clinicalmall.kuaixiu.service.ILockService;

@Transactional
@Service
public class LockService extends AbsService implements ILockService {
	@Resource
	private ICommonService commonService;

	@Override
	public RLock getUserLock(String userId) {
		RedissonClient redissonClient = commonService.getRedissonClient();
		return redissonClient.getLock(RedisKeyPrefix.LOCK + "user_" + userId);
	}

	@Override
	public RLock getTaskLock(String taskId) {
		RedissonClient redissonClient = commonService.getRedissonClient();
		return redissonClient.getLock(RedisKeyPrefix.LOCK + "task_" + taskId);
	}

}
