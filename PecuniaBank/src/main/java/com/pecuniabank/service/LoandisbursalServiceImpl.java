package com.pecuniabank.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pecuniabank.entity.Account;
import com.pecuniabank.entity.Loan;
import com.pecuniabank.exception.ResourseNotFoundException;
import com.pecuniabank.repository.AccountRepo;
import com.pecuniabank.repository.LoanRepo;
@Service
public class LoandisbursalServiceImpl implements LoandisbursalService{

	@Autowired
	private LoanRepo loanrepo;
	
	@Autowired
	private AccountRepo accountrepo;
	
	@Override
	public Loan getAccount(long accountid) {
			
	return loanrepo.findById(accountid).get();
	}	
	@Override
	public List<Loan> retrieveall(Loan loan) {
		
	return loanrepo.findAll();
	}
	@Override
	public Loan approveLoan(long loanid, Loan loan) {
		Loan loanobj = loanrepo.findById(loanid).get();
		loanrepo.save(loanobj);
		
		if(loan.getStatus().equals("approved")){
			loanobj.setStatus(loan.getStatus());
			Loan test=loanrepo.save(loanobj);
			if(loan.getStatus().equals("approved"))
			{
				updatedAmount(loanrepo.save(loanobj).getAccount(),loanrepo.save(loanobj).getAccount().getAccountid(),loanrepo.save(loanobj).getAmount());
				
			return loanrepo.save(loan);
			}	
		}
		return null;
		
	}
	
	public Account updatedAmount(Account account, long accountId,long amount) {
		Account accountobj = accountrepo.findById(accountId).orElseThrow(() ->
		new ResourseNotFoundException("account", "id", accountId));
	
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
			long oldamount=accountrepo.save(account).getAmount();
			accountobj.setAmount((int) (oldamount+amount));
			
			return accountrepo.save(accountobj);
	}
		
	
}
	
