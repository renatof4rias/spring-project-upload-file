package com.softwelse.upload.exceptions;

public class IllegalExtensionFileException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public IllegalExtensionFileException(String message) {
		super(message);
	}

}