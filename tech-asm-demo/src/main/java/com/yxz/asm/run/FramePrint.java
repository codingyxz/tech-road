package com.yxz.asm.run;

import com.yxz.asm.common.MethodStackMapFrameVisitor;
import com.yxz.asm.util.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Opcodes;


/**
 * 打印方法的操作数栈帧与本地变量表
 */
public class FramePrint {

    public static void main(String[] args) {
        String relative_path = "sample/HelloWorldForEdit.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes = FileUtils.readBytes(filepath);

        //（1）构建ClassReader
        ClassReader cr = new ClassReader(bytes);

        //（2）构建ClassVisitor
        int api = Opcodes.ASM9;
        ClassVisitor cv = new MethodStackMapFrameVisitor(api, null);

        //（3）结合ClassReader和ClassVisitor
        int parsingOptions = ClassReader.EXPAND_FRAMES; // 注意，这里使用了EXPAND_FRAMES
        cr.accept(cv, parsingOptions);
    }
}
