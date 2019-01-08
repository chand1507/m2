package com.cg.xyz.test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.xyz.bean.Customer;
import com.cg.xyz.dao.LoanDao;
import com.cg.xyz.exception.LoanException;

public class LoanDaoTest {

	static LoanDao dao;
	static Customer customer;
	
	@BeforeClass
	public static void initialize() {
		System.out.println("in before class");
		dao = new LoanDao();
		customer = new Customer();
	}
	/************************************
	 * Test case for insertDetails()
	 * 
	 ************************************/
	@Test
	public void test() throws ClassNotFoundException, SQLException, Exception {
		assertNotNull(dao.insertCust(customer));
	}
	
	
	
	
	@Test
	public void test2() throws ClassNotFoundException, SQLException, Exception {

		customer.setCustName("Chandana");
		
		customer.setAddress("Siruseri");
		customer.setEmail("chandana@gmail.com");
		assertTrue("Data Inserted successfully",
				dao.insertCust(customer) > 10001);

	}
	

}
