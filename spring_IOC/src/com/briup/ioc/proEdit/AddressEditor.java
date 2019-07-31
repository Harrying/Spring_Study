package com.briup.ioc.proEdit;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		String[] str = text.split(",");
		String city = str[0];
		String street = str[1];
		String country = str[2];
		Address add = new Address(city, street, country);
		//把新的值设置到对象中
		setValue(add);
	}

}
