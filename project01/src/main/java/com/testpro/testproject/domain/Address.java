package com.testpro.testproject.domain;

import java.util.Date;

public class Address {

    private Integer id;

    private String desc;

    private String deviceSerial;

    private Integer channelNo;

    private String deviceName;

    private String hls;

    private String hlsHd;

    private String rtmp;

    private String rtmpHd;

    private Date beginTime;

    private Date endTime;

    private Integer status;

    private Integer exception;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

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

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public String getHls() {
        return hls;
    }

    public void setHls(String hls) {
        this.hls = hls;
    }

    public String getHlsHd() {
        return hlsHd;
    }

    public void setHlsHd(String hlsHd) {
        this.hlsHd = hlsHd;
    }

    public String getRtmp() {
        return rtmp;
    }

    public void setRtmp(String rtmp) {
        this.rtmp = rtmp;
    }

    public String getRtmpHd() {
        return rtmpHd;
    }

    public void setRtmpHd(String rtmpHd) {
        this.rtmpHd = rtmpHd;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getException() {
        return exception;
    }

    public void setException(Integer exception) {
        this.exception = exception;
    }
}
