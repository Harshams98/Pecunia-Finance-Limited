package com.pecuniabank.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="LOAN")
@AllArgsConstructor
@NoArgsConstructor
public class Loan {
	
	@Id
	@Min(100000)
	@Max(999999)
	private long loanid; // auto genrate 
	@Min(1000)
	@Max(10000000)
	private	long amount;
	@Min(12)
	@Max(240)
	private long tenure;
	@Min(100)
	@Max(999)
	private long creditscore;
	@Min(4)
	@Max(15)
	private long roi;
	private String status;
	private String type; // home loan , viechle loan, land loan 
	@OneToOne
	@JoinColumn(name = "accountid", insertable = true, updatable = false)
	private Account account;

}
