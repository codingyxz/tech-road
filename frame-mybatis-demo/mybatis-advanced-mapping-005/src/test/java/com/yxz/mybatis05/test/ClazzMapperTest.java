package com.yxz.mybatis05.test;

import com.yxz.mybatis05.mapper.ClazzMapper;
import com.yxz.mybatis05.pojo.Clazz;
import com.yxz.mybatis05.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public class ClazzMapperTest {

    @Test
    public void testSelectByStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByStep1(1);
        //System.out.println(clazz);

        // 只访问班级名字。
        System.out.println(clazz.getCname());

        // 只有用到的时候才会去执行第二步SQL
        System.out.println(clazz.getStus());

        sqlSession.close();
    }

    @Test
    public void testSelectByCollection() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        ClazzMapper mapper = sqlSession.getMapper(ClazzMapper.class);
        Clazz clazz = mapper.selectByCollection(1);
        System.out.println(clazz);
        sqlSession.close();
    }

}
