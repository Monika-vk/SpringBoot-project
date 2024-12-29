package com.jsp.springBoot_actor.exception;

public class ActorNotFoundException extends RuntimeException{

	private final String message;

	public ActorNotFoundException (String message) {
		this.message=message;
	}

	public String getMessage() {
		return message;
	}
}
