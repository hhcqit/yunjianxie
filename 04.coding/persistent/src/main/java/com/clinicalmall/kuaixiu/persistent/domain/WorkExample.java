package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WorkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public WorkExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    public void setPage(Page page) {
        this.page=page;
    }

    public Page getPage() {
        return page;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNull() {
            addCriterion("deleteStatus is null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIsNotNull() {
            addCriterion("deleteStatus is not null");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusEqualTo(Integer value) {
            addCriterion("deleteStatus =", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotEqualTo(Integer value) {
            addCriterion("deleteStatus <>", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThan(Integer value) {
            addCriterion("deleteStatus >", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("deleteStatus >=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThan(Integer value) {
            addCriterion("deleteStatus <", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusLessThanOrEqualTo(Integer value) {
            addCriterion("deleteStatus <=", value, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusIn(List<Integer> values) {
            addCriterion("deleteStatus in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotIn(List<Integer> values) {
            addCriterion("deleteStatus not in", values, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusBetween(Integer value1, Integer value2) {
            addCriterion("deleteStatus between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andDeleteStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("deleteStatus not between", value1, value2, "deleteStatus");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNull() {
            addCriterion("planId is null");
            return (Criteria) this;
        }

        public Criteria andPlanIdIsNotNull() {
            addCriterion("planId is not null");
            return (Criteria) this;
        }

        public Criteria andPlanIdEqualTo(Long value) {
            addCriterion("planId =", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotEqualTo(Long value) {
            addCriterion("planId <>", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThan(Long value) {
            addCriterion("planId >", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdGreaterThanOrEqualTo(Long value) {
            addCriterion("planId >=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThan(Long value) {
            addCriterion("planId <", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdLessThanOrEqualTo(Long value) {
            addCriterion("planId <=", value, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdIn(List<Long> values) {
            addCriterion("planId in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotIn(List<Long> values) {
            addCriterion("planId not in", values, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdBetween(Long value1, Long value2) {
            addCriterion("planId between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPlanIdNotBetween(Long value1, Long value2) {
            addCriterion("planId not between", value1, value2, "planId");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIsNull() {
            addCriterion("periodType is null");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIsNotNull() {
            addCriterion("periodType is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeEqualTo(Integer value) {
            addCriterion("periodType =", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotEqualTo(Integer value) {
            addCriterion("periodType <>", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeGreaterThan(Integer value) {
            addCriterion("periodType >", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("periodType >=", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeLessThan(Integer value) {
            addCriterion("periodType <", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeLessThanOrEqualTo(Integer value) {
            addCriterion("periodType <=", value, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeIn(List<Integer> values) {
            addCriterion("periodType in", values, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotIn(List<Integer> values) {
            addCriterion("periodType not in", values, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeBetween(Integer value1, Integer value2) {
            addCriterion("periodType between", value1, value2, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("periodType not between", value1, value2, "periodType");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(Integer value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(Integer value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(Integer value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(Integer value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<Integer> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<Integer> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(Integer value1, Integer value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionIsNull() {
            addCriterion("executePermission is null");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionIsNotNull() {
            addCriterion("executePermission is not null");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionEqualTo(Integer value) {
            addCriterion("executePermission =", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionNotEqualTo(Integer value) {
            addCriterion("executePermission <>", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionGreaterThan(Integer value) {
            addCriterion("executePermission >", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("executePermission >=", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionLessThan(Integer value) {
            addCriterion("executePermission <", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionLessThanOrEqualTo(Integer value) {
            addCriterion("executePermission <=", value, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionIn(List<Integer> values) {
            addCriterion("executePermission in", values, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionNotIn(List<Integer> values) {
            addCriterion("executePermission not in", values, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionBetween(Integer value1, Integer value2) {
            addCriterion("executePermission between", value1, value2, "executePermission");
            return (Criteria) this;
        }

        public Criteria andExecutePermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("executePermission not between", value1, value2, "executePermission");
            return (Criteria) this;
        }

        public Criteria andOriginIsNull() {
            addCriterion("origin is null");
            return (Criteria) this;
        }

        public Criteria andOriginIsNotNull() {
            addCriterion("origin is not null");
            return (Criteria) this;
        }

        public Criteria andOriginEqualTo(Integer value) {
            addCriterion("origin =", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotEqualTo(Integer value) {
            addCriterion("origin <>", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThan(Integer value) {
            addCriterion("origin >", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginGreaterThanOrEqualTo(Integer value) {
            addCriterion("origin >=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThan(Integer value) {
            addCriterion("origin <", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginLessThanOrEqualTo(Integer value) {
            addCriterion("origin <=", value, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginIn(List<Integer> values) {
            addCriterion("origin in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotIn(List<Integer> values) {
            addCriterion("origin not in", values, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginBetween(Integer value1, Integer value2) {
            addCriterion("origin between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andOriginNotBetween(Integer value1, Integer value2) {
            addCriterion("origin not between", value1, value2, "origin");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("orgId is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("orgId is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Long value) {
            addCriterion("orgId =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Long value) {
            addCriterion("orgId <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Long value) {
            addCriterion("orgId >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("orgId >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Long value) {
            addCriterion("orgId <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("orgId <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Long> values) {
            addCriterion("orgId in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Long> values) {
            addCriterion("orgId not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Long value1, Long value2) {
            addCriterion("orgId between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("orgId not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNull() {
            addCriterion("labId is null");
            return (Criteria) this;
        }

        public Criteria andLabIdIsNotNull() {
            addCriterion("labId is not null");
            return (Criteria) this;
        }

        public Criteria andLabIdEqualTo(Long value) {
            addCriterion("labId =", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotEqualTo(Long value) {
            addCriterion("labId <>", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThan(Long value) {
            addCriterion("labId >", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdGreaterThanOrEqualTo(Long value) {
            addCriterion("labId >=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThan(Long value) {
            addCriterion("labId <", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdLessThanOrEqualTo(Long value) {
            addCriterion("labId <=", value, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdIn(List<Long> values) {
            addCriterion("labId in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotIn(List<Long> values) {
            addCriterion("labId not in", values, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdBetween(Long value1, Long value2) {
            addCriterion("labId between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andLabIdNotBetween(Long value1, Long value2) {
            addCriterion("labId not between", value1, value2, "labId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNull() {
            addCriterion("providerId is null");
            return (Criteria) this;
        }

        public Criteria andProviderIdIsNotNull() {
            addCriterion("providerId is not null");
            return (Criteria) this;
        }

        public Criteria andProviderIdEqualTo(Long value) {
            addCriterion("providerId =", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotEqualTo(Long value) {
            addCriterion("providerId <>", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThan(Long value) {
            addCriterion("providerId >", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("providerId >=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThan(Long value) {
            addCriterion("providerId <", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdLessThanOrEqualTo(Long value) {
            addCriterion("providerId <=", value, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdIn(List<Long> values) {
            addCriterion("providerId in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotIn(List<Long> values) {
            addCriterion("providerId not in", values, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdBetween(Long value1, Long value2) {
            addCriterion("providerId between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andProviderIdNotBetween(Long value1, Long value2) {
            addCriterion("providerId not between", value1, value2, "providerId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNull() {
            addCriterion("createUser is null");
            return (Criteria) this;
        }

        public Criteria andCreateUserIsNotNull() {
            addCriterion("createUser is not null");
            return (Criteria) this;
        }

        public Criteria andCreateUserEqualTo(Long value) {
            addCriterion("createUser =", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotEqualTo(Long value) {
            addCriterion("createUser <>", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThan(Long value) {
            addCriterion("createUser >", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("createUser >=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThan(Long value) {
            addCriterion("createUser <", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserLessThanOrEqualTo(Long value) {
            addCriterion("createUser <=", value, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserIn(List<Long> values) {
            addCriterion("createUser in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotIn(List<Long> values) {
            addCriterion("createUser not in", values, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserBetween(Long value1, Long value2) {
            addCriterion("createUser between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andCreateUserNotBetween(Long value1, Long value2) {
            addCriterion("createUser not between", value1, value2, "createUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNull() {
            addCriterion("updateUser is null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIsNotNull() {
            addCriterion("updateUser is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateUserEqualTo(Long value) {
            addCriterion("updateUser =", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotEqualTo(Long value) {
            addCriterion("updateUser <>", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThan(Long value) {
            addCriterion("updateUser >", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserGreaterThanOrEqualTo(Long value) {
            addCriterion("updateUser >=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThan(Long value) {
            addCriterion("updateUser <", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserLessThanOrEqualTo(Long value) {
            addCriterion("updateUser <=", value, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserIn(List<Long> values) {
            addCriterion("updateUser in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotIn(List<Long> values) {
            addCriterion("updateUser not in", values, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserBetween(Long value1, Long value2) {
            addCriterion("updateUser between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateUserNotBetween(Long value1, Long value2) {
            addCriterion("updateUser not between", value1, value2, "updateUser");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andEquipIdIsNull() {
            addCriterion("equipId is null");
            return (Criteria) this;
        }

        public Criteria andEquipIdIsNotNull() {
            addCriterion("equipId is not null");
            return (Criteria) this;
        }

        public Criteria andEquipIdEqualTo(Long value) {
            addCriterion("equipId =", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotEqualTo(Long value) {
            addCriterion("equipId <>", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThan(Long value) {
            addCriterion("equipId >", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThanOrEqualTo(Long value) {
            addCriterion("equipId >=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThan(Long value) {
            addCriterion("equipId <", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThanOrEqualTo(Long value) {
            addCriterion("equipId <=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdIn(List<Long> values) {
            addCriterion("equipId in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotIn(List<Long> values) {
            addCriterion("equipId not in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdBetween(Long value1, Long value2) {
            addCriterion("equipId between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotBetween(Long value1, Long value2) {
            addCriterion("equipId not between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdIsNull() {
            addCriterion("executeOrgId is null");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdIsNotNull() {
            addCriterion("executeOrgId is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdEqualTo(Long value) {
            addCriterion("executeOrgId =", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdNotEqualTo(Long value) {
            addCriterion("executeOrgId <>", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdGreaterThan(Long value) {
            addCriterion("executeOrgId >", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdGreaterThanOrEqualTo(Long value) {
            addCriterion("executeOrgId >=", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdLessThan(Long value) {
            addCriterion("executeOrgId <", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdLessThanOrEqualTo(Long value) {
            addCriterion("executeOrgId <=", value, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdIn(List<Long> values) {
            addCriterion("executeOrgId in", values, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdNotIn(List<Long> values) {
            addCriterion("executeOrgId not in", values, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdBetween(Long value1, Long value2) {
            addCriterion("executeOrgId between", value1, value2, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteOrgIdNotBetween(Long value1, Long value2) {
            addCriterion("executeOrgId not between", value1, value2, "executeOrgId");
            return (Criteria) this;
        }

        public Criteria andExecuteUserIsNull() {
            addCriterion("executeUser is null");
            return (Criteria) this;
        }

        public Criteria andExecuteUserIsNotNull() {
            addCriterion("executeUser is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteUserEqualTo(Long value) {
            addCriterion("executeUser =", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserNotEqualTo(Long value) {
            addCriterion("executeUser <>", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserGreaterThan(Long value) {
            addCriterion("executeUser >", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserGreaterThanOrEqualTo(Long value) {
            addCriterion("executeUser >=", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserLessThan(Long value) {
            addCriterion("executeUser <", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserLessThanOrEqualTo(Long value) {
            addCriterion("executeUser <=", value, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserIn(List<Long> values) {
            addCriterion("executeUser in", values, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserNotIn(List<Long> values) {
            addCriterion("executeUser not in", values, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserBetween(Long value1, Long value2) {
            addCriterion("executeUser between", value1, value2, "executeUser");
            return (Criteria) this;
        }

        public Criteria andExecuteUserNotBetween(Long value1, Long value2) {
            addCriterion("executeUser not between", value1, value2, "executeUser");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIsNull() {
            addCriterion("certificateNo is null");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIsNotNull() {
            addCriterion("certificateNo is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateNoEqualTo(String value) {
            addCriterion("certificateNo =", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotEqualTo(String value) {
            addCriterion("certificateNo <>", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoGreaterThan(String value) {
            addCriterion("certificateNo >", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoGreaterThanOrEqualTo(String value) {
            addCriterion("certificateNo >=", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLessThan(String value) {
            addCriterion("certificateNo <", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLessThanOrEqualTo(String value) {
            addCriterion("certificateNo <=", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoLike(String value) {
            addCriterion("certificateNo like", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotLike(String value) {
            addCriterion("certificateNo not like", value, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoIn(List<String> values) {
            addCriterion("certificateNo in", values, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotIn(List<String> values) {
            addCriterion("certificateNo not in", values, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoBetween(String value1, String value2) {
            addCriterion("certificateNo between", value1, value2, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateNoNotBetween(String value1, String value2) {
            addCriterion("certificateNo not between", value1, value2, "certificateNo");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameIsNull() {
            addCriterion("certificateFileName is null");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameIsNotNull() {
            addCriterion("certificateFileName is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameEqualTo(String value) {
            addCriterion("certificateFileName =", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameNotEqualTo(String value) {
            addCriterion("certificateFileName <>", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameGreaterThan(String value) {
            addCriterion("certificateFileName >", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("certificateFileName >=", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameLessThan(String value) {
            addCriterion("certificateFileName <", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameLessThanOrEqualTo(String value) {
            addCriterion("certificateFileName <=", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameLike(String value) {
            addCriterion("certificateFileName like", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameNotLike(String value) {
            addCriterion("certificateFileName not like", value, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameIn(List<String> values) {
            addCriterion("certificateFileName in", values, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameNotIn(List<String> values) {
            addCriterion("certificateFileName not in", values, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameBetween(String value1, String value2) {
            addCriterion("certificateFileName between", value1, value2, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFileNameNotBetween(String value1, String value2) {
            addCriterion("certificateFileName not between", value1, value2, "certificateFileName");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIsNull() {
            addCriterion("certificateFilePath is null");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIsNotNull() {
            addCriterion("certificateFilePath is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathEqualTo(String value) {
            addCriterion("certificateFilePath =", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotEqualTo(String value) {
            addCriterion("certificateFilePath <>", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathGreaterThan(String value) {
            addCriterion("certificateFilePath >", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathGreaterThanOrEqualTo(String value) {
            addCriterion("certificateFilePath >=", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLessThan(String value) {
            addCriterion("certificateFilePath <", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLessThanOrEqualTo(String value) {
            addCriterion("certificateFilePath <=", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathLike(String value) {
            addCriterion("certificateFilePath like", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotLike(String value) {
            addCriterion("certificateFilePath not like", value, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathIn(List<String> values) {
            addCriterion("certificateFilePath in", values, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotIn(List<String> values) {
            addCriterion("certificateFilePath not in", values, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathBetween(String value1, String value2) {
            addCriterion("certificateFilePath between", value1, value2, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andCertificateFilePathNotBetween(String value1, String value2) {
            addCriterion("certificateFilePath not between", value1, value2, "certificateFilePath");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andResultIsNull() {
            addCriterion("result is null");
            return (Criteria) this;
        }

        public Criteria andResultIsNotNull() {
            addCriterion("result is not null");
            return (Criteria) this;
        }

        public Criteria andResultEqualTo(String value) {
            addCriterion("result =", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotEqualTo(String value) {
            addCriterion("result <>", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThan(String value) {
            addCriterion("result >", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultGreaterThanOrEqualTo(String value) {
            addCriterion("result >=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThan(String value) {
            addCriterion("result <", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLessThanOrEqualTo(String value) {
            addCriterion("result <=", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultLike(String value) {
            addCriterion("result like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotLike(String value) {
            addCriterion("result not like", value, "result");
            return (Criteria) this;
        }

        public Criteria andResultIn(List<String> values) {
            addCriterion("result in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotIn(List<String> values) {
            addCriterion("result not in", values, "result");
            return (Criteria) this;
        }

        public Criteria andResultBetween(String value1, String value2) {
            addCriterion("result between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andResultNotBetween(String value1, String value2) {
            addCriterion("result not between", value1, value2, "result");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNull() {
            addCriterion("acceptTime is null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIsNotNull() {
            addCriterion("acceptTime is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeEqualTo(Date value) {
            addCriterion("acceptTime =", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotEqualTo(Date value) {
            addCriterion("acceptTime <>", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThan(Date value) {
            addCriterion("acceptTime >", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("acceptTime >=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThan(Date value) {
            addCriterion("acceptTime <", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeLessThanOrEqualTo(Date value) {
            addCriterion("acceptTime <=", value, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeIn(List<Date> values) {
            addCriterion("acceptTime in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotIn(List<Date> values) {
            addCriterion("acceptTime not in", values, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeBetween(Date value1, Date value2) {
            addCriterion("acceptTime between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andAcceptTimeNotBetween(Date value1, Date value2) {
            addCriterion("acceptTime not between", value1, value2, "acceptTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNull() {
            addCriterion("executeTime is null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIsNotNull() {
            addCriterion("executeTime is not null");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeEqualTo(Date value) {
            addCriterion("executeTime =", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotEqualTo(Date value) {
            addCriterion("executeTime <>", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThan(Date value) {
            addCriterion("executeTime >", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("executeTime >=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThan(Date value) {
            addCriterion("executeTime <", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeLessThanOrEqualTo(Date value) {
            addCriterion("executeTime <=", value, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeIn(List<Date> values) {
            addCriterion("executeTime in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotIn(List<Date> values) {
            addCriterion("executeTime not in", values, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeBetween(Date value1, Date value2) {
            addCriterion("executeTime between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andExecuteTimeNotBetween(Date value1, Date value2) {
            addCriterion("executeTime not between", value1, value2, "executeTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNull() {
            addCriterion("finishedTime is null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIsNotNull() {
            addCriterion("finishedTime is not null");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeEqualTo(Date value) {
            addCriterion("finishedTime =", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotEqualTo(Date value) {
            addCriterion("finishedTime <>", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThan(Date value) {
            addCriterion("finishedTime >", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("finishedTime >=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThan(Date value) {
            addCriterion("finishedTime <", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeLessThanOrEqualTo(Date value) {
            addCriterion("finishedTime <=", value, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeIn(List<Date> values) {
            addCriterion("finishedTime in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotIn(List<Date> values) {
            addCriterion("finishedTime not in", values, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeBetween(Date value1, Date value2) {
            addCriterion("finishedTime between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andFinishedTimeNotBetween(Date value1, Date value2) {
            addCriterion("finishedTime not between", value1, value2, "finishedTime");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andReservedIsNull() {
            addCriterion("reserved is null");
            return (Criteria) this;
        }

        public Criteria andReservedIsNotNull() {
            addCriterion("reserved is not null");
            return (Criteria) this;
        }

        public Criteria andReservedEqualTo(String value) {
            addCriterion("reserved =", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotEqualTo(String value) {
            addCriterion("reserved <>", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThan(String value) {
            addCriterion("reserved >", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedGreaterThanOrEqualTo(String value) {
            addCriterion("reserved >=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThan(String value) {
            addCriterion("reserved <", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLessThanOrEqualTo(String value) {
            addCriterion("reserved <=", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedLike(String value) {
            addCriterion("reserved like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotLike(String value) {
            addCriterion("reserved not like", value, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedIn(List<String> values) {
            addCriterion("reserved in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotIn(List<String> values) {
            addCriterion("reserved not in", values, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedBetween(String value1, String value2) {
            addCriterion("reserved between", value1, value2, "reserved");
            return (Criteria) this;
        }

        public Criteria andReservedNotBetween(String value1, String value2) {
            addCriterion("reserved not between", value1, value2, "reserved");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}