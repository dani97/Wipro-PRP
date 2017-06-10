package com.wipro.hms.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wipro.hms.bean.RentalPropertyBean;
import com.wipro.hms.util.*;

public class RentalPropertyObject {
	public String generatePropertyId(String city)
	{
		Connection conn = DBUtil.getConnection();
		String id = "",cityfr = "";
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select renatl_seq.nextval from dual");
			while(rs.next())
			{
				id = rs.getString(1);
			}
			 cityfr = city.substring(0,4);
			return cityfr+id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";	
	}
	
	public int createRentalProperty(RentalPropertyBean bean)
	{
		
		Connection conn = DBUtil.getConnection();
		String id = generatePropertyId(bean.getCity());
		int rowcount =0;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into rental_tbl_me12 (propertyid,rentalamount,location,city,numbedrooms) values(?,?,?,?,?)");
			ps.setString(1, id);
			ps.setFloat(2, bean.getRentalAmount());
			ps.setString(3, bean.getLocation());
			ps.setString(4, bean.getCity());
			ps.setInt(5, bean.getNumbedrooms());
			rowcount = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;
	}
	
	
	public List<RentalPropertyBean> findPropertyByCriteria(float minRentalAmount,float maxRentalAmount,RentalPropertyBean bean)
	{
		Connection conn = DBUtil.getConnection();
		List<RentalPropertyBean> result = new ArrayList<RentalPropertyBean>();
		try{
			PreparedStatement ps = conn.prepareStatement("select * from rental_tbl_me12 where rentalamount between ? and ? and UPPER(city) = ? and UPPER(location) = ?");
			ps.setFloat(1, minRentalAmount);
			ps.setFloat(2, maxRentalAmount);
			ps.setString(3, bean.getCity().toUpperCase());
			ps.setString(4,bean.getLocation().toUpperCase());
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				RentalPropertyBean temp = new RentalPropertyBean();
				temp.setPropertyId(rs.getString(1));
				temp.setRentalAmount(rs.getFloat(2));
				temp.setLocation(rs.getString(5));
				temp.setCity(rs.getString(3));
				temp.setNumbedrooms(rs.getInt(4));
				result.add(temp);
				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5));
			}
			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return result;
	}

}
