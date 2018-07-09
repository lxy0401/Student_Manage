package com.lxy.mybatis.mapper;

import com.github.pagehelper.PageHelper;
import com.lxy.mybatis.demo.common.Page;
import com.lxy.mybatis.demo.common.backGround;
import com.lxy.mybatis.demo.entity.MemoInfo;
import com.lxy.mybatis.demo.mapper.MemoInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class MemoInfoMapperTest {
    private static SqlSessionFactory sqlSessionFactory;

    //日志
    private final Logger logger = LoggerFactory.getLogger(MemoInfoMapperTest.class);

    static{
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("practise_map.xml"));
            //sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("practise_map.xml"));
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
        memoInfo.setGroup_id(3);
        memoInfo.setBackground(backGround.WHITE);
        memoInfo.setContent("LLH");
        memoInfo.setTitle("C++");
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

        int effect = memoInfoMapper.deleteMemoInfo(8);
        logger.info("Delete id = 8,Result = {}",effect);

        sqlSession.close();
    }


    //查询测试
    @Test
    public void test_queryMemoInfoById()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        MemoInfo memoInfo = memoInfoMapper.queryMemoInfoById(3);
        logger.info("Select id = 3,Result = {}",memoInfo);

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

        List<MemoInfo> memoInfo1 = memoInfoMapper.queryMemoInfoAll();
        logger.info("first:Select id = 9,Result = {}",memoInfo1);


        List<MemoInfo> memoInfo2 = memoInfoMapper.queryMemoInfoAll();
        logger.info("second:Select id = 9,Result = {}",memoInfo2);

        List<MemoInfo> memoInfo3 = memoInfoMapper.queryMemoInfoAll();
        logger.info("third:Select id = 9,Result = {}",memoInfo3);

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

    //分页查询测试
    @Test
    public void test_queryMemoInfoByPage()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        int pageSize = 2;
        String orderColumnName = "id";

        for (int i = 1; i < 3; i++) {
            int pageNumber = i;
            int pageOffset = (pageNumber - 1) * pageSize;
            List<MemoInfo> memoInfo = memoInfoMapper.queryMemoInfoByPage(pageSize, pageOffset, orderColumnName);
            logger.info("CurrentPage = {} Result = {}", pageNumber, memoInfo);
        }

        sqlSession.close();
    }

    //分页查询测试
    @Test
    public void test_queryMemoInfoByPageObject()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        Page page = new Page();
        page.setOrderColumnName("id");

        for (int i = 1; i < 3; i++) {
            page.setPageNumber(i);
            List<MemoInfo> memoInfo = memoInfoMapper.queryMemoInfoByPageObject(page);
            logger.info("CurrentPage = {} Result = {}", page, memoInfo);
        }

        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoAndLikeTitleAndLikePrivacy()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        List<MemoInfo> memoInfos = memoInfoMapper.queryMemoInfoAndLikeTitleAndLikePrivacy("Java",'0');
        logger.info("Result is : {}",memoInfos);

        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoBetweenStartAndEnd()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);


        LocalDateTime startTime = LocalDateTime.of(2018,7,1,0,0,0);
        LocalDateTime endTime = LocalDateTime.now();

        List<MemoInfo> memoInfos = memoInfoMapper.queryMemoInfoBetweenStartAndEnd(startTime,null);
        logger.info("Result is : {}",memoInfos);

        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoAndLikeTitleOrLikeContent()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        List<MemoInfo> memoInfos = memoInfoMapper.queryMemoInfoAndLikeTitleOrLikeContent("java",null);
        logger.info("Result is : {}",memoInfos);

        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoInSame()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        List<Integer> ids = new ArrayList<Integer>();
        ids.add(9);
        ids.add(10);
        ids.add(11);
        ids.add(12);
        logger.info("Result is : {}",ids);

        sqlSession.close();
    }

    @Test
    public void test_queryMemoInfoByPage1()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        PageHelper.startPage(1, 1);
        List<MemoInfo> list = memoInfoMapper.queryMemoInfoAll();

        logger.info("Result is : {}",list);

        sqlSession.close();
    }

    @Test
    public void test_updataMemoInfoByGroupIdAndTitleAndContentAndIsprotectAndIsremindAndRemindTime()
    {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);

        int remindTime = memoInfoMapper.updataMemoInfoByGroupIdAndTitleAndContentAndIsprotectAndIsremindAndRemindTime(10,3,"JS","CSS",'0','1',LocalDateTime.now());
        logger.info("Result is : {}",remindTime);

        sqlSession.close();
    }




}
