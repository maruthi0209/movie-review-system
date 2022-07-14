package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Studio;

@Component
public interface IStudioService {
	
	public Studio getStudio(Long studioId);
	
	public List<Studio> getAllStudio();
	
	public Studio createStudio(Studio studio);
	
	public Studio updateStudio(Studio studio);
	
	public boolean deleteStudio(Long studioId);

}
