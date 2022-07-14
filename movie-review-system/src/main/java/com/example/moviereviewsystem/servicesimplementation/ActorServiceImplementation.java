package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Actor getActor(Long actorId) {
		Actor actor = iActorRepository.getReferenceById(actorId);
		return actor;
		}		

	@Override
	@Transactional
	public List<Actor> getAllActors() {
			List<Actor> actorsList = new ArrayList<Actor>();
			actorsList = iActorRepository.findAll();
		return actorsList;
	}

	@Override
	@Transactional
	public Actor createActor(Actor actor) {
		Actor savedActor = iActorRepository.save(actor);
		return savedActor;
	}

	@Override
	@Transactional
	public Actor updateActor(Actor actor) {
		if (iActorRepository.existsById(actor.getActorId())) {
			Actor existingActor = iActorRepository.getReferenceById(actor.getActorId());
			existingActor.setActorName(actor.getActorName());
			Actor updatedActor = iActorRepository.save(existingActor);
			return updatedActor;
		} else {
			return actor;

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
