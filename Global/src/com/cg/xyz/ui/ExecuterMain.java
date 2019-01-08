package com.cg.xyz.ui;

import java.util.Scanner;

import com.cg.Loan.exception.LoanException;
import com.cg.xyz.bean.Customer;
import com.cg.xyz.bean.Loan;
import com.cg.xyz.service.ILoanService;
import com.cg.xyz.service.LoanService;





//import ui.Logger;

public class ExecuterMain {
	static ILoanService iloanService = null;
	static LoanService loanService = null;
	static Customer customer =null;
	static Scanner in = new Scanner(System.in);
static Loan loan = null;
	// static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) throws Exception {

		System.out.println("XYZ Finance Company welcomes you");

		System.out.println(" 1.Register Customer");

		System.out.println(" 2. Exit ");
		
		int option;
		
		option = in.nextInt();
		switch(option)
		{
			case 1:
				 Customer customer1 =new Customer();
				customer1 = populateCustomer();
				 loan = new Loan();
			/*double amount = 0;
			int duration = 0;
			double loan = loanService.calculateEmi(amount, duration);*/
				System.out.println(customer1);
				loanService = new LoanService();
				iloanService = new LoanService();
				
					long custId = 0;
						custId = iloanService.insertCust(customer1);
					try {
						System.out.println(" Your customer information saved successfully .your customer Id is "+custId);	
					}
					catch(Exception e) {
						
					}
					//	System.out.println("Enter the loan amount");
					
						
						

				break;
			default :
				in.close();
			
					System.exit(0);
	}

}

	private static Customer populateCustomer() throws LoanException {

		customer = new Customer();
		System.out.println("Register Customer");
		System.out.println("enter customer name : ");
		String custName = in.next();
		customer.setCustName(custName);
		
		
	
		System.out.println(" enter Address: ");
		
		customer.setAddress(in.next());
		
		System.out.println(" enter Email ");
		customer.setEmail(in.next());
		//System.out.println(customer.getEmail());

	
		loanService = new LoanService();
		try {
		loanService.validateCustomer(customer);
		return customer;
		}
		catch(LoanException le) {
			System.err.println(le.getMessage());
		}
		return customer;
	}
		
	
}
