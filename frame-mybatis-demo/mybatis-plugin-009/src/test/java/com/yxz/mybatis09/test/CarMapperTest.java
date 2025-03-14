package com.yxz.mybatis09.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxz.mybatis09.mapper.CarMapper;
import com.yxz.mybatis09.pojo.Car;
import com.yxz.mybatis09.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public class CarMapperTest {

    @Test
    public void testSelectAll() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);

        // 一定一定一定要注意：在执行DQL语句之前。开启分页功能。
        int pageNum = 2;
        int pageSize = 3;
        PageHelper.startPage(pageNum, pageSize);

        List<Car> cars = mapper.selectAll();
        cars.forEach(car -> System.out.println(car));

        // 封装分页信息对象new PageInfo()
        // PageInfo对象是PageHelper插件提供的，用来封装分页相关的信息的对象。
        PageInfo<Car> carPageInfo = new PageInfo<>(cars, 3);
        System.out.println(carPageInfo);

        sqlSession.close();

        /**
         * PageInfo{
         * * pageNum=2,
         * * pageSize=3,
         * * size=3,
         * * startRow=4,
         * * endRow=6,
         * * total=28,
         * * pages=10,
         * * list=Page{count=true, pageNum=2, pageSize=3, startRow=3, endRow=6, total=28, pages=10, reasonable=false, pageSizeZero=false}
         * * [
         * * * Car(id=4, carNum=9999, brand=凯美瑞, guidePrice=30.3, produceTime=1999-11-10, carType=燃油车),
         * * * Car(id=5, carNum=1003, brand=丰田霸道, guidePrice=30.0, produceTime=2000-10-11, carType=燃油车),
         * * * Car(id=6, carNum=1003, brand=丰田霸道, guidePrice=30.0, produceTime=2000-10-11, carType=燃油车)
         * * ],
         * * prePage=1,
         * * nextPage=3,
         * * isFirstPage=false,
         * * isLastPage=false,
         * * hasPreviousPage=true,
         * * hasNextPage=true,
         * * navigatePages=3,
         * * navigateFirstPage=1,
         * * navigateLastPage=3,
         * * navigatepageNums=[1, 2, 3]
         * }
         */
    }

    @Test
    public void testSelectByPage() {
        // 获取每页显示的记录条数
        int pageSize = 3;
        // 显示第几页：页码
        int pageNum = 3;
        // 计算开始下标
        int startIndex = (pageNum - 1) * pageSize;

        SqlSession sqlSession = SqlSessionUtil.openSession();
        CarMapper mapper = sqlSession.getMapper(CarMapper.class);
        List<Car> cars = mapper.selectByPage(startIndex, pageSize);
        cars.forEach(car -> System.out.println(car));
        sqlSession.close();
    }

}
