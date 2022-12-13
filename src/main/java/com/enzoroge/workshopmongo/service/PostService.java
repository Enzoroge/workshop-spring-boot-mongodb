package com.enzoroge.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoroge.workshopmongo.domain.Post;
import com.enzoroge.workshopmongo.domain.User;
import com.enzoroge.workshopmongo.dto.UserDto;
import com.enzoroge.workshopmongo.repository.PostRepository;
import com.enzoroge.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

}