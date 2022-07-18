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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Director;
import com.example.moviereviewsystem.services.IDirectorService;

@RestController
@RequestMapping(value = "/director")
public class DirectorController {
	
	@Autowired
	private IDirectorService iDirectorService;
	
	@PostMapping(value = "/createDirector")
	public ResponseEntity<Director> createDirector(@RequestBody Director director) {
		return iDirectorService.createDirector(director);
	}

	@PutMapping(value = "/updateDirector")
	public ResponseEntity<Director> updateDirectory(@RequestBody Director director) {
		return iDirectorService.updateDirector(director);
	}
	
	@DeleteMapping(value = "/deleteDirector/{directorId}")
	public boolean deleteDirector(@PathVariable Long directorId) {
		return iDirectorService.deleteDirector(directorId);
	}
	
	@GetMapping(value = "/getDirector/{directorId}") 
	public ResponseEntity<Director> getDirector(@PathVariable Long directorId) {
		return iDirectorService.getDirector(directorId);
	}
	
	@GetMapping(value = "/getAllDirectors")
	public ResponseEntity<List<Director>> getAllDirectors(){
		return iDirectorService.getAllDirectors();
	}
}
