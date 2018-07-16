package com.bittech.jdbc.dao.impl;

import com.bittech.jdbc.dao.JdbcComponent;
import com.bittech.jdbc.dao.MemoGroupDao;
import com.bittech.jdbc.entity.MemoGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/20
 */
@Repository
public class MemoGroupDaoImpl implements MemoGroupDao {
    
    private final JdbcComponent jdbcUtil;

    @Autowired
    public MemoGroupDaoImpl(JdbcComponent jdbcUtil) {
        this.jdbcUtil = jdbcUtil;
    }
    
    @Override
    public int insertMemoGroup(MemoGroup memoGroup) {
        if (memoGroup == null || memoGroup.getName() == null || memoGroup.getCreatedTime() == null) {
            return 0;
        }
        Connection connection = this.jdbcUtil.connection();
        String sql = "insert into memo_group (name,created_time) values (?,?)";
        PreparedStatement statement = this.jdbcUtil.preparedStatement(connection, sql);
        try {
            statement.setString(1, memoGroup.getName());
            statement.setDate(2, new java.sql.Date(memoGroup.getCreatedTime().getTime()));
            
            return this.jdbcUtil.update(statement);
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(null, statement, connection);
        }
        return 0;
    }
    
    @Override
    public int updateMemoGroup(int id, String name) {
        if (name == null) {
            return 0;
        }
        Connection connection = this.jdbcUtil.connection();
        String sql = "update memo_group set name =? where id=?";
        PreparedStatement statement = this.jdbcUtil.preparedStatement(connection, sql);
        try {
            statement.setString(1, name);
            statement.setInt(2, id);
            return this.jdbcUtil.update(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(null, statement, connection);
        }
        return 0;
    }
    
    @Override
    public List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime) {
        List<MemoGroup> memoGroups = new ArrayList<>();
        if (startTime == null || endTime == null) {
            return memoGroups;
        }
        Connection connection = this.jdbcUtil.connection();
        String sql = "select id, name, created_time, modify_time from memo_group where created_time between  ? and ?";
        PreparedStatement statement = this.jdbcUtil.preparedStatement(connection, sql);
        ResultSet resultSet = null;
        try {
            statement.setDate(1,
                    new java.sql.Date(startTime.getTime()));
            statement.setDate(2,
                    new java.sql.Date(endTime.getTime()));
            resultSet = this.jdbcUtil.query(statement);
            memoGroups = this.handleResult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(resultSet, statement, connection);
        }
        
        
        return memoGroups;
    }
    
    @Override
    public List<MemoGroup> queryMemoGroupById(int id) {
        List<MemoGroup> memoGroups = new ArrayList<>();
        Connection connection = this.jdbcUtil.connection();
        String sql = "select id, name, created_time, modify_time from memo_group where id= ?";
        PreparedStatement statement = this.jdbcUtil.preparedStatement(connection, sql);
        ResultSet resultSet = null;
        try {
            statement.setInt(1, id);
            resultSet = this.jdbcUtil.query(statement);
            memoGroups = this.handleResult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(resultSet, statement, connection);
        }
        return memoGroups;
    }
    
    @Override
    public int deleteMemoGroupById(int id) {
        Connection connection = this.jdbcUtil.connection();
        String sql = "delete from  memo_group where id= ?";
        PreparedStatement statement = this.jdbcUtil.preparedStatement(connection, sql);
        try {
            statement.setInt(1, id);
            return this.jdbcUtil.update(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.jdbcUtil.close(null, statement, connection);
        }
        return 0;
    }
    
    
    private List<MemoGroup> handleResult(ResultSet resultSet) {
        List<MemoGroup> memoGroups = new ArrayList<>();
        try {
            while (resultSet != null && resultSet.next()) {
                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(resultSet.getInt("id"));
                memoGroup.setName(resultSet.getString("name"));
                memoGroup.setCreatedTime(resultSet.getDate("created_time"));
                memoGroup.setModifyTime(resultSet.getTimestamp("modify_time"));
                memoGroups.add(memoGroup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return memoGroups;
    }
}
