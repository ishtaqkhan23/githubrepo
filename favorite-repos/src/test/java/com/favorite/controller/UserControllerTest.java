package com.favorite.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.github.favorite.controller.UserController;
import com.github.favorite.dao.UserRepositiry;
import com.github.favorite.entities.RepositoryDocument;
import com.github.favorite.entities.User;

@TestInstance(Lifecycle.PER_CLASS)
@SpringBootTest(classes = RepositoryControllerTest.class)
public class UserControllerTest {
	@Mock
	UserRepositiry userRepositiry;
	
	@InjectMocks
	UserController userController;
	
	@Mock
	Query query;
	
	@Mock
	Update update;
	
	@Test
	public void getUserRepos(){
		User user = new User();
		RepositoryDocument rd = new RepositoryDocument(1, "myrepo", "http://localhost:8080");
		List<RepositoryDocument> rdl = new ArrayList<>();
		rdl.add(rd);
		user.setFavRepos(rdl);
		when(userRepositiry.findFirstByUsername("username")).thenReturn(Optional.of(user));
		List<RepositoryDocument> rdl1 =userController.getUserRepos("username");
		assertNotNull(rdl1);
	}
	
	@Test
	public void createUserTest() {
		com.github.favorite.model.User userModel = new com.github.favorite.model.User();
		userModel.setUsername("username");
		
		User user = new User();
		user.setUsername("username");
		when(userRepositiry.save(user)).thenReturn(user);
		
		User user1 = userController.createUser(userModel);
		assertNotNull(user1);
	}
	
	
	@Test
	public void removeUserRepoTest() {
		User user = new User();
		RepositoryDocument rd = new RepositoryDocument(1, "myrepo", "http://localhost:8080");
		List<RepositoryDocument> rdl = new ArrayList<>();
		rdl.add(rd);
		user.setFavRepos(rdl);
		when(userRepositiry.findFirstByUsername("username1")).thenReturn(Optional.of(user));
		
		boolean isRemoved = userController.removeUserRepo("username", 1);
		assertEquals(true, isRemoved);
	}
}
