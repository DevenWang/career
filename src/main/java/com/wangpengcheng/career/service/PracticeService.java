package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.Practice;

import java.util.List;

public interface PracticeService {

    void save(Practice practice);

    List<Practice> findByUserId(String userId);

    Practice findById(String id);

    List<Practice> findAll();

    void remove(String id);

}
