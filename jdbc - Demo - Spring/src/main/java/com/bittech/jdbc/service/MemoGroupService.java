package com.bittech.jdbc.service;

import com.bittech.jdbc.dao.MemoGroupDao;
import com.bittech.jdbc.entity.MemoGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.Date;
import java.util.List;


//使用注解的方式来定义Bean
@Service
public class MemoGroupService {
    @Autowired
    private MemoGroupDao memoGroupDao;

    public List<MemoGroup> queryMemoGroup(int id)
    {
        return memoGroupDao.queryMemoGroupById(id);
    }

    public List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime)
    {
        return memoGroupDao.queryMemoGroupByCreatedTime(new Date(),new Date());
    }



}
