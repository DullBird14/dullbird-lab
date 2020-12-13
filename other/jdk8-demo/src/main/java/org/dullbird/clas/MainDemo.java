package org.dullbird.clas;

import java.util.Arrays;

public class MainDemo {
    public static void main(String[] args) {
        ClassDemo classDemo = new ClassDemo();
        Object o = classDemo.returnParamB();
        System.out.println(o.getClass());
        System.out.println(Arrays.toString(o.getClass().getDeclaredMethods()));

    }
}
