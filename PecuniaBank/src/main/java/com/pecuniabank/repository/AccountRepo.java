package com.pecuniabank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pecuniabank.entity.Account;

public interface AccountRepo extends JpaRepository<Account,Long>{

}
