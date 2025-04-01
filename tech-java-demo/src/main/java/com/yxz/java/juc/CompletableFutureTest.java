package com.yxz.java.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

/**
 * @Description TODO
 * @Date 2025-03-20
 * @Created by Yolo
 */
public class CompletableFutureTest {

    @Test
    public void testThenXX() {

        System.out.println(
                CompletableFuture
                        .supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName() + " supplyAsync");
                            return "A";
                        })
                        .thenRun(() -> System.out.println(Thread.currentThread().getName() + " thenRun"))
                        .join()
        );

        System.out.println("--------");

        System.out.println(
                CompletableFuture
                        .supplyAsync(() -> {
                            System.out.println(Thread.currentThread().getName() + " supplyAsync");
                            return "B";
                        })
                        .thenAccept(r -> System.out.println(Thread.currentThread().getName() + " thenAccept--" + r))
                        .join()
        );

    }

}
