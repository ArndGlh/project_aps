package com.epsi.projectaps.model;

import java.util.ArrayList;
import java.util.List;

public class User {

	private int id;
	private String userName;
	private String password;
	private String passwordConfirm;
	private String userMail;
	private List<User> contacts;
	public boolean authenticated;

	public User(){
		this.contacts = new ArrayList<>();
	}

	public User(String username, String password, String usermail) {
		this.userName = username;
		this.password = password;
		this.userMail = usermail;
		this.contacts = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public List<User> getContacts() {
		return contacts;
	}

	public void setContacts(List<User> contacts) {
		this.contacts = contacts;
	}

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}
}
