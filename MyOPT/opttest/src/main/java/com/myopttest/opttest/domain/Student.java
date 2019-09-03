package com.myopttest.opttest.domain;

public class Student {
    private Integer uid;
    private Integer allow;
    private String userName;
    private String password;
    private String userCard;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAllow() {
        return allow;
    }

    public void setAllow(Integer allow) {
        this.allow = allow;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserCard() {
        return userCard;
    }

    public void setUserCard(String userCard) {
        this.userCard = userCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "uid=" + uid +
                ", allow=" + allow +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", userCard='" + userCard + '\'' +
                '}';
    }
}
