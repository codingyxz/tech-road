package com.yxz.mybatis07.test;

import com.yxz.mybatis07.mapper.complex.CarMapper;
import com.yxz.mybatis07.pojo.Car;
import com.yxz.mybatis07.pojo.CarExample;
import com.yxz.mybatis07.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public class ComplexCarMapperTest {

    // CarExample类负责封装查询条件的。
    @Test
    public void testSelect() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        // 执行查询
        // 1. 查询一个
        Car car = mapper.selectByPrimaryKey(165L);
        System.out.println(car);
        // 2. 查询所有（selectByExample，根据条件查询，如果条件是null表示没有条件。）
        List<Car> cars = mapper.selectByExample(null);
        cars.forEach(car1 -> System.out.println(car1));
        System.out.println("=========================================");
        // 3. 按照条件进行查询
        // QBC 风格：Query By Criteria 一种查询方式，比较面向对象，看不到sql语句。
        // 封装条件，通过CarExample对象来封装查询条件
        CarExample carExample = new CarExample();
        // 调用carExample.createCriteria()方法来创建查询条件
        carExample.createCriteria()
                .andBrandLike("帕萨特")
                .andGuidePriceGreaterThan(new BigDecimal(20.0));
        // 添加or
        carExample.or().andCarTypeEqualTo("燃油车");
        // 执行查询
        List<Car> cars2 = mapper.selectByExample(carExample);
        cars2.forEach(car2 -> System.out.println(car2));

        sqlSession.close();

    }

}
