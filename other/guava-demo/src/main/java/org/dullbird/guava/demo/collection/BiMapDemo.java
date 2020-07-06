package org.dullbird.guava.demo.collection;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 21:45:00
 */
public class BiMapDemo {
    public static void main(String[] args) {
        BiMap<String, Long> biMap = HashBiMap.create();
        // 如果k和v反转的时候。发现一个v对应多个k，会报错
//        biMap.put("v1", 1L);
        biMap.put("v2", 1L);
        biMap.put("v3", 2L);
        BiMap<Long, String> inverse = biMap.inverse();
        System.out.println(biMap);
        System.out.println(inverse);
    }
}
