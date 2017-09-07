package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.BaseInfoDAO;
import com.wangpengcheng.career.model.BaseInfo;
import com.wangpengcheng.career.service.BaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BaseInfoServiceImpl implements BaseInfoService {

    private BaseInfoDAO baseInfoDAO;

    @Autowired
    public BaseInfoServiceImpl(BaseInfoDAO baseInfoDAO) {
        this.baseInfoDAO = baseInfoDAO;
    }

    @Override
    public void save(BaseInfo baseInfo) {
        baseInfoDAO.save(baseInfo);
    }

    @Override
    public BaseInfo getbyId(String id) {
        return baseInfoDAO.findOne(id);
    }

    @Override
    public List<BaseInfo> getAll() {
        return (List<BaseInfo>) baseInfoDAO.findAll();
    }

    @Override
    public void remove(String id) {
        baseInfoDAO.delete(id);
    }
}
