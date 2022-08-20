package com.cheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheque.entity.Debitcheque;

public interface DebitchequeRepo extends JpaRepository<Debitcheque,Long>{
	
	

}
