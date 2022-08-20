package com.cheque.service;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cheque.entity.Account;
import com.cheque.entity.Debitcheque;
import com.cheque.exception.ResourceNotFoundException;
import com.cheque.repository.AccountRepo;
import com.cheque.repository.DebitchequeRepo;

@Service
public class DebitchequeServiceImpl implements DebitchequeService {

	@Autowired
	private DebitchequeRepo debitchequeRepo;

	@Autowired
	private AccountRepo accountrepo;

	@Override
	public Debitcheque saveDebitCheque(Debitcheque Debitcheque) {

		int chequeissuemonth = Debitcheque.getIssuedate().toLocalDate().getMonth().getValue();

		Calendar calendar = new GregorianCalendar();
		calendar.setTime(Debitcheque.getIssuedate());
		int chequeissueyear = calendar.get(Calendar.YEAR);
		int currentyear = LocalDateTime.now().getYear();

		if (chequeissuemonth == LocalDateTime.now().getMonth().getValue()
				|| chequeissuemonth == LocalDateTime.now().getMonth().minus(1).getValue()
				|| chequeissuemonth == LocalDateTime.now().getMonth().minus(2).getValue()) {
			int amt = Debitcheque.getAmount();
			int updateamt = 0;
			if (amt <= debitchequeRepo.save(Debitcheque).getAccountnumber().getAmount()) {
				Debitcheque.setAmount(debitchequeRepo.save(Debitcheque).getAccountnumber().getAmount() - amt);
				updateamt = debitchequeRepo.save(Debitcheque).getAccountnumber().getAmount() - amt;

				updateAccountAmount(debitchequeRepo.save(Debitcheque).getAccountnumber(),
						debitchequeRepo.save(Debitcheque).getAccountnumber().getAcccountid(), updateamt);
				return debitchequeRepo.save(Debitcheque);
			}
		} else {
			deleteCheckbounceData(Debitcheque.getChequenumber());
		}

		return null;
	}

	public ResponseEntity<String> deleteCheckbounceData(long chequenumber) {
		debitchequeRepo.findById(chequenumber).orElseThrow(
				() -> new ResourceNotFoundException("Error deleting the data", "chequenumber = ", chequenumber));
		debitchequeRepo.deleteById(chequenumber);
		return new ResponseEntity<String>("Cheque is not vaild", HttpStatus.BAD_REQUEST);
	}

	public Account updateAccountAmount(Account account, long accountId, int amt) {
		Account accountobj = accountrepo.findById(accountId)
				.orElseThrow(() -> new ResourceNotFoundException("account", "id", accountId));

		accountobj.setAmount(amt);

		accountrepo.save(accountobj);
		return accountobj;
	}

	@Override
	public Debitcheque GetById(long chequenumber) {
		Optional<Account> debitchequenumber = accountrepo.findById(chequenumber);
		return debitchequeRepo.findById(chequenumber)
				.orElseThrow(() -> new ResourceNotFoundException("chequenumber", "id", debitchequenumber));
	}

}
