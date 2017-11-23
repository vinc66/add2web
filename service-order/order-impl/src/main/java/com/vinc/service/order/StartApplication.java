package com.vinc.service.order;

import com.vinc.service.order.api.OrderService;
import com.vinc.service.order.model.Order;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by wangaixu@chuchujie.com on 2017/11/22.
 */

public class StartApplication {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("spring.xml");
//        OrderService orderService = (OrderService) classPathXmlApplicationContext.getBean("orderService");
//        List<Order> list = orderService.list(2);
//        Order order = orderService.getOrder(3);
//
//        Order order2 = new Order();
//        order2.setPid(20);
//        order2.setPrice(99F);
//        order2.setUid(30);
//        orderService.addOrder(order2);
//
        while (true){}

    }
}
