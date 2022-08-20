package com.account.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.account.entity.Account;
import com.account.service.AccountServices;


@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	private AccountServices services;

	@PostMapping()
	public ResponseEntity<Account> insertAccount(@Valid @RequestBody Account account){
		return new ResponseEntity<Account>(services.saveAccount(account), HttpStatus.CREATED);
	}
	
	
	@PutMapping("{Id}")
	public ResponseEntity<Account> updateCustomerName( @PathVariable("Id") long accountId,@Valid @RequestBody Account account){
		return new ResponseEntity<Account>(services.updateCustomerName(account, accountId),HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> DeleteById(@PathVariable("id") long accountId) {
		// delete customer db
		services.DeleteById(accountId);;
		return new ResponseEntity<String>("Customer Account record deleted successfully!", HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Account> GetById(@PathVariable("id") long accountId) {
		return new ResponseEntity<Account>(services.GetById(accountId),
				HttpStatus.OK);//status -- 200
		}
	
	@GetMapping("login/{id}")
	public ResponseEntity<Account> LoginById(@PathVariable("id") long accountId) {
		return new ResponseEntity<Account>(services.GetById(accountId),
				HttpStatus.OK);//status -- 200
		}

}

