package com.bittech.javaweb.entity;

import lombok.Data;

@Data
public class User {
    
    /**
     * 系统用户编号
     */
    private int id;
    
    /**
     * 用户名
     */
    private String userName;
    
    /**
     * 密码
     */
    private String password;
}
