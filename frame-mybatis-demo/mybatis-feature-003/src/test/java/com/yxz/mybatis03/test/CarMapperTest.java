package com.yxz.mybatis03.test;

import com.yxz.mybatis03.mapper.CarMapper;
import com.yxz.mybatis03.pojo.Car;
import com.yxz.mybatis03.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public class CarMapperTest {

    @Test
    public void testInsertCarUseGeneratedKeys(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        Car car = new Car(null,"9991", "奔驰", 30.0, "2020-11-11", "燃油车");
        mapper.insertCarUseGeneratedKeys(car);

        System.out.println(car);

        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectByBrandLike(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByBrandLike("奔驰");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testDeleteBatch(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        int count = mapper.deleteBatch("11,12,13");
        System.out.println(count);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectAllByAscOrDesc(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectAllByAscOrDesc("desc");
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

    @Test
    public void testSelectByCarType(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mapper实际上就是daoImpl对象.
        // 底层不但为CarMapper接口生成了字节码，并且还new实现类对象了。
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByCarType("新能源");
        // 遍历
        cars.forEach(car -> System.out.println(car));

        sqlSession.close();
    }

}
