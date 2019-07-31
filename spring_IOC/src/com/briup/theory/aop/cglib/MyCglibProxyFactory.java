package com.briup.theory.aop.cglib;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

//产生cglib动态代理对象的工厂类
public class MyCglibProxyFactory implements MethodInterceptor {
	
	//获得动态代理对象
	public Object getInstance(Class<?> c) {
		Enhancer enhancer = new Enhancer();
		//设置谁是父类
		enhancer.setSuperclass(c);
		
		enhancer.setCallback(this);
		
		//通过字节码技术动态创建子类实例
		return enhancer.create();
	}
	
	
	//intercept方法会拦截所有代理对象中方法的调用
	//obj   参数:将来生成的代理对象
	//method参数:将来代理对象所调用的方法的镜像
	//args  参数:将来代理对象调用方法时所传的参数
	//proxy参数:该参数可以用来调用到父类中的方法
	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("log: "+method.getName()+"开始执行了..");
		
		//调用父类中的方法
		Object value = proxy.invokeSuper(obj, args);
		
		System.out.println("log: "+method.getName()+"方法执行结束..");
		
		return value;
	}
}
