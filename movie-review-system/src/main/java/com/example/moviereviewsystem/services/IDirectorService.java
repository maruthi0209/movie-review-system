package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Director;

@Component
public interface IDirectorService {
	
	public ResponseEntity<Director> getDirector(Long directorId);
	
	public ResponseEntity<List<Director>> getAllDirectors();
	
	public ResponseEntity<Director> createDirector(Director director);
	
	public ResponseEntity<Director> updateDirector(Director director);
	
	public boolean deleteDirector(Long directorId);

}
