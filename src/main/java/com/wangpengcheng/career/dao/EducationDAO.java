package com.wangpengcheng.career.dao;

import com.wangpengcheng.career.model.Education;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EducationDAO extends CrudRepository<Education, String> {

    List<Education> findByUserId(String userId);

}
