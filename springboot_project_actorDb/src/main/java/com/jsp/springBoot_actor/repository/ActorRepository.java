package com.jsp.springBoot_actor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springBoot_actor.entity.Actor;


public interface ActorRepository extends JpaRepository<Actor, Integer>{

	

//	public Actor save(Actor actor);
	//   public Actor merge(Actor actor);
//	public Actor remove(int actor);
	
	
	//save()
	//delete()
	//findbyId()
	//findAll()
	//deleteByID()
}
