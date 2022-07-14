package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Studio;
import com.example.moviereviewsystem.services.IStudioService;

@RestController
public class StudioController {

	@Autowired
	private IStudioService iStudioService;
	
	@RequestMapping(value = "/createStudio", method = RequestMethod.POST)
	public Studio createStudio(@RequestBody Studio studio) {
		return iStudioService.createStudio(studio);
	}
	
	@RequestMapping(value = "/updateStudio", method = RequestMethod.PUT)
	public Studio updateStudio (@RequestBody Studio studio) {
		return iStudioService.updateStudio(studio);
	}
	
	@RequestMapping(value = "/deleteStudio/{studioId}", method = RequestMethod.DELETE)
	public boolean deleteStudio(@PathVariable Long studioId) {
		return iStudioService.deleteStudio(studioId);
	}
	
	@RequestMapping(value = "/getStudio/{studioId}", method = RequestMethod.GET)
	public Studio getStudio(@PathVariable Long studioId) {
		return iStudioService.getStudio(studioId);
	}
	
	@RequestMapping(value = "/getAllStudios", method = RequestMethod.GET) 
	public List<Studio> getAllStudios() {
		return iStudioService.getAllStudio();
	}
}
