package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 招聘信息
 */
@Entity
public class Recruitment {

    @Id
    @Column(length = 20)
    private String recruitmentId;

    private String userId;

    private String company;

    private String post;

    private String address;

    private Date endTime;

    public Recruitment() {
    }

    public Recruitment(String recruitmentId, String userId, String company, String post, String address, Date endTime) {
        this.recruitmentId = recruitmentId;
        this.userId = userId;
        this.company = company;
        this.post = post;
        this.address = address;
        this.endTime = endTime;
    }

    public String getRecruitmentId() {
        return recruitmentId;
    }

    public void setRecruitmentId(String recruitmentId) {
        this.recruitmentId = recruitmentId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
