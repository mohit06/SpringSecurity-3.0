package com.webClient.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity(name = "USERS")
@Table(name = "USERS")
public class User {
	
	@Id
	@Column(name = "ID")
	private int id;
	@Column(name = "USERNAME")
	private String username;
	@Column(name = "PASSWORD")
	private String password;
//	@Column(name = "ENABLED")
//	private boolean enabled;
//	public boolean getEnabled() {
//		return enabled;
//	}
//	public void setEnabled(boolean enabled) {
//		this.enabled = enabled;
//	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int id, String username, String password) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
	//	this.enabled = enabled;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + "]";
	}
	public User() {
		super();
	}
	
	

}
