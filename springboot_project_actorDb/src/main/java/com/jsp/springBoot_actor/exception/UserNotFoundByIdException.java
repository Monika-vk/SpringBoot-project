package com.jsp.springBoot_actor.exception;

public class UserNotFoundByIdException extends RuntimeException{

	
	private final String message;

	public UserNotFoundByIdException(String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
	

}
