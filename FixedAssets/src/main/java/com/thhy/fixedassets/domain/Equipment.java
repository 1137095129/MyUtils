package com.thhy.fixedassets.domain;

import java.util.Date;

//设备实体类
public class Equipment {

    //设备编号
    private Integer equipmentId;

    //设备S/N号
    private String snNo;

    //设备种类
    private Kind kind;

    //设备型号
    private Model model;

    //设备描述
    private String describe;

    //设备自定义编号
    private String equipmentNo;

    //设备借出人员信息
    private UserInfo userInfo;

    //设备状态（0正常，1借出，2损坏，3遗失，4预定）
    private Integer statusNo;

    //添加时间
    private Date addTime;

    //最后修改时间
    private Date updateTime;

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getSnNo() {
        return snNo;
    }

    public void setSnNo(String snNo) {
        this.snNo = snNo;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getEquipmentNo() {
        return equipmentNo;
    }

    public void setEquipmentNo(String equipmentNo) {
        this.equipmentNo = equipmentNo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    public Integer getStatusNo() {
        return statusNo;
    }

    public void setStatusNo(Integer statusNo) {
        this.statusNo = statusNo;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
