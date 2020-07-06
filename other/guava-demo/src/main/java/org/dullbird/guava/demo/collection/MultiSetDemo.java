package org.dullbird.guava.demo.collection;

import com.google.common.collect.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 17:12:00
 */
public class MultiSetDemo {
    public static void main(String[] args) {
        Multiset<Long> multiset = HashMultiset.create();
        multiset.add(1L);
        multiset.add(1L);
        multiset.add(0L);
        multiset.add(2L);
        System.out.println(multiset);
        System.out.println(multiset.count(1L));

    }
}
