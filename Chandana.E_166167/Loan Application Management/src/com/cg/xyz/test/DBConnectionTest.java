package com.cg.xyz.test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cg.xyz.dao.LoanDao;
import com.cg.xyz.exception.LoanException;
import com.cg.xyz.util.DBConnection;

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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 **/
	@Test
	public void test() throws ClassNotFoundException, SQLException, Exception {
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
