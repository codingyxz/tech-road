package com.yxz.java.bytecode.bytebuddy;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.FixedValue;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * @Description TODO
 * @Date 2025-04-01
 * @Created by Yolo
 */
public class CreatePerson {

    public static void main(String[] args) {

        try {
            createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void createPerson() throws Exception {

        // 输出到class文件
        new ByteBuddy().subclass(Object.class)
                .name("com.yxz.java.bytecode.bytebuddy.Person")
                .defineMethod("sayHello", String.class, Modifier.PUBLIC)
                .intercept(FixedValue.value("hello world"))
                .make()
                .saveIn(new File("/Users/linkk/codes/freestyle/tech-road/tech-java-demo/src/main/java"));


        // 内存中生成person示例，并执行方法
        Object person = new ByteBuddy().subclass(Object.class)
                .name("com.yxz.java.bytecode.bytebuddy.Person")
                .defineMethod("sayHello", String.class, Modifier.PUBLIC)
                .intercept(FixedValue.value("hello world"))
                .make()
                .load(ClassLoader.getSystemClassLoader())
                .getLoaded()
                .getConstructor()
                .newInstance();


        Method sayHello = person.getClass().getMethod("sayHello");
        System.out.println(sayHello.invoke(person));
    }

}
