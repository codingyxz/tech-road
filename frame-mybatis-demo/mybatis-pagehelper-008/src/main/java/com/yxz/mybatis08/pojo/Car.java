package com.yxz.mybatis08.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @Description 汽车实体类
 * @Date 2025-03-11
 * @Created by Yolo
 */

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Car implements Serializable {
    // 数据库表当中的字段应该和pojo类的属性一一对应。
    // 建议使用包装类，这样可以防止null的问题。
    private Long id;
    private String carNum;
    private String brand;
    private Double guidePrice;
    private String produceTime;
    private String carType;

}
