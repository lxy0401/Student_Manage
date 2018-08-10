package com.bittech.javaweb.dao;

import com.bittech.javaweb.entity.User;


public interface UserDao {
    
    User login(User user);
    
    int insert(User user);
    
    boolean exist(String username);
}
