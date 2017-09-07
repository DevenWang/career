package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.MatchesDAO;
import com.wangpengcheng.career.model.Matches;
import com.wangpengcheng.career.service.MatchesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatchesServiceImpl implements MatchesService {

    private MatchesDAO matchDAO;

    @Autowired
    public MatchesServiceImpl(MatchesDAO matchDAO) {
        this.matchDAO = matchDAO;
    }

    @Override
    public void save(Matches match) {
        matchDAO.save(match);
    }

    @Override
    public Matches findById(String id) {
        return matchDAO.findOne(id);
    }

    @Override
    public List<Matches> findByName(String name) {
        return matchDAO.findByNameLike(name);
    }

    @Override
    public List<Matches> findByLevel(String level) {
        return matchDAO.findByLevelLike(level);
    }

    @Override
    public List<Matches> findByUserId(String userId) {
        return matchDAO.findByUserId(userId);
    }

    @Override
    public void remove(String id) {
        matchDAO.delete(id);

    }

}
