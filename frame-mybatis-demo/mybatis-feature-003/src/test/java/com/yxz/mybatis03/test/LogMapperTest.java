package com.yxz.mybatis03.test;

import com.yxz.mybatis03.mapper.LogMapper;
import com.yxz.mybatis03.pojo.Log;
import com.yxz.mybatis03.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public class LogMapperTest {

    @Test
    public void testSelectAllByTable() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        LogMapper mapper = sqlSession.getMapper(LogMapper.class);
//        List<Log> logs = mapper.selectAllByTable("20250311");
        List<Log> logs = mapper.selectAllByTable("20250312");
        logs.forEach(log -> System.out.println(log));
    }

}
