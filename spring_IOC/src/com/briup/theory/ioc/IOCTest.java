package com.briup.theory.ioc;

public class IOCTest {
	public static void main(String[] args) {

		//创建对象与对象之间的关系
		//所有操作由程序员处理
//		Student stu = new Student();
//		Teacher t = new Teacher();
//		t.setStudent(stu);
//		System.out.println(t);
//		System.out.println(t.getStudent());

		//交给容器
		BeanFactory container = new BeanFactory();
		//直接从容器中获取自己想要的数据
//		Student stu = (Student)container.getBean("stu");
//		System.out.println(stu);

		Teacher t = (Teacher)container.getBean("t");
		System.out.println(t);
		System.out.println(t.getStudent());
	}
}
