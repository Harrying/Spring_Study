package com.hairui.aop.demo6;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyAroundAdvice implements MethodInterceptor {

    public Object invoke(MethodInvocation invocation) throws Throwable {
        System.out.println("环绕前增强");

        Object obj = invocation.proceed();

        System.out.println("环绕后执行");
        return obj;
    }
}
