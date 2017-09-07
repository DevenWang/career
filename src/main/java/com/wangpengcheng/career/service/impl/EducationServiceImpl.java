package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.EducationDAO;
import com.wangpengcheng.career.model.Education;
import com.wangpengcheng.career.service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements EducationService {

    private EducationDAO educationDAO;

    @Autowired
    public EducationServiceImpl(EducationDAO educationDAO) {
        this.educationDAO = educationDAO;
    }

    @Override
    public void save(Education education) {
        educationDAO.save(education);
    }

    @Override
    public List<Education> getByUserId(String userId) {
        return educationDAO.findByUserId(userId);
    }

    @Override
    public Education getById(String id) {
        return educationDAO.findOne(id);
    }

    @Override
    public List<Education> getAll() {
        return (List<Education>) educationDAO.findAll();
    }

    @Override
    public void remove(String id) {
        educationDAO.delete(id);

    }

}
