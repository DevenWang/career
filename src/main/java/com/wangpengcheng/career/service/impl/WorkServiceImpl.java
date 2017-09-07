package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.WorkDAO;
import com.wangpengcheng.career.model.Work;
import com.wangpengcheng.career.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServiceImpl implements WorkService {

    private WorkDAO workDAO;

    @Autowired
    public WorkServiceImpl(WorkDAO workDAO) {
        this.workDAO = workDAO;
    }

    @Override
    public void save(Work work) {
        workDAO.save(work);
    }

    @Override
    public Work findById(String id) {
        return workDAO.findOne(id);
    }

    @Override
    public List<Work> findByUserId(String userId) {
        return workDAO.findByUserId(userId);
    }

    @Override
    public List<Work> findAll() {
        return (List<Work>) workDAO.findAll();
    }

    @Override
    public void remove(String id) {
        workDAO.delete(id);

    }
}
