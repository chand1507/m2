package com.cg.xyz.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.cg.xyz.dao.ILoanDao;
import com.cg.xyz.dao.LoanDao;
import com.cg.xyz.exception.LoanException;
import com.cg.xyz.bean.Customer;

public class LoanService implements ILoanService{
	
 ILoanDao iLoanDao;
	
	//------------------------ 1. Loan Application --------------------------
	/*******************************************************************************************************
	 - Function Name	:	insertCustomerDetails
	 - Input Parameters	:	cust object
	 - Return Type		:	long id
	 - Throws			:  	LoanException
	 - Author			:	CAPGEMINI
	 - Creation Date	:	08/1/2019
	 - Description		:	adding customer to database calls dao method insertCust(cust)
	 * @throws Exception 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 ********************************************************************************************************/
	
	@Override
	public long insertCust(Customer cust) throws ClassNotFoundException, SQLException, Exception {
		iLoanDao=new LoanDao();	
		long seq;
		seq= iLoanDao.insertCust(cust);
		return seq; 
	}
	
	
	/*******************************************************************************************************
	 - Function Name	: validateCustomer(Customer customer)
	 - Input Parameters	: Customer customer
	 - Return Type		: boolean
	 - Throws		    : LoanException
	 - Author	      	: CAPGEMINI
	 - Creation Date	: 8/01/2019
	 - Description		: validates the customer object
	 ********************************************************************************************************/

	@Override
	public boolean validateCustomer(Customer customer) throws LoanException {
		List<String> list = new ArrayList<>();
		boolean result = false;

		if (!validateName(customer.getCustName()))
			{
			list.add(" name should start with capital letter & length should be greater than 6 ");
		}
		if (!validateAddress(customer.getAddress()))
		{
			list.add(" address  should start with capital letter & length should be atleast 5 characters ");
		}
		if (!validateEmail(customer.getEmail())) {
			list.add("enter valid email which contains an upper case & 1 symbol & numerics ");
		}
		
		
		if (!list.isEmpty()) {
			result = false;
			throw new LoanException(list + "");
		} else {
			result = true;
		}
		return result;
		
	}

	private boolean validateEmail(String email) {
		String emailr = "[a-z0-9._+]+@[a-z]+.[a-z]{2,3}";
		Pattern pattern = Pattern.compile(emailr);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	private boolean validateAddress(String address) {
		String addressr = "[A-Z]{1}[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(addressr);
		Matcher matcher = pattern.matcher(address);
		return matcher.matches();
	}

	private boolean validateName(String custName) {
		String name = "[A-Z]{1}[a-zA-Z]{5,20}";
		Pattern pattern = Pattern.compile(name);
		Matcher matcher = pattern.matcher(custName);
		return matcher.matches();
	}

	
	
	
	
	

	
}
