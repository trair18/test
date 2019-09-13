package com.kino.shop.repository;

import com.kino.shop.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tokens", path = "tokens")
public interface TokenRepository extends MongoRepository<Token, String> {

    Token findByValue(@Param("value") String value);
}