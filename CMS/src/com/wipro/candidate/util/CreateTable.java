package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getDbConn();
		try {
			Statement stmt = conn.createStatement();
			stmt.execute("drop table candidate_tbl_me12");
			stmt.execute("drop sequence candidate_SEQ");
			stmt.execute("create table candidate_tbl_me12 (ID varchar2(10) not null,name varchar2(20),M1 number(3),M2 number(3),M3 number(3),result varchar2(15),grade varchar2(15),CONSTRAINT candidate_dk primary key(ID))");
			stmt.execute("create sequence candidate_SEQ start With 5000 minvalue 5000 maxvalue 7000 increment by 1");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
