package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import com.example.moviereviewsystem.models.Actor;

@Component
public interface IActorService {
	
		public ResponseEntity<Actor> getActor(Long actorId);
		
		public ResponseEntity<List<Actor>> getAllActors();
		
		public ResponseEntity<Actor> createActor(Actor actor);
		
		public ResponseEntity<Actor> updateActor(Actor actor);
		
		public boolean deleteActor(Long actorId);

}
