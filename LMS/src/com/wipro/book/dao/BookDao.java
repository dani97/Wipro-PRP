package com.wipro.book.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.wipro.book.bean.BookBean;
import com.wipro.book.util.DBUtil;

public class BookDao {
	public BookBean fetchBook(String ISBN){
		Connection conn = DBUtil.getDBConnection();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select * from book_tbl_me12 where ISBN=?");
			ps.setString(1, ISBN);
			ResultSet rs = ps.executeQuery();
			BookBean bean =null;
			while(rs.next()){
				bean = new BookBean();
				bean.setIsbn(ISBN);
				bean.setBookName(rs.getString(2));
				bean.setBookType(rs.getString(3).charAt(0));
				bean.setAuthor( new AuthorDao().getAuthor(rs.getInt(4)));
				bean.setCost(rs.getFloat(5));
			}
			return bean;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException e){
			System.out.println("error"+ISBN);
			
		}
		
		return null;
	}
	
	public int createBook(BookBean book){
		Connection conn = DBUtil.getDBConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into book_tbl_me12 values(?,?,?,?,?)");
			ps.setString(1, book.getIsbn());
			ps.setString(2, book.getBookName());
			ps.setString(3,((Character)book.getBookType()).toString());
			ps.setInt(4, book.getAuthor().getAuthorCode());
			ps.setFloat(5, book.getCost());
			ps.execute();
			return 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
		
		
	}

}
