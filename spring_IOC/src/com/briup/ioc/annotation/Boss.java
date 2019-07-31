package com.briup.ioc.annotation;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Boss {
	private String name;
	@Autowired
	private Car car;
	@Autowired
	private Office office;
	
	public Boss(){
		
	}
	
	public Boss(String name, Car car, Office office) {
		this.name = name;
		this.car = car;
		this.office = office;
	}
	
	public Boss( Car car, Office office) {
		this.car = car;
		this.office = office;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Car getCar() {
		return car;
	}
	
	
	public void setCar(Car car) {
		this.car = car;
	}
	public Office getOffice() {
		return office;
	}
	
	public void setOffice(Office office) {
		this.office = office;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("初始化..");
	}
	
	@PreDestroy
	public void destory(){
		System.out.println("销毁...");
	}
	
	
	
}
