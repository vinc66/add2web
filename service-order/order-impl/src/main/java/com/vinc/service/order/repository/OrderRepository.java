package com.vinc.service.order.repository;

import com.alibaba.fastjson.JSON;
import com.vinc.service.order.exception.AddOrderException;
import com.vinc.service.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.TimeoutUtils;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:06 2017/3/15
 */
@Component
@Slf4j
public class OrderRepository {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public void addOrderListRedis(Order order) {
        if (order == null || order.getUid() == null || order.getId() == null)
            throw new AddOrderException("order param error");
        String key = KeyUtis.userOrderList(order.getUid());
        String value = JSON.toJSONString(order);
        double score = order.getId().doubleValue();
        try {
            redisTemplate.opsForZSet().add(key, value, score);
        } catch (Exception e) {
            log.error("addOrderListRedis opsForZSet error，key:{},value:{},score:{}", key, value, score);
        }
    }


    public void sendOrderCacheMQ(Order order) {
        //fixme
//        redisTemplate.opsForList().leftPush()
        log.info("to ordercachemq");
    }

    public Integer getStock(int pid) {
        String stockStr = redisTemplate.opsForValue().get(KeyUtis.productStock(pid));
        if (StringUtils.isBlank(stockStr))
            return null;
        return NumberUtils.toInt(stockStr);
    }


    public void setStock(Integer pid, Integer stock) {
        redisTemplate.opsForValue().increment(KeyUtis.productStock(pid), -stock);
    }

    public void setWithJSon(String key, Object obj) {
        redisTemplate.opsForValue().set(key,JSON.toJSONString(obj));
    }


    public String get(String key) {
        return redisTemplate.opsForValue().get(key);
    }
}
