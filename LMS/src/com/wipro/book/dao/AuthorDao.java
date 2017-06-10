package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.wipro.book.bean.AuthorBean;
import com.wipro.book.util.DBUtil;

public class AuthorDao {
	public AuthorBean getAuthor(int authorCode){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from author_tbl_me12 where author_code=?");
			ps.setInt(1, authorCode);
			ResultSet rs = ps.executeQuery();
			AuthorBean bean = null;
			while(rs.next()){
				bean = new AuthorBean();
				bean.setAuthorCode(authorCode);
				bean.setAuthorName(rs.getString(2));
				bean.setContactNumber(rs.getLong(3));
			}
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.println("error"+authorCode);
		}
		
		return null;
	}
	
	public AuthorBean getAuthor(String authorName){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from author_tbl_me12 where author_name=?");
			ps.setString(1, authorName);
			ResultSet rs = ps.executeQuery();
			AuthorBean bean = new AuthorBean();
			while(rs.next()){
				bean.setAuthorCode(rs.getInt(1));
				bean.setAuthorName(rs.getString(2));
				bean.setContactNumber(rs.getLong(3));
			}
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
