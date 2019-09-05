package com.thhy.fixedassets.domain;

import java.sql.Timestamp;

//设备种类实体类
public class Kind {

    //设备种类编号
    private Integer kindId;

    //设备种类名
    private String kindName;

    //添加时间
    private Timestamp addTime;

    //最后修改时间
    private Timestamp updateTime;

    public Integer getKindId() {
        return kindId;
    }

    public void setKindId(Integer kindId) {
        this.kindId = kindId;
    }

    public String getKindName() {
        return kindName;
    }

    public void setKindName(String kindName) {
        this.kindName = kindName;
    }

    public Timestamp getAddTime() {
        return addTime;
    }

    public void setAddTime(Timestamp addTime) {
        this.addTime = addTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }
}
