package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Actor;
import com.example.moviereviewsystem.repositories.IActorRepository;
import com.example.moviereviewsystem.services.IActorService;

@Service
public class ActorServiceImplementation implements IActorService {

	@Autowired 
	private IActorRepository iActorRepository;
	
	@Override
	@Transactional
	public ResponseEntity<Actor> getActor(Long actorId) {
		Actor actor = iActorRepository.getReferenceById(actorId);
		ResponseEntity<Actor> response = new ResponseEntity<Actor>(actor, HttpStatus.OK);
		return response;
		}		

	@Override
	@Transactional
	public ResponseEntity<List<Actor>> getAllActors() {
			List<Actor> actorsList = new ArrayList<Actor>();
			actorsList = iActorRepository.findAll();
			ResponseEntity<List<Actor>> response = new ResponseEntity<List<Actor>>(actorsList, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Actor> createActor(Actor actor) {
		Actor savedActor = iActorRepository.save(actor);
		ResponseEntity<Actor> response = new ResponseEntity<Actor>(savedActor, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Actor> updateActor(Actor actor) {
		if (iActorRepository.existsById(actor.getActorId())) {
			Actor existingActor = iActorRepository.getReferenceById(actor.getActorId());
			existingActor.setActorName(actor.getActorName());
			Actor updatedActor = iActorRepository.save(existingActor);
			ResponseEntity<Actor> response = new ResponseEntity<Actor>(updatedActor, HttpStatus.OK);
			return response;
		} else {
			ResponseEntity<Actor> failedresponse = new ResponseEntity<Actor>(actor, HttpStatus.NOT_MODIFIED);
			return failedresponse;

		}
	}

	@Override
	public boolean deleteActor(Long actorId) {
		if (iActorRepository.existsById(actorId)) {
			iActorRepository.deleteById(actorId);
			return true;
		} else {
			return false;
		}
	}
	
	
}
