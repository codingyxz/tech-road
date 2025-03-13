package com.yxz.mybatis05.mapper;

import com.yxz.mybatis05.pojo.Clazz;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public interface ClazzMapper {

    /**
     * 分步查询。第一步：根据班级编号获取班级信息。
     * @param cid 班级编号
     * @return
     */
    Clazz selectByStep1(Integer cid);

    /**
     * 根据班级编号查询班级信息。
     * @param cid
     * @return
     */
    Clazz selectByCollection(Integer cid);


    /**
     * 分步查询第二步：根据cid获取班级信息。
     * @param cid
     * @return
     */
    Clazz selectByIdStep2(Integer cid);

}
