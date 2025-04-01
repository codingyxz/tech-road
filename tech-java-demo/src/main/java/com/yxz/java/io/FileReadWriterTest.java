package com.yxz.java.io;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;

/**
 * @Description TODO
 * @Date 2025-03-17
 * @Created by Yolo
 */
public class FileReadWriterTest {

    public <T> String getStr(T t) {
        return null;
    }


    @Test
    public void testRead() throws IOException {

        File file = new File("k.txt");

        FileReader fr = new FileReader(file);

        char[] buffer = new char[5];

        int length = fr.read(buffer);
        while (length != -1) {
            System.out.println("length: " + length);
            for (int i = 0; i < length; i++) {
                System.out.println(buffer[i]);
            }
            length = fr.read(buffer);
        }

        System.out.println("length: " + length);

    }

}
