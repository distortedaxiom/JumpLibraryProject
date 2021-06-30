package com.cognixia.jump.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cognixia.jump.dao.LoginDao;
import com.cognixia.jump.model.Patron;


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
		
		Patron p = null;
		
		String username = request.getParameter("username").toLowerCase();
		String password = request.getParameter("password");
		
	if (LoginDao.validate(username, password)) {
		
		p = LoginDao.getPatronInfo(username, password);
		
        HttpSession session=request.getSession();  
        session.setAttribute("patron", p); 
        
		response.sendRedirect(request.getContextPath()+"/books");
		
	} else {
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request, response);
	}

	}
}
