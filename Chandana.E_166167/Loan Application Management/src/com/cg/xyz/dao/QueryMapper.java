package com.cg.xyz.dao;

public interface QueryMapper {
	
	
	public static final String ADD_CUSTOMER="insert into customer values(Cust_seq.nextval,?,?,?)";
	public static final String CUSTOMERID_QUERY_SEQUENCE="select Cust_seq.currval from Customer";
	
}
