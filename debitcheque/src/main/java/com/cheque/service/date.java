package com.cheque.service;

import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;

import com.cheque.entity.Debitcheque;

public class date {

	public static void main(String[] args) {
		
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   //LocalDateTime now = LocalDateTime.now().compareTo(null).minusMonths(3);  
		   
		   int dates =LocalDateTime.now().getMonth().getValue();
		   
		   int currentmonth ;
		   
		    currentmonth  =LocalDateTime.now().getMonth().minus(10).getValue();
		   
		   System.out.println(dates);
		   System.out.println("asdfghjkl    "+currentmonth);
		   System.out.println(dtf);
			//int chequeissuemonth = dtf.get).toLocalDate().getMonth().getValue();
		   
		   System.out.println(LocalDateTime.now().getYear());
	}

}
