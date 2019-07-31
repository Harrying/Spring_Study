package com.briup.ioc.event;

import org.springframework.context.ApplicationEvent;

/**
 * 事件类
 */
public class RainEvent extends ApplicationEvent {
    public RainEvent(Object source) {
        super(source);
    }
}
