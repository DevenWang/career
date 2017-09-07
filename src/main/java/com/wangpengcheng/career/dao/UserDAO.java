package com.wangpengcheng.career.dao;

import com.wangpengcheng.career.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, String> {

}
