package com.briup.theory.ioc;

import java.util.Map;

//容器(这里是一个工厂类,里面封装了Map集合)
//作用:读取配置文件然后帮我们创建对象,并且建立起对象和对象之间的依赖关系(就是把一个对象注入到另一个对象里面,一般就是调用set方法)
//我们使用某个对象的时候,从容器中拿就可以了
//我们拿到对象之后,对象中的依赖关系自然而然的就已经被容器建立起来了
//比如我们拿到一个servlet对象的时候,会发现servlet和service，service和dao对象的依赖关系已经建立起了
public class BeanFactory {
	
	private Map<String,Object> map;
	
	public BeanFactory(String path){
		try {
			//解析xml文件获得数据(存放在map集合里面)
			map = ParseHelper.parseXML(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public BeanFactory() {
		this("src/com/briup/theory/ioc/bean.xml");
	}
	
	public Object getBean(String beanName) {
		
		return map.get(beanName);
	}

}
