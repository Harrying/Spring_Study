package com.briup.jtest;

import com.briup.bean.Teacher;
import com.briup.ioc.annotation.Boss;
import com.briup.ioc.event.RainEvent;
import com.briup.ioc.life.LifeBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.briup.bean.Student;

import java.sql.Connection;
import java.util.List;

//ioc功能的测试类
//每个方法测试一个知识点
//每个知识点对应src下面的一个package
//每个package中是这个知识点的配置方式

//这里面的方法名字和对应的src下面的package名字是对应的
//这个类中从上到下 方法的顺序就是我们学习ioc知识点的顺序
@SuppressWarnings("all")
public class IocTest {
	

	//本类中的测试方法中的代码大致的编写模式
	public void ioc_test() {

		try {
			//1 声明要读取的xml文件路径(如果有多个可以放在数组中)
			//2 读取xml文件创建spring的容器contanier
			//3 从容器container中根据配置的名字拿出需要使用的对象
			//4 使用对象进行操作(对象中的需要的各种数据和依赖的其他对象早已经被spring的容器注入进来)
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 知识点:spring的set方式注入
	@Test
	public void ioc_set() {

		try {
			String[] path = {"com/briup/ioc/set/set.xml"};
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);

			/*Student stu = (Student)container.getBean("stu");
			System.out.println(stu);
			System.out.println(stu.getId());
			System.out.println(stu.getName());
			System.out.println(stu.getAge());*/

			Teacher t = (Teacher) container.getBean("teacher");
			System.out.println(t);
			System.out.println(t.getName());
			System.out.println(t.getStudent());
			System.out.println(t.getStudent().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 知识点:向一个对象中注入集合
	@Test
	public void ioc_collection() {
		try {
			String[] path = {"com/briup/ioc/collection/collection.xml"};
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Student stu =(Student) container.getBean("student");
			/*System.out.println(stu.getList());
			List list = stu.getList();
			list.add("ahha");*/
			stu.show();
			System.out.println("-------------------------------");
			System.out.println(stu.getList().getClass());
			System.out.println(stu.getSet().getClass());
			System.out.println(stu.getMap().getClass());
			System.out.println(stu.getProp().getClass());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点:构造器注入(之前的是set注入)
	@Test
	public void ioc_constructor() {
		try {
			String path = "com/briup/ioc/constructor/constructor.xml";
			
			ApplicationContext container = 
						new ClassPathXmlApplicationContext(path);
			Student stu = (Student) container.getBean("s2");
			System.out.println(stu);
			System.out.println(stu.getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//知识点:自动注入
	@Test
	public void ioc_autowired() {
		try {
			String path = "com/briup/ioc/autowired/autowired.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Teacher t = (Teacher) container.getBean("teacher");
			System.out.println(t);
			System.out.println(t.getStudent());
			System.out.println(t.getStudent().getName());

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点:配置文件中的标签 bean和bean之间也是可以继承的
	@Test
	public void ioc_extend() {
		try {
			String[] path = {"com/briup/ioc/extend/extends.xml"};
			ApplicationContext container = 
						new ClassPathXmlApplicationContext(path);
			Teacher t = (Teacher) container.getBean("t");
			System.out.println(t);
			System.out.println(t.getName());
			System.out.println(t.getStudent());
			System.out.println(t.getStudent().getName());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	//知识点:spring所管理对象的声明周期
	@Test
	public void ioc_life() {
		try {
			String path = "com/briup/ioc/life/life.xml";
			ClassPathXmlApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			LifeBean life = (LifeBean) container.getBean("life");
			LifeBean life1 = (LifeBean) container.getBean("life");
			System.out.println(life.getName());
			System.out.println(life == life1);
			container.destroy();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点:一个xml配置文件中 导入另外一个xml配置文件
	@Test
	public void ioc_imp() {
		try {
			
			//String[] path = {"com/briup/ioc/imp/teacher.xml","com/briup/ioc/imp/student.xml"};
			String[] path = {"com/briup/ioc/imp/import.xml"};
			ApplicationContext container =
					new ClassPathXmlApplicationContext(path);
			Teacher teacher = (Teacher) container.getBean("teacher");
			System.out.println(teacher.getName());
			System.out.println(teacher.getStudent().getName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点: 在xml中配置工厂类，然后通过这个工厂类获得工厂生产的实例
	@Test
	public void ioc_Factory() {
		try {
			String path = "com/briup/ioc/factory/factory.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点: 实例工厂
	@Test
	public void ioc_instanceFactory() {
		try {
			String path = "com/briup/ioc/instanceFactory/instanceFactory.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//知识点: 静态工厂
	@Test
	public void ioc_staticFactory() {
		try {
			String path = "com/briup/ioc/staticFactory/staticFactory.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Connection conn = (Connection) container.getBean("conn");
			System.out.println(conn);
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	//知识点: 使用自定义属性编辑器
	public void ioc_proEdit() {
		try {
			String[] path = {"com/briup/ioc/proEdit/proEdit.xml"};
			ApplicationContext container =
					new ClassPathXmlApplicationContext(path);
			com.briup.ioc.proEdit.Student stu=(com.briup.ioc.proEdit.Student)container.getBean("student");
			System.out.println(stu);
			System.out.println(stu.getAddress().getCity());
			System.out.println(stu.getAddress().getCountry());
			System.out.println(stu.getAddress().getStreet());


		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	//知识点: 自定义事件
	public void ioc_event() {
		try {
			String path = "com/briup/ioc/event/event.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			//发布事件，监听器自动运行
			container.publishEvent(new RainEvent("这下雨了"));
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	//知识点: ioc中的注解
	public void ioc_annotation() {
		try {
			String path = "com/briup/ioc/annotation/annotation.xml";
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(path);
			Boss boss = (Boss) container.getBean("boss");
			System.out.println(boss);
			System.out.println(boss.getCar());
			System.out.println(boss.getOffice());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
