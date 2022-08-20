package com.pecuniabank.service;



import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


import com.pecuniabank.entity.Loan;
import com.pecuniabank.repository.LoanRepo;


@Service
public class LoanServiceImpl implements LoanService{

	@Autowired
	private LoanRepo loanrepo;

	@Override
	public Loan addLoanDetails(Loan loan) {	
		if(loan.getCreditscore()>=670) {
			loan.setStatus("Pending");
		}else {
			loan.setStatus("Rejected");
		}
		Loan loanobject= loanrepo.save(loan);
		return loanobject;
	}




	
	
}
