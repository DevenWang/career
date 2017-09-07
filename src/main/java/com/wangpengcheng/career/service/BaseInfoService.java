package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.BaseInfo;

import java.util.List;

public interface BaseInfoService {

    void save(BaseInfo baseInfo);

    BaseInfo getbyId(String id);

    List<BaseInfo> getAll();

    void remove(String id);

}
