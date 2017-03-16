package com.vinc.data.test;

import org.junit.Test;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 15:25 2017/3/16
 */
public class TestClazz {

    @Test
    public void testCluster() {
//        Jedis jedis = new Jedis("test.redis.in");
//        jedis.set("foo", "bar");
//        String value = jedis.get("foo");

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("ads-redis1.nhorizon.in", 6391));

        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value2 = jc.get("foo");

        int i = 9;
    }

}
