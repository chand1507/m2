package com.cg.xyz.ui;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.xyz.bean.Customer;
import com.cg.xyz.exception.LoanException;
import com.cg.xyz.service.ILoanService;
import com.cg.xyz.service.LoanService;

public class ExecuterMain {
	
	
	static Scanner sc = new Scanner(System.in);
	static ILoanService iLoanService = null;
	static LoanService loanService = null;
	static Logger logger = Logger.getRootLogger();

	public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
		
		PropertyConfigurator.configure("resources//log4j.properties");
		Customer customer = null;
        
		long custId = 0;
		int option = 0;
			
		while(true) {
			System.out.println();
			System.out.println();
			System.out.println("    XYZ Finance Company welcomes you     ");
			System.out.println();
			
			System.out.println("1.Register Customer");
			System.out.println("2.Exit");
			System.out.println("Select an option:");
			
			try {
				
				option = sc.nextInt();
				
				switch (option) {
				case 1:
					
					while (customer == null) {
						customer = populateCustomer();
						
					}

					try {
						iLoanService = new LoanService();
						custId = iLoanService.insertCust(customer);

						System.out.println("Customer details  has been successfully added ");
						System.out.println("Customer  ID Is: " + custId);
						
						String apply=null;
						System.out.println("Do you wish to apply for Loan?(Yes/No)");
						apply=sc.next();
						
						   switch (apply) {
						 case "Yes":
							
							System.out.println("Enter the loan amount");
			                double amount= sc.nextDouble();
			              
			                System.out.println("Enter loan duration in years");
			                int duration=sc.nextInt();
			                double r=0.095;
			                int n=duration*12;
			                double a=amount*r*((1+r)*n)/(((1+r)*n)-1);
			                System.out.println("EMI per month="+a);
			                
							break;
						case "No":
							System.out.print("Exit Application");
							System.exit(0);
							break;

						default:
							break;
						}
						
						
						

					} catch (LoanException loanException) {
						logger.error("exception occured", loanException);
						System.err.println("ERROR : "+ loanException.getMessage());
					} finally {
						custId = 0;
						iLoanService = null;
						customer = null;
					}

				
					
					break;
				case 2:
					System.out.print("Exit Application");
					System.exit(0);
					break;
					
				default:
					break;
				}
				
				
			}catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println(" try again");
			}			
		}
	
	}
	

	private static Customer populateCustomer() {
		Customer customer = new Customer();;

		

		System.out.println("Enter customer name: ");
		customer.setCustName(sc.next());

		

		System.out.println("Enter address: ");
		customer.setAddress(sc.next());
		
		
		System.out.println("Enter email: ");
		customer.setEmail(sc.next());

		

		loanService = new LoanService();

		try {
			loanService.validateCustomer(customer);
			return customer;
		} catch (LoanException loanException) {
			logger.error("exception occured", loanException);
			System.err.println("\nInvalid data:");
			System.err.println(loanException.getMessage() + " \n Try again..");
			

		}
		return null;

	}

}
