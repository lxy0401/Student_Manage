package com.lxy.mybatis.demo.mapper;

import com.lxy.mybatis.demo.common.Page;
import com.lxy.mybatis.demo.entity.MemoInfo;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public interface MemoInfoMapper {
    //插入
    int insertMemoInfo(MemoInfo memoInfo);

    //更新
    int updataMemoInfo(@Param("id") int id,@Param("content") String content);

    int updataMemoInfoObject(MemoInfo memoInfo);

    //删除
    int deleteMemoInfo(int id);

    //查询
    MemoInfo queryMemoInfoById(int id);

    Map queryMemoInfoByIdReturnHashMap(int id);

    List<MemoInfo> queryMemoInfoAll();

    List<Map> queryMemoInfoAllReturnHashMap();

    //分页查询
    List<MemoInfo> queryMemoInfoByPage(@Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset, @Param("orderColumnName") String orderColumnName);

    List<MemoInfo> queryMemoInfoByPageObject(Page page);


    //练习
    //根据title和privacy查询便签信息
    List<MemoInfo> queryMemoInfoAndLikeTitleAndLikePrivacy(@Param("title") String title,@Param("isprotected") Character isprotected);

    //查询创建时间在startTime,endTime之间的便签信息
    List<MemoInfo> queryMemoInfoBetweenStartAndEnd(@Param("startTime")LocalDateTime startTime, @Param("endTime")LocalDateTime endTime);

    //查询符合title或者content的其中一个条件的便签
    List<MemoInfo> queryMemoInfoAndLikeTitleOrLikeContent(@Param("title")String title,@Param("content")String content);

    //查询Id在一个集合的便签信息
    List<MemoInfo> queryMemoInfoInSame(List ids);

    //分页查询便签信息
    List<MemoInfo> queryMemoInfoByPage1(@Param("pageSize") Integer pageSize, @Param("pageOffset") Integer pageOffset, @Param("orderColumnName") String orderColumnName);

    //根据MemoInfo更新便签信息，更新内容有：group_id , title, content, is_protected, is_remind, remindTime
   int updataMemoInfoByGroupIdAndTitleAndContentAndIsprotectAndIsremindAndRemindTime
        (@Param("id") Integer id,@Param("groupid") Integer groupid,@Param("title")String title,@Param("content")String content,@Param("isprotected")Character isprotected,@Param("remind")Character remind,@Param("reminTime") LocalDateTime reminTime);



}
