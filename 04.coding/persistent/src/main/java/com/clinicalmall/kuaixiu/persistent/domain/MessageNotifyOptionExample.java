package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MessageNotifyOptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public MessageNotifyOptionExample() {
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

        public Criteria andUserIdIsNull() {
            addCriterion("userId is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("userId is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("userId =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("userId <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("userId >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("userId >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("userId <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("userId <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("userId in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("userId not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("userId between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("userId not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyIsNull() {
            addCriterion("wechatNotify is null");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyIsNotNull() {
            addCriterion("wechatNotify is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyEqualTo(Integer value) {
            addCriterion("wechatNotify =", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyNotEqualTo(Integer value) {
            addCriterion("wechatNotify <>", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyGreaterThan(Integer value) {
            addCriterion("wechatNotify >", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("wechatNotify >=", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyLessThan(Integer value) {
            addCriterion("wechatNotify <", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("wechatNotify <=", value, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyIn(List<Integer> values) {
            addCriterion("wechatNotify in", values, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyNotIn(List<Integer> values) {
            addCriterion("wechatNotify not in", values, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyBetween(Integer value1, Integer value2) {
            addCriterion("wechatNotify between", value1, value2, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andWechatNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("wechatNotify not between", value1, value2, "wechatNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyIsNull() {
            addCriterion("taskNotify is null");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyIsNotNull() {
            addCriterion("taskNotify is not null");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyEqualTo(Integer value) {
            addCriterion("taskNotify =", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyNotEqualTo(Integer value) {
            addCriterion("taskNotify <>", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyGreaterThan(Integer value) {
            addCriterion("taskNotify >", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("taskNotify >=", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyLessThan(Integer value) {
            addCriterion("taskNotify <", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("taskNotify <=", value, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyIn(List<Integer> values) {
            addCriterion("taskNotify in", values, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyNotIn(List<Integer> values) {
            addCriterion("taskNotify not in", values, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyBetween(Integer value1, Integer value2) {
            addCriterion("taskNotify between", value1, value2, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andTaskNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("taskNotify not between", value1, value2, "taskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyIsNull() {
            addCriterion("repairedTaskNotify is null");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyIsNotNull() {
            addCriterion("repairedTaskNotify is not null");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyEqualTo(Integer value) {
            addCriterion("repairedTaskNotify =", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyNotEqualTo(Integer value) {
            addCriterion("repairedTaskNotify <>", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyGreaterThan(Integer value) {
            addCriterion("repairedTaskNotify >", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairedTaskNotify >=", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyLessThan(Integer value) {
            addCriterion("repairedTaskNotify <", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("repairedTaskNotify <=", value, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyIn(List<Integer> values) {
            addCriterion("repairedTaskNotify in", values, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyNotIn(List<Integer> values) {
            addCriterion("repairedTaskNotify not in", values, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyBetween(Integer value1, Integer value2) {
            addCriterion("repairedTaskNotify between", value1, value2, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andRepairedTaskNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("repairedTaskNotify not between", value1, value2, "repairedTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyIsNull() {
            addCriterion("patchTaskNotify is null");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyIsNotNull() {
            addCriterion("patchTaskNotify is not null");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyEqualTo(Integer value) {
            addCriterion("patchTaskNotify =", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyNotEqualTo(Integer value) {
            addCriterion("patchTaskNotify <>", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyGreaterThan(Integer value) {
            addCriterion("patchTaskNotify >", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("patchTaskNotify >=", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyLessThan(Integer value) {
            addCriterion("patchTaskNotify <", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("patchTaskNotify <=", value, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyIn(List<Integer> values) {
            addCriterion("patchTaskNotify in", values, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyNotIn(List<Integer> values) {
            addCriterion("patchTaskNotify not in", values, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyBetween(Integer value1, Integer value2) {
            addCriterion("patchTaskNotify between", value1, value2, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andPatchTaskNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("patchTaskNotify not between", value1, value2, "patchTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyIsNull() {
            addCriterion("newTaskNotify is null");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyIsNotNull() {
            addCriterion("newTaskNotify is not null");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyEqualTo(Integer value) {
            addCriterion("newTaskNotify =", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyNotEqualTo(Integer value) {
            addCriterion("newTaskNotify <>", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyGreaterThan(Integer value) {
            addCriterion("newTaskNotify >", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("newTaskNotify >=", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyLessThan(Integer value) {
            addCriterion("newTaskNotify <", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyLessThanOrEqualTo(Integer value) {
            addCriterion("newTaskNotify <=", value, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyIn(List<Integer> values) {
            addCriterion("newTaskNotify in", values, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyNotIn(List<Integer> values) {
            addCriterion("newTaskNotify not in", values, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyBetween(Integer value1, Integer value2) {
            addCriterion("newTaskNotify between", value1, value2, "newTaskNotify");
            return (Criteria) this;
        }

        public Criteria andNewTaskNotifyNotBetween(Integer value1, Integer value2) {
            addCriterion("newTaskNotify not between", value1, value2, "newTaskNotify");
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