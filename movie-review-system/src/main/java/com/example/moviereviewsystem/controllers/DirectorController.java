package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Director;
import com.example.moviereviewsystem.services.IDirectorService;

@RestController
public class DirectorController {
	
	@Autowired
	private IDirectorService iDirectorService;
	
	@RequestMapping(value = "/createDirector", method = RequestMethod.POST)
	public Director createDirector(@RequestBody Director director) {
		return iDirectorService.createDirector(director);
	}

	@RequestMapping(value = "/updateDirector", method = RequestMethod.PUT)
	public Director updateDirectory(@RequestBody Director director) {
		return iDirectorService.updateDirector(director);
	}
	
	@RequestMapping(value = "/deleteDirector/{directorId}", method = RequestMethod.DELETE)
	public boolean deleteDirector(@PathVariable Long directorId) {
		return iDirectorService.deleteDirector(directorId);
	}
	
	@RequestMapping(value = "/getDirector/{directorId}", method = RequestMethod.GET) 
	public Director getDirector(@PathVariable Long directorId) {
		return iDirectorService.getDirector(directorId);
	}
	
	@RequestMapping(value = "/getAllDirectors", method = RequestMethod.GET)
	public List<Director> getAllDirectors(){
		return iDirectorService.getAllDirectors();
	}
}
