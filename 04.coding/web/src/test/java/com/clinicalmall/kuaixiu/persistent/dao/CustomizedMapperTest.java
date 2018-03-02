package com.clinicalmall.kuaixiu.persistent.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.az.common.vo.mybatis.pagination.Page;
import com.clinicalmall.kuaixiu.common.constants.Constants;
import com.clinicalmall.kuaixiu.persistent.domain.Org;
import com.clinicalmall.kuaixiu.vo.Equipment;
import com.clinicalmall.kuaixiu.vo.Plan;
import com.clinicalmall.kuaixiu.vo.Task;
import com.clinicalmall.kuaixiu.vo.Work;

@RunWith(SpringJUnit4ClassRunner.class)
// 表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = { "classpath:spring-config.xml" })
public class CustomizedMapperTest {
	@Resource
	private CustomizedMapper customizedMapper = null;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCountOrgBind() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("id", 1l);
		where.put("type", 1);
		where.put("name", null);
		// where.put("page", new Page(1, 10));
		long total = customizedMapper.countOrgBind(where);
		Assert.assertNotEquals(total, 0);
	}

	@Test
	public void testSelectOrgBind() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("id", 1l);
		where.put("type", 1);
		where.put("name", null);
		where.put("page", new Page(0, 10));
		List<Org> orgs = customizedMapper.selectOrgBind(where);
		Assert.assertNotEquals(orgs.size(), 0);
	}

	@Test
	public void testCountEquipment() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		where.put("bind", 1);
		where.put("bindType", 2);
		where.put("name", null);
		// where.put("page", new Page(1, 10));
		long total = customizedMapper.countEquipment(where);
		Assert.assertNotEquals(total, 0);
	}

	@Test
	public void testSelectEquipment() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		// where.put("bind", 1);
		where.put("bindType", 2);
		where.put("name", null);
		where.put("deleteStatus", Constants.DELETE_STATUS_TRUE);
		where.put("page", new Page(0, 10));
		List<Equipment> equipments = customizedMapper.selectEquipment(where);
		Assert.assertNotEquals(equipments.size(), 0);
	}

	@Test
	public void testCountPlan() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		where.put("name", null);
		// where.put("page", new Page(1, 10));
		long total = customizedMapper.countPlan(where);
		Assert.assertNotEquals(total, 0);
	}

	@Test
	public void testSelectPlan() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 5l);
		where.put("orgType", 2);
		where.put("name", null);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);
		where.put("page", new Page(0, 10));
		List<Plan> list = customizedMapper.selectPlan(where);
		Assert.assertNotEquals(list.size(), 0);
	}

	@Test
	public void testCountWork() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		where.put("name", null);
		// where.put("page", new Page(1, 10));
		long total = customizedMapper.countWork(where);
		Assert.assertNotEquals(total, 0);
	}

	@Test
	public void testSelectWork() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 2l);
		where.put("name", null);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);
		where.put("page", new Page(0, 10));
		List<Work> list = customizedMapper.selectWork(where);
		Assert.assertNotEquals(list.size(), 0);
	}

	@Test
	public void testCountTask() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);
		where.put("status", 1);
		long total = customizedMapper.countTask(where);
		Assert.assertNotEquals(total, 0);
	}

	@Test
	public void testSelectTask() {
		Map<String, Object> where = new HashMap<String, Object>();
		where.put("orgId", 1l);
		where.put("deleteStatus", Constants.DELETE_STATUS_FALSE);
		where.put("page", new Page(0, 10));
		List<Task> list = customizedMapper.selectTask(where);
		Assert.assertNotEquals(list.size(), 0);
	}

}
