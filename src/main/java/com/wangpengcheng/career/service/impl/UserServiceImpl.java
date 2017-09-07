package com.wangpengcheng.career.service.impl;

import com.wangpengcheng.career.dao.UserDAO;
import com.wangpengcheng.career.model.User;
import com.wangpengcheng.career.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDAO userDAO;

    @Autowired
    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public User getUserById(String userId) {
        return userDAO.findOne(userId);
    }

    @Override
    public void saveUser(User user) {
        userDAO.save(user);
    }
}
