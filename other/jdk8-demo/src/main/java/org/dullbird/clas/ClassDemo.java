package org.dullbird.clas;

import java.lang.reflect.Method;
import java.util.function.Consumer;

public class ClassDemo {
    /**
     * @see org.dullbird.clas.MainDemo
     * @return
     */
    public Object returnParamB() {
        /**
         * 这种场景什么下用?虽然可以返回。但是对外都是Object,
         * 只能用类信息获取 ParamB的定义或者方法
         */
        //定义class
        class ParamB {
            private Long id;

            public ParamB(Long id) {
                this.id = id;
            }

            public Long addId(Long num) {
                return id + num;
            }
        }

        //创建定义对象
        return new ParamB(15L);
    }

    public String methodOne(ParamA paramA) {
        return null;
    }

    public ParamA returnParamA() {
        return new ParamA();
    }

    private class ParamA {
        private String userName;
    }

    public static void main(String[] args) {
        // 会获取到所有的
        Method[] methods = ClassDemo.class.getMethods();
        System.out.println("============================ClassDemo.class.getMethods=====================");
        for (Method method : methods) {
            System.out.println(method);
        }
        //仅仅获取到自己声明的
        System.out.println("============================ClassDemo.class.declaredMethods=====================");
        Method[] declaredMethods = ClassDemo.class.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.println(method);
        }
        System.out.println("============================ClassDemo.class.declaredMethods=====================");
        Method enclosingMethod = ClassDemo.class.getEnclosingMethod();
        System.out.println(enclosingMethod);
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                return;
            }
        };
        System.out.println("============================Consumer consumer.class.declaredMethods=====================");
        enclosingMethod = consumer.getClass().getEnclosingMethod();
        System.out.println(enclosingMethod);
        System.out.println("============================Consumer.class.declaredMethods=====================");
        enclosingMethod = Consumer.class.getEnclosingMethod();
        System.out.println(enclosingMethod);
        System.out.println("============================ClassDemo.returnParamB.class.declaredMethods=====================");
        ClassDemo classDemo = new ClassDemo();
        Method enclosingMethod1 = classDemo.returnParamB().getClass().getEnclosingMethod();
        System.out.println(enclosingMethod1);


    }
}
