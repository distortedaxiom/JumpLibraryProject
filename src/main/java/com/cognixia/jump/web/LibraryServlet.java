package com.cognixia.jump.web;

import com.cognixia.jump.dao.PatronDao;
import com.cognixia.jump.model.Book;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class LibraryServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private PatronDao patronDao;

    @Override
    public void init() {
        patronDao = new PatronDao();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/books":
                listAllBooks(request, response);
                break;
            default:
                response.sendRedirect(request.getContextPath() + "/");
        }
    }

    private void listAllBooks(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = patronDao.getAllBooks();

        request.setAttribute("allBooks", books);

        RequestDispatcher dispatcher = request.getRequestDispatcher("books-list.jsp");
        dispatcher.forward(request, response);
    }
}
