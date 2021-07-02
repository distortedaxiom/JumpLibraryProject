package com.jump.cognixia.library.demo3.dao;

import com.jump.cognixia.library.demo3.connection.ConnectionManager;
import com.jump.cognixia.library.demo3.model.BookCheckout;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookCheckoutDao {

    private static final Connection connection = ConnectionManager.getConnection();

    private static final String ALL_BOOK_CHECKOUTS = "SELECT * FROM book_checkout";
    private static final String INSERT_CHECKOUT_BOOK = "insert into book_checkout(checkout_id, patron_id, isbn, checkedout, due_date, returned) values (null,?, ?, current_date(), date_add(current_date(), interval 14 day), null)";
    private static final String RETURN_CHECKEDOUT_BOOK_DATE = "update book_checkout set returned = current_date() where returned is null and book_checkout.isbn = ? and patron_id = ?";
    private static final String RETURN_CHECKEDOUT_BOOK_RENTED = "update book inner join book_checkout on book.isbn = book_checkout.isbn set book.rented = 0 where book.isbn = ? and book_checkout.patron_id = ?";
    private static final String CHECKOUT_BOOK_RENTED  = "update book inner join book_checkout on book.isbn = book_checkout.isbn set book.rented = 1 where book.isbn = ? and book_checkout.patron_id = ?";
    
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

    public boolean checkoutBook(int patronId, String isbn){
    	
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(INSERT_CHECKOUT_BOOK);
        PreparedStatement preparedStatement2 = connection.prepareStatement(CHECKOUT_BOOK_RENTED)){
            preparedStatement1.setInt(1, patronId);
            preparedStatement1.setString(2, isbn);
            
            preparedStatement2.setString(1, isbn);
            preparedStatement2.setInt(2, patronId);
 

            if ((preparedStatement1.executeUpdate() > 0) && (preparedStatement2.executeUpdate() > 0)) {
                return true;
            }

        } catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean returnBook(int patronId, String isbn) {
    	
        try (PreparedStatement preparedStatement1 = connection.prepareStatement(RETURN_CHECKEDOUT_BOOK_DATE);
        PreparedStatement preparedStatement2 = connection.prepareStatement(RETURN_CHECKEDOUT_BOOK_RENTED)) {
            preparedStatement1.setString(1, isbn);
            preparedStatement1.setInt(2, patronId);
            
            preparedStatement2.setString(1, isbn);
            preparedStatement2.setInt(2, patronId);
        
         
            if ((preparedStatement1.executeUpdate() > 0) && (preparedStatement2.executeUpdate() > 0)) {
                return true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}