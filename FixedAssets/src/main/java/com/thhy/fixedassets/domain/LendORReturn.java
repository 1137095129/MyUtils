package com.thhy.fixedassets.domain;

import java.util.Date;

//设备借还表实体类
public class LendORReturn {

    //借还编号
    private Integer rlId;

    //用户编号
    private UserInfo userInfo;

    //设备编号
    private Equipment equipment;

    //借出原因/归还描述
    private String lendorreturnDescribe;

    //借出/归还日期
    private Date lendorreturnDate;

    //是否允许借出/归还（0否，1是,默认0）
    private Integer isLendorreturnPermissible;

    //拒绝借出/归还理由
    private String refuseLendorreturnReason;

    //申请借出/归还日期
    private Date lendorreturnApplyDate;

    //借出/归还审核日期
    private Date lendorreturnApprovalDate;

    //借出/归还审核人员
    private UserInfo admin;

    //归还关联的借出记录
    private LendORReturn lendorreturn;

    public Integer getRlId() {
        return rlId;
    }

    public void setRlId(Integer rlId) {
        this.rlId = rlId;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public String getLendorreturnDescribe() {
        return lendorreturnDescribe;
    }

    public void setLendorreturnDescribe(String lendorreturnDescribe) {
        this.lendorreturnDescribe = lendorreturnDescribe;
    }

    public Date getLendorreturnDate() {
        return lendorreturnDate;
    }

    public void setLendorreturnDate(Date lendorreturnDate) {
        this.lendorreturnDate = lendorreturnDate;
    }

    public Integer getIsLendorreturnPermissible() {
        return isLendorreturnPermissible;
    }

    public void setIsLendorreturnPermissible(Integer isLendorreturnPermissible) {
        this.isLendorreturnPermissible = isLendorreturnPermissible;
    }

    public String getRefuseLendorreturnReason() {
        return refuseLendorreturnReason;
    }

    public void setRefuseLendorreturnReason(String refuseLendorreturnReason) {
        this.refuseLendorreturnReason = refuseLendorreturnReason;
    }

    public Date getLendorreturnApplyDate() {
        return lendorreturnApplyDate;
    }

    public void setLendorreturnApplyDate(Date lendorreturnApplyDate) {
        this.lendorreturnApplyDate = lendorreturnApplyDate;
    }

    public Date getLendorreturnApprovalDate() {
        return lendorreturnApprovalDate;
    }

    public void setLendorreturnApprovalDate(Date lendorreturnApprovalDate) {
        this.lendorreturnApprovalDate = lendorreturnApprovalDate;
    }

    public UserInfo getAdmin() {
        return admin;
    }

    public void setAdmin(UserInfo admin) {
        this.admin = admin;
    }

    public LendORReturn getLendorreturn() {
        return lendorreturn;
    }

    public void setLendorreturn(LendORReturn lendorreturn) {
        this.lendorreturn = lendorreturn;
    }
}
