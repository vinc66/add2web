package com.vinc.service.listener;

import com.vinc.service.event.RelationEvent;
import com.vinc.service.handler.FollowHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * Description:
 * User: vincent
 * Date: 2017-12-20
 * Time: 14:25
 */
@Component
public class FollowListener {

    @Autowired
    private FollowHandler handleFlow;

    @Async
    @EventListener
    public void handleContextStart(RelationEvent relationEvent) {
        handleFlow.handleFlow(relationEvent);
    }


}
