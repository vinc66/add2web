package com.vinc.web.controller;

import com.alibaba.fastjson.JSON;
import com.vinc.domain.User;
import com.vinc.service.api.UserService;
import com.vinc.service.order.api.OrderService;
import com.vinc.service.order.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Author: vinc
 * @Description:
 * @Date: created in 18:08 2017/3/13
 */
//@Controller
//@Slf4j
//@RequestMapping("/o")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/set")
    @ResponseBody
    public String set(@RequestBody Order order) {
        orderService.addOrder(order);
        return JSON.toJSONString(order);
    }

    @RequestMapping("/get/{id}")
    @ResponseBody
    public String get(@PathVariable("id") Integer id) {
        Order order = orderService.getOrder(id);
        return JSON.toJSONString(order);
    }

    @RequestMapping("/stock")
    @ResponseBody
    public String stock(Integer pid,Integer stock) {
        orderService.setStock(pid, stock);
        return "0";
    }



}
