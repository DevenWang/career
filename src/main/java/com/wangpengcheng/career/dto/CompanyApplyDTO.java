package com.wangpengcheng.career.dto;

import java.util.Date;

public class CompanyApplyDTO {
    private String userId;
    private String userName;
    private String se;
    private String phone;
    private String email;
    private String post;
    private Date joinTime;

    public CompanyApplyDTO() {
    }

    public CompanyApplyDTO(String userId, String userName, String se, String phone, String email, String post, Date joinTime) {
        this.userId = userId;
        this.userName = userName;
        this.se = se;
        this.phone = phone;
        this.email = email;
        this.post = post;
        this.joinTime = joinTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSe() {
        return se;
    }

    public void setSe(String se) {
        this.se = se;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
