package com.yxz.mybatis04.mapper;

import com.yxz.mybatis04.pojo.Car;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public interface CarMapper {

    /**
     * 根据id批量删除 使用or关键字。
     * @param ids
     * @return
     */
    int deleteByIds2(@Param("ids") Long[] ids);

    /**
     * 批量插入，一次插入多条Car信息
     * @param cars
     * @return
     */
    int insertBatch(@Param("cars") List<Car> cars);

    /**
     * 批量删除。foreach标签
     * @param ids
     * @return
     */
    int deleteByIds(@Param("ids") Long[] ids);

    /**
     * 使用choose when otherwise标签。
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByChoose(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用set标签
     * @param car
     * @return
     */
    int updateBySet(Car car);

    /**
     * 更新Car
     * @param car
     * @return
     */
    int updateById(Car car);

    /**
     * 使用trim标签
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithTrim(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 使用where标签，让where子句更加的智能。
     * @param brand
     * @param guidePrice
     * @param carType
     * @return
     */
    List<Car> selectByMultiConditionWithWhere(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);

    /**
     * 多条件查询
     * @param brand 品牌
     * @param guidePrice 指导价
     * @param carType 汽车类型
     * @return
     */
    List<Car> selectByMultiCondition(@Param("brand") String brand, @Param("guidePrice") Double guidePrice, @Param("carType") String carType);


}
