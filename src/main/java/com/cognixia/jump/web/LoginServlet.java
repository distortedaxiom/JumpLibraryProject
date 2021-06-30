package com.cognixia.jump.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognixia.jump.dao.LoginDao;


/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginDao loginDao; 
	
    public LoginServlet() {
        super();
        
    }
    
    @Override
    public void init() throws ServletException {
    	loginDao = new LoginDao();
    }
    

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		
	if (LoginDao.validate(username, password)) {
		
		response.sendRedirect(request.getContextPath()+"/books");
		
	} else {
		System.out.println("ERROR");
	}

	}
}
