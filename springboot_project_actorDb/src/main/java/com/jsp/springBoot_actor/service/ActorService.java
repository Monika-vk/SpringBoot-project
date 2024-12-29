package com.jsp.springBoot_actor.service;

import java.util.List;
import java.util.Optional;

import com.jsp.springBoot_actor.entity.Actor;

public interface ActorService {

	public Actor addActor(Actor actor);
	public List<Actor> findAllActor();
	public Actor findActorById(int actorId);
	public Actor DeleteActorById(int actorId);
	public Actor updateActorBYId(Actor actor);

}
