package com.vinc.service.event;

/**
 * Description:
 * User: vincent
 * Date: 2017-12-19
 * Time: 18:02
 */
public class RegisterEvent extends VEvent {
    public RegisterEvent(Object source) {
        super(source);
        System.out.println("======================RegisterEvent :"+source.toString());
    }
}

