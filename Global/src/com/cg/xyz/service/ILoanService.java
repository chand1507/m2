package com.cg.xyz.service;

import com.cg.Loan.exception.LoanException;
import com.cg.xyz.bean.Customer;

public interface ILoanService {
public Customer validateCustomer(Customer customer) throws LoanException;
public long insertCust(Customer cust) throws Exception;
public double calculateEmi(double amount,int duration);
}
