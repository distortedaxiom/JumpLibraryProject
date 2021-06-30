package com.cognixia.jump.dao;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatronDao {
    private static final Connection connection = ConnectionManager.getConnection();

    private static final String ALL_BOOKS = "SELECT * FROM book";

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
}
