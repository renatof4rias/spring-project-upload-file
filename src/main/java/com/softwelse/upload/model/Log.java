package com.softwelse.upload.model;

public class Log {

	private String data;
	private String ip;
	private String request;
	private Long status;
	private String userAgent;

	public Log() {
	}

	public Log(String data, String ip, String request, Long status, String userAgent) {
		super();
		this.data = data;
		this.ip = ip;
		this.request = request;
		this.status = status;
		this.userAgent = userAgent;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}
	
}