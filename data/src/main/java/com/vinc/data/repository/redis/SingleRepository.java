package com.vinc.data.repository.redis;

import com.alibaba.fastjson.JSONObject;
import com.vinc.domain.redis.Slot;
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

    public Slot getSlot(String id) {
        return JSONObject.parseObject(redisTemplate.opsForValue().get(KeyUtis.getSlot(id)), Slot.class);
      }

}
