package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Director;

@Component
public interface IDirectorService {
	
	public Director getDirector(Long directorId);
	
	public List<Director> getAllDirectors();
	
	public Director createDirector(Director director);
	
	public Director updateDirector(Director director);
	
	public boolean deleteDirector(Long directorId);

}
