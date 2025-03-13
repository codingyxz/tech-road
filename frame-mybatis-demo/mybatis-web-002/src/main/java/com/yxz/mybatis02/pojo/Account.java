package com.yxz.mybatis02.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description TODO
 * @Date 2025-03-$Proxy8
 * @Created by Yolo
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account {

    private Long id;
    private String actno;
    private Double balance;

}
