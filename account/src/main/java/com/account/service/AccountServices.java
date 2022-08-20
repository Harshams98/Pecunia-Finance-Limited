package com.account.service;

import com.account.entity.Account;


public interface AccountServices {
	
	public Account saveAccount(Account account);
	
	public Account updateCustomerName(Account account, long accountId);
	
	public void DeleteById(long accountId);
	
	public Account GetById(long accountId);
}
