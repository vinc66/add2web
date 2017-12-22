package com.vinc.service.handler;

import com.vinc.service.event.RegisterEvent;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: vincent
 * Date: 2017-12-19
 * Time: 18:08
 */


@Component
public class RegisterHandler implements VHandler {

    public void handleEmial(RegisterEvent userEvent) {
        System.out.println("______RegisterHandler handleEmial :" + userEvent.getSource().toString());
    }

    public void handleDb(RegisterEvent userEvent) {
        System.out.println("______RegisterHandler handleDb :" + userEvent.getSource().toString());
    }

    public void handleCoupon(RegisterEvent userEvent) {
        System.out.println("______RegisterHandler handleCoupon :" + userEvent.getSource().toString());
    }
}
