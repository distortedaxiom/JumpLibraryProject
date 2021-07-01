package com.cognixia.jump.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cognixia.jump.connection.ConnectionManager;

public class SignupDao {

	private static final Connection connection = ConnectionManager.getConnection();
	
	private static final String PATRON_SIGNUP = "INSERT INTO patron (first_name, last_name, username, password) VALUES (?, ?, ?, ?)";
	
	public static boolean signup(String first_name, String last_name, String username, String password){  
	
		boolean signedUp = false;  
		
	try(PreparedStatement pstmt = connection.prepareStatement(PATRON_SIGNUP)) {  
		
		pstmt.setString(1, first_name);
		pstmt.setString(2, last_name);
		pstmt.setString(3, username);
		pstmt.setString(4, password);
		
		if (pstmt.executeUpdate() > 0) {
			return true;
		};
		
		
	} catch(SQLException e){
		e.printStackTrace();
	}  
	
		return signedUp;  
	}
	
}
