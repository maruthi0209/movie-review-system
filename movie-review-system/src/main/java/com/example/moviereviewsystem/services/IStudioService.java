package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Studio;

@Component
public interface IStudioService {
	
	public ResponseEntity<Studio> getStudio(Long studioId);
	
	public ResponseEntity<List<Studio>> getAllStudio();
	
	public ResponseEntity<Studio> createStudio(Studio studio);
	
	public ResponseEntity<Studio> updateStudio(Studio studio);
	
	public boolean deleteStudio(Long studioId);

}
