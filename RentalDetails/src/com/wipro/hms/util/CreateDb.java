package com.wipro.hms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDb {
	public static void main(String [] args)
	{

		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@orcl.rmk.ac.in:1521:ORCL","scott","tiger");
			System.out.println("success");
			Statement stmt  = conn.createStatement();
			 stmt.executeQuery("drop table  rental_tbl_me12");
			stmt.executeQuery("create table rental_tbl_me12(propertyid varchar2(7) not null,rentalamount number(10,2) not null,location varchar2(10) not null,numbedrooms number(2) not null,city varchar2(20) not null)");
			stmt.executeQuery("ALTER TABLE rental_tbl_me12 ADD (CONSTRAINT dept_pk PRIMARY KEY (propertyid))");
            stmt.execute("CREATE SEQUENCE renatl_seq START WITH 1000");
		}
		catch(ClassNotFoundException e)
		{
			System.out.println("Driver Not Found");
			
		}
		catch(SQLException e)
		{
			System.out.println("Could not connect to database");
			e.printStackTrace();
		
			
		}
	}

}
