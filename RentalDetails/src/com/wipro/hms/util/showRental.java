package com.wipro.hms.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class showRental {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection conn = DBUtil.getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from rental_tbl_me12");
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
