package com.wipro.power.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
			 stmt.executeQuery("drop table  power_rate_tbl_me12");
			 stmt.executeQuery("drop table  readings_tbl_me12");
			 stmt.executeQuery("drop sequence  power_seq");
			stmt.executeQuery("create table power_rate_tbl_me12(type varchar2(8) not null,slab1 number(4),slab2 number(4),slab3 number(4),slab1rate number(4,2),slab2rate number(4,2),slab3rate number(4,2),CONSTRAINT power_pk PRIMARY KEY (type))");
			stmt.executeQuery("create table readings_tbl_me12(serialno varchar2(4) not null,assetid varchar2(6),type varchar2(4),presentReading number(6),pastReading number(6),billMonth varchar2(12),billYear varchar(4),unitsUsed number(6),amount number(10,2),CONSTRAINT rate_pk PRIMARY KEY (serialno))");
			stmt.execute("CREATE SEQUENCE power_seq START WITH 1000 INCREMENT By 1 maxvalue 9999 ");
			PreparedStatement ps = conn.prepareStatement("insert into power_rate_tbl_me12 values(?,?,?,?,?,?,?)");
			ps.setString(1, "house");
			ps.setInt(2,0 );
			ps.setInt(3, 25);
			ps.setInt(4, 50);
			ps.setFloat(5, 1.5f);
			ps.setFloat(6, 3.45f);
			ps.setFloat(7, 7.85f);
			ps.execute();
			ps.setString(1, "shop");
			ps.setInt(2,0);
			ps.setInt(3, 100);
			ps.setInt(4, 200);
			ps.setFloat(5, 3.55f);
			ps.setFloat(6, 9.55f);
			ps.setFloat(7, 16.95f);
			ps.execute();
			ps.setString(1, "mall");
			ps.setInt(2, 0);
			ps.setInt(3, 500);
			ps.setInt(4, 1000);
			ps.setFloat(5, 7.85f);
			ps.setFloat(6, 15.45f);
			ps.setFloat(7, 27.65f);
			ps.execute();
			ps = conn.prepareStatement("select * from power_rate_tbl_me12");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}
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
