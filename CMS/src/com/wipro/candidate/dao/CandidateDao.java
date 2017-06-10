package com.wipro.candidate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.wipro.candidate.bean.CandidateBean;
import com.wipro.candidate.util.DBUtil;

public class CandidateDao {
	public String addCandidate(CandidateBean bean)
	{
		Connection conn = DBUtil.getDbConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into candidate_tbl_me12 values(?,?,?,?,?,?,?)");
			ps.setString(1, bean.getId());
			ps.setString(2, bean.getName());
			ps.setInt(3, bean.getM1());
			ps.setInt(4, bean.getM2());
			ps.setInt(5, bean.getM3());
			ps.setString(6, bean.getResult());
			ps.setString(7, bean.getGrade());
			if(ps.execute())
				return "SUCCESS";
			else
				return "FAIL";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return "FAIL";
		}

	}


	public ArrayList<CandidateBean>getByResult(String criteria)
	{
		Connection conn = DBUtil.getDbConn();
		ArrayList<CandidateBean> res = new ArrayList<CandidateBean>();
		ResultSet rs = null;
		try{
			if(criteria.equals("ALL"))
			{
				PreparedStatement ps = conn.prepareStatement("select * from candidate_tbl_me12");
				rs = ps.executeQuery();
			}
			else
			{
				PreparedStatement ps = conn.prepareStatement("select * from candidate_tbl_me12 where result=? ");
				ps.setString(1, criteria);
				rs = ps.executeQuery();
			}


			while(rs.next())
			{
				CandidateBean bean = new CandidateBean();
				bean.setId(rs.getString(1));
				bean.setName(rs.getString(2));
				bean.setM1(rs.getInt(3));
				bean.setM2(rs.getInt(4));
				bean.setM3(rs.getInt(5));
				bean.setResult(rs.getString(6));
				bean.setGrade(rs.getString(7));
				res.add(bean);
			}
			if(res.isEmpty())
			{
				return null;
			}
			else
			{
				return res;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return null;
	}

	public String generateCandidateId(String name)
	{
		Connection conn = DBUtil.getDbConn();
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select candidate_SEQ.nextval from dual");
			String gen = name.substring(0,2).toUpperCase();
			while(rs.next())
			{
				gen += rs.getString(1);
			}
			return gen;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
