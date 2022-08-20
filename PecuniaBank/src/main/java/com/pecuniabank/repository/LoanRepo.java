package com.pecuniabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.pecuniabank.entity.Loan;

public interface LoanRepo extends JpaRepository<Loan,Long>{

}
