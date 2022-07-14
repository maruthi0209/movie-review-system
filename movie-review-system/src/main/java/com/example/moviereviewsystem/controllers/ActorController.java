package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Actor;
import com.example.moviereviewsystem.services.IActorService;

@RestController
public class ActorController {

	@Autowired
	private IActorService iActorService;
	
	@RequestMapping(value="/createActor", method = RequestMethod.POST)
	public Actor createActor(@RequestBody Actor actor) {
		return iActorService.createActor(actor);
	}
	
	@RequestMapping(value = "/updateActor", method = RequestMethod.PUT)
	public Actor updateActor(@RequestBody Actor actor) {
		return iActorService.updateActor(actor);
	}
	
	@RequestMapping(value = "/deleteActor/{actorId}", method = RequestMethod.DELETE)
	public boolean deleteActor(@PathVariable Long actorId) {
		return iActorService.deleteActor(actorId);
	}
	
	@RequestMapping(value = "/getActor/{actorId}", method = RequestMethod.GET)
	public Actor getActor(@PathVariable Long actorId) {
		return iActorService.getActor(actorId);
	}
	
	@RequestMapping(value = "/getAllActors", method = RequestMethod.GET)
	public List<Actor> getAllActors() {
		return iActorService.getAllActors();
	}
}
