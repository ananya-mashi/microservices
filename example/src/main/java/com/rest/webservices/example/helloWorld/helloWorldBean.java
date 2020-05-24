package com.rest.webservices.example.helloWorld;

public class helloWorldBean {
	
	private String message;

	
	
	


	public helloWorldBean(String message2) {
		this.message = message2;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "helloWorldBean [message=" + message + "]";
	}
	
	

}
