package com.jsp.springBoot_actor.utility;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.jsp.springBoot_actor.exception.ActorNotFoundException;
import com.jsp.springBoot_actor.exception.UserNotFoundByIdException;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
//	private Map<String, Object> sendresponse(int status,String message,String rootcause){
//		 return Map.of(
//				"status",status,
//				"message",message,
//				"rootcause",rootcause
//				);
//
//	}
	@ExceptionHandler
	public ErrorStructure handleUserNotFoundById(UserNotFoundByIdException ex) {
		//		Map<String, Object> response =new HashMap<String, Object>();
		//		response.put("status", 404);
		//		response.put("message",ex.getMessage());
		//		response.put("rootCause", "user not found by the given Id ");
		//		return response;


		//another easy to give the complete information to the frontend developer

//		return Map.of(
//				"status",404,
//				"message",ex.getMessage(),
//				"rootcause","user not found by the given Id"
//				);
		
//		return this.sendresponse(404,ex.getMessage(),"user not found by the given Id");
		
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(), "user not found By id");

	}
	
	@ExceptionHandler
	public ErrorStructure handleActorNotFoundException(ActorNotFoundException ex) {
		
//		return this.sendresponse(404,ex.getMessage(), "Actor Not Found");
		return ErrorStructure.create(HttpStatus.NOT_FOUND.value(), ex.getMessage(),"actor Not Found");
	}

}
