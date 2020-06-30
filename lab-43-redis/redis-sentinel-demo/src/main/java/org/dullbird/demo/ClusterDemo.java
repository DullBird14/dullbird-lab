package org.dullbird.demo;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dullBird
 * @version 1.0.0
 * @createTime 2020年06月27日 21:29:00
 */
@Slf4j
public class ClusterDemo {
    public static void main(String[] args) {
        Set<HostAndPort> hostAndPortSet = new HashSet<>();
        hostAndPortSet.add(new HostAndPort("127.0.0.1", 7000));
        hostAndPortSet.add(new HostAndPort("127.0.0.1", 7001));
        hostAndPortSet.add(new HostAndPort("127.0.0.1", 7002));
        try (JedisCluster cluster = new JedisCluster(hostAndPortSet, 1000)) {
            for (int i = 0; i < 1000; i++) {
                String response = cluster.set("c" + i, String.valueOf(i));
                log.info("================response:{}==========={}", response, i);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            log.error("{}", e);
        }
    }
}
