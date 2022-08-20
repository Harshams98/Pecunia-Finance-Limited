package com.cheque.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cheque.entity.Debitcheque;
import com.cheque.service.DebitchequeService;

@RestController
@RequestMapping("/debitcheque")
public class DebitchequeController {
	
	@Autowired
	DebitchequeService service;
	
	@PostMapping()
	public ResponseEntity<Debitcheque> savedebitcheque(@Valid @RequestBody Debitcheque debitcheque){
		return new ResponseEntity<Debitcheque> (service.saveDebitCheque(debitcheque),HttpStatus.CREATED);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Debitcheque> GetById(@PathVariable("id") long accountId) {
		return new ResponseEntity<Debitcheque>(service.GetById(accountId),
				HttpStatus.OK);//status -- 200
		}
}
