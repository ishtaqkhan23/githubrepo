package com.github.favorite.entities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

//@Entity
@Document
public class User {
	@MongoId
	private String id;
	private String username;
	private String email;
	private String password;
	private List<RepositoryDocument> favRepos = new ArrayList<>();
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
	public User(String id, String username, String email, String password, List<RepositoryDocument> favRepos) {
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username)) {
			return false;
		}
		return true;
	}
}
