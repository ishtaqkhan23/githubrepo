package com.github.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Size;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class User {
	@MongoId
	private String id;

	@Size(min = 4, max = 255, message = "Minimum username length: 4 characters")
	private String username;

	private String email;

	@Size(min = 8, message = "Minimum password length: 8 characters")
	private String password;

	@JsonIgnore
	private List<RepositoryDocument> favRepos = new ArrayList<>();

	public User(String id, @Size(min = 4, max = 255, message = "Minimum username length: 4 characters") String username,
			String email, @Size(min = 8, message = "Minimum password length: 8 characters") String password,
			List<RepositoryDocument> favRepos) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.favRepos = favRepos;
	}

	public User() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

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

	public List<RepositoryDocument> getFavRepos() {
		return favRepos;
	}

	public void setFavRepos(List<RepositoryDocument> favRepos) {
		this.favRepos = favRepos;
	}

}
