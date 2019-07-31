package com.briup.ioc.annotation;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
/*初始化bean对象*/
@Component
//@Scope("prototype")
public class Car {
	private double price;
	private String name;
	
	public Car(){
		
	}
	
	public Car(double price, String name) {
		this.price = price;
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
