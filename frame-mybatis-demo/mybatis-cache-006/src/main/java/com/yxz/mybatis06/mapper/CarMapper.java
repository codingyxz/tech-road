package com.yxz.mybatis06.mapper;

import com.yxz.mybatis06.pojo.Car;
import org.apache.ibatis.annotations.Param;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public interface CarMapper {

    /**
     * 测试二级缓存
     * @param id
     * @return
     */
    Car selectById(Long id);

    /**
     * 新增汽车
     * @param car
     * @return
     */
    long insertCar(Car car);
}
