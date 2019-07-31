package com.briup.jtest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.aop.service.AccountServiceImpl;
import com.briup.aop.service.IAccountService;

@SuppressWarnings("all")
public class AopTest {
	// advice : 通知/拦截器
	// 知识点: aop中的前置通知/前拦截器
	@Test
	public void aop_before() {
		try {
			String path = "com/briup/aop/before/before.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点: aop中的后置通知/前拦截器
	@Test
	public void aop_after() {
		try {
			String path = "com/briup/aop/after/after.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点: aop中的环绕通知/环绕截器
	@Test
	public void aop_around() {

		try {
			String path = "com/briup/aop/around/around.xml";

			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点: aop中的异常通知/异常截器
	@Test
	public void aop_throwException() {
		try {
			String path = "com/briup/aop/throwException/throwing.xml";

			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:aop中增强器的使用
	// 增强器的作用:
	// 默认情况下,代理对象会代理目标对象中非final修饰的方法
	// 增强器可以帮我们去筛选代理对象要代理目标对象中的那些方法
	@Test
	public void aop_advisor() {

		try {
			String path = "com/briup/aop/advisor/advisor.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:自动产生代理对象
	// 自动代理会把当前xml中配置的所有的对象全代理了
	// 注意:一定是在使用了advisor的基础上才能使用这个自动代理
	@Test
	public void aop_autoproxy() {

		try {
			String path = "com/briup/aop/autoProxy/autoProxy.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:通过名字进行自动代理
	// 可以通过名字指的代理xml文件中配置的哪些对象
	// 注意:这个配置即使没有advisor也可以使用
	@Test
	public void aop_autoproxybyname() {

		try {
			String path = "com/briup/aop/autoProxyByName/autoProxyByName.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:使用<aop >标签来配置aop功能
	@Test
	public void aop_aopconfig() {

		try {
			String path = "com/briup/aop/aopConfig/aopconfig.xml";
			ApplicationContext container = new ClassPathXmlApplicationContext(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:使用<aop >标签来配置aop功能另外一种方式
	@Test
	public void aop_xml() {

		try {
			String path = "com/briup/aop/xml/xmlHandler.xml";
			ApplicationContext container = new ClassPathXmlApplicationContext(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:使用注解来配置aop
	@Test
	public void aop_annotation() {

		try {
			String path = "com/briup/aop/annotation/annotation.xml";
			ApplicationContext container = new ClassPathXmlApplicationContext(path);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
