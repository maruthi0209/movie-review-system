package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;
import com.example.moviereviewsystem.models.Actor;

@Component
public interface IActorService {
	
		public Actor getActor(Long actorId);
		
		public List<Actor> getAllActors();
		
		public Actor createActor(Actor actor);
		
		public Actor updateActor(Actor actor);
		
		public boolean deleteActor(Long actorId);

}
