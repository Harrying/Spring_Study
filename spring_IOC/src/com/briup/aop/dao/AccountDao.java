package com.briup.aop.dao;

import com.briup.aop.pojo.Account;

public interface AccountDao {
	//取款 账号减去多少钱
	void withdraw(Account acc,double amt);
	//存款 账号加上多少钱
	void deposit(Account acc,double amt);
}
