package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Director getDirector(Long directorId) {
		Director director = iDirectorRepository.getReferenceById(directorId);
		return director;
	}

	@Override
	@Transactional
	public List<Director> getAllDirectors() {
		List<Director> directorsList = new ArrayList<Director>();
		directorsList = iDirectorRepository.findAll();
		return directorsList;
	}

	@Override
	@Transactional
	public Director createDirector(Director director) {
		Director saveddirector = iDirectorRepository.save(director);
		return saveddirector;
	}

	@Override
	@Transactional
	public Director updateDirector(Director director) {
		if (iDirectorRepository.existsById(director.getDirectorId())) {
			Director existingDirector = iDirectorRepository.getReferenceById(director.getDirectorId());
			existingDirector.setDirectorName(director.getDirectorName());
			Director updatedDirector = iDirectorRepository.save(existingDirector);
			return updatedDirector;
		} else {
			return director;
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
