package com.cg.xyz.dao;

import java.sql.SQLException;

import com.cg.xyz.bean.Customer;
import com.cg.xyz.exception.LoanException;

public interface ILoanDao {
	
	
	public long insertCust(Customer cust) throws LoanException, ClassNotFoundException, SQLException, Exception;
	

}
