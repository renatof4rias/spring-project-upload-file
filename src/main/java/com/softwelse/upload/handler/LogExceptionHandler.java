package com.softwelse.upload.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.softwelse.upload.exceptions.EmptyFileException;
import com.softwelse.upload.exceptions.EmptyLogException;
import com.softwelse.upload.exceptions.IllegalExtensionFileException;

@ControllerAdvice
public class LogExceptionHandler {

	@ExceptionHandler(EmptyFileException.class)
	public ResponseEntity<Object> handle(EmptyFileException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	

	@ExceptionHandler(IllegalExtensionFileException.class)
	public ResponseEntity<Object> handle(IllegalExtensionFileException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

	@ExceptionHandler(EmptyLogException.class)
	public ResponseEntity<Object> handle(EmptyLogException e) {
		return ResponseEntity.badRequest().body(e.getMessage());
	}

}