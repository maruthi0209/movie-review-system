package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Movie;

@Component
public interface IMovieService {

	public ResponseEntity<Movie> getMovie(Long movieId);
	
	public ResponseEntity<List<Movie>> getAllMovies();
	
	public ResponseEntity<Movie> createMovie(Movie movie);
	
	public ResponseEntity<Movie> updateMovie(Movie movie);
	
	public boolean deleteMovie(Long movieId);
}
