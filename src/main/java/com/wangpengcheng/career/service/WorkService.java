package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.Work;

import java.util.List;

public interface WorkService {

    void save(Work work);

    Work findById(String id);

    List<Work> findByUserId(String userId);

    List<Work> findAll();

    void remove(String id);

}
