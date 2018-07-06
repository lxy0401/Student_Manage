package com.lxy.mybatis.demo;

import com.lxy.mybatis.demo.entity.MemoGroup;
import com.lxy.mybatis.demo.mapper.MemoGroupMapper;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Date;

public class MybatisApplication {
    private static SqlSessionFactory sqlSessionFactory;

    public static void buildSqlSessionFactoryWithXml()
    {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(
                            Resources.getResourceAsStream("practise_map.xml")
                    );
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sqlSessionFactory);
    }
//
//    public static void buildSqlSessionFactoryWithJava()
//    {
//        Configuration configuration = new Configuration();
//        DataSource dataSource = new PooledDataSource(
//                "com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/memo",
//                "root", "root");
//        Environment environment = new Environment(
//                "dev",
//                new JdbcTransactionFactory(),
//                dataSource);
//        configuration.setEnvironment(environment);
//        sqlSessionFactory = new
//                SqlSessionFactoryBuilder().build(configuration);
//        System.out.println(sqlSessionFactory);
//
//    }


    public static void main(String[] args)
    {
        buildSqlSessionFactoryWithXml();
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setName("LPU");
        memoGroup.setCreatedTime(new Date());
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
        int effect = memoGroupMapper.insertMemoGroup(memoGroup);
        System.out.println(effect);
        sqlSession.close();
    }

}
