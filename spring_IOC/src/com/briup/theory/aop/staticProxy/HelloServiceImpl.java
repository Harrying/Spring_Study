package com.briup.theory.aop.staticProxy;

//委托类(目标类)
public class HelloServiceImpl implements HelloService{

	@Override
	public void sayHello() {
		
		System.out.println("hello world");
	}

}
