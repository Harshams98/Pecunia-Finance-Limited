package com.sliptransaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sliptransaction.entity.Sliptransaction;

@Repository
public interface Sliptransactionrepo extends JpaRepository<Sliptransaction, Long>  {

}
