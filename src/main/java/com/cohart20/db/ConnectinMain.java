package com.cohart20.db;

import java.sql.Connection;

import java.sql.DriverManager;

public   class ConnectinMain {

	public static Connection getconnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employees", "root", "45Epsomroad");
		return conn;
	}

}