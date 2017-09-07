package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Apply {

    @Id
    @Column(length = 20)
    private String applyId;

    @Column(length = 20)
    private String userId;

    @Column(length = 20)
    private String workId;

    private Date time;

    public Apply() {
    }

    public Apply(String applyId, String userId, String workId, Date time) {
        this.applyId = applyId;
        this.userId = userId;
        this.workId = workId;
        this.time = time;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
