package com.briup.theory.aop.staticProxy;

//代理类
public class HelloServiceProxy implements HelloService{
	//代理类对象中需要关联目标类对象
	private HelloService target;
	
	public HelloServiceProxy(HelloService target) {
		this.target = target;
	}

	@Override
	public void sayHello() {
		
		//在真正调用目标对象的sayHello方法之前添加日志代码
		System.out.println("log:sayHello马上要执行了...");
		
		target.sayHello();
		
	}
	
}
