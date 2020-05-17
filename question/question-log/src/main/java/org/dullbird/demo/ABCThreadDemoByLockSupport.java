package org.dullbird.demo;

import java.util.concurrent.locks.LockSupport;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年04月22日 10:53:00
 */
public class ABCThreadDemoByLockSupport {

    public static void main(String[] args) throws InterruptedException {
        TestThreadOne a = new TestThreadOne("A");
        TestThreadOne b = new TestThreadOne("B");
        TestThreadOne c = new TestThreadOne("C");
        Thread threadA = new Thread(a);
        Thread threadB = new Thread(b);
        Thread threadC = new Thread(c);
        a.setNotifyThread(threadB);
        b.setNotifyThread(threadC);
        c.setNotifyThread(threadA);
        threadA.start();
        threadB.start();
        threadC.start();
        //todo 其实需要等待所有的线程都启动了。才能执行下面这句话
        LockSupport.unpark(threadA);
//        semaphoreA.release(1);
//        Thread.sleep(3000);
    }
}

class TestThreadOne implements Runnable{
    private Thread notifyThread;
    private String name;

    public TestThreadOne(String name) {
        this.name = name;
    }

    public Thread getNotifyThread() {
        return notifyThread;
    }

    public void setNotifyThread(Thread notifyThread) {
        this.notifyThread = notifyThread;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            LockSupport.park();
            System.out.printf("%s线程打印。。。。第%d次\n", name, count);
            count --;
            LockSupport.unpark(notifyThread);
        }
    }
}
