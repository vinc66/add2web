package com.vinc.service.handler;

import com.vinc.service.event.RegisterEvent;
import com.vinc.service.event.RelationEvent;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: vincent
 * Date: 2017-12-19
 * Time: 18:08
 */


@Component
public class FollowHandler implements VHandler {

    public void handleFlow(RelationEvent userEvent) {
        System.out.println("________FollowHandler  handleFlow :" + userEvent.getSource());
    }
}
