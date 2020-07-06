package org.dullbird.guava.demo.collection;

import com.google.common.collect.*;

import java.util.Collection;
import java.util.Map;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 17:12:00
 */
public class MultiMapDemo {
    public static void main(String[] args) {
        Multimap<Long, Long> multimap = ArrayListMultimap.create();
        multimap.put(1L, 1L);
        multimap.put(1L, 0L);
        multimap.put(2L, 0L);
        Map<Long, Collection<Long>> longCollectionMap = multimap.asMap();
        System.out.println(longCollectionMap);

    }
}
