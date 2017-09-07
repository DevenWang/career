package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.ApplyDAO;
import com.wangpengcheng.career.model.Apply;
import com.wangpengcheng.career.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApplyServiceImpl implements ApplyService {

    private ApplyDAO applyDAO;

    @Autowired
    public ApplyServiceImpl(ApplyDAO applyDAO) {
        this.applyDAO = applyDAO;
    }

    @Override
    public void save(Apply apply) {
        applyDAO.save(apply);
    }

    @Override
    public List<Apply> findByUserId(String userId) {
        return applyDAO.findByUserId(userId);
    }

    @Override
    public Apply findById(String id) {
        return applyDAO.findOne(id);
    }

    @Override
    public List<Apply> findByWorkId(String workId) {
        return applyDAO.findByWorkId(workId);
    }

    @Override
    public List<Apply> findAll() {
        return (List<Apply>) applyDAO.findAll();
    }

    @Override
    public void remove(String id) {
        applyDAO.delete(id);
    }
}
