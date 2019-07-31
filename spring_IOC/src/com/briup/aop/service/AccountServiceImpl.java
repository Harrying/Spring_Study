package com.briup.aop.service;


import com.briup.aop.dao.AccountDao;
import com.briup.aop.pojo.Account;

//目标对象(target)
public class AccountServiceImpl implements IAccountService{
	private AccountDao accountDao;
	private Account account;
	
	//转账
	public void bankAction(){
		accountDao.withdraw(account, 100);
		accountDao.deposit(account, 100);
//		throw new RuntimeException("我的异常测试");
	}
	
	public AccountDao getAccountDao() {
		return accountDao;
	}
	
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public Account getAccount() {
		return account;
	}
	
	public void setAccount(Account account) {
		this.account = account;
	}
	
}
