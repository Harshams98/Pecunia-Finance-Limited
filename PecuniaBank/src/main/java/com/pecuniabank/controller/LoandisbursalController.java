package com.pecuniabank.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.pecuniabank.entity.Loan;
import com.pecuniabank.service.LoandisbursalService;

@RestController
@RequestMapping("/loandisbursal")
public class LoandisbursalController {
		
	@Autowired
	private LoandisbursalService services;
	
	@GetMapping()
	public List<Loan> retrieveall(@Valid @RequestBody Loan loan){
	   return services.retrieveall(loan);
	}
	@PutMapping("{Id}")
	public ResponseEntity<Loan> update(@RequestBody Loan loan,@PathVariable("Id")long loanid){
		return new ResponseEntity<Loan>(services.approveLoan(loanid, loan),HttpStatus.OK);
	}
}
