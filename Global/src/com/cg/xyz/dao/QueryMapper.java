package com.cg.xyz.dao;

public interface QueryMapper {

	String INSERT_Customer_QUERY = "insert into customer values(cust_id_seq.nextval,?,?,?)";

}
