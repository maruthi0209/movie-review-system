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

import com.example.moviereviewsystem.models.Studio;
import com.example.moviereviewsystem.services.IStudioService;

@RestController
@RequestMapping(value = "/studio")
public class StudioController {

	@Autowired
	private IStudioService iStudioService;
	
	@PostMapping(value = "/createStudio")
	public ResponseEntity<Studio> createStudio(@RequestBody Studio studio) {
		return iStudioService.createStudio(studio);
	}
	
	@PutMapping(value = "/updateStudio")
	public ResponseEntity<Studio> updateStudio (@RequestBody Studio studio) {
		return iStudioService.updateStudio(studio);
	}
	
	@DeleteMapping(value = "/deleteStudio/{studioId}")
	public boolean deleteStudio(@PathVariable Long studioId) {
		return iStudioService.deleteStudio(studioId);
	}
	
	@GetMapping(value = "/getStudio/{studioId}")
	public ResponseEntity<Studio> getStudio(@PathVariable Long studioId) {
		return iStudioService.getStudio(studioId);
	}
	
	@GetMapping(value = "/getAllStudios") 
	public ResponseEntity<List<Studio>> getAllStudios() {
		return iStudioService.getAllStudio();
	}
}
