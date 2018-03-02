package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public TaskExample() {
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

        public Criteria andModifyStatusIsNull() {
            addCriterion("modifyStatus is null");
            return (Criteria) this;
        }

        public Criteria andModifyStatusIsNotNull() {
            addCriterion("modifyStatus is not null");
            return (Criteria) this;
        }

        public Criteria andModifyStatusEqualTo(Integer value) {
            addCriterion("modifyStatus =", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusNotEqualTo(Integer value) {
            addCriterion("modifyStatus <>", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusGreaterThan(Integer value) {
            addCriterion("modifyStatus >", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("modifyStatus >=", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusLessThan(Integer value) {
            addCriterion("modifyStatus <", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusLessThanOrEqualTo(Integer value) {
            addCriterion("modifyStatus <=", value, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusIn(List<Integer> values) {
            addCriterion("modifyStatus in", values, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusNotIn(List<Integer> values) {
            addCriterion("modifyStatus not in", values, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusBetween(Integer value1, Integer value2) {
            addCriterion("modifyStatus between", value1, value2, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andModifyStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("modifyStatus not between", value1, value2, "modifyStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNull() {
            addCriterion("commentStatus is null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIsNotNull() {
            addCriterion("commentStatus is not null");
            return (Criteria) this;
        }

        public Criteria andCommentStatusEqualTo(Integer value) {
            addCriterion("commentStatus =", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotEqualTo(Integer value) {
            addCriterion("commentStatus <>", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThan(Integer value) {
            addCriterion("commentStatus >", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("commentStatus >=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThan(Integer value) {
            addCriterion("commentStatus <", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusLessThanOrEqualTo(Integer value) {
            addCriterion("commentStatus <=", value, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusIn(List<Integer> values) {
            addCriterion("commentStatus in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotIn(List<Integer> values) {
            addCriterion("commentStatus not in", values, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusBetween(Integer value1, Integer value2) {
            addCriterion("commentStatus between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andCommentStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("commentStatus not between", value1, value2, "commentStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusIsNull() {
            addCriterion("supplementStatus is null");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusIsNotNull() {
            addCriterion("supplementStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusEqualTo(Integer value) {
            addCriterion("supplementStatus =", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusNotEqualTo(Integer value) {
            addCriterion("supplementStatus <>", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusGreaterThan(Integer value) {
            addCriterion("supplementStatus >", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("supplementStatus >=", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusLessThan(Integer value) {
            addCriterion("supplementStatus <", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusLessThanOrEqualTo(Integer value) {
            addCriterion("supplementStatus <=", value, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusIn(List<Integer> values) {
            addCriterion("supplementStatus in", values, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusNotIn(List<Integer> values) {
            addCriterion("supplementStatus not in", values, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusBetween(Integer value1, Integer value2) {
            addCriterion("supplementStatus between", value1, value2, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSupplementStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("supplementStatus not between", value1, value2, "supplementStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusIsNull() {
            addCriterion("sendBackStatus is null");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusIsNotNull() {
            addCriterion("sendBackStatus is not null");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusEqualTo(Integer value) {
            addCriterion("sendBackStatus =", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusNotEqualTo(Integer value) {
            addCriterion("sendBackStatus <>", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusGreaterThan(Integer value) {
            addCriterion("sendBackStatus >", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("sendBackStatus >=", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusLessThan(Integer value) {
            addCriterion("sendBackStatus <", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusLessThanOrEqualTo(Integer value) {
            addCriterion("sendBackStatus <=", value, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusIn(List<Integer> values) {
            addCriterion("sendBackStatus in", values, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusNotIn(List<Integer> values) {
            addCriterion("sendBackStatus not in", values, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusBetween(Integer value1, Integer value2) {
            addCriterion("sendBackStatus between", value1, value2, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andSendBackStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("sendBackStatus not between", value1, value2, "sendBackStatus");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNull() {
            addCriterion("taskNo is null");
            return (Criteria) this;
        }

        public Criteria andTaskNoIsNotNull() {
            addCriterion("taskNo is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNoEqualTo(String value) {
            addCriterion("taskNo =", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotEqualTo(String value) {
            addCriterion("taskNo <>", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThan(String value) {
            addCriterion("taskNo >", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoGreaterThanOrEqualTo(String value) {
            addCriterion("taskNo >=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThan(String value) {
            addCriterion("taskNo <", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLessThanOrEqualTo(String value) {
            addCriterion("taskNo <=", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoLike(String value) {
            addCriterion("taskNo like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotLike(String value) {
            addCriterion("taskNo not like", value, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoIn(List<String> values) {
            addCriterion("taskNo in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotIn(List<String> values) {
            addCriterion("taskNo not in", values, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoBetween(String value1, String value2) {
            addCriterion("taskNo between", value1, value2, "taskNo");
            return (Criteria) this;
        }

        public Criteria andTaskNoNotBetween(String value1, String value2) {
            addCriterion("taskNo not between", value1, value2, "taskNo");
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

        public Criteria andRepairerUserIsNull() {
            addCriterion("repairerUser is null");
            return (Criteria) this;
        }

        public Criteria andRepairerUserIsNotNull() {
            addCriterion("repairerUser is not null");
            return (Criteria) this;
        }

        public Criteria andRepairerUserEqualTo(Long value) {
            addCriterion("repairerUser =", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserNotEqualTo(Long value) {
            addCriterion("repairerUser <>", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserGreaterThan(Long value) {
            addCriterion("repairerUser >", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserGreaterThanOrEqualTo(Long value) {
            addCriterion("repairerUser >=", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserLessThan(Long value) {
            addCriterion("repairerUser <", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserLessThanOrEqualTo(Long value) {
            addCriterion("repairerUser <=", value, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserIn(List<Long> values) {
            addCriterion("repairerUser in", values, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserNotIn(List<Long> values) {
            addCriterion("repairerUser not in", values, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserBetween(Long value1, Long value2) {
            addCriterion("repairerUser between", value1, value2, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andRepairerUserNotBetween(Long value1, Long value2) {
            addCriterion("repairerUser not between", value1, value2, "repairerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserIsNull() {
            addCriterion("examinerUser is null");
            return (Criteria) this;
        }

        public Criteria andExaminerUserIsNotNull() {
            addCriterion("examinerUser is not null");
            return (Criteria) this;
        }

        public Criteria andExaminerUserEqualTo(Long value) {
            addCriterion("examinerUser =", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserNotEqualTo(Long value) {
            addCriterion("examinerUser <>", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserGreaterThan(Long value) {
            addCriterion("examinerUser >", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserGreaterThanOrEqualTo(Long value) {
            addCriterion("examinerUser >=", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserLessThan(Long value) {
            addCriterion("examinerUser <", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserLessThanOrEqualTo(Long value) {
            addCriterion("examinerUser <=", value, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserIn(List<Long> values) {
            addCriterion("examinerUser in", values, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserNotIn(List<Long> values) {
            addCriterion("examinerUser not in", values, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserBetween(Long value1, Long value2) {
            addCriterion("examinerUser between", value1, value2, "examinerUser");
            return (Criteria) this;
        }

        public Criteria andExaminerUserNotBetween(Long value1, Long value2) {
            addCriterion("examinerUser not between", value1, value2, "examinerUser");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionIsNull() {
            addCriterion("repairDescription is null");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionIsNotNull() {
            addCriterion("repairDescription is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionEqualTo(String value) {
            addCriterion("repairDescription =", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionNotEqualTo(String value) {
            addCriterion("repairDescription <>", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionGreaterThan(String value) {
            addCriterion("repairDescription >", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("repairDescription >=", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionLessThan(String value) {
            addCriterion("repairDescription <", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionLessThanOrEqualTo(String value) {
            addCriterion("repairDescription <=", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionLike(String value) {
            addCriterion("repairDescription like", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionNotLike(String value) {
            addCriterion("repairDescription not like", value, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionIn(List<String> values) {
            addCriterion("repairDescription in", values, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionNotIn(List<String> values) {
            addCriterion("repairDescription not in", values, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionBetween(String value1, String value2) {
            addCriterion("repairDescription between", value1, value2, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andRepairDescriptionNotBetween(String value1, String value2) {
            addCriterion("repairDescription not between", value1, value2, "repairDescription");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonIsNull() {
            addCriterion("canceledReason is null");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonIsNotNull() {
            addCriterion("canceledReason is not null");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonEqualTo(String value) {
            addCriterion("canceledReason =", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonNotEqualTo(String value) {
            addCriterion("canceledReason <>", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonGreaterThan(String value) {
            addCriterion("canceledReason >", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonGreaterThanOrEqualTo(String value) {
            addCriterion("canceledReason >=", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonLessThan(String value) {
            addCriterion("canceledReason <", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonLessThanOrEqualTo(String value) {
            addCriterion("canceledReason <=", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonLike(String value) {
            addCriterion("canceledReason like", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonNotLike(String value) {
            addCriterion("canceledReason not like", value, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonIn(List<String> values) {
            addCriterion("canceledReason in", values, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonNotIn(List<String> values) {
            addCriterion("canceledReason not in", values, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonBetween(String value1, String value2) {
            addCriterion("canceledReason between", value1, value2, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andCanceledReasonNotBetween(String value1, String value2) {
            addCriterion("canceledReason not between", value1, value2, "canceledReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonIsNull() {
            addCriterion("sendBackReason is null");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonIsNotNull() {
            addCriterion("sendBackReason is not null");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonEqualTo(String value) {
            addCriterion("sendBackReason =", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonNotEqualTo(String value) {
            addCriterion("sendBackReason <>", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonGreaterThan(String value) {
            addCriterion("sendBackReason >", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonGreaterThanOrEqualTo(String value) {
            addCriterion("sendBackReason >=", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonLessThan(String value) {
            addCriterion("sendBackReason <", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonLessThanOrEqualTo(String value) {
            addCriterion("sendBackReason <=", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonLike(String value) {
            addCriterion("sendBackReason like", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonNotLike(String value) {
            addCriterion("sendBackReason not like", value, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonIn(List<String> values) {
            addCriterion("sendBackReason in", values, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonNotIn(List<String> values) {
            addCriterion("sendBackReason not in", values, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonBetween(String value1, String value2) {
            addCriterion("sendBackReason between", value1, value2, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andSendBackReasonNotBetween(String value1, String value2) {
            addCriterion("sendBackReason not between", value1, value2, "sendBackReason");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateIsNull() {
            addCriterion("examineCalibrate is null");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateIsNotNull() {
            addCriterion("examineCalibrate is not null");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateEqualTo(String value) {
            addCriterion("examineCalibrate =", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateNotEqualTo(String value) {
            addCriterion("examineCalibrate <>", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateGreaterThan(String value) {
            addCriterion("examineCalibrate >", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateGreaterThanOrEqualTo(String value) {
            addCriterion("examineCalibrate >=", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateLessThan(String value) {
            addCriterion("examineCalibrate <", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateLessThanOrEqualTo(String value) {
            addCriterion("examineCalibrate <=", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateLike(String value) {
            addCriterion("examineCalibrate like", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateNotLike(String value) {
            addCriterion("examineCalibrate not like", value, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateIn(List<String> values) {
            addCriterion("examineCalibrate in", values, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateNotIn(List<String> values) {
            addCriterion("examineCalibrate not in", values, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateBetween(String value1, String value2) {
            addCriterion("examineCalibrate between", value1, value2, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineCalibrateNotBetween(String value1, String value2) {
            addCriterion("examineCalibrate not between", value1, value2, "examineCalibrate");
            return (Criteria) this;
        }

        public Criteria andExamineQcIsNull() {
            addCriterion("examineQc is null");
            return (Criteria) this;
        }

        public Criteria andExamineQcIsNotNull() {
            addCriterion("examineQc is not null");
            return (Criteria) this;
        }

        public Criteria andExamineQcEqualTo(String value) {
            addCriterion("examineQc =", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcNotEqualTo(String value) {
            addCriterion("examineQc <>", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcGreaterThan(String value) {
            addCriterion("examineQc >", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcGreaterThanOrEqualTo(String value) {
            addCriterion("examineQc >=", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcLessThan(String value) {
            addCriterion("examineQc <", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcLessThanOrEqualTo(String value) {
            addCriterion("examineQc <=", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcLike(String value) {
            addCriterion("examineQc like", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcNotLike(String value) {
            addCriterion("examineQc not like", value, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcIn(List<String> values) {
            addCriterion("examineQc in", values, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcNotIn(List<String> values) {
            addCriterion("examineQc not in", values, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcBetween(String value1, String value2) {
            addCriterion("examineQc between", value1, value2, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineQcNotBetween(String value1, String value2) {
            addCriterion("examineQc not between", value1, value2, "examineQc");
            return (Criteria) this;
        }

        public Criteria andExamineSampleIsNull() {
            addCriterion("examineSample is null");
            return (Criteria) this;
        }

        public Criteria andExamineSampleIsNotNull() {
            addCriterion("examineSample is not null");
            return (Criteria) this;
        }

        public Criteria andExamineSampleEqualTo(String value) {
            addCriterion("examineSample =", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleNotEqualTo(String value) {
            addCriterion("examineSample <>", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleGreaterThan(String value) {
            addCriterion("examineSample >", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleGreaterThanOrEqualTo(String value) {
            addCriterion("examineSample >=", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleLessThan(String value) {
            addCriterion("examineSample <", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleLessThanOrEqualTo(String value) {
            addCriterion("examineSample <=", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleLike(String value) {
            addCriterion("examineSample like", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleNotLike(String value) {
            addCriterion("examineSample not like", value, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleIn(List<String> values) {
            addCriterion("examineSample in", values, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleNotIn(List<String> values) {
            addCriterion("examineSample not in", values, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleBetween(String value1, String value2) {
            addCriterion("examineSample between", value1, value2, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineSampleNotBetween(String value1, String value2) {
            addCriterion("examineSample not between", value1, value2, "examineSample");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionIsNull() {
            addCriterion("examineDescription is null");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionIsNotNull() {
            addCriterion("examineDescription is not null");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionEqualTo(String value) {
            addCriterion("examineDescription =", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionNotEqualTo(String value) {
            addCriterion("examineDescription <>", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionGreaterThan(String value) {
            addCriterion("examineDescription >", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("examineDescription >=", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionLessThan(String value) {
            addCriterion("examineDescription <", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionLessThanOrEqualTo(String value) {
            addCriterion("examineDescription <=", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionLike(String value) {
            addCriterion("examineDescription like", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionNotLike(String value) {
            addCriterion("examineDescription not like", value, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionIn(List<String> values) {
            addCriterion("examineDescription in", values, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionNotIn(List<String> values) {
            addCriterion("examineDescription not in", values, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionBetween(String value1, String value2) {
            addCriterion("examineDescription between", value1, value2, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andExamineDescriptionNotBetween(String value1, String value2) {
            addCriterion("examineDescription not between", value1, value2, "examineDescription");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationIsNull() {
            addCriterion("malfunctionDuration is null");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationIsNotNull() {
            addCriterion("malfunctionDuration is not null");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationEqualTo(Integer value) {
            addCriterion("malfunctionDuration =", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationNotEqualTo(Integer value) {
            addCriterion("malfunctionDuration <>", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationGreaterThan(Integer value) {
            addCriterion("malfunctionDuration >", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationGreaterThanOrEqualTo(Integer value) {
            addCriterion("malfunctionDuration >=", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationLessThan(Integer value) {
            addCriterion("malfunctionDuration <", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationLessThanOrEqualTo(Integer value) {
            addCriterion("malfunctionDuration <=", value, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationIn(List<Integer> values) {
            addCriterion("malfunctionDuration in", values, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationNotIn(List<Integer> values) {
            addCriterion("malfunctionDuration not in", values, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationBetween(Integer value1, Integer value2) {
            addCriterion("malfunctionDuration between", value1, value2, "malfunctionDuration");
            return (Criteria) this;
        }

        public Criteria andMalfunctionDurationNotBetween(Integer value1, Integer value2) {
            addCriterion("malfunctionDuration not between", value1, value2, "malfunctionDuration");
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

        public Criteria andRepairedTimeIsNull() {
            addCriterion("repairedTime is null");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeIsNotNull() {
            addCriterion("repairedTime is not null");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeEqualTo(Date value) {
            addCriterion("repairedTime =", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeNotEqualTo(Date value) {
            addCriterion("repairedTime <>", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeGreaterThan(Date value) {
            addCriterion("repairedTime >", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("repairedTime >=", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeLessThan(Date value) {
            addCriterion("repairedTime <", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeLessThanOrEqualTo(Date value) {
            addCriterion("repairedTime <=", value, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeIn(List<Date> values) {
            addCriterion("repairedTime in", values, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeNotIn(List<Date> values) {
            addCriterion("repairedTime not in", values, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeBetween(Date value1, Date value2) {
            addCriterion("repairedTime between", value1, value2, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andRepairedTimeNotBetween(Date value1, Date value2) {
            addCriterion("repairedTime not between", value1, value2, "repairedTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNull() {
            addCriterion("examineTime is null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIsNotNull() {
            addCriterion("examineTime is not null");
            return (Criteria) this;
        }

        public Criteria andExamineTimeEqualTo(Date value) {
            addCriterion("examineTime =", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotEqualTo(Date value) {
            addCriterion("examineTime <>", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThan(Date value) {
            addCriterion("examineTime >", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("examineTime >=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThan(Date value) {
            addCriterion("examineTime <", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeLessThanOrEqualTo(Date value) {
            addCriterion("examineTime <=", value, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeIn(List<Date> values) {
            addCriterion("examineTime in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotIn(List<Date> values) {
            addCriterion("examineTime not in", values, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeBetween(Date value1, Date value2) {
            addCriterion("examineTime between", value1, value2, "examineTime");
            return (Criteria) this;
        }

        public Criteria andExamineTimeNotBetween(Date value1, Date value2) {
            addCriterion("examineTime not between", value1, value2, "examineTime");
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