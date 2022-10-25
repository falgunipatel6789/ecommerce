package com.cohart20.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cohart20.db.ConnectinMain;
import com.cohart20.tb.User;

public class UserDAO {

	public void setuser(String username, String password, String name, String lastname, String email) throws Exception {
		Connection conn = ConnectinMain.getconnection();
		PreparedStatement psmt = conn.prepareStatement("insert into user1 values(?,?,?,?,?)");

		psmt.setString(1, username);
		psmt.setString(2, password);
		psmt.setString(3, name);
		psmt.setString(4, lastname);
		psmt.setString(5, email);
		psmt.execute();
	}

	public void setuser1(User user) throws Exception {
		Connection conn = ConnectinMain.getconnection();
		PreparedStatement psmt = conn.prepareStatement("insert into user1 values(?,?,?,?,?)");

		psmt.setString(1, user.getUsername());
		psmt.setString(2, user.getPassword());
		psmt.setString(3, user.getName());
		psmt.setString(4, user.getLastname());
		psmt.setString(5, user.getEmail());
		psmt.execute();
	}

	public boolean loginSuccess(String username, String password) throws Exception {

		boolean loginSuccess = false;

		Connection conn = ConnectinMain.getconnection();

		PreparedStatement pstmt = conn.prepareStatement("select * from user1 where usernmae = ? and password = ?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			loginSuccess = true;
		}
		return loginSuccess;
	}

	public User loginSuccess1(String username, String password) throws Exception{
		Connection conn = ConnectinMain.getconnection();
		User user = null;
		PreparedStatement pstmt = conn.prepareStatement("select * from user1 where usernmae = ? and password = ?");

		pstmt.setString(1, username);
		pstmt.setString(2, password);

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			String uname = rs.getString(1);
			String pword = rs.getString(2);
			String name = rs.getString(3);
			String lname = rs.getString(4);
			String email = rs.getString(5);
			user =new User(uname,pword,name,lname,email);
		
			
			
		}
		return user;
	
	}
	public boolean userloginSuccess(String username) throws Exception{
		Connection conn = ConnectinMain.getconnection();
		User user = null;
		boolean logins = true;
		PreparedStatement pstmt = conn.prepareStatement("select * from user1 where usernmae = ?");

		pstmt.setString(1, username);
	

		ResultSet rs = pstmt.executeQuery();

		if (rs.next()) {
			logins = false;
		}
		return logins;
	}

	public List<User> getUsers() throws Exception {
List<User> users = new ArrayList<User>();
		
		Connection conn = ConnectinMain.getconnection();	
		PreparedStatement pstmt =  conn.prepareStatement("select * from user");
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
			
			String username = rs.getString(1);
			String password = rs.getString(2);
			String fName = rs.getString(3);
			String lName =rs.getString(4);
			String emailAddress = rs.getString(5);
			
			User user = new User(username, password, fName, lName, emailAddress);
			users.add(user);
		}
		
		return users;
		
	}

}
