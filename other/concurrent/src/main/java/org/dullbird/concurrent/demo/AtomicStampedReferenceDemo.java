package org.dullbird.concurrent.demo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年05月04日 10:38:00
 */
public class AtomicStampedReferenceDemo {
    public static void main(String[] args) {
        User user = new User(1L, "mark");
        AtomicStampedReference<User> reference = new AtomicStampedReference<>(user, 0);
        User newUser = new User(2L, "joy");
        boolean b = reference.compareAndSet(user, newUser, 1, 10);
        System.out.println(b);
        System.out.println(reference.getReference());
        System.out.println(reference.getStamp());
    }
}
