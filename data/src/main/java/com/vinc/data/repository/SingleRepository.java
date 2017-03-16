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
public class SingleRepository {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public String getName(String name) {
        return redisTemplate.opsForValue().get(name);
    }
}
