package com.yxz.mybatis03.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description TODO
 * @Date 2025-03-11
 * @Created by Yolo
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Log {
    private Integer id;
    private String log;
    private String time;
}
