package com.briup.ioc.event;

import org.springframework.context.ApplicationListener;

public class RainListener implements ApplicationListener<RainEvent> {
    @Override
    public void onApplicationEvent(RainEvent rainEvent) {
        //event.getSource()获取事件源
        System.out.println("唐僧大喊：" + rainEvent.getSource() + "赶快收衣服喽！");
    }
}
