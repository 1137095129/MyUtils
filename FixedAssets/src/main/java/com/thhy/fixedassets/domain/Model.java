package com.thhy.fixedassets.domain;

import java.sql.Timestamp;

//设备型号实体类
public class Model {

    //设备型号编号
    private Integer modelId;

    //设备型号名
    private String modelName;

    //设备规格
    private String specifications;

    //设备价格
    private Float price;

    //设备型号信息添加时间
    private Timestamp addTime;

    //设备型号信息最后修改时间
    private Timestamp updateTime;

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getSpecifications() {
        return specifications;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
