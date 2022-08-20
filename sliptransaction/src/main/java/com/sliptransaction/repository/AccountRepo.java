package com.sliptransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sliptransaction.entity.Account;





public interface AccountRepo extends JpaRepository<Account,Long>{

}
