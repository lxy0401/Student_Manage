package com.lxy.mybatis.demo.mapper;

import com.lxy.mybatis.demo.entity.MemoInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface MemoInfoMapper {
    int insertMemoInfo(MemoInfo memoInfo);

    int updataMemoInfo(@Param("id") int id,@Param("content") String content);

    int updataMemoInfoObject(MemoInfo memoInfo);

    int deleteMemoInfo(int id);

    MemoInfo queryMemoInfoById(int id);

    Map queryMemoInfoByIdReturnHashMap(int id);

    List<MemoInfo> queryMemoInfoAll();

    List<Map> queryMemoInfoAllReturnHashMap();


}
