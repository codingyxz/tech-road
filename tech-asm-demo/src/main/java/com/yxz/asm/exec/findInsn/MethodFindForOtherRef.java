package com.yxz.asm.exec.findInsn;

import com.yxz.asm.util.FileUtils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

import java.util.ArrayList;
import java.util.List;

import static org.objectweb.asm.Opcodes.ACC_ABSTRACT;
import static org.objectweb.asm.Opcodes.ACC_NATIVE;

public class MethodFindForOtherRef {

    public static void main(String[] args) {
        findInvokeMethods();
    }

    public static void findInvokeMethods() {
        String relative_path = "sample/HelloWorldForOtherRef.class";
        String filepath = FileUtils.getFilePath(relative_path);
        byte[] bytes1 = FileUtils.readBytes(filepath);

        //（1）构建ClassReader
        ClassReader cr = new ClassReader(bytes1);

        //（2）分析ClassVisitor
        int api = Opcodes.ASM9;
        ClassVisitor cv = new MethodFindRefVisitor(api, null, "sample/HelloWorldForOtherRef", "test", "(III)V");

        //（4）结合ClassReader和ClassVisitor
        int parsingOptions = ClassReader.SKIP_DEBUG | ClassReader.SKIP_FRAMES;
        cr.accept(cv, parsingOptions);
    }

    static class MethodFindRefVisitor extends ClassVisitor {
        private final String methodOwner;
        private final String methodName;
        private final String methodDesc;

        private String owner;
        private final List<String> resultList = new ArrayList<>();

        public MethodFindRefVisitor(int api, ClassVisitor classVisitor, String methodOwner, String methodName, String methodDesc) {
            super(api, classVisitor);
            this.methodOwner = methodOwner;
            this.methodName = methodName;
            this.methodDesc = methodDesc;
        }

        @Override
        public void visit(int version, int access, String name, String signature, String superName, String[] interfaces) {
            super.visit(version, access, name, signature, superName, interfaces);
            this.owner = name;
        }

        @Override
        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
            boolean isAbstractMethod = (access & ACC_ABSTRACT) != 0;
            boolean isNativeMethod = (access & ACC_NATIVE) != 0;
            if (!isAbstractMethod && !isNativeMethod) {
                return new MethodFindRefAdaptor(api, null, owner, name, descriptor);
            }
            return null;
        }

        @Override
        public void visitEnd() {
            // 首先，处理自己的代码逻辑
            for (String item : resultList) {
                System.out.println(item);
            }

            // 其次，调用父类的方法实现
            super.visitEnd();
        }

        private class MethodFindRefAdaptor extends MethodVisitor {
            private final String currentMethodOwner;
            private final String currentMethodName;
            private final String currentMethodDesc;

            public MethodFindRefAdaptor(int api, MethodVisitor methodVisitor, String currentMethodOwner, String currentMethodName, String currentMethodDesc) {
                super(api, methodVisitor);
                this.currentMethodOwner = currentMethodOwner;
                this.currentMethodName = currentMethodName;
                this.currentMethodDesc = currentMethodDesc;
            }

            @Override
            public void visitMethodInsn(int opcode, String owner, String name, String descriptor, boolean isInterface) {
                // 首先，处理自己的代码逻辑
                if (methodOwner.equals(owner) && methodName.equals(name) && methodDesc.equals(descriptor)) {
                    String info = String.format("%s.%s%s", currentMethodOwner, currentMethodName, currentMethodDesc);
                    if (!resultList.contains(info)) {
                        resultList.add(info);
                    }
                }

                // 其次，调用父类的方法实现
                super.visitMethodInsn(opcode, owner, name, descriptor, isInterface);
            }
        }
    }
}
