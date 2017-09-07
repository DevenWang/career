package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {

    public static final String APPLICANT = "applicant";
    public static final String ADMIN = "admin";
    public static final String COMPANY = "company";

    @Id
    @Column(length = 20)
    private String userId;

    @Column(length = 16)
    private String pwd;

    @Column(length = 15)
    private String type;

    public User() {
    }

    public User(String userId, String pwd, String type) {
        this.userId = userId;
        this.pwd = pwd;
        this.type = type;
    }

    public User(String userId, String pwd) {
        this.userId = userId;
        this.pwd = pwd;
        this.type = APPLICANT;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
