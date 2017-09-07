package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.Matches;

import java.util.List;

public interface MatchesService {

    void save(Matches match);

    Matches findById(String id);

    List<Matches> findByName(String name);

    List<Matches> findByLevel(String level);

    List<Matches> findByUserId(String userId);

    void remove(String id);

}
