package com.cognixia.jump.dao;

import com.cognixia.jump.connection.ConnectionManager;
import com.cognixia.jump.model.Book;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {  
	
	private static final Connection connection = ConnectionManager.getConnection();
	
	private static final String PATRON_LOGIN = "SELECT * FROM patron where username = ? and password = ?";
	
	public static boolean validate(String username,String password){  
	
		boolean loggedIn = false;  
		
	try(PreparedStatement pstmt = connection.prepareStatement(PATRON_LOGIN)) {  
		
		pstmt.setString(1, username);
		pstmt.setString(2, password);
		
		ResultSet rs = pstmt.executeQuery();
		loggedIn = rs.next();
		
	          
	} catch(SQLException e){
		e.printStackTrace();
	}  
	
		return loggedIn;  
	}  
}  
