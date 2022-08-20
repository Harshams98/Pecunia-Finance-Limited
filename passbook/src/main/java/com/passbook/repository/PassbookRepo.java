package com.passbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.passbook.entity.Passbook;

public interface PassbookRepo extends JpaRepository<Passbook,Long> {
}
