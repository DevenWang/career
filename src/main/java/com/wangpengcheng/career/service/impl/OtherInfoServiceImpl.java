package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.OtherInfoDAO;
import com.wangpengcheng.career.model.OtherInfo;
import com.wangpengcheng.career.service.OtherInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OtherInfoServiceImpl implements OtherInfoService {

    private OtherInfoDAO otherInfoDAO;

    @Autowired
    public OtherInfoServiceImpl(OtherInfoDAO otherInfoDAO) {
        this.otherInfoDAO = otherInfoDAO;
    }

    @Override
    public void save(OtherInfo otherInfo) {
        otherInfoDAO.save(otherInfo);
    }

    @Override
    public OtherInfo findById(String id) {
        return otherInfoDAO.findOne(id);
    }

    @Override
    public List<OtherInfo> findByUserId(String userId) {
        return otherInfoDAO.findByUserId(userId);
    }

    @Override
    public List<OtherInfo> findByCity(String city) {
        return otherInfoDAO.findByCity(city);
    }

    @Override
    public void remove(String id) {
        otherInfoDAO.delete(id);
    }
}
