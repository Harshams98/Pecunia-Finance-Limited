package com.cheque.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cheque.entity.Account;



public interface AccountRepo extends JpaRepository<Account,Long>{

}
