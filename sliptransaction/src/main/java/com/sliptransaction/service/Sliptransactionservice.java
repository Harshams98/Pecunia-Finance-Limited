package com.sliptransaction.service;

import java.util.List;

import com.sliptransaction.entity.Sliptransaction;

public interface Sliptransactionservice {

	public Sliptransaction saveSliptransaction(Sliptransaction sliptransaction);

	// To get all Sliptransaction records

	public List<Sliptransaction> getAllSliptransaction();

	// get specific Sliptransaction by Sliptransactionid

	public Sliptransaction getSliptransactionBySliptransactionid(long sliptransactionid);

	// update specific Sliptransaction by Sliptransactionid

	public Sliptransaction updateSliptransaction(Sliptransaction sliptransaction, long sliptransactionid);

	// delete specific Sliptransaction by Sliptransactionid

	public void deleteSliptransaction(long sliptransactionid);

}
