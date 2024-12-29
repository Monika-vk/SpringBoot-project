package com.jsp.springBoot_actor.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.springBoot_actor.entity.Actor;
import com.jsp.springBoot_actor.exception.UserNotFoundByIdException;
import com.jsp.springBoot_actor.service.ActorService;
import com.jsp.springBoot_actor.utility.ResponseStructure;

//@Controller
//@ResponseBody
@RestController
public class ActorController {
	
	

	@Autowired
	private ActorService actorService;
	
	
//	private Map<String , Object> sendResponse(int status,String message,Actor data){
//		return Map.of(
//				"status",status,
//				"message",message,
//				"data",data
//				);		
//	}

	//	@RequestMapping(value = "/actors",method=RequestMethod.POST)
	@PostMapping("/actors")
	public ResponseStructure<Actor> addActor(@RequestBody Actor actor) {
//		return actorService.addActor(actor);
		
		//if we pass the clarity message to the user then we can use :
		
		actor =actorService.addActor(actor);
//		return this.sendResponse(201,"user created", actor);
		return ResponseStructure.create(201, "User Created", actor);
	}

	//	@RequestMapping(value = "/actors",method=RequestMethod.GET)
	@GetMapping("/actors")
	public ResponseStructure<List<Actor>> findAllActor() {
	List<Actor> actors	= actorService.findAllActor();
	return ResponseStructure.create(HttpStatus.FOUND.value(),"User Found", actors);

	}

	@GetMapping("/find-actor")
	public ResponseEntity< ResponseStructure<Actor>> findActorById(@RequestParam int actorId) {
	Actor actor= actorService.findActorById(actorId);
//	return ResponseStructure.create(HttpStatus.FOUND.value(),"user found by given id", actor);
	
	return ResponseEntity
			.status(HttpStatus.FOUND)
			.body(ResponseStructure.create(HttpStatus.FOUND.value(),"UserFound", actor));
	}

	

	//it is handle the exception in this senorie the front end developer can esaily to understand the problem
	//	@ExceptionHandler
	//	public String handleUserNotFoundById(UserNotFoundByIdException ex) {
	//		return ex.getMessage();
	//	}


	
	//insted of using here we can write a code in utility package
	//another way to  give the complete message to the frontend developer
//	@ExceptionHandler
//	public Map<String, Object> handleUserNotFoundById(UserNotFoundByIdException ex) {
//		//		Map<String, Object> response =new HashMap<String, Object>();
//		//		response.put("status", 404);
//		//		response.put("message",ex.getMessage());
//		//		response.put("rootCause", "user not found by the given Id ");
//		//		return response;
//
//
//		//another easy to give the complte information to the frontend developer
//
//		return Map.of(
//				"status",404,
//				"message",ex.getMessage(),
//				"rootcause","user not found by the given Id"
//				);
//
//	}



	@DeleteMapping("/delete-byId")
	public ResponseStructure<Actor> DeleteActorById(@RequestParam int actorId) {
	  Actor actor =actorService.DeleteActorById(actorId);
	  return ResponseStructure.create(HttpStatus.OK.value(),"user deleted",actor);
	}

	@PutMapping("/update")
	public ResponseStructure<Actor> updateActorBYId(@RequestBody Actor actor) {
	 actor	= actorService.updateActorBYId(actor);
	 return ResponseStructure.create(HttpStatus.OK.value(),"user updated",actor);
	}

}
