package com.vinc.service.order.impl;

import com.alibaba.fastjson.JSON;
import com.vinc.service.order.api.OrderService;
import com.vinc.service.order.exception.AddOrderException;
import com.vinc.service.order.mapper.OrderMapper;
import com.vinc.service.order.model.Order;
import com.vinc.service.order.repository.DistributeLock;
import com.vinc.service.order.repository.KeyUtis;
import com.vinc.service.order.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderRepository orderRepository;


    @Autowired
    private DistributeLock distributeLock;

    @Override
    public List<Order> list(Integer pid) {
        Order order = orderMapper.selectByPrimaryKey(2);
        return Arrays.asList(order);
    }


    /**
     * 确保db cache一致性
     *
     * @param order
     */
    @Override
    public void addOrder(Order order) {
        try {
            orderMapper.insertSelective(order);
        } catch (AddOrderException e) {
            throw new AddOrderException("AddOrder error");
        }
        for (int i = 0; i < 5; i++) {
            try {
                orderRepository.setWithJSon(KeyUtis.order(order.getId()), order);
                orderRepository.addOrderListRedis(order);
                log.error("addOrderListRedis opsForZSet success");
                break;
            } catch (AddOrderException e) {
                log.error("addOrderListRedis opsForZSet error times :{}", i);
                //第四次还没有成功 扔mq中，异步加载
                if (i == 4)
                    orderRepository.sendOrderCacheMQ(order);
            }
        }
    }

    @Override
    public Order getOrder(Integer id) {
        Order order = null;
        String jsonStr = orderRepository.get(KeyUtis.order(id));
        if (jsonStr == null) {
            log.info("product :{} cross db",id);
            order = orderMapper.selectByPrimaryKey(id);
            orderRepository.setWithJSon(KeyUtis.order(id), order == null ? "" : order);
            return order;
        } else {
            if (StringUtils.equals("", jsonStr)) {
                log.info("order :{},not exits in redis ", id);
            } else {
                order = JSON.parseObject(jsonStr, Order.class);
            }
        }
        return order;
    }

    //使用分布式锁
    @Override
    public void setStock(Integer pid, Integer stock) {
        if (pid == null || stock == null)
            throw new RuntimeException("set stock param error....");
        if (distributeLock.getLock(KeyUtis.stockLock(pid))) {
            int stockOld = getStock(pid);
            if (stockOld >= stock) {
                orderRepository.setStock(pid, stock);
                log.info("set stock success ,pid :{} ,stock :{} ,existStock :{}", pid, stock, stockOld);
            } else {
                log.info("stock not enought, pid :{} ,stock :{} ,existStock :{}", pid, stock, stockOld);
            }
            distributeLock.release(KeyUtis.stockLock(pid));
        }
    }

    private int getStock(int pid) {
        Integer stock = orderRepository.getStock(pid);
        if (stock == null) {
            log.info("product :{} stock not exists!", pid);
            return 0;
        }
        return stock;
    }
}
