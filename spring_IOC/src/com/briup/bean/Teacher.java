package com.briup.bean;

public class Teacher {
	private long id;
	private String name;
	private Student student;
	
	
	public Teacher() {}
	
	public Teacher(Student student) {
		this.student = student;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStudent() {
		return student;
	}
	//byName方式: 方法名:setStudent ---> property名字:student
	//byType方式:
	public void setStudent(Student student) {
		this.student = student;
	}
}
