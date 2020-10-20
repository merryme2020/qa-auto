package com.yizhan.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {
    public static SqlSession  getSqlSession() throws IOException {
        //获取资源文件
        Reader reader = Resources.getResourceAsReader("databaseConfing.xml");
        SqlSessionFactory  factory = new SqlSessionFactoryBuilder().build( reader);
       //sqlSession就是能够执行配置文件中的sql 语句
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }




}
