package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Actor;
import com.example.moviereviewsystem.services.IActorService;

@RestController
@RequestMapping(value = "/actor")
public class ActorController {

	@Autowired
	private IActorService iActorService;
	
	@PostMapping(value="/createActor")
	public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
		return iActorService.createActor(actor);
	}
	
	@PutMapping(value = "/updateActor")
	public ResponseEntity<Actor> updateActor(@RequestBody Actor actor) {
		return iActorService.updateActor(actor);
	}
	
	@DeleteMapping(value = "/deleteActor/{actorId}")
	public boolean deleteActor(@PathVariable Long actorId) {
		return iActorService.deleteActor(actorId);
	}
	
	@GetMapping(value = "/getActor/{actorId}")
	public ResponseEntity<Actor> getActor(@PathVariable Long actorId) {
		return iActorService.getActor(actorId);
	}
	
	@GetMapping(value = "/getAllActors")
	public ResponseEntity<List<Actor>> displayHello() {
		return iActorService.getAllActors();
		}
}
