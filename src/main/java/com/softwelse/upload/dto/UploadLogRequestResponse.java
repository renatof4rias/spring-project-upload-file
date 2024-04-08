package com.softwelse.upload.dto;

public class UploadLogRequestResponse {
	
	private Long qtdErrorsLine;
	private Long qtdSuccessLine;
	private String message;
	
	public Long getQtdErrorsLine() {
		return qtdErrorsLine;
	}
	
	public void setQtdErrorsLine(Long qtdErrorsLine) {
		this.qtdErrorsLine = qtdErrorsLine;
	}
	public Long getQtdSuccessLine() {
		return qtdSuccessLine;
	}
	public void setQtdSuccessLine(Long qtdSuccessLine) {
		this.qtdSuccessLine = qtdSuccessLine;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

}