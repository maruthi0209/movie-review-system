package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Genre;

@Component
public interface IGenreService {

	public Genre getGenre(Long genreId);
	
	public List<Genre> getAllGenres();
	
	public Genre createGenre(Genre genre);
	
	public Genre updateGenre(Genre genre);
	
	public boolean deleteGenre(Long genreId);
}
