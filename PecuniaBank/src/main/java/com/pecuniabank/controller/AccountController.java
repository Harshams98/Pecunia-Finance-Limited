package com.pecuniabank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniabank.entity.Account;
import com.pecuniabank.service.AccountServices;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServices services;
	
	@PostMapping()
	public Account insertAccount(@Valid @RequestBody Account account) {
		return services.saveAccount(account);
		}
	
	@PutMapping("{Id}")
	public ResponseEntity<Account> updateCustomerName(@PathVariable("Id")long accountId,@Valid @RequestBody Account account){
		return new ResponseEntity<Account>(services.updateCustomerName(account, accountId),HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") long accountId) {
		// delete customer db
		services.DeleteById(accountId);;
		return new ResponseEntity<String>("Customer Account record deleted successfully!", HttpStatus.OK);
	}


}

