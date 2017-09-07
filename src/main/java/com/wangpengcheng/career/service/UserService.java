package com.wangpengcheng.career.service;

import com.wangpengcheng.career.model.User;

public interface UserService {

    User getUserById(String userId);

    void saveUser(User user);

}
