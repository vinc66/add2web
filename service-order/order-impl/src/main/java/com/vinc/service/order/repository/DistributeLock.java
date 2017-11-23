package com.vinc.service.order.repository;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * 分布式锁
 * Created by wangaixu@chuchujie.com on 2017/11/23.
 */
@Component
@Slf4j
public class DistributeLock {
    @Autowired
    private StringRedisTemplate redisTemplate;

    public static final String DEFAULT_VALUE = "1";
    //    锁失效时间，防止死锁
    public static final int DEFAULT_EXPIRE_TIME = 10;
    //    获取锁的最大时间
    public static final int DEFAULT_TIMEOUT = 10 * 1000;
    //    轮询获取锁的时间间隔
    public static final int DEFAULT_INTERNAL = 10;


    public boolean getLock(String key) {

        if (StringUtils.isBlank(key))
            return false;
        long start = System.currentTimeMillis();
        while (true) {
            if (redisTemplate.opsForValue().setIfAbsent(key, DEFAULT_VALUE)) {
                redisTemplate.expire(key, DEFAULT_EXPIRE_TIME, TimeUnit.SECONDS);
                log.info("{} get lock", Thread.currentThread().getName());
                return true;
            }
            if (System.currentTimeMillis() - start > DEFAULT_TIMEOUT) {
                return false;
            }
            try {
                Thread.sleep(DEFAULT_INTERNAL);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void release(String key) {
        redisTemplate.delete(key);
        log.info("lock release key :{}", key);
    }
}
