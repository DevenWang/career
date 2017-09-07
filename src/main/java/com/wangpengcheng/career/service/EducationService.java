package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.Education;

import java.util.List;

public interface EducationService {

    void save(Education education);

    List<Education> getByUserId(String userId);

    Education getById(String id);

    List<Education> getAll();

    void remove(String id);

}
