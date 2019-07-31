package com.hairui.aop.demo1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyJdkProxy implements InvocationHandler {
    private UserDao userDao;

    public MyJdkProxy(UserDao userDao){
        this.userDao=userDao;
    }

    public Object createProxy(){
        //jdk动态代理 只能对实现接口的类实现代理
        //newProxyInstance的三个参数：类加载器，实现的接口,InvocationHandler接口
        Object proxy = Proxy.newProxyInstance(userDao.getClass().getClassLoader(), userDao.getClass().getInterfaces(), this);
        return proxy;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if ("save".equals(method.getName())){
            System.out.println("权限校验通过。。。");
            return method.invoke(userDao,args);
        }
        return method.invoke(userDao,args);
    }
}
