package com.briup.ioc.life;

/*这里面测试的是spring容器中bean对象普通的生命周期*/
/*Bean中不实现spring提供的任何接口,之后项目大多数Bean是这种情况*/
public class LifeBean{
	private String name;
	
	public LifeBean(){
		System.out.println("LifeBean() 构造器");
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName() 方法");
		this.name = name;
	}
	
	public void init(){
		System.out.println("init方法执行");
	}
	
	public void destory(){
		System.out.println("destory方法执行");
	}
	
}
