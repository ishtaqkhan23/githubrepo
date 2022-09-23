package com.favorite.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.favorite.controller.RepositoryController;
import com.github.favorite.dao.Repository;
import com.github.favorite.entities.RepositoryDocument;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = RepositoryControllerTest.class)
public class RepositoryControllerTest {

	@InjectMocks
	RepositoryController repositoryController;
	@Mock
	Repository repository;
	
	
	@BeforeAll
	public void config() {
		java.util.List<RepositoryDocument> rdl=new ArrayList<>();
		RepositoryDocument rd = new RepositoryDocument(1, "repo1", "http://localhost:8084");
		rdl.add(rd);
		when(repository.findAll()).thenReturn(rdl);
	}
	
	@Test
	public void testRepoList() {
		List<RepositoryDocument> rdl= repositoryController.getRepos();
		assertNotNull(rdl);
	}
	
	@Test
	public void testCreateRepo() {
		com.github.favorite.model.Repository repo = new com.github.favorite.model.Repository();
		repo.setRepoName("repo1");
		repo.setRepoLocation("http://localhost:8080");
		
		RepositoryDocument rd = new RepositoryDocument(1, "repo1", "http://localhost:8084");
		when(repository.save(rd)).thenReturn(rd);
		RepositoryDocument rd1 = repositoryController.createRepo(repo);
		assertNotNull(rd1);
	}
}
