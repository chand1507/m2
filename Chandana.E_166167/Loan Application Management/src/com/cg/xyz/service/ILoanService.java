package com.cg.xyz.service;

import java.sql.SQLException;

import com.cg.xyz.bean.Customer;
import com.cg.xyz.exception.LoanException;


public interface ILoanService {
	
	
	public boolean validateCustomer(Customer customer) throws LoanException;
	public long insertCust(Customer cust) throws LoanException, ClassNotFoundException, SQLException, Exception;
	
	

}
