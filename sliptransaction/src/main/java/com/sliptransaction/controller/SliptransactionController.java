package com.sliptransaction.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sliptransaction.entity.Sliptransaction;
import com.sliptransaction.service.Sliptransactionservice;

@RestController
@RequestMapping("/slip")
public class SliptransactionController {
	@Autowired
	private Sliptransactionservice services;
	
	@PostMapping()
	public ResponseEntity <Sliptransaction> insertSliptransaction(@Valid @RequestBody Sliptransaction sliptransaction) {
		return new ResponseEntity <Sliptransaction>(services.saveSliptransaction(sliptransaction),HttpStatus.CREATED);
		}
	
	@GetMapping("/{sliptransactionid}")
	public ResponseEntity<Sliptransaction> getSliptransactionBySliptransactionid(@PathVariable long sliptransactionid) {
		return new ResponseEntity <Sliptransaction>(services.getSliptransactionBySliptransactionid(sliptransactionid),HttpStatus.CREATED);
	}
	
	@GetMapping()
	public  List<Sliptransaction> getAllSliptransaction(){
		return services.getAllSliptransaction();
	}
	@DeleteMapping("/{sliptransactionid}")
    public ResponseEntity<String> deleteSliptransaction(@PathVariable("sliptransactionid") long sliptransactionid){
    	services.deleteSliptransaction(sliptransactionid);
    	return new ResponseEntity<String>("Sliptransaction record delete ", HttpStatus.OK);
    }
}
