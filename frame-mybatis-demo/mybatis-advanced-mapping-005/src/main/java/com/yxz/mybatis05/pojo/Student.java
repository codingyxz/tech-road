package com.yxz.mybatis05.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    private Integer sid;
    private String sname;
    private Clazz clazz; // Clazz是一的一方。

}
