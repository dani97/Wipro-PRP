package com.wipro.power.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.power.bean.ReadingBean;
import com.wipro.power.util.DBUtil;

public class ReadingDao {
	
	public int generateSerialNo()
	{
		Connection conn = DBUtil.getConnection();
		int serialno=0;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select power_seq.nextval from dual");
			while(rs.next())
			{
				serialno = rs.getInt(1);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return serialno;
	}
	
	public  String CreateReading(ReadingBean bean)
	{
		Connection conn = DBUtil.getConnection();
		
		try {
			PreparedStatement ps = conn.prepareStatement("insert into readings_tbl_me12 values(?,?,?,?,?,?,?,?,?,?)");
			ps.setInt(1, bean.getSerialNo());
			ps.setString(2, bean.getAssetId());
			ps.setString(3,bean.getType());
			ps.setInt(4,bean.getPresentReading());
			ps.setInt(5, bean.getPastReading());
			ps.setString(6,bean.getBillMonth());
			ps.setString(7, bean.getBillYear());
			ps.setInt(8, bean.getUnitsUsed());
			ps.setFloat(9,bean.getAmount());
			return "success";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
	}

	public ArrayList<ReadingBean> viewAllBillsByMonth(String month,String year)
	{
		Connection conn = DBUtil.getConnection();
		PreparedStatement ps;
		ArrayList<ReadingBean> list = new ArrayList<ReadingBean>(); 
		try {
			ps = conn.prepareStatement("select * from readings_tbl_me12 where billMonth = ? and billYear = ?");
			ps.setString(1, month);
			ps.setString(2, year);
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				ReadingBean bean = new ReadingBean();
				bean.setSerialNo(rs.getInt(1));
				bean.setAssetId(rs.getString(2));
				bean.setType(rs.getString(3));
				bean.setPresentReading(rs.getInt(4));
				bean.setPresentReading(rs.getInt(5));
				bean.setBillMonth(rs.getString(6));
				bean.setBillYear(rs.getString(7));
				bean.setUnitsUsed(rs.getInt(8));
				bean.setAmount(rs.getFloat(9));
				list.add(bean);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(list.size()==0)
			return null;
		return list;
		
	}
}
