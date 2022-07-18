package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Director;
import com.example.moviereviewsystem.repositories.IDirectorRepository;
import com.example.moviereviewsystem.services.IDirectorService;

@Service
public class DirectorServiceImplementation implements IDirectorService{
	
	@Autowired
	private IDirectorRepository iDirectorRepository;

	@Override
	@Transactional
	public ResponseEntity<Director> getDirector(Long directorId) {
		Director director = iDirectorRepository.getReferenceById(directorId);
		ResponseEntity<Director> response = new ResponseEntity<>(director, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Director>> getAllDirectors() {
		List<Director> directorsList = new ArrayList<Director>();
		directorsList = iDirectorRepository.findAll();
		ResponseEntity<List<Director>> response = new ResponseEntity<>(directorsList, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Director> createDirector(Director director) {
		Director saveddirector = iDirectorRepository.save(director);
		ResponseEntity<Director> response = new ResponseEntity<>(saveddirector, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Director> updateDirector(Director director) {
		if (iDirectorRepository.existsById(director.getDirectorId())) {
			Director existingDirector = iDirectorRepository.getReferenceById(director.getDirectorId());
			existingDirector.setDirectorName(director.getDirectorName());
			Director updatedDirector = iDirectorRepository.save(existingDirector);
			ResponseEntity<Director> response = new ResponseEntity<>(updatedDirector, HttpStatus.OK);
			return response;
		} else {
			ResponseEntity<Director> failedresponse = new ResponseEntity<>(director, HttpStatus.NOT_MODIFIED);
			return failedresponse;
		}
	}

	@Override
	@Transactional
	public boolean deleteDirector(Long directorId) {
		if (iDirectorRepository.existsById(directorId)) {
			iDirectorRepository.deleteById(directorId);
			return true;
		} else {
			return false;
		}
	}
	
	

}
