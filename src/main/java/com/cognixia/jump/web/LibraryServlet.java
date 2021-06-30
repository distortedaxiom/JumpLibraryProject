package com.cognixia.jump.web;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.dao.BookDao;
import com.cognixia.jump.dao.PatronDao;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.BookCheckout;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/")
public class LibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BookDao bookDao;
    private PatronDao patronDao;
    private BookCheckout bookCheckout;

    @Override
    public void init() {
        bookDao = new BookDao();
        patronDao = new PatronDao();
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
        List<Book> checkoutBooks = bookDao.getPatronCheckoutBooks();
        request.setAttribute("allCheckoutBooks", checkoutBooks);
        RequestDispatcher dispatcher = request.getRequestDispatcher("checkout-books-list.jsp");
        dispatcher.forward(request, response);
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
