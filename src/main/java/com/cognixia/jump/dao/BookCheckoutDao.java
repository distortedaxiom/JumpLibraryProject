package com.cognixia.jump.dao;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.BookCheckout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCheckoutDao {

    private static final Connection connection = ConnectionManager.getConnection();

    private static final String ALL_BOOK_CHECKOUTS = "SELECT * FROM book_checkout";

    public List<BookCheckout> getAllCheckoutBooks() {

        List<BookCheckout> checkoutBooks = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(ALL_BOOK_CHECKOUTS);
            ResultSet resultSet = preparedStatement.executeQuery() ) {

            while (resultSet.next()) {
                checkoutBooks.add(new BookCheckout(resultSet.getInt("checkout_id"),
                        resultSet.getInt("patron_id"),
                        resultSet.getInt("isbn"),
                        resultSet.getDate("checkedout"),
                        resultSet.getDate("due_date"),
                        resultSet.getDate("returned")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return checkoutBooks;
    }
}