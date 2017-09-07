package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Matches {

    @Id
    @Column(length = 20)
    private String matchId;

    @Column(length = 20)
    private String userId;

    @Column(length = 20)
    private String name;

    @Column(length = 20)
    private String level;

    private Date time;

    public Matches() {
    }

    public Matches(String matchId, String userId, String name, String level, Date time) {
        this.matchId = matchId;
        this.userId = userId;
        this.name = name;
        this.level = level;
        this.time = time;
    }

    public String getMatchId() {
        return matchId;
    }

    public void setMatchId(String matchId) {
        this.matchId = matchId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
