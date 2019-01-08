package com.cg.xyz.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
	
	/*************************************************************************************
	 *  - @throws Exception
	 *  - Author : CAPGEMINI 
	 *  - Creation Date : 8/01/2019
	 *  - Desc:Loads the  jdbc.properties file and Driver Class and gets the connection
	 ***************************************************************************************/
	
	public static Connection getConnection() throws Exception, ClassNotFoundException, SQLException {
		Properties properties=new Properties();
		//File f=new File("resources/DB.properties");
		FileInputStream	fis=new FileInputStream("resources/db.properties");
			properties.load(fis);
			
			String driver=properties.getProperty("driver");
			String url=properties.getProperty("url");
			String username=properties.getProperty("username");
			String password=properties.getProperty("password");
			
				Class.forName(driver);
				Connection connection=DriverManager.getConnection(url,username,password);		
	
			return connection;
	
	
	

}

}