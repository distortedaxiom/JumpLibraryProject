package com.cognixia.jump.web;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDao;
import com.cognixia.jump.dao.LoginDao;
import com.cognixia.jump.dao.PatronDao;
import com.cognixia.jump.dao.BookCheckoutDao;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.BookCheckout;
import com.cognixia.jump.model.Patron;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class LibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookDao bookDao;
    private PatronDao patronDao;
    private BookCheckoutDao bookCheckoutDao;
    private BookCheckout bookCheckout;
    @Override
    public void init() {
        bookDao = new BookDao();
        patronDao = new PatronDao();
        bookCheckoutDao = new BookCheckoutDao();
        bookCheckout = new BookCheckout();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/books":
                listAllBooks(request, response);
                break;
            case "/checkout":
                listAllCheckoutBooks(request, response);
                break;
            case "/signup":
            	goToSignupPage(request, response);
            	break;
            case "/checkoutbook":
            	checkoutBook(request, response);
            	break;
            case "/returnbook":
            	returnBook(request, response);
            	break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
        }
    }

    private void listAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = bookDao.getAllBooks();

        request.setAttribute("allBooks", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("books-list.jsp");
        dispatcher.forward(request, response);
    }

    private void listAllCheckoutBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	HttpSession session = request.getSession(false);
    	
    	Patron patron = (Patron) session.getAttribute("patron");
    	
        List<Book> previousCheckoutBooks = bookDao.getPatronPreviousCheckoutBooks(patron.getId());
        List<Book> currentCheckoutBooks = bookDao.getPatronCurrentCheckoutBooks(patron.getId());
        request.setAttribute("previousCheckoutBooks", previousCheckoutBooks);
        request.setAttribute("currentCheckoutBooks", currentCheckoutBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout-books-list.jsp");
        dispatcher.forward(request, response);
    }
    
	private void goToSignupPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("signup.jsp");
		dispatcher.forward(request, response);
	}
	
	private void checkoutBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession(false);
    	
    	Patron patron = (Patron) session.getAttribute("patron");
		
		String isbn  = request.getParameter("isbn");
		
		bookCheckoutDao.checkoutBook(patron.getId(), isbn);
		
		response.sendRedirect(request.getContextPath() + "/books");
		
	}
	
	private void returnBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	HttpSession session = request.getSession(false);
    	
    	Patron patron = (Patron) session.getAttribute("patron");
    	
    	String isbn  = request.getParameter("isbn");
		
		bookCheckoutDao.returnBook(patron.getId(), isbn);
		
		response.sendRedirect(request.getContextPath() + "/checkout");
		
	}


    @Override
    public void destroy() {
        try {
            ConnectionManager.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}