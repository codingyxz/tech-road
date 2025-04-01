package com.yxz.java.classloader;

import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * * loadClass：JVM在加载类的时候，都是通过ClassLoader的loadClass()方法来加载class的，
 * *            loadClass使用双亲委派模式。如果要改变双亲委派模式，可以修改loadClass来改
 * *            变class的加载方式。双亲委派模式这里就不赘述了。
 * * findClass：ClassLoader通过findClass()方法来加载类。自定义类加载器实现这个方法来加
 * *            载需要的类，比如指定路径下的文件，字节流等。
 * * definedClass：definedClass在findClass中使用，通过调用传进去一个Class文件的字节数组，
 * *               就可以方法区生成一个Class对象，也就是findClass实现了类加载的功能了。
 */
public class CustomMyClassLoader extends ClassLoader {

    private String path;

    public CustomMyClassLoader(String path) {
        this.path = path;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClass(name);
            if (result == null) {
                throw new ClassNotFoundException();
            } else {
                return defineClass(name, result, 0, result.length);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private byte[] getClass(String name) {
        try {
            return Files.readAllBytes(Paths.get(this.path, name + ".class"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        CustomMyClassLoader myClassLoader = new CustomMyClassLoader("/Users/linkk/codes/freestyle/tech-road/tech-java-demo/class/");
        Class clazz = myClassLoader.loadClass("HelloH");
        Object obj = clazz.getConstructor().newInstance();
        System.out.println(obj);
        System.out.println(obj.getClass().getClassLoader());

    }

}
