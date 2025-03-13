package com.yxz.mybatis01.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public class MyBatisIntroductionDemo {

    public static void main(String[] args) throws Exception {

        // 获取SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();

        // 获取SqlSessionFactory对象
        // Resources.getResourceAsStream默认就是从类的根路径下开始查找资源。
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
//        InputStream is = Resources.getResourceAsStream("com/mybatis.xml");
//        InputStream is = new FileInputStream("d:\\mybatis-config.xml");
//        InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("mybatis-config.xml");

        // 一般情况下都是一个数据库对应一个SqlSessionFactory对象。
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);

        // 获取SqlSession对象
        // 如果使用的事务管理器是JDBC的话，底层实际上会执行：conn.setAutoCommit(false);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 这种方式实际上是不建议的，因为没有开启事务。
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        // 执行SQL语句
        int count = sqlSession.insert("testInsertCar"); // 返回值是影响数据库表当中的记录条数。

        System.out.println("插入了几条记录：" + count);

        // 手动提交
        sqlSession.commit(); // 如果使用的事务管理器是JDBC的话，底层实际上还是会执行conn.commit();

    }

}
