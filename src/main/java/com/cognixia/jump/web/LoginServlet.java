package com.cognixia.jump.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = -1553054370076316817L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// get the values from the form, should be using names attribute from inputs
		String email = req.getParameter("email").trim().toLowerCase();
		String password = req.getParameter("pw").trim();
		
		// PrintWriter will help us write an html document as a response to the form submission
		PrintWriter pw = res.getWriter();
		
		// will make sure the following lines we print to the page are recognized as html
		res.setContentType("text/html");
		
		
		pw.println("<html>");
		
		pw.println("<head>");
		pw.println("<title>Login Status</title>");
		//you can include the bootstrap link to use the styling
		pw.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
		pw.println("</head>");
		
		pw.println("<body>");
		
		if(email.matches(".+@cognixia\\.com") && password.matches("123")) {
			
			// we use the alert class to style our message from bootstrap
			pw.print("<div class=\"alert alert-success\">Login Sucessful!!</div>");
		}
		else {
			pw.print("<div class=\"alert alert-danger\">Incorrect Login</div>");
		}
		
		
		pw.println("</body>");
		
		pw.println("</html>");
		
	}

	
}
