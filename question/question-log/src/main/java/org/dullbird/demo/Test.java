package org.dullbird.demo;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月26日 15:28:00
 */
public class Test implements A,B {
    public static void main(String[] args) {
//        String temp = "sfgasdkjfhkashdfkj";
//        int i = temp.hashCode();
//        System.out.println(i);
        Test test = new Test();
        A a = test;
        a.hello();
        B b = test;
        b.hello();
    }

    @Override
    public void hello() {
        System.out.println("hahahahahs");
    }
}
interface A {
    void hello();
}
interface B {
    void hello();
}
