package com.wangpengcheng.career.dao;

import com.wangpengcheng.career.model.Recruitment;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RecruitmentDAO extends CrudRepository<Recruitment, String> {

    List<Recruitment> findByUserId(String userId);

    List<Recruitment> findByCompanyLike(String company);

    List<Recruitment> findByPostLike(String post);

}
