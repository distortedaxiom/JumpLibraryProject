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

    private static final String UPDATE_FIRST_NAME = "update patron set first_name = ? where patron_id = ?";
    private static final String UPDATE_LAST_NAME = "update patron set last_name = ? where patron_id = ?";
    private static final String UPDATE_USERNAME = "update patron set username = ? where patron_id = ?";
    private static final String UPDATE_PASSWORD = "update patron set password = ? where patron_id = ?";

    public boolean changeFirstName(String firstname, int patronId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_FIRST_NAME)) {
            preparedStatement.setString(1, firstname);
            preparedStatement.setInt(2, patronId);

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean changeLastName(String lastname, int patronId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_LAST_NAME)) {
            preparedStatement.setString(1, lastname);
            preparedStatement.setInt(2, patronId);

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean changeUsername(String username, int patronId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERNAME)) {
            preparedStatement.setString(1, username);
            preparedStatement.setInt(2, patronId);

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean changePassword(String password, int patronId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PASSWORD)) {
            preparedStatement.setString(1, password);
            preparedStatement.setInt(2, patronId);

            if (preparedStatement.executeUpdate() > 0) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
