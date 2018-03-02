package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class EquipmentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EquipmentExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andCheckPermissionIsNull() {
            addCriterion("checkPermission is null");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionIsNotNull() {
            addCriterion("checkPermission is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionEqualTo(Integer value) {
            addCriterion("checkPermission =", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionNotEqualTo(Integer value) {
            addCriterion("checkPermission <>", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionGreaterThan(Integer value) {
            addCriterion("checkPermission >", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkPermission >=", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionLessThan(Integer value) {
            addCriterion("checkPermission <", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionLessThanOrEqualTo(Integer value) {
            addCriterion("checkPermission <=", value, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionIn(List<Integer> values) {
            addCriterion("checkPermission in", values, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionNotIn(List<Integer> values) {
            addCriterion("checkPermission not in", values, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionBetween(Integer value1, Integer value2) {
            addCriterion("checkPermission between", value1, value2, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPermissionNotBetween(Integer value1, Integer value2) {
            addCriterion("checkPermission not between", value1, value2, "checkPermission");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNull() {
            addCriterion("checkPeriod is null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIsNotNull() {
            addCriterion("checkPeriod is not null");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodEqualTo(Integer value) {
            addCriterion("checkPeriod =", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotEqualTo(Integer value) {
            addCriterion("checkPeriod <>", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThan(Integer value) {
            addCriterion("checkPeriod >", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodGreaterThanOrEqualTo(Integer value) {
            addCriterion("checkPeriod >=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThan(Integer value) {
            addCriterion("checkPeriod <", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodLessThanOrEqualTo(Integer value) {
            addCriterion("checkPeriod <=", value, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodIn(List<Integer> values) {
            addCriterion("checkPeriod in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotIn(List<Integer> values) {
            addCriterion("checkPeriod not in", values, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodBetween(Integer value1, Integer value2) {
            addCriterion("checkPeriod between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andCheckPeriodNotBetween(Integer value1, Integer value2) {
            addCriterion("checkPeriod not between", value1, value2, "checkPeriod");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(String value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(String value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(String value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(String value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(String value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(String value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLike(String value) {
            addCriterion("area like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotLike(String value) {
            addCriterion("area not like", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<String> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<String> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(String value1, String value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(String value1, String value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAddressIsNull() {
            addCriterion("address is null");
            return (Criteria) this;
        }

        public Criteria andAddressIsNotNull() {
            addCriterion("address is not null");
            return (Criteria) this;
        }

        public Criteria andAddressEqualTo(String value) {
            addCriterion("address =", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotEqualTo(String value) {
            addCriterion("address <>", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThan(String value) {
            addCriterion("address >", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressGreaterThanOrEqualTo(String value) {
            addCriterion("address >=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThan(String value) {
            addCriterion("address <", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLessThanOrEqualTo(String value) {
            addCriterion("address <=", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressLike(String value) {
            addCriterion("address like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotLike(String value) {
            addCriterion("address not like", value, "address");
            return (Criteria) this;
        }

        public Criteria andAddressIn(List<String> values) {
            addCriterion("address in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotIn(List<String> values) {
            addCriterion("address not in", values, "address");
            return (Criteria) this;
        }

        public Criteria andAddressBetween(String value1, String value2) {
            addCriterion("address between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andAddressNotBetween(String value1, String value2) {
            addCriterion("address not between", value1, value2, "address");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNull() {
            addCriterion("place is null");
            return (Criteria) this;
        }

        public Criteria andPlaceIsNotNull() {
            addCriterion("place is not null");
            return (Criteria) this;
        }

        public Criteria andPlaceEqualTo(String value) {
            addCriterion("place =", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotEqualTo(String value) {
            addCriterion("place <>", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThan(String value) {
            addCriterion("place >", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("place >=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThan(String value) {
            addCriterion("place <", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLessThanOrEqualTo(String value) {
            addCriterion("place <=", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceLike(String value) {
            addCriterion("place like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotLike(String value) {
            addCriterion("place not like", value, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceIn(List<String> values) {
            addCriterion("place in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotIn(List<String> values) {
            addCriterion("place not in", values, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceBetween(String value1, String value2) {
            addCriterion("place between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andPlaceNotBetween(String value1, String value2) {
            addCriterion("place not between", value1, value2, "place");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("model is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("model is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("model =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("model <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("model >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("model >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("model <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("model <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("model like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("model not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("model in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("model not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("model between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("model not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNull() {
            addCriterion("category is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIsNotNull() {
            addCriterion("category is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryEqualTo(String value) {
            addCriterion("category =", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotEqualTo(String value) {
            addCriterion("category <>", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThan(String value) {
            addCriterion("category >", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryGreaterThanOrEqualTo(String value) {
            addCriterion("category >=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThan(String value) {
            addCriterion("category <", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLessThanOrEqualTo(String value) {
            addCriterion("category <=", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryLike(String value) {
            addCriterion("category like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotLike(String value) {
            addCriterion("category not like", value, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryIn(List<String> values) {
            addCriterion("category in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotIn(List<String> values) {
            addCriterion("category not in", values, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryBetween(String value1, String value2) {
            addCriterion("category between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andCategoryNotBetween(String value1, String value2) {
            addCriterion("category not between", value1, value2, "category");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNull() {
            addCriterion("supplier is null");
            return (Criteria) this;
        }

        public Criteria andSupplierIsNotNull() {
            addCriterion("supplier is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierEqualTo(String value) {
            addCriterion("supplier =", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotEqualTo(String value) {
            addCriterion("supplier <>", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThan(String value) {
            addCriterion("supplier >", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierGreaterThanOrEqualTo(String value) {
            addCriterion("supplier >=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThan(String value) {
            addCriterion("supplier <", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLessThanOrEqualTo(String value) {
            addCriterion("supplier <=", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierLike(String value) {
            addCriterion("supplier like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotLike(String value) {
            addCriterion("supplier not like", value, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierIn(List<String> values) {
            addCriterion("supplier in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotIn(List<String> values) {
            addCriterion("supplier not in", values, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierBetween(String value1, String value2) {
            addCriterion("supplier between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierNotBetween(String value1, String value2) {
            addCriterion("supplier not between", value1, value2, "supplier");
            return (Criteria) this;
        }

        public Criteria andSupplierContactIsNull() {
            addCriterion("supplierContact is null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactIsNotNull() {
            addCriterion("supplierContact is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierContactEqualTo(String value) {
            addCriterion("supplierContact =", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactNotEqualTo(String value) {
            addCriterion("supplierContact <>", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactGreaterThan(String value) {
            addCriterion("supplierContact >", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactGreaterThanOrEqualTo(String value) {
            addCriterion("supplierContact >=", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactLessThan(String value) {
            addCriterion("supplierContact <", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactLessThanOrEqualTo(String value) {
            addCriterion("supplierContact <=", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactLike(String value) {
            addCriterion("supplierContact like", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactNotLike(String value) {
            addCriterion("supplierContact not like", value, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactIn(List<String> values) {
            addCriterion("supplierContact in", values, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactNotIn(List<String> values) {
            addCriterion("supplierContact not in", values, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactBetween(String value1, String value2) {
            addCriterion("supplierContact between", value1, value2, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierContactNotBetween(String value1, String value2) {
            addCriterion("supplierContact not between", value1, value2, "supplierContact");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneIsNull() {
            addCriterion("supplierTelephone is null");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneIsNotNull() {
            addCriterion("supplierTelephone is not null");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneEqualTo(String value) {
            addCriterion("supplierTelephone =", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneNotEqualTo(String value) {
            addCriterion("supplierTelephone <>", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneGreaterThan(String value) {
            addCriterion("supplierTelephone >", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("supplierTelephone >=", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneLessThan(String value) {
            addCriterion("supplierTelephone <", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneLessThanOrEqualTo(String value) {
            addCriterion("supplierTelephone <=", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneLike(String value) {
            addCriterion("supplierTelephone like", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneNotLike(String value) {
            addCriterion("supplierTelephone not like", value, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneIn(List<String> values) {
            addCriterion("supplierTelephone in", values, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneNotIn(List<String> values) {
            addCriterion("supplierTelephone not in", values, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneBetween(String value1, String value2) {
            addCriterion("supplierTelephone between", value1, value2, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andSupplierTelephoneNotBetween(String value1, String value2) {
            addCriterion("supplierTelephone not between", value1, value2, "supplierTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNull() {
            addCriterion("manufacturer is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerIsNotNull() {
            addCriterion("manufacturer is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerEqualTo(String value) {
            addCriterion("manufacturer =", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotEqualTo(String value) {
            addCriterion("manufacturer <>", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThan(String value) {
            addCriterion("manufacturer >", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturer >=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThan(String value) {
            addCriterion("manufacturer <", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLessThanOrEqualTo(String value) {
            addCriterion("manufacturer <=", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerLike(String value) {
            addCriterion("manufacturer like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotLike(String value) {
            addCriterion("manufacturer not like", value, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerIn(List<String> values) {
            addCriterion("manufacturer in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotIn(List<String> values) {
            addCriterion("manufacturer not in", values, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerBetween(String value1, String value2) {
            addCriterion("manufacturer between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerNotBetween(String value1, String value2) {
            addCriterion("manufacturer not between", value1, value2, "manufacturer");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactIsNull() {
            addCriterion("manufacturerContact is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactIsNotNull() {
            addCriterion("manufacturerContact is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactEqualTo(String value) {
            addCriterion("manufacturerContact =", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactNotEqualTo(String value) {
            addCriterion("manufacturerContact <>", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactGreaterThan(String value) {
            addCriterion("manufacturerContact >", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturerContact >=", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactLessThan(String value) {
            addCriterion("manufacturerContact <", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactLessThanOrEqualTo(String value) {
            addCriterion("manufacturerContact <=", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactLike(String value) {
            addCriterion("manufacturerContact like", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactNotLike(String value) {
            addCriterion("manufacturerContact not like", value, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactIn(List<String> values) {
            addCriterion("manufacturerContact in", values, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactNotIn(List<String> values) {
            addCriterion("manufacturerContact not in", values, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactBetween(String value1, String value2) {
            addCriterion("manufacturerContact between", value1, value2, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerContactNotBetween(String value1, String value2) {
            addCriterion("manufacturerContact not between", value1, value2, "manufacturerContact");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneIsNull() {
            addCriterion("manufacturerTelephone is null");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneIsNotNull() {
            addCriterion("manufacturerTelephone is not null");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneEqualTo(String value) {
            addCriterion("manufacturerTelephone =", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneNotEqualTo(String value) {
            addCriterion("manufacturerTelephone <>", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneGreaterThan(String value) {
            addCriterion("manufacturerTelephone >", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneGreaterThanOrEqualTo(String value) {
            addCriterion("manufacturerTelephone >=", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneLessThan(String value) {
            addCriterion("manufacturerTelephone <", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneLessThanOrEqualTo(String value) {
            addCriterion("manufacturerTelephone <=", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneLike(String value) {
            addCriterion("manufacturerTelephone like", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneNotLike(String value) {
            addCriterion("manufacturerTelephone not like", value, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneIn(List<String> values) {
            addCriterion("manufacturerTelephone in", values, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneNotIn(List<String> values) {
            addCriterion("manufacturerTelephone not in", values, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneBetween(String value1, String value2) {
            addCriterion("manufacturerTelephone between", value1, value2, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andManufacturerTelephoneNotBetween(String value1, String value2) {
            addCriterion("manufacturerTelephone not between", value1, value2, "manufacturerTelephone");
            return (Criteria) this;
        }

        public Criteria andMadeAreaIsNull() {
            addCriterion("madeArea is null");
            return (Criteria) this;
        }

        public Criteria andMadeAreaIsNotNull() {
            addCriterion("madeArea is not null");
            return (Criteria) this;
        }

        public Criteria andMadeAreaEqualTo(String value) {
            addCriterion("madeArea =", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaNotEqualTo(String value) {
            addCriterion("madeArea <>", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaGreaterThan(String value) {
            addCriterion("madeArea >", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaGreaterThanOrEqualTo(String value) {
            addCriterion("madeArea >=", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaLessThan(String value) {
            addCriterion("madeArea <", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaLessThanOrEqualTo(String value) {
            addCriterion("madeArea <=", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaLike(String value) {
            addCriterion("madeArea like", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaNotLike(String value) {
            addCriterion("madeArea not like", value, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaIn(List<String> values) {
            addCriterion("madeArea in", values, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaNotIn(List<String> values) {
            addCriterion("madeArea not in", values, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaBetween(String value1, String value2) {
            addCriterion("madeArea between", value1, value2, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeAreaNotBetween(String value1, String value2) {
            addCriterion("madeArea not between", value1, value2, "madeArea");
            return (Criteria) this;
        }

        public Criteria andMadeTimeIsNull() {
            addCriterion("madeTime is null");
            return (Criteria) this;
        }

        public Criteria andMadeTimeIsNotNull() {
            addCriterion("madeTime is not null");
            return (Criteria) this;
        }

        public Criteria andMadeTimeEqualTo(Date value) {
            addCriterionForJDBCDate("madeTime =", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("madeTime <>", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("madeTime >", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("madeTime >=", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeLessThan(Date value) {
            addCriterionForJDBCDate("madeTime <", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("madeTime <=", value, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeIn(List<Date> values) {
            addCriterionForJDBCDate("madeTime in", values, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("madeTime not in", values, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("madeTime between", value1, value2, "madeTime");
            return (Criteria) this;
        }

        public Criteria andMadeTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("madeTime not between", value1, value2, "madeTime");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNull() {
            addCriterion("batchNo is null");
            return (Criteria) this;
        }

        public Criteria andBatchNoIsNotNull() {
            addCriterion("batchNo is not null");
            return (Criteria) this;
        }

        public Criteria andBatchNoEqualTo(String value) {
            addCriterion("batchNo =", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotEqualTo(String value) {
            addCriterion("batchNo <>", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThan(String value) {
            addCriterion("batchNo >", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoGreaterThanOrEqualTo(String value) {
            addCriterion("batchNo >=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThan(String value) {
            addCriterion("batchNo <", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLessThanOrEqualTo(String value) {
            addCriterion("batchNo <=", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoLike(String value) {
            addCriterion("batchNo like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotLike(String value) {
            addCriterion("batchNo not like", value, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoIn(List<String> values) {
            addCriterion("batchNo in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotIn(List<String> values) {
            addCriterion("batchNo not in", values, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoBetween(String value1, String value2) {
            addCriterion("batchNo between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andBatchNoNotBetween(String value1, String value2) {
            addCriterion("batchNo not between", value1, value2, "batchNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoIsNull() {
            addCriterion("madeNo is null");
            return (Criteria) this;
        }

        public Criteria andMadeNoIsNotNull() {
            addCriterion("madeNo is not null");
            return (Criteria) this;
        }

        public Criteria andMadeNoEqualTo(String value) {
            addCriterion("madeNo =", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoNotEqualTo(String value) {
            addCriterion("madeNo <>", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoGreaterThan(String value) {
            addCriterion("madeNo >", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoGreaterThanOrEqualTo(String value) {
            addCriterion("madeNo >=", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoLessThan(String value) {
            addCriterion("madeNo <", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoLessThanOrEqualTo(String value) {
            addCriterion("madeNo <=", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoLike(String value) {
            addCriterion("madeNo like", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoNotLike(String value) {
            addCriterion("madeNo not like", value, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoIn(List<String> values) {
            addCriterion("madeNo in", values, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoNotIn(List<String> values) {
            addCriterion("madeNo not in", values, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoBetween(String value1, String value2) {
            addCriterion("madeNo between", value1, value2, "madeNo");
            return (Criteria) this;
        }

        public Criteria andMadeNoNotBetween(String value1, String value2) {
            addCriterion("madeNo not between", value1, value2, "madeNo");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNull() {
            addCriterion("barcode is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeIsNotNull() {
            addCriterion("barcode is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeEqualTo(String value) {
            addCriterion("barcode =", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotEqualTo(String value) {
            addCriterion("barcode <>", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThan(String value) {
            addCriterion("barcode >", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeGreaterThanOrEqualTo(String value) {
            addCriterion("barcode >=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThan(String value) {
            addCriterion("barcode <", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLessThanOrEqualTo(String value) {
            addCriterion("barcode <=", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeLike(String value) {
            addCriterion("barcode like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotLike(String value) {
            addCriterion("barcode not like", value, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeIn(List<String> values) {
            addCriterion("barcode in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotIn(List<String> values) {
            addCriterion("barcode not in", values, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeBetween(String value1, String value2) {
            addCriterion("barcode between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andBarcodeNotBetween(String value1, String value2) {
            addCriterion("barcode not between", value1, value2, "barcode");
            return (Criteria) this;
        }

        public Criteria andUsedDeptIsNull() {
            addCriterion("usedDept is null");
            return (Criteria) this;
        }

        public Criteria andUsedDeptIsNotNull() {
            addCriterion("usedDept is not null");
            return (Criteria) this;
        }

        public Criteria andUsedDeptEqualTo(String value) {
            addCriterion("usedDept =", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptNotEqualTo(String value) {
            addCriterion("usedDept <>", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptGreaterThan(String value) {
            addCriterion("usedDept >", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptGreaterThanOrEqualTo(String value) {
            addCriterion("usedDept >=", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptLessThan(String value) {
            addCriterion("usedDept <", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptLessThanOrEqualTo(String value) {
            addCriterion("usedDept <=", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptLike(String value) {
            addCriterion("usedDept like", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptNotLike(String value) {
            addCriterion("usedDept not like", value, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptIn(List<String> values) {
            addCriterion("usedDept in", values, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptNotIn(List<String> values) {
            addCriterion("usedDept not in", values, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptBetween(String value1, String value2) {
            addCriterion("usedDept between", value1, value2, "usedDept");
            return (Criteria) this;
        }

        public Criteria andUsedDeptNotBetween(String value1, String value2) {
            addCriterion("usedDept not between", value1, value2, "usedDept");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNull() {
            addCriterion("owner is null");
            return (Criteria) this;
        }

        public Criteria andOwnerIsNotNull() {
            addCriterion("owner is not null");
            return (Criteria) this;
        }

        public Criteria andOwnerEqualTo(String value) {
            addCriterion("owner =", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotEqualTo(String value) {
            addCriterion("owner <>", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThan(String value) {
            addCriterion("owner >", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerGreaterThanOrEqualTo(String value) {
            addCriterion("owner >=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThan(String value) {
            addCriterion("owner <", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLessThanOrEqualTo(String value) {
            addCriterion("owner <=", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerLike(String value) {
            addCriterion("owner like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotLike(String value) {
            addCriterion("owner not like", value, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerIn(List<String> values) {
            addCriterion("owner in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotIn(List<String> values) {
            addCriterion("owner not in", values, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerBetween(String value1, String value2) {
            addCriterion("owner between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andOwnerNotBetween(String value1, String value2) {
            addCriterion("owner not between", value1, value2, "owner");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgIsNull() {
            addCriterion("barcodeImg is null");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgIsNotNull() {
            addCriterion("barcodeImg is not null");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgEqualTo(String value) {
            addCriterion("barcodeImg =", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgNotEqualTo(String value) {
            addCriterion("barcodeImg <>", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgGreaterThan(String value) {
            addCriterion("barcodeImg >", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgGreaterThanOrEqualTo(String value) {
            addCriterion("barcodeImg >=", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgLessThan(String value) {
            addCriterion("barcodeImg <", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgLessThanOrEqualTo(String value) {
            addCriterion("barcodeImg <=", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgLike(String value) {
            addCriterion("barcodeImg like", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgNotLike(String value) {
            addCriterion("barcodeImg not like", value, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgIn(List<String> values) {
            addCriterion("barcodeImg in", values, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgNotIn(List<String> values) {
            addCriterion("barcodeImg not in", values, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgBetween(String value1, String value2) {
            addCriterion("barcodeImg between", value1, value2, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andBarcodeImgNotBetween(String value1, String value2) {
            addCriterion("barcodeImg not between", value1, value2, "barcodeImg");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeIsNull() {
            addCriterion("purchasedTime is null");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeIsNotNull() {
            addCriterion("purchasedTime is not null");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeEqualTo(Date value) {
            addCriterionForJDBCDate("purchasedTime =", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("purchasedTime <>", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("purchasedTime >", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("purchasedTime >=", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeLessThan(Date value) {
            addCriterionForJDBCDate("purchasedTime <", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("purchasedTime <=", value, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeIn(List<Date> values) {
            addCriterionForJDBCDate("purchasedTime in", values, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("purchasedTime not in", values, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("purchasedTime between", value1, value2, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andPurchasedTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("purchasedTime not between", value1, value2, "purchasedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIsNull() {
            addCriterion("usedTime is null");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIsNotNull() {
            addCriterion("usedTime is not null");
            return (Criteria) this;
        }

        public Criteria andUsedTimeEqualTo(Date value) {
            addCriterionForJDBCDate("usedTime =", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("usedTime <>", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("usedTime >", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("usedTime >=", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeLessThan(Date value) {
            addCriterionForJDBCDate("usedTime <", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("usedTime <=", value, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeIn(List<Date> values) {
            addCriterionForJDBCDate("usedTime in", values, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("usedTime not in", values, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("usedTime between", value1, value2, "usedTime");
            return (Criteria) this;
        }

        public Criteria andUsedTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("usedTime not between", value1, value2, "usedTime");
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