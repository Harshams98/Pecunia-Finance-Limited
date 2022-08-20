package com.passbook.entity;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


import javax.persistence.Table;



import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="PASSBOOK_TB")
@AllArgsConstructor
@NoArgsConstructor
public class Passbook {
	@Id
	//@GeneratedValue(strategy= GenerationType.AUTO)
	private long passbookId;
	@OneToOne
	private Account accountId;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date startdate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date endingdate;

}
