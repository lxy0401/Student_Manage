package com.bittech.jdbc;

import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/20
 */
public class MemoGroupApp {
    
    private final MemoGroupJdbc memoGroupJdbc;
    
    
    public MemoGroupApp(MemoGroupJdbc memoGroupJdbc) {
        this.memoGroupJdbc = memoGroupJdbc;
    }
    
    
    public void testInsertMemoGroup() {
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setName("JDBC");
        memoGroup.setCreatedTime(new Date());
        int effect = this.memoGroupJdbc.insertMemoGroup(memoGroup);
        System.out.println("Test-Result : " + (effect == 1));
    }
    
    public void testUpdateMemoGroup() {
        int effect = this.memoGroupJdbc.updateMemoGroup(4, "JDBC-P");
        System.out.println("Test-Result : " + (effect == 1));
    }
    
    public void testQueryMemoGroupByCreatedTime() {
        Date startTime = new Date();
        Date endTime = new Date();
        List<MemoGroup> memoGroups = this.memoGroupJdbc.queryMemoGroupByCreatedTime(startTime, endTime);
        System.out.println(memoGroups);
        System.out.println("Test-Result : " + !memoGroups.isEmpty());
    }
    
    public void testQueryMemoGroupById() {
        List<MemoGroup> memoGroups = this.memoGroupJdbc.queryMemoGroupById(4);
        System.out.println(memoGroups);
        System.out.println("Test-Result : " + (memoGroups.size() == 1));
    }
    
    public void testDeleteMemoGroupById() {
        int effect = this.memoGroupJdbc.deleteMemoGroupById(5);
        System.out.println("Test-Result : " + (effect == 1));
    }
    
    public static void main(String[] args) {
        
        JdbcUtil jdbcUtil = new JdbcUtil(
                "com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/memo?user=root&password=root"
        );
        MemoGroupJdbc memoGroupJdbc = new MemoGroupJdbcImpl(jdbcUtil);
        MemoGroupApp memoGroupApp = new MemoGroupApp(memoGroupJdbc);

//        memoGroupJdbcTest.testInsertMemoGroup();

//        memoGroupJdbcTest.testUpdateMemoGroup();
        
//        memoGroupJdbcTest.testQueryMemoGroupByCreatedTime();
        
//        memoGroupJdbcTest.testQueryMemoGroupById();
        
        memoGroupApp.testDeleteMemoGroupById();
    }
}


