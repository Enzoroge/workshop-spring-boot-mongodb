package com.enzoroge.workshopmongo.dto;

import java.io.Serializable;

import com.enzoroge.workshopmongo.domain.User;

//DTO não precisa de "hashcode and equals"

public class AuthorDto implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	
	public AuthorDto() {
		
	}

	public AuthorDto(User obj) {
		super();
		id = obj.getId();
		name = obj.getName();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
