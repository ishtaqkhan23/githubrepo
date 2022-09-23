package com.github.favorite.model;

public class Repository {
	
	private String repoName;
	private String repoLocation;

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
	public Repository( String repoName, String repoLocation) {
		super();
		this.repoName = repoName;
		this.repoLocation = repoLocation;
	}
	public Repository() {
		super();
	}
}
