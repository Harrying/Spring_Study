package com.briup.aop.dao;


import com.briup.aop.pojo.Account;

public class AccountDaoImpl implements AccountDao{
	
	//取款
	@Override
	public void withdraw(Account acc, double amt) {
		System.out.println("账号成功取款"+amt);
	}
	
	//存款
	@Override
	public void deposit(Account acc, double amt) {
		System.out.println("账号成功存款"+amt);
	}
}
