package org.dullbird.concurrent.demo;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月04日 10:43:00
 */
public class AtomicLongFieldUpdaterDemo {
    public static void main(String[] args) {
        User user = new User(1L, "mark");
        User newUser = new User(2L, "joy");
        AtomicLongFieldUpdater<User> updater = AtomicLongFieldUpdater.newUpdater(User.class, "id");
//        updater.set(user, );
        long l = updater.get(user);
        System.out.println(l);
    }
}
