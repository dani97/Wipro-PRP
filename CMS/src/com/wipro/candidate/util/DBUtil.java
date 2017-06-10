package com.wipro.candidate.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	public static Connection getDbConn()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn  = DriverManager.getConnection("jdbc:oracle:thin:@orcl.rmk.ac.in:1521:ORCL","scott","tiger");
			System.out.println("Success");
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		return null; 
	}
}
