package com.wipro.book.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@orcl.rmk.ac.in:1521:ORCL","scott","tiger");
			System.out.println("success");
			Statement stmt  = conn.createStatement();
			stmt.executeQuery("drop table  book_tbl_me12");
			 stmt.executeQuery("drop table  author_tbl_me12");
			stmt.executeQuery("create table author_tbl_me12(author_code number(5) primary key,author_name varchar2(20) not null,contact_no number(10))");
			stmt.executeQuery("create table book_tbl_me12(ISBN varchar2(10) primary key,book_title varchar2(20) not null,book_type char(1),author_code number(5) not null,book_cost number(15,2) not null,constraint bk_ck check(book_type='T' or book_type='G'),constraint au_fk foreign key(author_code) references author_tbl_me12(author_code))");
			stmt.executeQuery("insert into author_tbl_me12 values (1,'RobinSharma',8800799224)");
			stmt.executeQuery("insert into author_tbl_me12 values (2,'R.K.Narayan',8800799255)");
			stmt.executeQuery("insert into author_tbl_me12 values (3,'Paulo',8800799775)");

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
		return;
	}

}
