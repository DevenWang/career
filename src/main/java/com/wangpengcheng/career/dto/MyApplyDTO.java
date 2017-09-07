package com.wangpengcheng.career.dto;

import java.util.Date;

public class MyApplyDTO {

    private String id;
    private String name;
    private String post;
    private String address;
    private Date endTime;
    private Date joinTime;

    public MyApplyDTO() {
    }

    public MyApplyDTO(String id, String name, String post, String address, Date endTime, Date joinTime) {
        this.id = id;
        this.name = name;
        this.post = post;
        this.address = address;
        this.endTime = endTime;
        this.joinTime = joinTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Date getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(Date joinTime) {
        this.joinTime = joinTime;
    }
}
