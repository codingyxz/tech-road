package com.yxz.mybatis07.test;

import com.yxz.mybatis07.mapper.simple.CarMapper;
import com.yxz.mybatis07.pojo.Car;
import com.yxz.mybatis07.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public class SimpleCarMapperTest {

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testDeleteByPrimaryKey() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteByPrimaryKey(164L);
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

}
