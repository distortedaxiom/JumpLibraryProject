package com.cognixia.jump.web;

import com.cognixia.jump.dao.LoginDao;
import com.cognixia.jump.dao.PatronDao;
import com.cognixia.jump.model.Patron;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccountServlet extends HttpServlet {

    private PatronDao patronDao;

    @Override
    public void init() {
        patronDao = new PatronDao();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
		Patron p = null;
    	
        HttpSession session = request.getSession();

        Patron patron = (Patron) session.getAttribute("patron");
        session.setAttribute("patron", patron);

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (patronDao.changeFirstName(firstname, patron.getId()) &&
                patronDao.changeLastName(lastname, patron.getId()) &&
                patronDao.changeUsername(username, patron.getId()) &&
                patronDao.changePassword(password, patron.getId())) {
        	
    		p = LoginDao.getPatronInfo(username, password);
    		
            session.setAttribute("patron", p); 

            response.sendRedirect(request.getContextPath() + "/books");

        } else {

            RequestDispatcher dispatcher = request.getRequestDispatcher("account.jsp");
            dispatcher.forward(request, response);

        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
