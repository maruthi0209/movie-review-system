package com.example.moviereviewsystem.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.moviereviewsystem.models.Movie;

@Component
public interface IMovieService {

	public Movie getMovie(Long movieId);
	
	public List<Movie> getAllMovies();
	
	public Movie createMovie(Movie movie);
	
	public Movie updateMovie(Movie movie);
	
	public boolean deleteMovie(Long movieId);
}
