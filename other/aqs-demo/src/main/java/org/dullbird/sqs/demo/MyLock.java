package org.dullbird.sqs.demo;

import java.util.concurrent.locks.AbstractQueuedSynchronizer;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月16日 20:39:00
 */
public class MyLock extends AbstractQueuedSynchronizer {
    public MyLock(int num) {
        setState(num);
    }

    @Override
    protected int tryAcquireShared(int arg) {
        return getState() == 0 ? 0 :-1;
    }

    @Override
    protected boolean tryReleaseShared(int arg) {
        while (true) {
            int state = getState();
            if (state == 0) {
                return false;
            }
            int newValue = state - 1;
            if (compareAndSetState(state, newValue)) {
                return newValue == 0;
            }
        }
    }

    public long getCount() {
        return getState();
    }

    public void await() throws InterruptedException {
        acquireSharedInterruptibly(1);
    }

    public void countDown() {
        releaseShared(1);
    }
}
