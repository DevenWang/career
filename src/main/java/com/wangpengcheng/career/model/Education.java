package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Education {

    @Id
    @Column(length = 20)
    private String educationId;

    @Column(length = 20)
    private String userId;

    private Date start;

    private Date end;

    @Column(length = 30)
    private String school;

    @Column(length = 50)
    private String department;

    @Column(length = 50)
    private String major;

    @Column(length = 20)
    private String degree;

    @Column(length = 10)
    private String rank;

    public Education() {
    }

    public Education(String educationId, String userId, Date start, Date end, String school, String department, String major, String degree, String rank) {
        this.educationId = educationId;
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.school = school;
        this.department = department;
        this.major = major;
        this.degree = degree;
        this.rank = rank;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
