package com.bittech.jdbc;

import com.bittech.jdbc.entity.MemoGroup;
import com.bittech.jdbc.service.MemoGroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Author: secondriver
 * Created: 2018/6/20
 */

public class MemoApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
        MemoGroupService memoGroupService = (MemoGroupService) context.getBean("memoGroupService");
        List<MemoGroup> memoGroupList = memoGroupService.queryMemoGroup(1);
        System.out.println(memoGroupList);
    }
}


