package com.yxz.java.bytecode.javassist;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;

import java.lang.reflect.Method;

/**
 * @Description TODO
 * @Date 2025-04-01
 * @Created by Yolo
 */
public class PersonServiceUpdate {

    public static void main(String[] args) {
        try {
            update();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void update() throws Exception {
        ClassPool pool = ClassPool.getDefault();
        CtClass ctClass = pool.get("com.yxz.java.bytecode.javassist.PersonService");

        CtMethod personFly = ctClass.getDeclaredMethod("personFly");
        personFly.insertBefore("System.out.println(\"起飞之前准备降落伞\");");
        personFly.insertAfter("System.out.println(\"成功落地。。。\");");

        // 新增一个方法
        CtMethod joinFriend = new CtMethod(CtClass.voidType, "joinFriend", new CtClass[]{}, ctClass);
        joinFriend.setModifiers(Modifier.PUBLIC);
        joinFriend.setBody("{System.out.println(\"I want to be your friend\");}");
        ctClass.addMethod(joinFriend);

        Object personService = ctClass.toClass().newInstance();
        // 调用personFly方法
        Method executePersonFly = personService.getClass().getMethod("personFly");
        executePersonFly.invoke(personService);

        // 调用新增的joinFriend方法
        Method executeJoinFriend = personService.getClass().getMethod("joinFriend");
        executeJoinFriend.invoke(personService);


    }

}
