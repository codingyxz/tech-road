package com.yxz.java.syn;

import org.openjdk.jol.info.ClassLayout;

/**
 * @Description TODO
 * @Date 2025-03-26
 * @Created by Yolo
 */
public class BiasedLockTest {

    /**
     *
     *  -XX:-UseBiasedLocking  关闭偏向锁s
     */

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();


        new Thread(() -> {
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
            System.out.println("-------------");
            try {
                Thread.sleep(5000l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (o){
                System.out.println(ClassLayout.parseInstance(o).toPrintable());
                System.out.println("-------------");

            }

            System.out.println(ClassLayout.parseInstance(o).toPrintable());
            System.out.println("-------------");

        },"a").start();


    }

}
