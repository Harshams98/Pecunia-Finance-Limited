package com.cheque.service;


import com.cheque.entity.Debitcheque;

public interface DebitchequeService {
	
	public Debitcheque saveDebitCheque(Debitcheque Debitcheque);

	
	public Debitcheque GetById(long chequenumber);
}
