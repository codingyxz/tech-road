package com.yxz.mybatis03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;
    private String name;
    private Integer age;
    private Double height;
    private Date birth;
    private Character sex;

}
