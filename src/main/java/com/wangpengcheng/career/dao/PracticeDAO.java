package com.wangpengcheng.career.dao;

import com.wangpengcheng.career.model.Practice;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PracticeDAO extends CrudRepository<Practice, String> {

    List<Practice> findByUserId(String userId);

}
