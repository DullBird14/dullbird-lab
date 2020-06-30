package org.dullbird.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Objects;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月27日 17:07:00
 */
@Slf4j
public class SentinelDemo {
    public static void main(String[] args) {
        HashSet<String> sentinelHostAndPort = new HashSet<>();
        sentinelHostAndPort.add("127.0.0.1:26379");
        JedisSentinelPool pool = new JedisSentinelPool("mymaster",
                sentinelHostAndPort);
        for (int i = 0; i < 100; i++) {
            Jedis resource = null;
            try {
                Thread.sleep(1000);
                resource = pool.getResource();
                String response = resource.set("a" + i, String.valueOf(i));
                log.info("======response-{}========:{}", i, response);
            } catch (Exception e) {
                i--;
                log.info("{}", e);
            } finally {
                if (Objects.nonNull(resource)) {
                    resource.close();
                }
            }
        }

    }
}
