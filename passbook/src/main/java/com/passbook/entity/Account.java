package com.passbook.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Table(name="ACCOUNT_TB")
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	@Id
	private long acccountid;
	private String addresslanOne;
	private String addresslanTwo;
	private String CustomerName;
	@Column(nullable = false)
	@Pattern(regexp="^\\d{10}$",message="please enter the valid 10 digit number for contact")
	@Size(min = 10, max = 10, message ="contact should be 10 digit number")
	private String	contact;
	@Column(nullable = false)
	@Pattern(regexp="^\\d{12}$",message="please enter the valid 12 digit number for aadhar")
	@Size(min = 12, max = 12 , message ="Aadhar should be 12 digit number")
	private String aadhar;
	@Column(nullable = false)
	@Pattern(regexp="^[A-Z]{4}[0-9]{4}[A-Z]{1}$",message="please enter the valid 9 letters for paan")
	@Size(min = 9, max = 9,message ="pan number should be 9 Letters")
	private String pan;
	private LocalDate date;
	private String gender;
	@Min(100)
	@Max(200000)
	private int amount;
	
}
