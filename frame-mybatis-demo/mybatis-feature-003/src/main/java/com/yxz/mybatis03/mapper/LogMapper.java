package com.yxz.mybatis03.mapper;

import com.yxz.mybatis03.pojo.Log;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public interface LogMapper {

    /**
     * 根据日期查询不同的表。获取表中所有的日志。
     * @param date
     * @return
     */
    List<Log> selectAllByTable(String date);

}
