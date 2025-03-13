package com.yxz.mybatis05.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @Description TODO
 * @Date 2025-03-13
 * @Created by Yolo
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clazz {

    private Integer cid;
    private String cname;

    private List<Student> stus;
}
