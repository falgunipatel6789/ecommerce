package com.cohart20.pojo;

public class User {

	int userId;
	String userName;
	String email;
	int age;

	public User() {

	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public User(int userId, String userName, String email, int age) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.age = age;
	}
}
