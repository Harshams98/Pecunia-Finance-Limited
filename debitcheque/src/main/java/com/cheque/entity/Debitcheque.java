package com.cheque.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name="DebitCheque_tb")
@AllArgsConstructor
@NoArgsConstructor
public class Debitcheque {
	
	@Id
	@Min(100000)
	@Max(999999)
	private long chequenumber;
	
	
	@OneToOne
	private Account accountnumber;
	
	@Column(nullable = false)
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="please enter the valid IFSC")
	@Size(min = 10, max = 10,message ="IFSC number should be 10 Letters")
	private String ifsc;
	
	@Column(nullable = false)
	@Min(100)
	@Max(2000000)
	private int amount;

	@Column(nullable = false)
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date issuedate;
	
	
	
	
	
	

}
