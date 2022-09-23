package com.github.favorite.entities;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RepositoryDocument {

	public String getRepoName() {
		return repoName;
	}

	public String getRepoLocation() {
		return repoLocation;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((repoName == null) ? 0 : repoName.hashCode());
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
		RepositoryDocument other = (RepositoryDocument) obj;
		if (repoName == null) {
			if (other.repoName != null)
				return false;
		} else if (!repoName.equals(other.repoName)) {
			return false;
		}
		return true;
	}

	private int id;
	private String repoName;
	private String repoLocation;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setRepoName(String repoName) {
		this.repoName = repoName;
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
