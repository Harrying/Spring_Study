package com.briup.theory.aop.cglib;

public class TestCglibProxy {
	public static void main(String[] args) {  
		//产生cglib的动态代理对象的工厂类
        MyCglibProxyFactory factory = new MyCglibProxyFactory();  
        
        BookService proxy= 
        	(BookService)factory.getInstance(BookService.class);  
        
        proxy.addBook();  
        
        System.out.println("------------------");
        System.out.println(proxy.getClass());
    }  
}
