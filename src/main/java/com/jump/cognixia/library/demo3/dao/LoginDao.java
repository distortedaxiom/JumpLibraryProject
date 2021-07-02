package com.jump.cognixia.library.demo3.dao;

import com.jump.cognixia.library.demo3.connection.ConnectionManager;
import com.jump.cognixia.library.demo3.model.Patron;

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
	
	public static Patron getPatronInfo(String username, String password) {
		
		int id = 0;
	    String first_name = null;
	    String last_name = null;
	    boolean frozen;
	    
	    Patron p = null;
		
		try(PreparedStatement pstmt = connection.prepareStatement(PATRON_LOGIN)) {  
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			
			id = rs.getInt("patron_id");
			first_name = rs.getString("first_name");
			last_name = rs.getString("last_name");
			frozen = rs.getBoolean("account_frozen");
			
			p = new Patron(id, first_name, last_name, username, password, frozen);
		          
		} catch(SQLException e){
			e.printStackTrace();
		}
		
		return p;
		
	}
}  
