package com.clinicalmall.kuaixiu.service;

import org.redisson.core.RLock;

public interface ILockService {
	/**
	 * 获取用户锁
	 * 
	 * @param userId
	 * @return
	 */
	public RLock getUserLock(String userId);

	/**
	 * 获取任务锁
	 * 
	 * @param taskId
	 * @return
	 */
	public RLock getTaskLock(String taskId);

}
