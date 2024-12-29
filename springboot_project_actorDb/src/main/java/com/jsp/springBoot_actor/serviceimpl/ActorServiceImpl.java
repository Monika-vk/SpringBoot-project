package com.jsp.springBoot_actor.serviceimpl;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.springBoot_actor.entity.Actor;
import com.jsp.springBoot_actor.exception.ActorNotFoundException;
import com.jsp.springBoot_actor.exception.UserNotFoundByIdException;
import com.jsp.springBoot_actor.repository.ActorRepository;
import com.jsp.springBoot_actor.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;


	@Override
	public Actor addActor(Actor actor) {
		return actorRepository.save(actor);
	}

	@Override
	public List<Actor> findAllActor() {
		List<Actor> actors	= actorRepository.findAll();
		if(actors.isEmpty()) {
			//			return null;
			throw new ActorNotFoundException("Failed to find user");
		}else {
			return actors;
		}	
	}




	@Override
	public Actor findActorById(int actorId) {
		return actorRepository.findById(actorId)
				.orElseThrow(()->new UserNotFoundByIdException("Failed to find user"));

		//		Optional<Actor> optional=actorRepository.findById(actorId);
		//		if(optional.isPresent()) {
		//			Actor actor=optional.get();
		//			return actor;
		//		}else {
		//			throw new UserNotFoundByIdException("Failed to find user");
		//		}
		////		return optional;
	}



	@Override
	public Actor DeleteActorById(int actorId) {
		//		actorRepository.findById(actorId).ifPresentOrElse(actor->actorRepository.delete(actor) ,
		//				()->{
		//					throw new RuntimeException("Failed to delete Actor");
		//				});

		return actorRepository.findById(actorId).map(actor->{actorRepository.delete(actor);
		return actor;
		}).orElseThrow(()->new RuntimeException("failed to delete user"));

		//		Optional<Actor> optional=actorRepository.findById(actorId);

		//		if(optional.isPresent()) {
		//			Actor actor=optional.get();
		//			actorRepository.delete(actor);
		//		return actor;
		//		}else {
		//			throw new RuntimeException("Failed to delete user");
		//		}
		//		
	}

	@Override
	public Actor updateActorBYId(Actor actor) {
		//		return actorRepository.save(actor);

		//the best approch for during the deal with multiple table with forigen key relationship

		Optional<Actor> optional= actorRepository.findById(actor.getActorId());

		if(optional.isPresent()) {
			Actor exActor =optional.get() ;
			exActor.setActorName(actor.getActorName());
			exActor.setAge(actor.getAge());
			exActor.setIndustry(actor.getNationality());
			exActor.setNationality(actor.getNationality());

			return actorRepository.save(exActor);
		}
		else {
			throw new RuntimeException("Failed to update user");
		}
	}


}
