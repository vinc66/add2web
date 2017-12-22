package com.vinc.service.event;

import org.springframework.context.ApplicationEvent;

/**
 * Description:
 * User: vincent
 * Date: 2017-12-20
 * Time: 11:26
 */
public class VEvent extends ApplicationEvent {
    public VEvent(Object source) {
        super(source);
    }
}
