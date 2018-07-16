package com.bittech.jdbc;

import java.util.Date;
import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/20
 */
public interface MemoGroupJdbc {
    
    /**
     * 插入便签组
     *
     * @param memoGroup 便签组对象
     * @return 插入成功返回1否则0
     */
    int insertMemoGroup(MemoGroup memoGroup);
    
    int updateMemoGroup(int id, String name);
    
    List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime);
    
    List<MemoGroup> queryMemoGroupById(int id);
    
    int deleteMemoGroupById(int id);
    
}
