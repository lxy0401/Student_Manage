package com.bittech.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Author: secondriver
 * Created: 2018/6/17
 */
public class JdbcUtil {
    
    private String driverClass;
    private String url;
    
    public JdbcUtil(String driverClass, String url) {
        this.url = url;
        this.driverClass = driverClass;
        //加载驱动程序
        try {

//            Class.forName("com.mysql.jdbc.Driver");
            Class.forName(this.driverClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    
    public Connection connection() {
        //连接数据库
        try {
//            return DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/scott?user=root&password=root&useSSL=true"
//            );
            return DriverManager.getConnection(this.url);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public PreparedStatement preparedStatement(Connection connection, String sql) {
        if (connection != null) {
            try {
                return connection.prepareStatement(sql);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public ResultSet query(PreparedStatement statement) {
        if (statement != null) {
            try {
                return statement.executeQuery();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    
    public int update(PreparedStatement statement) {
        if (statement != null) {
            try {
                return statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            
        }
        return 0;
    }
    
    
    public void close(ResultSet resultSet, PreparedStatement statement, Connection connection) {
        
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
}
