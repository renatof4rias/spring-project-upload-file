package com.softwelse.upload.exceptions;

public class EmptyLogException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public EmptyLogException(String message) {
		super(message);
	}

}