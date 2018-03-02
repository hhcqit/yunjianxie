package com.clinicalmall.kuaixiu.persistent.domain;

import com.az.common.vo.mybatis.pagination.Page;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrgOptionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected Page page;

    public OrgOptionExample() {
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

        public Criteria andEquipIdIsNull() {
            addCriterion("equipId is null");
            return (Criteria) this;
        }

        public Criteria andEquipIdIsNotNull() {
            addCriterion("equipId is not null");
            return (Criteria) this;
        }

        public Criteria andEquipIdEqualTo(Integer value) {
            addCriterion("equipId =", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotEqualTo(Integer value) {
            addCriterion("equipId <>", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThan(Integer value) {
            addCriterion("equipId >", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipId >=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThan(Integer value) {
            addCriterion("equipId <", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdLessThanOrEqualTo(Integer value) {
            addCriterion("equipId <=", value, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdIn(List<Integer> values) {
            addCriterion("equipId in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotIn(List<Integer> values) {
            addCriterion("equipId not in", values, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdBetween(Integer value1, Integer value2) {
            addCriterion("equipId between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipIdNotBetween(Integer value1, Integer value2) {
            addCriterion("equipId not between", value1, value2, "equipId");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeIsNull() {
            addCriterion("equipQrcode is null");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeIsNotNull() {
            addCriterion("equipQrcode is not null");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeEqualTo(Integer value) {
            addCriterion("equipQrcode =", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeNotEqualTo(Integer value) {
            addCriterion("equipQrcode <>", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeGreaterThan(Integer value) {
            addCriterion("equipQrcode >", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeGreaterThanOrEqualTo(Integer value) {
            addCriterion("equipQrcode >=", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeLessThan(Integer value) {
            addCriterion("equipQrcode <", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeLessThanOrEqualTo(Integer value) {
            addCriterion("equipQrcode <=", value, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeIn(List<Integer> values) {
            addCriterion("equipQrcode in", values, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeNotIn(List<Integer> values) {
            addCriterion("equipQrcode not in", values, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeBetween(Integer value1, Integer value2) {
            addCriterion("equipQrcode between", value1, value2, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andEquipQrcodeNotBetween(Integer value1, Integer value2) {
            addCriterion("equipQrcode not between", value1, value2, "equipQrcode");
            return (Criteria) this;
        }

        public Criteria andRepairUserIsNull() {
            addCriterion("repairUser is null");
            return (Criteria) this;
        }

        public Criteria andRepairUserIsNotNull() {
            addCriterion("repairUser is not null");
            return (Criteria) this;
        }

        public Criteria andRepairUserEqualTo(Integer value) {
            addCriterion("repairUser =", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserNotEqualTo(Integer value) {
            addCriterion("repairUser <>", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserGreaterThan(Integer value) {
            addCriterion("repairUser >", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairUser >=", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserLessThan(Integer value) {
            addCriterion("repairUser <", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserLessThanOrEqualTo(Integer value) {
            addCriterion("repairUser <=", value, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserIn(List<Integer> values) {
            addCriterion("repairUser in", values, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserNotIn(List<Integer> values) {
            addCriterion("repairUser not in", values, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserBetween(Integer value1, Integer value2) {
            addCriterion("repairUser between", value1, value2, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairUserNotBetween(Integer value1, Integer value2) {
            addCriterion("repairUser not between", value1, value2, "repairUser");
            return (Criteria) this;
        }

        public Criteria andRepairDeptIsNull() {
            addCriterion("repairDept is null");
            return (Criteria) this;
        }

        public Criteria andRepairDeptIsNotNull() {
            addCriterion("repairDept is not null");
            return (Criteria) this;
        }

        public Criteria andRepairDeptEqualTo(Integer value) {
            addCriterion("repairDept =", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptNotEqualTo(Integer value) {
            addCriterion("repairDept <>", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptGreaterThan(Integer value) {
            addCriterion("repairDept >", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairDept >=", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptLessThan(Integer value) {
            addCriterion("repairDept <", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptLessThanOrEqualTo(Integer value) {
            addCriterion("repairDept <=", value, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptIn(List<Integer> values) {
            addCriterion("repairDept in", values, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptNotIn(List<Integer> values) {
            addCriterion("repairDept not in", values, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptBetween(Integer value1, Integer value2) {
            addCriterion("repairDept between", value1, value2, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairDeptNotBetween(Integer value1, Integer value2) {
            addCriterion("repairDept not between", value1, value2, "repairDept");
            return (Criteria) this;
        }

        public Criteria andRepairMobileIsNull() {
            addCriterion("repairMobile is null");
            return (Criteria) this;
        }

        public Criteria andRepairMobileIsNotNull() {
            addCriterion("repairMobile is not null");
            return (Criteria) this;
        }

        public Criteria andRepairMobileEqualTo(Integer value) {
            addCriterion("repairMobile =", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileNotEqualTo(Integer value) {
            addCriterion("repairMobile <>", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileGreaterThan(Integer value) {
            addCriterion("repairMobile >", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairMobile >=", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileLessThan(Integer value) {
            addCriterion("repairMobile <", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileLessThanOrEqualTo(Integer value) {
            addCriterion("repairMobile <=", value, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileIn(List<Integer> values) {
            addCriterion("repairMobile in", values, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileNotIn(List<Integer> values) {
            addCriterion("repairMobile not in", values, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileBetween(Integer value1, Integer value2) {
            addCriterion("repairMobile between", value1, value2, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairMobileNotBetween(Integer value1, Integer value2) {
            addCriterion("repairMobile not between", value1, value2, "repairMobile");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentIsNull() {
            addCriterion("repairUrgent is null");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentIsNotNull() {
            addCriterion("repairUrgent is not null");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentEqualTo(Integer value) {
            addCriterion("repairUrgent =", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentNotEqualTo(Integer value) {
            addCriterion("repairUrgent <>", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentGreaterThan(Integer value) {
            addCriterion("repairUrgent >", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairUrgent >=", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentLessThan(Integer value) {
            addCriterion("repairUrgent <", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentLessThanOrEqualTo(Integer value) {
            addCriterion("repairUrgent <=", value, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentIn(List<Integer> values) {
            addCriterion("repairUrgent in", values, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentNotIn(List<Integer> values) {
            addCriterion("repairUrgent not in", values, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentBetween(Integer value1, Integer value2) {
            addCriterion("repairUrgent between", value1, value2, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairUrgentNotBetween(Integer value1, Integer value2) {
            addCriterion("repairUrgent not between", value1, value2, "repairUrgent");
            return (Criteria) this;
        }

        public Criteria andRepairModifyIsNull() {
            addCriterion("repairModify is null");
            return (Criteria) this;
        }

        public Criteria andRepairModifyIsNotNull() {
            addCriterion("repairModify is not null");
            return (Criteria) this;
        }

        public Criteria andRepairModifyEqualTo(Integer value) {
            addCriterion("repairModify =", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyNotEqualTo(Integer value) {
            addCriterion("repairModify <>", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyGreaterThan(Integer value) {
            addCriterion("repairModify >", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairModify >=", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyLessThan(Integer value) {
            addCriterion("repairModify <", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyLessThanOrEqualTo(Integer value) {
            addCriterion("repairModify <=", value, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyIn(List<Integer> values) {
            addCriterion("repairModify in", values, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyNotIn(List<Integer> values) {
            addCriterion("repairModify not in", values, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyBetween(Integer value1, Integer value2) {
            addCriterion("repairModify between", value1, value2, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyNotBetween(Integer value1, Integer value2) {
            addCriterion("repairModify not between", value1, value2, "repairModify");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryIsNull() {
            addCriterion("repairModifyExpiry is null");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryIsNotNull() {
            addCriterion("repairModifyExpiry is not null");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryEqualTo(Integer value) {
            addCriterion("repairModifyExpiry =", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryNotEqualTo(Integer value) {
            addCriterion("repairModifyExpiry <>", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryGreaterThan(Integer value) {
            addCriterion("repairModifyExpiry >", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairModifyExpiry >=", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryLessThan(Integer value) {
            addCriterion("repairModifyExpiry <", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryLessThanOrEqualTo(Integer value) {
            addCriterion("repairModifyExpiry <=", value, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryIn(List<Integer> values) {
            addCriterion("repairModifyExpiry in", values, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryNotIn(List<Integer> values) {
            addCriterion("repairModifyExpiry not in", values, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryBetween(Integer value1, Integer value2) {
            addCriterion("repairModifyExpiry between", value1, value2, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairModifyExpiryNotBetween(Integer value1, Integer value2) {
            addCriterion("repairModifyExpiry not between", value1, value2, "repairModifyExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryIsNull() {
            addCriterion("repairedRemainExpiry is null");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryIsNotNull() {
            addCriterion("repairedRemainExpiry is not null");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryEqualTo(Integer value) {
            addCriterion("repairedRemainExpiry =", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryNotEqualTo(Integer value) {
            addCriterion("repairedRemainExpiry <>", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryGreaterThan(Integer value) {
            addCriterion("repairedRemainExpiry >", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairedRemainExpiry >=", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryLessThan(Integer value) {
            addCriterion("repairedRemainExpiry <", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryLessThanOrEqualTo(Integer value) {
            addCriterion("repairedRemainExpiry <=", value, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryIn(List<Integer> values) {
            addCriterion("repairedRemainExpiry in", values, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryNotIn(List<Integer> values) {
            addCriterion("repairedRemainExpiry not in", values, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryBetween(Integer value1, Integer value2) {
            addCriterion("repairedRemainExpiry between", value1, value2, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedRemainExpiryNotBetween(Integer value1, Integer value2) {
            addCriterion("repairedRemainExpiry not between", value1, value2, "repairedRemainExpiry");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmIsNull() {
            addCriterion("repairedConfirm is null");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmIsNotNull() {
            addCriterion("repairedConfirm is not null");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmEqualTo(Integer value) {
            addCriterion("repairedConfirm =", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmNotEqualTo(Integer value) {
            addCriterion("repairedConfirm <>", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmGreaterThan(Integer value) {
            addCriterion("repairedConfirm >", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmGreaterThanOrEqualTo(Integer value) {
            addCriterion("repairedConfirm >=", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmLessThan(Integer value) {
            addCriterion("repairedConfirm <", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmLessThanOrEqualTo(Integer value) {
            addCriterion("repairedConfirm <=", value, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmIn(List<Integer> values) {
            addCriterion("repairedConfirm in", values, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmNotIn(List<Integer> values) {
            addCriterion("repairedConfirm not in", values, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmBetween(Integer value1, Integer value2) {
            addCriterion("repairedConfirm between", value1, value2, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andRepairedConfirmNotBetween(Integer value1, Integer value2) {
            addCriterion("repairedConfirm not between", value1, value2, "repairedConfirm");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackIsNull() {
            addCriterion("acceptedSendBack is null");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackIsNotNull() {
            addCriterion("acceptedSendBack is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackEqualTo(Integer value) {
            addCriterion("acceptedSendBack =", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackNotEqualTo(Integer value) {
            addCriterion("acceptedSendBack <>", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackGreaterThan(Integer value) {
            addCriterion("acceptedSendBack >", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackGreaterThanOrEqualTo(Integer value) {
            addCriterion("acceptedSendBack >=", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackLessThan(Integer value) {
            addCriterion("acceptedSendBack <", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackLessThanOrEqualTo(Integer value) {
            addCriterion("acceptedSendBack <=", value, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackIn(List<Integer> values) {
            addCriterion("acceptedSendBack in", values, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackNotIn(List<Integer> values) {
            addCriterion("acceptedSendBack not in", values, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackBetween(Integer value1, Integer value2) {
            addCriterion("acceptedSendBack between", value1, value2, "acceptedSendBack");
            return (Criteria) this;
        }

        public Criteria andAcceptedSendBackNotBetween(Integer value1, Integer value2) {
            addCriterion("acceptedSendBack not between", value1, value2, "acceptedSendBack");
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