package com.github.favorite.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.favorite.dao.Repository;
import com.github.favorite.dao.UserRepositiry;
import com.github.favorite.entities.RepositoryDocument;
import com.github.favorite.entities.User;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	MongoTemplate mongoTemplate;
	@Autowired
	UserRepositiry userRepositiry;
	@Autowired
	Repository repository;

	@GetMapping("/{username}")
	public List<RepositoryDocument> getUserRepos(@PathVariable("username") String username) {
		Optional<User> user = userRepositiry.findFirstByUsername(username);
		if (user.isPresent()) {
			return null != user.get().getFavRepos() ? user.get().getFavRepos() : new ArrayList<>();
		} else {
			return new ArrayList<>();
		}
	}

	@DeleteMapping("/{username}/{repoId}")
	public boolean removeUserRepo(@PathVariable("username") String username, @PathVariable("repoId") Integer repoId) {
		Optional<User> user = userRepositiry.findFirstByUsername(username);
		if (user.isPresent()) {
			List<RepositoryDocument> userRepos = user.get().getFavRepos();
			List<RepositoryDocument> newUserRepos = new ArrayList<>();
			for (RepositoryDocument repositoryDocument : userRepos) {
				if (repositoryDocument.getId() != repoId) {
					newUserRepos.add(repositoryDocument);
				}
			}
			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(username));
			Update update = new Update();
			update.set("favRepos", newUserRepos);
			mongoTemplate.findAndModify(query, update, User.class);
		}
		return true;
	}

	@PostMapping
	public User createUser(@RequestBody com.github.favorite.model.User user) {
		User userEntity = new User();
		userEntity.setEmail(user.getEmail());
		userEntity.setPassword(user.getPassword());
		userEntity.setUsername(user.getUsername());
		return userRepositiry.save(userEntity);
	}

	@GetMapping("/{username}/{repoId}")
	public boolean addUserRepo(@PathVariable("username") String username, @PathVariable("repoId") Integer repoId) {
		Optional<User> user = userRepositiry.findFirstByUsername(username);
		if(user.isPresent()) {
			Query query = new Query();
			query.addCriteria(Criteria.where("username").is(username));
			Update update = new Update();
			List<RepositoryDocument> userRepos = user.get().getFavRepos();
			Optional<RepositoryDocument> repoDoc = repository.findById(repoId);
			if (repoDoc.isPresent()) {
				userRepos.add(repoDoc.get());
			}
			update.set("favRepos",userRepos );
			mongoTemplate.findAndModify(query, update, User.class);
			return true;
		}else {
			return false;
		}
	}
}
