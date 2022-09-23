package com.github.favorite.dao;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.favorite.entities.User;

public interface UserRepositiry extends MongoRepository<User, Integer>{
	Optional<User> findFirstByUsername(String username);
}
