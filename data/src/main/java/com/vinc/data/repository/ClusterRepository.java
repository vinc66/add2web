package com.vinc.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:06 2017/3/15
 */
@Component
public class ClusterRepository {

    @Autowired
    private StringRedisTemplate redisClusterTemplate;

    public String getClusterName(String name) {
        return redisClusterTemplate.opsForValue().get(name);
    }
}
