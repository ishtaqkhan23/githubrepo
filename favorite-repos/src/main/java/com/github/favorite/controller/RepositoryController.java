package com.github.favorite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.favorite.dao.Repository;
import com.github.favorite.entities.RepositoryDocument;
@CrossOrigin
@RestController
@RequestMapping("/repository")
public class RepositoryController {
	
	@Autowired
	Repository repository;
	
	@PostMapping
	public RepositoryDocument createRepo(@RequestBody com.github.favorite.model.Repository repoDoc) {
		RepositoryDocument rd = new RepositoryDocument();
		rd.setRepoLocation(repoDoc.getRepoLocation());
		rd.setRepoName(repoDoc.getRepoName());
		return repository.save(rd);
	}
	
	@GetMapping
	public List<RepositoryDocument> getRepos() {
		return repository.findAll();
	}
}
