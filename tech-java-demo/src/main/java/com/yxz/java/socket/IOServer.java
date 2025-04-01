package com.yxz.java.socket;

import lombok.extern.slf4j.Slf4j;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description TODO
 * @Date 2025-03-17
 * @Created by Yolo
 */

@Slf4j
public class IOServer {

    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8888);
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Socket socket = null;
        while ((socket = serverSocket.accept()) != null) {
            log.info("建立连接：" + socket);
            Socket finalSocket = socket;
            executorService.submit(() -> {
                DataInputStream is;
                PrintStream ps;
                try {
                    is = new DataInputStream(finalSocket.getInputStream());
                    ps = new PrintStream(finalSocket.getOutputStream());
                    log.info("构建接收发送流完成......");
                    while (true) {
                        String line = is.readLine();
                        log.info(line);
                        ps.println("response：" + line);
                    }
                } catch (IOException ex) {
                    System.out.println(ex);
                }
            });

        }

        System.out.println(".......");

        Thread.sleep(1000000000l);

    }
}
