package com.yxz.java.bytecode.javassist;

import javassist.*;

import java.lang.reflect.Method;

/**
 * @Description javassist生成字节码演示
 * @Date 2025-04-01
 * @Created by Yolo
 */
public class GeneratePerson {

    public static void main(String[] args) {
        try {
            createPerson();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建一个Person类
     *
     * @throws Exception
     */
    public static void createPerson() throws Exception {
        ClassPool pool = ClassPool.getDefault();

        // 1、创建一个空类
        CtClass ctClass = pool.makeClass("com.yxz.java.bytecode.javassist.Person");

        // 2、新增一个字段 private String name
        // 字段名为name
        CtField name = new CtField(pool.get("java.lang.String"), "name", ctClass);
        // 访问级别是 private
        name.setModifiers(Modifier.PRIVATE);
        // 初始值为 zhang3
        ctClass.addField(name, CtField.Initializer.constant("zhang3"));

        // 3、生成getter、setter方法
        ctClass.addMethod(CtNewMethod.setter("setName", name));
        ctClass.addMethod(CtNewMethod.getter("getName", name));

        // 4、添加无参的构造器
        CtConstructor noArgsConstructor = new CtConstructor(new CtClass[]{}, ctClass);
        noArgsConstructor.setBody("{name = \"li4\";}");
        ctClass.addConstructor(noArgsConstructor);

        // 5、添加有参构造器
        CtConstructor withArgsConstructor = new CtConstructor(new CtClass[]{pool.get("java.lang.String")}, ctClass);
        withArgsConstructor.setBody("{$0.name = $1;}");
        ctClass.addConstructor(withArgsConstructor);

        // 6、创建一个名为printName方法，无参数、无返回值、输出name值
        CtMethod printName = new CtMethod(CtClass.voidType, "printName", new CtClass[]{}, ctClass);
        printName.setModifiers(Modifier.PUBLIC);
        printName.setBody("{System.out.println(name);}");
        ctClass.addMethod(printName);

        // 这里会将这个创建的类对象编译为.class文件
        ctClass.writeFile("/Users/linkk/codes/freestyle/tech-road/tech-java-demo/src/main/java");


        /*------------------------------------------------------------------------------------------------------------*/

        // 通过反射的方式调用
        // 这里不写入文件，直接实例化
        Object person = ctClass.toClass().newInstance();
        // 设置值
        Method setName = person.getClass().getMethod("setName", String.class);
        setName.invoke(person, "wang5");
        // 调用方法输出
        Method execute = person.getClass().getMethod("printName");
        execute.invoke(person);

    }
}
