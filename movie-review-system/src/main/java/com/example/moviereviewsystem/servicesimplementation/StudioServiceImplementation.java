package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Studio;
import com.example.moviereviewsystem.repositories.IStudioRepository;
import com.example.moviereviewsystem.services.IStudioService;

@Service
public class StudioServiceImplementation implements IStudioService{
	
	@Autowired
	private IStudioRepository iStudioRepository;

	@Override
	@Transactional
	public ResponseEntity<Studio> getStudio(Long studioId) {
		Studio studio = iStudioRepository.getReferenceById(studioId);
		ResponseEntity<Studio> response = new ResponseEntity<Studio>(studio, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Studio>> getAllStudio() {
		List<Studio> studiosList = new ArrayList<Studio>();
		studiosList = iStudioRepository.findAll();
		ResponseEntity<List<Studio>> response = new ResponseEntity<List<Studio>>(studiosList, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Studio> createStudio(Studio studio) {
		Studio savedStudio = iStudioRepository.save(studio);
		ResponseEntity<Studio> response = new ResponseEntity<Studio>(savedStudio, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Studio> updateStudio(Studio studio) {
		if (iStudioRepository.existsById(studio.getStudioId())) {
			Studio existingStudio = iStudioRepository.getReferenceById(studio.getStudioId());
			existingStudio.setStudioName(studio.getStudioName());
			existingStudio.setStudioLocation(studio.getStudioLocation());
			Studio savedStudio = iStudioRepository.save(existingStudio);
			ResponseEntity<Studio> response = new ResponseEntity<Studio>(savedStudio, HttpStatus.OK);
			return response;
		} else {
			ResponseEntity<Studio> failedresponse = new ResponseEntity<Studio>(studio, HttpStatus.OK);
			return failedresponse;
		}
	}

	@Override
	@Transactional
	public boolean deleteStudio(Long studioId) {
		if (iStudioRepository.existsById(studioId)) {
			iStudioRepository.deleteById(studioId);
			return true;
		} else {
			return false;
		}
	}
	
	
}
