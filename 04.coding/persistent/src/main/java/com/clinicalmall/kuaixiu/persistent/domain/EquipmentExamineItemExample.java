package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EquipmentExamineItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public EquipmentExamineItemExample() {
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

        public Criteria andExamineIdIsNull() {
            addCriterion("examineId is null");
            return (Criteria) this;
        }

        public Criteria andExamineIdIsNotNull() {
            addCriterion("examineId is not null");
            return (Criteria) this;
        }

        public Criteria andExamineIdEqualTo(Long value) {
            addCriterion("examineId =", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotEqualTo(Long value) {
            addCriterion("examineId <>", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdGreaterThan(Long value) {
            addCriterion("examineId >", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdGreaterThanOrEqualTo(Long value) {
            addCriterion("examineId >=", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdLessThan(Long value) {
            addCriterion("examineId <", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdLessThanOrEqualTo(Long value) {
            addCriterion("examineId <=", value, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdIn(List<Long> values) {
            addCriterion("examineId in", values, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotIn(List<Long> values) {
            addCriterion("examineId not in", values, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdBetween(Long value1, Long value2) {
            addCriterion("examineId between", value1, value2, "examineId");
            return (Criteria) this;
        }

        public Criteria andExamineIdNotBetween(Long value1, Long value2) {
            addCriterion("examineId not between", value1, value2, "examineId");
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

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andStandardValueIsNull() {
            addCriterion("standardValue is null");
            return (Criteria) this;
        }

        public Criteria andStandardValueIsNotNull() {
            addCriterion("standardValue is not null");
            return (Criteria) this;
        }

        public Criteria andStandardValueEqualTo(String value) {
            addCriterion("standardValue =", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotEqualTo(String value) {
            addCriterion("standardValue <>", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueGreaterThan(String value) {
            addCriterion("standardValue >", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueGreaterThanOrEqualTo(String value) {
            addCriterion("standardValue >=", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLessThan(String value) {
            addCriterion("standardValue <", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLessThanOrEqualTo(String value) {
            addCriterion("standardValue <=", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueLike(String value) {
            addCriterion("standardValue like", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotLike(String value) {
            addCriterion("standardValue not like", value, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueIn(List<String> values) {
            addCriterion("standardValue in", values, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotIn(List<String> values) {
            addCriterion("standardValue not in", values, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueBetween(String value1, String value2) {
            addCriterion("standardValue between", value1, value2, "standardValue");
            return (Criteria) this;
        }

        public Criteria andStandardValueNotBetween(String value1, String value2) {
            addCriterion("standardValue not between", value1, value2, "standardValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueIsNull() {
            addCriterion("measureValue is null");
            return (Criteria) this;
        }

        public Criteria andMeasureValueIsNotNull() {
            addCriterion("measureValue is not null");
            return (Criteria) this;
        }

        public Criteria andMeasureValueEqualTo(String value) {
            addCriterion("measureValue =", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueNotEqualTo(String value) {
            addCriterion("measureValue <>", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueGreaterThan(String value) {
            addCriterion("measureValue >", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueGreaterThanOrEqualTo(String value) {
            addCriterion("measureValue >=", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueLessThan(String value) {
            addCriterion("measureValue <", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueLessThanOrEqualTo(String value) {
            addCriterion("measureValue <=", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueLike(String value) {
            addCriterion("measureValue like", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueNotLike(String value) {
            addCriterion("measureValue not like", value, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueIn(List<String> values) {
            addCriterion("measureValue in", values, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueNotIn(List<String> values) {
            addCriterion("measureValue not in", values, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueBetween(String value1, String value2) {
            addCriterion("measureValue between", value1, value2, "measureValue");
            return (Criteria) this;
        }

        public Criteria andMeasureValueNotBetween(String value1, String value2) {
            addCriterion("measureValue not between", value1, value2, "measureValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueIsNull() {
            addCriterion("deviationValue is null");
            return (Criteria) this;
        }

        public Criteria andDeviationValueIsNotNull() {
            addCriterion("deviationValue is not null");
            return (Criteria) this;
        }

        public Criteria andDeviationValueEqualTo(String value) {
            addCriterion("deviationValue =", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueNotEqualTo(String value) {
            addCriterion("deviationValue <>", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueGreaterThan(String value) {
            addCriterion("deviationValue >", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueGreaterThanOrEqualTo(String value) {
            addCriterion("deviationValue >=", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueLessThan(String value) {
            addCriterion("deviationValue <", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueLessThanOrEqualTo(String value) {
            addCriterion("deviationValue <=", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueLike(String value) {
            addCriterion("deviationValue like", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueNotLike(String value) {
            addCriterion("deviationValue not like", value, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueIn(List<String> values) {
            addCriterion("deviationValue in", values, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueNotIn(List<String> values) {
            addCriterion("deviationValue not in", values, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueBetween(String value1, String value2) {
            addCriterion("deviationValue between", value1, value2, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andDeviationValueNotBetween(String value1, String value2) {
            addCriterion("deviationValue not between", value1, value2, "deviationValue");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNull() {
            addCriterion("isQualified is null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIsNotNull() {
            addCriterion("isQualified is not null");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedEqualTo(Integer value) {
            addCriterion("isQualified =", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotEqualTo(Integer value) {
            addCriterion("isQualified <>", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThan(Integer value) {
            addCriterion("isQualified >", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedGreaterThanOrEqualTo(Integer value) {
            addCriterion("isQualified >=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThan(Integer value) {
            addCriterion("isQualified <", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedLessThanOrEqualTo(Integer value) {
            addCriterion("isQualified <=", value, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedIn(List<Integer> values) {
            addCriterion("isQualified in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotIn(List<Integer> values) {
            addCriterion("isQualified not in", values, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedBetween(Integer value1, Integer value2) {
            addCriterion("isQualified between", value1, value2, "isQualified");
            return (Criteria) this;
        }

        public Criteria andIsQualifiedNotBetween(Integer value1, Integer value2) {
            addCriterion("isQualified not between", value1, value2, "isQualified");
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