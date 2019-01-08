package com.cg.xyz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.cg.Loan.util.DBConnection;
import com.cg.xyz.bean.Customer;


public class LoanDao implements ILoanDao{
Customer customer = null;
	@Override
	public long insertCust(Customer cust) throws Exception {
		
		Connection con = DBConnection.getConnection();
		
		
		ResultSet resultSet = null;
		int custId =0;
		
		try 
		{
			
			
		PreparedStatement	pst = con.prepareStatement(QueryMapper.INSERT_Customer_QUERY);
			
			
			pst.setString(1, customer.getCustName());
			pst.setString(2, customer.getAddress());
			pst.setString(3, customer.getEmail());
			
			pst.executeUpdate();
			
		
		System.out.println("5");
		Statement st = con.createStatement();
		
		resultSet= st.executeQuery("select max(cust_Id) from customer");
		while(resultSet.next()) {
			System.out.println("3");
		custId = resultSet.getInt(1);
		
			return custId;
		}
		}
		catch(Exception e) {
			
		}
		return custId;
	}

	@Override
	public double calculateEmi(double amount, int duration) {
		// TODO Auto-generated method stub
		return 0;
	}

}
