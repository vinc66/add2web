package com.vinc.service.listener;

import com.vinc.service.event.RegisterEvent;
import com.vinc.service.handler.RegisterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;


/**
 * Description:
 * User: vincent
 * Date: 2017-12-19
 * Time: 18:02
 */
@Component
public class RegisterCouponListener  {

    @Autowired
    private RegisterHandler userHandler;

//    @Override
//    public void onApplicationEvent(RegisterEvent userEvent) {
//        userHandler.handleCoupon(userEvent);
//    }


    /**
     * 异步发送事件
     * @param userEvent
     */
    @EventListener
    @Async
    public void handleContextStart(RegisterEvent userEvent) {
        userHandler.handleCoupon(userEvent);
    }

}
