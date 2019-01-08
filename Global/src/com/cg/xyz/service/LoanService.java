package com.cg.xyz.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.Loan.exception.LoanException;
import com.cg.xyz.bean.Customer;
import com.cg.xyz.bean.Loan;
import com.cg.xyz.dao.ILoanDao;
import com.cg.xyz.dao.LoanDao;





public class LoanService implements ILoanService{
	ILoanDao iLoanDao =null;
	Loan loan = null;
	@Override
	public Customer validateCustomer(Customer customer) throws LoanException {
List<String> list = new ArrayList<>();
		
		if(!(isValidName(customer.getCustName())))
		{
			list.add(" customer name must be minimum 5 characters ...");
		}
		
		if(!(isValidAddress(customer.getAddress())))
		{
			list.add("Address must be minimum 5 characters ...");
		}
		
		/*if(!(isValidEmail(customer.getEmail())))
		{
			list.add(" Email must have  minimum 5 characters ...");
		}*/
		
		
		if(!list.isEmpty())
		{
			throw new LoanException(list + " ");
		}
	//	return false;
		return customer;
	}

	private boolean isValidAddress(String address) {
		Pattern pat1 = Pattern.compile("^[A-Z][A-Za-z]{4,}$");
		Matcher mat1 = pat1.matcher(address);
		return mat1.matches();
	}

	/*private boolean isValidEmail(String email) {
		Pattern pat1 = Pattern.compile("^([a-zA-Z0-9_\\-\\.]{5,10}+)@([a-zA-Z0-9_\\-\\.]+)\\.([a-zA-Z]{2,5})$ ");
		Matcher mat1 = pat1.matcher(email);
		return mat1.matches();
	}*/
	private boolean isValidName(String custName) {
		Pattern pat1 = Pattern.compile("^[A-Z][A-Za-z]{4,}$");
		Matcher mat1 = pat1.matcher(custName);
		return mat1.matches();
	}
	@Override
	public long insertCust(Customer cust) throws Exception {
		
		long custId = 0;
		iLoanDao = new LoanDao();
		custId = iLoanDao.insertCust(cust);
		return custId;
	}

	@Override
	public double calculateEmi(double amount, int duration) {
	
 double EMI = (loan.getLoanAmount()*9.5*12 *(1+9.5)*loan.getDuration())/((1+9.5)*(loan.getDuration()*12)-1)	;
		return EMI;
	}

}
