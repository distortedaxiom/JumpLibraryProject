package com.cognixia.jump.dao;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;
import com.cognixia.jump.model.BookCheckout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static final Connection connection = ConnectionManager.getConnection();

    private static final String ALL_BOOKS = "SELECT * FROM book";
    private static final String ALL_CHECKOUT_BOOKS = "select distinct book.isbn, book.title, descr from book, book_checkout where book.isbn = book_checkout.isbn";
    private static final String ALL_CURRENT_CHECKOUT_BOOKS =
            "select distinct book.isbn, book.title, book_checkout.checkedout, book_checkout.returned " +
            "from book, book_checkout, patron " +
            "where book_checkout.patron_id = patron.patron_id " +
                    "and book.isbn = book_checkout.isbn;";


    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_BOOKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                books.add(new Book(resultSet.getInt("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("descr"),
                        resultSet.getBoolean("rented"),
                        resultSet.getDate("added_to_library")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return books;
    }

    public List<Book> getAllCheckoutBooks() {
        List<Book> checkoutBooks = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_CURRENT_CHECKOUT_BOOKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                checkoutBooks.add(new Book(resultSet.getInt("isbn"),
                        resultSet.getString("title"),
                        resultSet.getString("descr")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkoutBooks;
    }

    public List<Book> getPatronCheckoutBooks() {
        List<Book> currentCheckoutBooks = new ArrayList<>();

        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_CURRENT_CHECKOUT_BOOKS);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            while (resultSet.next()) {
                BookCheckout bookCheckout = new BookCheckout(resultSet.getDate("checkedout"), resultSet.getDate("returned"));
                currentCheckoutBooks.add(new Book(resultSet.getInt("isbn"),
                        resultSet.getString("title"),
                        bookCheckout.getCheckOutDate(),
                        bookCheckout.getReturnDate()));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return currentCheckoutBooks;
    }
}
