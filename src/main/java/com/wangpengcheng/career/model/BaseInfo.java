package com.wangpengcheng.career.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class BaseInfo {

    @Id
    @Column(length = 20)
    private String baseInfoId;

    @Column(length = 20)
    private String name;

    @Column(length = 2)
    private String gender;

    @Column(length = 18)
    private String cardId;

    private Date birthday;

    @Column(length = 20)
    private String localCity;

    @Column(length = 20)
    private String birthCity;

    @Column(length = 11)
    private String phone;

    @Column(length = 30)
    private String email;

    public BaseInfo() {

    }

    public BaseInfo(String baseInfoId, String name, String gender, String cardId, Date birthday, String localCity, String birthCity, String phone, String email) {
        this.baseInfoId = baseInfoId;
        this.name = name;
        this.gender = gender;
        this.cardId = cardId;
        this.birthday = birthday;
        this.localCity = localCity;
        this.birthCity = birthCity;
        this.phone = phone;
        this.email = email;
    }

    public String getBaseInfoId() {
        return baseInfoId;
    }

    public void setBaseInfoId(String baseInfoId) {
        this.baseInfoId = baseInfoId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getLocalCity() {
        return localCity;
    }

    public void setLocalCity(String localCity) {
        this.localCity = localCity;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
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
}
