package com.cg.xyz.dao;

import com.cg.xyz.bean.Customer;

public interface ILoanDao {

	public long insertCust(Customer cust) throws Exception;
	public double calculateEmi(double amount,int duration);
}
