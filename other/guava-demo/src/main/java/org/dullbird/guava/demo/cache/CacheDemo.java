package org.dullbird.guava.demo.cache;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;
import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年07月05日 22:00:00
 */
public class CacheDemo {
    public static void main(String[] args) {
        LoadingCache<Long, User> cache = CacheBuilder.newBuilder()
                .maximumSize(1)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build(new CacheLoader<Long, User>() {
                    @Override
                    public User load(Long key) {
                        System.out.printf("=========创建user:%d=============\n", key);
                        return new User("test", key);
                    }
                });
        User user = cache.getUnchecked(1L);
        System.out.println(user);
        System.out.println(cache.getUnchecked(1L));
        System.out.println(cache.getUnchecked(2L));
        System.out.println(cache.getUnchecked(3L));
        System.out.println(cache.size());
        try {
            Thread.sleep(4000);
            System.out.println(cache.getUnchecked(3L));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }
    @Data
    @AllArgsConstructor
    @Accessors(chain = true)
    static class User{
        private String name;
        private Long age;
    }
}
