package com.pecuniabank.service;

import com.pecuniabank.entity.Account;


public interface AccountServices {
	
	public Account saveAccount(Account account);
	
	public Account updateCustomerName(Account account, long accountId);
	
	public void DeleteById(long accountId);
}
