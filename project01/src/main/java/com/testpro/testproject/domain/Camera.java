package com.testpro.testproject.domain;

public class Camera {

    private String deviceSerial;

    private Integer channelNo;

    private String channelName;

    private Integer status;

    private String isShared;

    private String picUrl;

    private Integer isEncrypt;

    private Integer videoLevel;

    private Integer permission;

    public String getDeviceSerial() {
        return deviceSerial;
    }

    public void setDeviceSerial(String deviceSerial) {
        this.deviceSerial = deviceSerial;
    }

    public Integer getChannelNo() {
        return channelNo;
    }

    public void setChannelNo(Integer channelNo) {
        this.channelNo = channelNo;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getIsShared() {
        return isShared;
    }

    public void setIsShared(String isShared) {
        this.isShared = isShared;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public Integer getIsEncrypt() {
        return isEncrypt;
    }

    public void setIsEncrypt(Integer isEncrypt) {
        this.isEncrypt = isEncrypt;
    }

    public Integer getVideoLevel() {
        return videoLevel;
    }

    public void setVideoLevel(Integer videoLevel) {
        this.videoLevel = videoLevel;
    }

    public Integer getPermission() {
        return permission;
    }

    public void setPermission(Integer permission) {
        this.permission = permission;
    }
}
