package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class OtherInfo {

    @Id
    @Column(length = 20)
    private String otherInfoId;

    @Column(length = 20)
    private String englishLevel;

    @Column(length = 20)
    private String userId;

    private int english;

    @Column(length = 20)
    private String city;

    @Column(length = 2)
    private String swap;

    public OtherInfo() {
    }

    public OtherInfo(String otherInfoId, String englishLevel, String userId, int english, String city, String swap) {
        this.otherInfoId = otherInfoId;
        this.englishLevel = englishLevel;
        this.userId = userId;
        this.english = english;
        this.city = city;
        this.swap = swap;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOtherInfoId() {
        return otherInfoId;
    }

    public void setOtherInfoId(String otherInfoId) {
        this.otherInfoId = otherInfoId;
    }

    public String getEnglishLevel() {
        return englishLevel;
    }

    public void setEnglishLevel(String englishLevel) {
        this.englishLevel = englishLevel;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSwap() {
        return swap;
    }

    public void setSwap(String swap) {
        this.swap = swap;
    }
}
