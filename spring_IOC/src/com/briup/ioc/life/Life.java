package com.briup.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*这里面测试的是spring容器中bean对象完整的生命周期*/
public class Life implements BeanNameAware,BeanFactoryAware,ApplicationContextAware,DisposableBean{
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("第二步,依赖注入");
		this.name = name;
	}

	public Life() {
		System.out.println("第一步,创建对象");
	}
	
	public void myInit(){
		System.out.println("第七步,调用myInit方法,因为bean在xml中的配置里面使用了init-method属性来指定初始化方法");
	}
	
	public void myDestroy(){
		System.out.println("第十步,调用myDestroy方法,因为bean在xml中的配置里面使用了destroy-method属性来指定初始化方法");
	}

	@Override
	public void setBeanName(String name) {
		System.out.println("第三步,调用setBeanName方法,因为bean类实现了BeanNameAware");
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("第四步,调用setBeanFactory方法,因为bean类实现了BeanFactoryAware");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0) throws BeansException {
		System.out.println("第五步,调用setApplicationContext方法,因为bean类实现了ApplicationContextAware");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("第九步,调用destroy方法,因为bean类实现了DisposableBean接口");
	}

}
