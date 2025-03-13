package com.yxz.mybatis03.test;

import com.yxz.mybatis03.mapper.StudentMapper;
import com.yxz.mybatis03.pojo.Student;
import com.yxz.mybatis03.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
public class StudentMapperTest {

    @Test
    public void testSelectByNameAndSex2(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        // mapper实际上指向了代理对象
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        // mapper是代理对象
        // selectByNameAndSex2是代理方法
        List<Student> students = mapper.selectByNameAndSex2("张飞", '女');
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testSelectByNameAndSex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByNameAndSex("张飞", '女');
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testInsertStudentByPOJO(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        // POJO对象
        Student student = new Student();
        student.setName("张飞");
        student.setAge(50);
        student.setSex('女');
        student.setBirth(new Date());
        student.setHeight(10.0);

        mapper.insertStudentByPOJO(student);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void testInsertStudentByMap(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<>();
//        map.put("姓名", "赵六");
//        map.put("年龄", 20);
//        map.put("身高", 1.81);
//        map.put("性别", '男');
//        map.put("生日", new Date());
        map.put("姓名", "zhang3");
        map.put("年龄", 22);
        map.put("身高", 1.79);
        map.put("性别", '女');
        map.put("生日", new Date());

        mapper.insertStudentByMap(map);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelectBySex(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        // char --> Character
        Character sex = Character.valueOf('男');
        List<Student> students = mapper.selectBySex(sex);

        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    // java.util.Date java.sql.Date，他们都是简单类型。
    @Test
    public void testSelectByBirth() throws Exception{
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date birth = sdf.parse("2025-03-11");

        List<Student> students = mapper.selectByBirth(birth);

        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

    @Test
    public void testSelectByName(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("zhang3");
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }
    @Test
    public void testSelectById(){
        SqlSession sqlSession = SqlSessionUtil.openSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectById(1L);
        students.forEach(student -> System.out.println(student));
        sqlSession.close();
    }

}
