package com.cg.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.cg.xyz.bean.Customer;
import com.cg.xyz.exception.LoanException;
import com.cg.xyz.util.DBConnection;

public class LoanDao implements ILoanDao{
	
	
	Logger logger=Logger.getRootLogger();
	public LoanDao()
	{
	PropertyConfigurator.configure("resources//log4j.properties");
	
	}
	

	//------------------------ 1. Loan Application --------------------------
		/*******************************************************************************************************
		 - Function Name	:	insertCust(Customer cust)
		 - Input Parameters	:	Customer cust
		 - Return Type		:	long
		 - Throws			:  	LoanException
		 - Author			:	CAPGEMINI
		 - Creation Date	:	8/01/2019
		 - Description		:	Adding Customer
		 * @throws Exception 
		 * @throws SQLException 
		 * @throws ClassNotFoundException 
		 ********************************************************************************************************/

	@Override
	public long insertCust(Customer cust) throws ClassNotFoundException, SQLException, Exception {
Connection connection = DBConnection.getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		long custId=0;
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.ADD_CUSTOMER);

			preparedStatement.setString(1,cust.getCustName());			
			preparedStatement.setString(2,cust.getAddress());
			preparedStatement.setString(3,cust.getEmail());
						
			
			queryResult=preparedStatement.executeUpdate();
		
			preparedStatement = connection.prepareStatement(QueryMapper.CUSTOMERID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				custId=resultSet.getLong(1);
						
			}
			
			
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new LoanException("Inserting details failed ");

			}
			else
			{
				logger.info("Customer details added successfully:");
				return custId;
			}
			
		}catch(SQLException sqlException)
		{
			sqlException.printStackTrace();
			logger.error(sqlException.getMessage());
			
		}
			
			
		return custId;
	}

}
