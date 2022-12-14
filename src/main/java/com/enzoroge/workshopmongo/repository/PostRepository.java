package com.enzoroge.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.enzoroge.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
	
	//ignoreCase faz a busca ignorar letras maiuscula ou minuscula
	
	@Query("{'title' :{$regex: ?0, $options : 'i'}}")
	List<Post> searchTitle(String text);
	
	List<Post> findBytitleContainingIgnoreCase(String text);

}
