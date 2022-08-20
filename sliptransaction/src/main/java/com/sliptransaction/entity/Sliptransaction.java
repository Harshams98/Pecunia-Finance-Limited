package com.sliptransaction.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "SLIP_TB")
@AllArgsConstructor
@NoArgsConstructor
public class Sliptransaction {

	@Id
	private long sliptransactionid;
	private int amount;
	@OneToOne
	private Account account;
	
	private String tranactiontype;
}
