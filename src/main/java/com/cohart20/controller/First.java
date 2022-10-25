package com.cohart20.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cohart20.pojo.User;

@RestController
public class First {
	@RequestMapping("/message")
	public String getMessage() {
		return "this is ur third  message  :";
	}

	@RequestMapping("/userInfo")
	public List<User> userInfo() {

		User u = new User(111, "falguni", "f@gmail.com", 40);
		User u1 = new User(222, "sarini", "s@gmail.com", 45);
		User u2 = new User(333, "dhyey", "d@gmail.com", 20);
		User u3 = new User(444, "dev", "dev@gmail.com", 15);
		List<User> user = new ArrayList<User>();

		user.add(u);
		user.add(u1);
		user.add(u2);
		user.add(u3);
		return user;
	}

	@RequestMapping("/userDbInfo")
	public List<User> userDbInfo() throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "45Epsomroad");
		PreparedStatement pstat = conn.prepareStatement("select * from user");
		ResultSet rs = pstat.executeQuery();
		List<User> user = new ArrayList<User>();
		while (rs.next()) {
			int uid = rs.getInt(1);
			String uname = rs.getString(2);
			String email = rs.getString(3);
			int age = rs.getInt(4);

			User user3 = new User(uid, uname, email, age);

			user.add(user3);

		}

		return user;
	}

}
