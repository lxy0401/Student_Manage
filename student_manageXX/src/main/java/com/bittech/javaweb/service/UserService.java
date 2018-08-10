package com.bittech.javaweb.service;

/**
 * Author: secondriver
 * Created: 2018/7/29
 */
public interface UserService {
    
    boolean login(String username, String password);
    
    boolean register(String username, String password);
    
}
