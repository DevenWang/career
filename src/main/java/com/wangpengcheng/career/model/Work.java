package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import java.util.Date;

@Entity
public class Work {

    @Id
    @Column(length = 20)
    private String workId;

    @Column(length = 20)
    private String userId;

    private Date start;

    private Date end;

    private String workType;

    private String name;

    @Lob
    private String content;

    @Lob
    private String duty;

    public Work() {
    }

    public Work(String workId, String userId, Date start, Date end, String workType, String name, String content, String duty) {
        this.workId = workId;
        this.userId = userId;
        this.start = start;
        this.end = end;
        this.workType = workType;
        this.name = name;
        this.content = content;
        this.duty = duty;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
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

    public String getWorkType() {
        return workType;
    }

    public void setWorkType(String workType) {
        this.workType = workType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }
}
