package com.github.favorite.model;

import java.util.ArrayList;
import java.util.List;

import com.github.favorite.model.Repository;

//@Entity
public class User {
	private String username;
	private String email;
	private String password;
	private List<Repository> favRepos = new ArrayList<>();
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Repository> getFavRepos() {
		return favRepos;
	}
	public void setFavRepos(List<Repository> favRepos) {
		this.favRepos = favRepos;
	}
	public User( String username, String email, String password, List<Repository> favRepos) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.favRepos = favRepos;
	}
	public User() {
		super();
	}
}
