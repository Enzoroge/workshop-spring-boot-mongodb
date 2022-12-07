package com.enzoroge.workshopmongo.resource.exception;

import java.awt.desktop.SystemSleepEvent;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.enzoroge.workshopmongo.service.exception.ObjectNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//informa que essa classe eh responsavel por tratar possiveis errors nas requisiçoes
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError erro = new StandardError(System.currentTimeMillis(),status.value(), "Nao encontrado",e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(erro);
	}

}
