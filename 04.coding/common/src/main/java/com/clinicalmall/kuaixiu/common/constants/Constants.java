package com.clinicalmall.kuaixiu.common.constants;

import java.util.Arrays;
import java.util.List;

public class Constants {
	// system
	public static final int USER_TOKEN_EXPIRY = 3 * 24 * 3600;
	// common

	public static final int FLAG_TRUE = 1;
	public static final int FLAG_FALSE = 0;
	public static final int DELETE_STATUS_TRUE = 1;
	public static final int DELETE_STATUS_FALSE = 0;

	/**
	 * 0、其他/未分类 1、注册 2、找回密码 3、动态密码 9、系统通知
	 */
	public static final int SMS_TYPE_NONE = 0;
	public static final int SMS_TYPE_REGISTER = 1;
	public static final int SMS_TYPE_FIND_PWD = 2;
	public static final int SMS_TYPE_DYNAMIC_PWD = 3;

	/**
	 * 执行权限 0、不限 1、内部 2、外部
	 */
	public static final int EXECUTE_PERMISSION_UNLIMITED = 0;
	public static final int EXECUTE_PERMISSION_INNER = 1;
	public static final int EXECUTE_PERMISSION_OUTER = 2;

	// user
	/**
	 * 用户类型 0、系统管理员 1、平台管理员，一个平台只有一个 2、业务管理员，一个平台可以有多个 3、普通用户
	 */
	public static final int USER_TYPE_SYSTEM_ADMIN = 0;
	public static final int USER_TYPE_ORG_ADMIN = 1;
	public static final int USER_TYPE_OPERATION_ADMIN = 2;
	public static final int USER_TYPE_NORMAL = 3;
	public static final List<Integer> userTypeList = Arrays.asList(USER_TYPE_SYSTEM_ADMIN, USER_TYPE_ORG_ADMIN,
			USER_TYPE_OPERATION_ADMIN, USER_TYPE_NORMAL);

	// org
	/**
	 * 类型 1、实验室 2、服务商
	 */
	public static final int ORG_TYPE_LAB = 1;
	public static final int ORG_TYPE_PROVIDER = 2;

	public static final List<Integer> orgTypeList = Arrays.asList(ORG_TYPE_LAB, ORG_TYPE_PROVIDER);
	// equipment
	/**
	 * 状态 0、未启用 1、启用
	 */
	public static final int EQUIPMENT_STATUS_DISABLED = 0;
	public static final int EQUIPMENT_STATUS_ENABLED = 1;
	/**
	 * 状态 0、草稿 1、归档
	 */
	public static final int EQUIPMENT_EXAMINE_STATUS_DRAFT = 0;
	public static final int EQUIPMENT_EXAMINE_STATUS_ARCHIVED = 1;

	// plan
	/**
	 * 周期类型 0、自定义 1、每日 2、每周 3、每月 4、每3月 5、每半年 6、每年
	 */
	public static final int PLAN_PERIOD_TYPE_CUSTOMIZED = 0;
	public static final int PLAN_PERIOD_TYPE_DAY = 1;
	public static final int PLAN_PERIOD_TYPE_WEEK = 2;
	public static final int PLAN_PERIOD_TYPE_MONTH = 3;
	public static final int PLAN_PERIOD_TYPE_QUARTER = 4;
	public static final int PLAN_PERIOD_TYPE_HALF_A_YEAR = 5;
	public static final int PLAN_PERIOD_TYPE_YEAR = 6;
	/**
	 * 类型 1、保养计划 2、检定计划
	 */
	public static final int PLAN_TYPE_MAINTAIN = 1;
	public static final int PLAN_TYPE_CHECK = 2;
	public static final List<Integer> planTypeList = Arrays.asList(PLAN_TYPE_MAINTAIN, PLAN_TYPE_CHECK);

	// work
	/**
	 * 来源 1、计划生成 2、手工生成
	 */

	public static final int WORK_ORIGIN_PLAN = 1;
	public static final int WORK_ORIGIN_TEMPORARY = 2;

	/**
	 * 当前状态 0、未开始 1、执行中 2、待确认 3、已完成
	 */

	public static final int WORK_STATUS_ORIGIN = 0;
	public static final int WORK_STATUS_UNDERWAY = 1;
	public static final int WORK_STATUS_TO_BE_CONFIRMED = 2;
	public static final int WORK_STATUS_FINISHED = 3;

	// task
	/**
	 * 当前状态 10、待受理 11、报修人撤销 12、维修人删除 20、待维修 21、报修人撤销 22、维修人删除 23、被拒绝 30、待确认 40、已完成
	 * 50、已关闭
	 */
	public static final int TASK_STATUS_TO_BE_ACCEPT = 10;
	public static final int TASK_STATUS_CREATOR_CANCEL = 11;
	public static final int TASK_STATUS_CREATOR_DELETE = 12;
	public static final int TASK_STATUS_TO_BE_REPAIR = 20;
	public static final int TASK_STATUS_REPAIRER_CANCEL = 21;
	public static final int TASK_STATUS_REPAIRER_DELETE = 22;
	public static final int TASK_STATUS_REPAIRER_REJECT = 23;
	public static final int TASK_STATUS_TO_BE_CONFIRMED = 30;
	public static final int TASK_STATUS_FINISHED = 40;
	public static final int TASK_STATUS_CLOSED = 50;

	/**
	 * 当前状态 0、待维修 1、已修好 -1、已退回
	 */
	public static final int TASK_REPAIR_STATUS_ORIGINAL = 0;
	public static final int TASK_REPAIR_STATUS_FINISHED = 1;
	public static final int TASK_REPAIR_STATUS_REJECT = -1;

}
