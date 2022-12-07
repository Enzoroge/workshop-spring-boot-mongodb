package com.enzoroge.workshopmongo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.enzoroge.workshopmongo.domain.User;
import com.enzoroge.workshopmongo.dto.UserDto;
import com.enzoroge.workshopmongo.repository.UserRepository;
import com.enzoroge.workshopmongo.service.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	
	
	public List<User> findAll(){
			return repository.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado"));
	}

}
