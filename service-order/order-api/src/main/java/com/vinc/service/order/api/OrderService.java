package com.vinc.service.order.api;

import com.vinc.service.order.model.Order;

import java.util.List;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */
public interface OrderService {

    void addOrder(Order order);

    Order getOrder(Integer id);

    List<Order> list(Integer pid);

    void setStock(Integer pid, Integer stock);
}
