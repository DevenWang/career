package com.wangpengcheng.career.dao;

import com.wangpengcheng.career.model.Matches;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MatchesDAO extends CrudRepository<Matches, String> {

    List<Matches> findByNameLike(String name);

    List<Matches> findByLevelLike(String level);

    List<Matches> findByUserId(String userId);

}
