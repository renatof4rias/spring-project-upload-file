package com.softwelse.upload.exceptions;

public class EmptyFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmptyFileException(String message) {
		super(message);
	}
}