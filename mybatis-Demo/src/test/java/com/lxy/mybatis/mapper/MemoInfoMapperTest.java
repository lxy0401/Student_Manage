package com.lxy.mybatis.mapper;


import com.lxy.mybatis.demo.common.backGround;
import com.lxy.mybatis.demo.entity.MemoInfo;
import com.lxy.mybatis.demo.mapper.MemoInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


public class MemoInfoMapperTest {
    private static SqlSessionFactory sqlSessionFactory;
    private final Logger logger = LoggerFactory.getLogger(MemoInfoMapperTest.class);

    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("practise_map.xml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //插入测试
    @Test
    public void test_insertMemoInfo()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setGroup_id(7);
        memoInfo.setBackground(backGround.WHITE);
        memoInfo.setContent("HXF");
        memoInfo.setTitle("Java");
        memoInfo.setIsprotected('0');
        memoInfo.setRemind('1');
        memoInfo.setReminTime(new Date());
        memoInfo.setCreatedTime(new Date());

        logger.info("Insert Before :{}",memoInfo);
        int effect = memoInfoMapper.insertMemoInfo(memoInfo);
        logger.info("Insert Result = {}",effect);
        logger.info("Insert After : {}",memoInfo);

//        int result =memoInfoMapper.insertMamoInfo(memoInfo);
//        System.out.println(result);
//
        sqlSession.close();
    }

    //更新测试
    @Test
    public void test_updataMemoInfo()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();

        logger.info("Update Before :{}",memoInfo);
        int effect = memoInfoMapper.updataMemoInfo(2,"C++");
        logger.info("Update Result = {}",effect);
        logger.info("Update After : {}",memoInfo);

        sqlSession.close();
    }

    //更新测试
    @Test
    public void test_updataMemoInfoObject()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();

        memoInfo.setId(2);
        memoInfo.setContent("JavaSE");

        logger.info("Update Before :{}",memoInfo);
        int effect = memoInfoMapper.updataMemoInfoObject(memoInfo);
        logger.info("Update id = 7,Result = {}",effect);
        logger.info("Update After : {}",memoInfo);

        sqlSession.close();

    }

    //删除测试
    @Test
    public void test_deleteMemoInfoObject()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        //MemoInfo memoInfo = new MemoInfo();

        int effect = memoInfoMapper.deleteMemoInfo(5);
        logger.info("Delete id = 5,Result = {}",effect);

        sqlSession.close();
    }

    //查询测试
    @Test
    public void test_queryMemoInfoById()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        MemoInfo memoInfo = memoInfoMapper.queryMemoInfoById(4);
        logger.info("Select id = 4,Result = {}",memoInfo);

        sqlSession.close();
    }

    //查询测试
    @Test
    public void test_queryMemoInfoReturnHashMap()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        Map memoInfo = memoInfoMapper.queryMemoInfoByIdReturnHashMap(4);
        logger.info("Select id = 4,Result = {}",memoInfo);

        sqlSession.close();
    }

    //查询测试
    @Test
    public void test_queryMemoInfoAll()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        List<MemoInfo> memoInfo = memoInfoMapper.queryMemoInfoAll();
        logger.info("Select id = 4,Result = {}",memoInfo);

        sqlSession.close();
    }

    //查询测试
    @Test
    public void test_queryMemoInfoAllReturnHashMap()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        List<Map> memoInfo = memoInfoMapper.queryMemoInfoAllReturnHashMap();
        logger.info("Select id = 4,Result = {}",memoInfo);

        sqlSession.close();
    }


}
