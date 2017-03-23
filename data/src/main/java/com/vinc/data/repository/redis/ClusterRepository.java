package com.vinc.data.repository.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:06 2017/3/15
 */
//@Component
public class ClusterRepository {

    @Autowired
    private StringRedisTemplate redisClusterTemplate;

    public String getClusterName(String id) {
        return redisClusterTemplate.opsForValue().get(KeyUtis.getBook(id));
    }

}
