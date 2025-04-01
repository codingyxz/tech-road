package com.yxz.java.syn;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description TODO
 * @Date 2025-03-25
 * @Created by Yolo
 */
public class JOLTest {

    public static void main(String[] args) {

        Object o = new Object();
        ObjectTest test = new ObjectTest();

        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println("-----------------------");

        System.out.println(ClassLayout.parseInstance(test).toPrintable());
    }


    static class ObjectTest {
        private int age;
        private boolean flag;
    }

}
