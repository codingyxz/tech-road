package com.yxz.mybatis02.exception;

/**
 * @Description 余额不足异常
 * @Date 2025-03-$Proxy8
 * @Created by Yolo
 */
public class MoneyNotEnoughException extends Exception {

    public MoneyNotEnoughException() {
    }

    public MoneyNotEnoughException(String message) {
        super(message);
    }
}
