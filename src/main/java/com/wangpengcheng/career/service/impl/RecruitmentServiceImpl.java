package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.RecruitmentDAO;
import com.wangpengcheng.career.model.Recruitment;
import com.wangpengcheng.career.service.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentServiceImpl implements RecruitmentService {

    private RecruitmentDAO recruitmentDAO;

    @Autowired
    public RecruitmentServiceImpl(RecruitmentDAO recruitmentDAO) {
        this.recruitmentDAO = recruitmentDAO;
    }

    @Override
    public void save(Recruitment recruitment) {
        recruitmentDAO.save(recruitment);
    }

    @Override
    public List<Recruitment> getByUserId(String userId) {
        return recruitmentDAO.findByUserId(userId);
    }

    @Override
    public Recruitment getById(String id) {
        return recruitmentDAO.findOne(id);
    }

    @Override
    public List<Recruitment> findByCompany(String company) {
        return recruitmentDAO.findByCompanyLike(company);
    }

    @Override
    public List<Recruitment> findAll() {
        return (List<Recruitment>) recruitmentDAO.findAll();
    }

    @Override
    public List<Recruitment> findByPost(String post) {
        return recruitmentDAO.findByPostLike(post);
    }

    @Override
    public void remove(String id) {
        recruitmentDAO.delete(id);
    }

}
