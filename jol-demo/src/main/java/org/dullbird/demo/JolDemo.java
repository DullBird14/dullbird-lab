package org.dullbird.demo;

import org.openjdk.jol.info.ClassLayout;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年03月29日 20:36:00
 */
public class JolDemo {
    private int id;
    private String name;
    public static void main(String[] args) {
        /**
         * # WARNING: Unable to attach Serviceability Agent. You can try again with escalated privileges. Two options: a) use -Djol.tryWithSudo=true to try with sudo; b) echo 0 | sudo tee /proc/sys/kernel/yama/ptrace_scope
         * org.dullbird.demo.JolDemo object internals:
         *  OFFSET  SIZE               TYPE DESCRIPTION                               VALUE
         *       0     4                    (object header)                           01 00 00 00 (00000001 00000000 00000000 00000000) (1)
         *       4     4                    (object header)                           00 00 00 00 (00000000 00000000 00000000 00000000) (0)
         *       8     4                    (object header)                           54 c4 00 f8 (01010100 11000100 00000000 11111000) (-134167468)
         *      12     4                int JolDemo.id                                0
         *      16     4   java.lang.String JolDemo.name                              null
         *      20     4                    (loss due to the next object alignment)
         * Instance size: 24 bytes
         * Space losses: 0 bytes internal + 4 bytes external = 4 bytes total
         */
        JolDemo jolDemo = new JolDemo();
        System.out.println(ClassLayout.parseInstance(jolDemo).toPrintable());

    }
}
