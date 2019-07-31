package com.hairui.aop.demo1;

import org.junit.Test;

public class SpringDemo1 {

    @Test
    public void demo1(){
        UserDao userDao = new UserDaoImpl();

        UserDao proxy = (UserDao) new MyJdkProxy(userDao).createProxy();

        proxy.save();
        proxy.delete();
        proxy.update();
        proxy.find();
    }
}
