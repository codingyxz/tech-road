package com.yxz.java.juc;

import java.util.concurrent.*;

/**
 * @Description TODO
 * @Date 2025-03-21
 * @Created by Yolo
 */
public class FutureTaskTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println(Thread.currentThread().getName() + "--------");
            return "xxx";
        });

        Future<?> future = executorService.submit(task);

        System.out.println(task.get());
        System.out.println(future.get());


        Thread.sleep(5000l);


    }

}
