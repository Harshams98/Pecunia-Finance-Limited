package com.pecuniabank.service;

import java.util.List;

import com.pecuniabank.entity.Loan;

public interface LoandisbursalService {
	
	public Loan getAccount(long accountid);
	
	public List<Loan> retrieveall(Loan loan);
	
	public Loan approveLoan(long loanid, Loan loan);

}
