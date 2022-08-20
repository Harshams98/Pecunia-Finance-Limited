package com.account.service;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.account.entity.Account;
import com.account.exception.ResourceNotFoundException;
import com.account.repository.AccountRepo;



@Service
public class AccountServiceImpl implements AccountServices{
	
	@Autowired
	private AccountRepo accountrepo;
	
	@Override
	public Account saveAccount(Account account) {
		 LocalDate myObj = LocalDate.now(); 
		account.setDate(myObj);
		long num;   
        num = (long)(Math.random()*100000000*10000);
		account.setAcccountid(num);
		return  accountrepo.save(account);	
				
	}
	
	public Account updateCustomerName(Account account, long accountId) {
		Account accountobj = accountrepo.findById(accountId).orElseThrow(() ->
		new ResourceNotFoundException("account", "id", accountId));
	
			if (Objects.nonNull(account.getCustomerName())&& !"".equalsIgnoreCase(account.getCustomerName())) {
					accountobj.setCustomerName(account.getCustomerName());
 	}
			if (Objects.nonNull(account.getContact())&& !"".equalsIgnoreCase(account.getContact())) {
				accountobj.setContact(account.getContact());
			
	}
			if (Objects.nonNull(account.getAddresslanOne())&& !"".equalsIgnoreCase(account.getAddresslanOne())) {
				accountobj.setAddresslanOne(account.getAddresslanOne());
	}
			if (Objects.nonNull(account.getAddresslanTwo())&& !"".equalsIgnoreCase(account.getAddresslanTwo())) {
				accountobj.setAddresslanTwo(account.getAddresslanTwo());
	}
			
			accountrepo.save(accountobj);
			return accountobj;
	}

	@Override
	public void DeleteById(long accountId) {
		accountrepo.findById(accountId).orElseThrow(
				() -> new ResourceNotFoundException("account", "id", accountId));
		accountrepo.deleteById(accountId);

	}

	@Override
	public Account GetById(long accountId) {
		Optional<Account> account = accountrepo.findById(accountId);
		return accountrepo.findById(accountId).orElseThrow(
				() -> new ResourceNotFoundException("account", "id", account));
		
	}
	
	
	
}
