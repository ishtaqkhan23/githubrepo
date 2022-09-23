package com.github.favorite.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.favorite.entities.RepositoryDocument;

public interface Repository extends MongoRepository<RepositoryDocument	, Integer>{

}
