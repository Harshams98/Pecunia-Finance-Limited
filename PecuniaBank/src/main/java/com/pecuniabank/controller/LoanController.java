package com.pecuniabank.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pecuniabank.entity.Loan;
import com.pecuniabank.service.LoanService;




@RestController
@RequestMapping("/loan")
public class LoanController {
	
	@Autowired
	private LoanService loanservice;
	
	
	@PostMapping()
	public ResponseEntity<Loan>  CreateLoanRequest(@Valid @RequestBody Loan loan) {
		
		return new ResponseEntity<Loan>(loanservice.addLoanDetails(loan),HttpStatus.CREATED);
		}
	

}
