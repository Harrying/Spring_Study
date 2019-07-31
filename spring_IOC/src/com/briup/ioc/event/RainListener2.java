package com.briup.ioc.event;

import org.springframework.context.ApplicationListener;

public class RainListener2 implements ApplicationListener<RainEvent> {
    @Override
    public void onApplicationEvent(RainEvent rainEvent) {
        //event.getSource()获取事件源
        System.out.println("我们：" + rainEvent.getSource() + "太好了不用上课了！");
    }
}
