package com.cg.test;

import java.sql.Connection;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.Loan.util.DBConnection;
import com.cg.xyz.dao.LoanDao;

public class DBConnectionTest {
	static LoanDao daotest;
	static Connection dbCon;

	@BeforeClass
	public static void initialise() {
		daotest = new LoanDao();
		dbCon = null;
	}

	@Before
	public void beforeEachTest() {
		System.out.println("----Starting DBConnection Test Case----\n");
	}

	/**
	 * Test case for Establishing Connection
	 * @throws Exception 
	 * 
	 * @throws LoanException
	 **/
	@Test
	public void test() throws Exception {
		Connection dbCon = DBConnection.getConnection();
		Assert.assertNotNull(dbCon);
	}

	@After
	public void afterEachTest() {
		System.out.println("----End of DBConnection Test Case----\n");
	}

	@AfterClass
	public static void destroy() {
		System.out.println("\t----End of Tests----");
		daotest = null;
		dbCon = null;
	}

}
