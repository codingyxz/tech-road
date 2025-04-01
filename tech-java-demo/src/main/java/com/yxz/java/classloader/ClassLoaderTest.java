package com.yxz.java.classloader;

import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @Description TODO
 * @Date 2025-03-31
 * @Created by Yolo
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        String path = "file:///Users/linkk/codes/freestyle/tech-road/tech-java-demo/class/";

        URLClassLoader v1 = new URLClassLoader(new URL[]{new URL(path)});
        URLClassLoader v2 = new URLClassLoader(new URL[]{new URL(path)});

        Class printClassV1 = v1.loadClass("HelloH");
        Object printV1 = printClassV1.getConstructor().newInstance();
        printClassV1.getMethod("print").invoke(printV1);


        Class printClassV2 = v2.loadClass("HelloH");
        Object printV2 = printClassV2.getConstructor().newInstance();
        printClassV2.getMethod("print").invoke(printV2);

        System.out.println("v1：" + printClassV1.getClassLoader());
        System.out.println("v2：" + printClassV2.getClassLoader());
        System.out.println(printClassV1 == printClassV2);
        System.out.println(printClassV1.equals(printClassV2));

    }
}
