package com.passbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.passbook.entity.Passbook;
import com.passbook.repository.PassbookRepo;

@Service
public class PassbookServiceImpl implements PassbookService {
	@Autowired
	private PassbookRepo repo;
	@Override
	public Passbook savePassbook(Passbook Passbook) {
		
		//repo.save(Passbook).getAccountId();
		Long num;   
        num = (long) (Math.random()*1000000);
     
		Passbook.setPassbookId(num);
		return repo.save(Passbook);
	}

}
