package com.briup.ioc.life;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/*注意:需要把这个类注册到spring的容器中,才能生效*/
/*怎么注册到容器中?配置bean标签即可*/
public class MyBeanPostProcessor implements BeanPostProcessor{

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第六步,调用postProcessBeforeInitialization方法,因为spring容器中注册了BeanPostProcessor接口的实现类");
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("第八步,调用postProcessAfterInitialization方法,因为spring容器中注册了BeanPostProcessor接口的实现类");
		return bean;
	}

}
