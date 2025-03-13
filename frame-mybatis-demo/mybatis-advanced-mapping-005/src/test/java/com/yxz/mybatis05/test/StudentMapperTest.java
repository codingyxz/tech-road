package com.yxz.mybatis05.test;

import com.yxz.mybatis05.mapper.StudentMapper;
import com.yxz.mybatis05.pojo.Student;
import com.yxz.mybatis05.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public class StudentMapperTest {
    @Test
    public void testSelectByIdStep1() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdStep1(5);
//        System.out.println(student);

        // 只需要看学生的名字
        System.out.println(student.getSname());

        // 程序执行到这里了，我想看看班级的名字
        System.out.println(student.getClazz().getCname());

        sqlSession.close();
    }

    @Test
    public void testSelectByIdAssociation() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectByIdAssociation(4);
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectById() {
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = mapper.selectById(1);
        /*System.out.println(student.getSid());
        System.out.println(student.getSname());
        System.out.println(student.getClazz().getCid());
        System.out.println(student.getClazz().getCname());*/

        System.out.println(student);
        sqlSession.close();
    }
}
