package com.cohart20.service;

import com.cohart20.dao.UserDAO;

public class UserService {

	public void setuser(String username, String password, String name, String lastname, String email) throws Exception {
		UserDAO user = new UserDAO();
		user.setuser(username, password, name, lastname, email);
	}

}
