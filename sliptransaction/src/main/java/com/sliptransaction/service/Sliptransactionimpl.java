package com.sliptransaction.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sliptransaction.entity.Account;
import com.sliptransaction.entity.Sliptransaction;
import com.sliptransaction.exception.ResourceNotFoundException;
import com.sliptransaction.repository.AccountRepo;
import com.sliptransaction.repository.Sliptransactionrepo;

@Service
public class Sliptransactionimpl implements Sliptransactionservice {

	@Autowired
	private Sliptransactionrepo sliptransactionrepo;
	
	@Autowired
	private AccountRepo accountrepo;

	@Override
	public Sliptransaction saveSliptransaction(Sliptransaction sliptransaction) {
		
		if(sliptransaction.getTranactiontype().equals("debit")) {
		
			if(sliptransaction.getAmount()<sliptransactionrepo.save(sliptransaction).getAccount().getAmount())
			{
			
				long updateamt = sliptransactionrepo.save(sliptransaction).getAccount().getAmount() - sliptransaction.getAmount();
//
				updateAccountAmount(sliptransactionrepo.save(sliptransaction).getAccount(),
						sliptransactionrepo.save(sliptransaction).getAccount().getAcccountid(), updateamt);
//				
				return sliptransactionrepo.save(sliptransaction);
			
		}
			else {
				sliptransactionrepo.deleteById(sliptransaction.getSliptransactionid());
			}
		}
		if(sliptransaction.getTranactiontype().equals("credit")) {

				long updateamt = sliptransactionrepo.save(sliptransaction).getAccount().getAmount() +sliptransaction.getAmount();
//
				updateAccountAmount(sliptransactionrepo.save(sliptransaction).getAccount(),
						sliptransactionrepo.save(sliptransaction).getAccount().getAcccountid(), updateamt);
//				
				return sliptransactionrepo.save(sliptransaction);
			
		
		}
		return null;
		 
	}

	@Override
	public List<Sliptransaction> getAllSliptransaction() {
		return this.sliptransactionrepo.findAll();
	}

	@Override
	public Sliptransaction getSliptransactionBySliptransactionid(long sliptransactionid) {
		return this.sliptransactionrepo.findById(sliptransactionid)
		.orElseThrow(() -> new ResourceNotFoundException("Sliptransaction", "sliptransactionid",sliptransactionid));
	}

	@Override
	public Sliptransaction updateSliptransaction(Sliptransaction sliptransaction, long sliptransactionid) {
		Sliptransaction st=this.sliptransactionrepo.findById(sliptransactionid).
		orElseThrow(() -> new ResourceNotFoundException("Sliptransaction", "sliptransactionid", sliptransactionid));
		st.setSliptransactionid(sliptransaction.getSliptransactionid());
		st.setAccount(sliptransaction.getAccount());
		st.setAmount(sliptransaction.getAmount());
		st.setTranactiontype(sliptransaction.getTranactiontype());
		sliptransactionrepo.save(st);
		return st;
	}

	@Override
	public void deleteSliptransaction(long sliptransactionid) {
		Sliptransaction st=this.sliptransactionrepo.findById(sliptransactionid).
		orElseThrow(() -> new ResourceNotFoundException("Sliptransaction", "sliptransactionid", sliptransactionid));
		sliptransactionrepo.delete(st);
		
	}
	
	public Account updateAccountAmount(Account account, long accountId, long amt) {
		Account accountobj = accountrepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account", "id", accountId));

		accountobj.setAmount((int) amt);

		accountrepo.save(accountobj);
		return accountobj;
	}

}
