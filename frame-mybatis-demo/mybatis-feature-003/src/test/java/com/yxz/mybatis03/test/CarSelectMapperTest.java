package com.yxz.mybatis03.test;

import com.yxz.mybatis03.mapper.CarSelectMapper;
import com.yxz.mybatis03.pojo.Car;
import com.yxz.mybatis03.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public class CarSelectMapperTest {

    @Test
    public void testSelectTotal() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        Long total = mapper.selectTotal();
        System.out.println("总记录条数：" + total);
        sqlSession.close();
    }

    @Test
    public void testSelectAllByMapUnderscoreToCamelCase() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        List<Car> cars = mapper.selectAllByMapUnderscoreToCamelCase();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAllByResultMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        List<Car> cars = mapper.selectAllByResultMap();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        Map<Long, Map<String, Object>> map = mapper.selectAllRetMap();
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void testSelectAllRetListMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        List<Map<String, Object>> maps = mapper.selectAllRetListMap();
        maps.forEach(map -> System.out.println(map));
        sqlSession.close();
    }

    @Test
    public void testSelectByIdRetMap() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        Map<String, Object> car = mapper.selectByIdRetMap(20L);
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectByIdList() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        List<Car> cars = mapper.selectByIdList(20L);
        System.out.println(cars);
        sqlSession.close();
    }

    @Test
    public void testSelectByBrandLike() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        // TooManyResultsException
        // 什么意思？你期望的结果是返回一条记录。但是实际的SQL语句在执行的时候，返回的记录条数不是一条，是多条。
        Car car = mapper.selectByBrandLike("丰田霸道");
        System.out.println(car);
        sqlSession.close();
    }

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarSelectMapper mapper = sqlSession.getMapper(CarSelectMapper.class);
        Car car = mapper.selectById(20L);
        System.out.println(car);
        sqlSession.close();
    }

}
