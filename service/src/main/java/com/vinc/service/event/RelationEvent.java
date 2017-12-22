package com.vinc.service.event;


/**
 * Description:
 * User: vincent
 * Date: 2017-12-19
 * Time: 18:02
 */
public class RelationEvent extends VEvent {
    public RelationEvent(Object source) {
        super(source);
        System.out.println("======================RelationEvent :"+source.toString());
    }
}

