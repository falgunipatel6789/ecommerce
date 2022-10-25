package com.cohart20.service;

import java.util.List;

import com.cohart20.dao.UserDAO;
import com.cohart20.tb.User;

public class UserService1 {
	public void setuser(User user1) throws Exception {
		UserDAO user = new UserDAO();
		user.setuser1(user1);
	}
public  User login(String username, String password) throws Exception {
		
		UserDAO userDao = new UserDAO();
		
		User loginSuccess = userDao.loginSuccess1(username, password);
		
		return loginSuccess;
}
public  boolean userlogin(String username) throws Exception {
	
	UserDAO userDao = new UserDAO();
	
	boolean loginSuccess = userDao.userloginSuccess(username);
	
	return loginSuccess;
}

public List<User> getAllUsers() throws Exception {
		
		UserDAO userDao = new UserDAO();
		
		List<User> users = userDao.getUsers();
		
		return users;
	
}

}