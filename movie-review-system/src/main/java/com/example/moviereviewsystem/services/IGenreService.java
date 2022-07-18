package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Genre;

@Component
public interface IGenreService {

	public ResponseEntity<Genre> getGenre(Long genreId);
	
	public ResponseEntity<List<Genre>> getAllGenres();
	
	public ResponseEntity<Genre> createGenre(Genre genre);
	
	public ResponseEntity<Genre> updateGenre(Genre genre);
	
	public boolean deleteGenre(Long genreId);
}
