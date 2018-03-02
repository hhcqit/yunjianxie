package com.clinicalmall.kuaixiu.job;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.common.utils.DateUtils;
import com.clinicalmall.kuaixiu.persistent.dao.PlanMapper;
import com.clinicalmall.kuaixiu.persistent.domain.Plan;
import com.clinicalmall.kuaixiu.persistent.domain.PlanExample;
import com.clinicalmall.kuaixiu.service.IPlanService;

public class PlanJob implements IJob {
	@Resource
	private IPlanService planService;
	@Resource
	private PlanMapper planMapper;

	public void execute() {
		Calendar currentCalendar = Calendar.getInstance();
		int currentWeek = currentCalendar.get(Calendar.DAY_OF_WEEK);
		String currentDate = DateUtils.formatDate(new Date());
		PlanExample example = new PlanExample();
		example.createCriteria().andDeleteStatusEqualTo(Constants.DELETE_STATUS_FALSE);
		List<Plan> plans = planMapper.selectByExample(example);

		for (Plan plan : plans) {
			if (plan.getStartTime() == null || (plan.getLatestExecuteTime() != null
					&& DateUtils.formatDate(plan.getLatestExecuteTime()).compareTo(currentDate) >= 0))
				continue;
			Date startTime = plan.getStartTime();
			Integer periodType = plan.getPeriodType();
			Integer period = plan.getPeriod();
			Date latestExecuteTime = plan.getLatestExecuteTime();
			Calendar planCalendar = Calendar.getInstance();
			if (latestExecuteTime == null)
				planCalendar.setTime(startTime);
			else
				planCalendar.setTime(latestExecuteTime.after(startTime) ? latestExecuteTime : startTime);// 如果开始时间在最后一次执行时间之后，则用新的开始时间
			if (periodType == Constants.PLAN_PERIOD_TYPE_CUSTOMIZED) {
				if (latestExecuteTime != null)// 第一次执行时使用开始时间，不用再加周期
					planCalendar.add(Calendar.DAY_OF_MONTH, period);
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_DAY) {
				planCalendar.setTime(new Date());
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_WEEK) {
				Calendar calendar = Calendar.getInstance();
				int planWeek = calendar.get(Calendar.DAY_OF_WEEK);
				if (planWeek == currentWeek)
					planCalendar.setTime(new Date());
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_MONTH) {
				if (latestExecuteTime != null)// 第一次执行时使用开始时间，不用再加周期
					planCalendar.add(Calendar.MONTH, 1);
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_QUARTER) {
				if (latestExecuteTime != null)// 第一次执行时使用开始时间，不用再加周期
					planCalendar.add(Calendar.MONTH, 3);
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_HALF_A_YEAR) {
				if (latestExecuteTime != null)// 第一次执行时使用开始时间，不用再加周期
					planCalendar.add(Calendar.MONTH, 6);
			} else if (periodType == Constants.PLAN_PERIOD_TYPE_YEAR) {
				if (latestExecuteTime != null)// 第一次执行时使用开始时间，不用再加周期
					planCalendar.add(Calendar.YEAR, 1);
			}
			if (DateUtils.formatDate(planCalendar.getTime()).equals(currentDate))
				planService.genPlanInstance(plan);
		}
	}
}
