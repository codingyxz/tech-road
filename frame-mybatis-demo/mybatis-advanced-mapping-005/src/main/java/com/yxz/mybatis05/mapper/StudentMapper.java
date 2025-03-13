package com.yxz.mybatis05.mapper;

import com.yxz.mybatis05.pojo.Student;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */
public interface StudentMapper {

    /**
     * 根据班级编号查询学生信息。
     * @param cid
     * @return
     */
    List<Student> selectByCidStep2(Integer cid);

    /**
     * 分部查询第一步：先根据学生的sid查询学生的信息。
     * @param sid
     * @return
     */
    Student selectByIdStep1(Integer sid);

    /**
     * 一条SQL语句，association
     * @param id
     * @return
     */
    Student selectByIdAssociation(Integer id);

    /**
     * 根据id获取学生信息。同时获取学生关联的班级信息。
     * @param id 学生的id
     * @return 学生对象，但是学生对象当中含有班级对象。
     */
    Student selectById(Integer id);


}
