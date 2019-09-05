package com.thhy.fixedassets.domain;

//用户实体类
public class UserInfo {

    //用户编号
    private Integer userId;

    //用户名
    private String userName;

    //用户身份
    private String userStatus;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }
}
