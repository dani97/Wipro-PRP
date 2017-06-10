package com.wipro.book.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.book.bean.BookBean;
import com.wipro.book.dao.AuthorDao;
import com.wipro.book.service.Administrator;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String operation = request.getParameter("operation");
		if(operation.equals("AddBook")){
			String result = addBook(request);
			
			if(result.equals("SUCCESS")){
				RequestDispatcher rd = request.getRequestDispatcher("/Menu.html");
				rd.include(request, response);  
			}
			else if(result.equals("FAILURE")){
				RequestDispatcher rd = request.getRequestDispatcher("Failure.html");
				rd.include(request, response); 
			}
			else{
				RequestDispatcher rd = request.getRequestDispatcher("Invalid.html");
				rd.include(request, response); 
			}
		}
		if(operation.equals("Search")){
			BookBean bean = viewBook(request.getParameter("isbn"));
			if(bean==null){
				RequestDispatcher rd = request.getRequestDispatcher("Invalid.html");
				rd.include(request, response);
				return;
			}
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    out.println("<!DOCTYPE html><html><head><title>View Book</title></head><body><table>");
		    String type="";
		    if(bean.getBookType()=='T')
		    	type = "Technical";
		    else if(bean.getBookType()=='G')
		    	type = "General";
		    else{
				RequestDispatcher rd = request.getRequestDispatcher("Failure.html");
				rd.forward(request, response);
				return;
		    }
		    
		    out.println("<tr><td>ISBN<td>"+bean.getIsbn()+"</tr>");
		    out.println("<tr><td>Book Name<td>"+bean.getBookName()+"</tr>");
		    out.println("<tr><td>Book Type<td>"+type+"</tr>");
		    out.println("<tr><td>Author Name<td>"+bean.getAuthor().getAuthorName()+"</tr>");
		    out.println("<tr><td>Contact<td>"+bean.getAuthor().getContactNumber()+"</tr>");
		    out.println("<tr><td>Cost<td>"+bean.getCost()+"</tr></table>");
		    out.println("</body></html>");
		    out.close();
		    
		}
	}
	
	public String addBook(HttpServletRequest request){
		Administrator admin = new Administrator();
		BookBean bean = new BookBean();
		bean.setIsbn(request.getParameter("isbn"));
		bean.setBookName(request.getParameter("bookname"));
		bean.setBookType(request.getParameter("booktype").charAt(0));
		bean.setAuthor(( new AuthorDao()).getAuthor(Integer.parseInt(request.getParameter("author")) ));
		bean.setCost(Float.parseFloat(request.getParameter("cost")));
		return admin.addBook(bean);
	}
	
	
	public BookBean viewBook(String isbn){
		return new Administrator().viewBook(isbn);
	}
	
}
