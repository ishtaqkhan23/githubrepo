package com.github.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RepositoryDocument {
	
	private int id;
	private String repoName;
	private String repoLocation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRepoName() {
		return repoName;
	}
	public void setRepoName(String repoName) {
		this.repoName = repoName;
	}
	public String getRepoLocation() {
		return repoLocation;
	}
	public void setRepoLocation(String repoLocation) {
		this.repoLocation = repoLocation;
	}
	public RepositoryDocument(int id, String repoName, String repoLocation) {
		super();
		this.id = id;
		this.repoName = repoName;
		this.repoLocation = repoLocation;
	}
	public RepositoryDocument() {
		super();
	}

	

}
