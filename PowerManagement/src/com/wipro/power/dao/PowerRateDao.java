package com.wipro.power.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.power.bean.PowerRateBean;
import com.wipro.power.util.DBUtil;

public class PowerRateDao {
	public PowerRateBean findRateByType(String type)
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps;
		PowerRateBean bean = new PowerRateBean();
		try {
			ps = conn.prepareStatement("select * from power_rate_tbl_me12 where type =?");
			ps.setString(1, type);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				bean.setType(rs.getString(1));
				bean.setSlab1(rs.getInt(2));
				bean.setSlab2(rs.getInt(3));
				bean.setSlab3(rs.getInt(4));
				bean.setSlab1rate(rs.getFloat(5));
				bean.setSlab2rate(rs.getFloat(6));
				bean.setSlab3rate(rs.getFloat(7));
			}
			
		return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
