package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.Recruitment;

import java.util.List;

public interface RecruitmentService {

    void save(Recruitment recruitment);

    List<Recruitment> getByUserId(String userId);

    Recruitment getById(String id);

    List<Recruitment> findByCompany(String company);

    List<Recruitment> findAll();

    List<Recruitment> findByPost(String post);

    void remove(String id);

}
