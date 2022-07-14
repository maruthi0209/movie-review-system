package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Movie;
import com.example.moviereviewsystem.services.IMovieService;

@RestController
public class MovieController {

	@Autowired
	private IMovieService iMovieService;
	
	@RequestMapping(value = "/createMovie", method = RequestMethod.POST)
	public Movie createMovie(@RequestBody Movie movie) {
		return iMovieService.createMovie(movie);
	}
	
	@RequestMapping(value = "/updateMovie", method = RequestMethod.PUT)
	public Movie updateMovie(@RequestBody Movie movie) {
		return iMovieService.updateMovie(movie);
	}
	
	@RequestMapping(value = "/deleteMovie/{movieId}", method = RequestMethod.DELETE)
	public boolean deleteMovie(@PathVariable Long movieId) {
		return iMovieService.deleteMovie(movieId);
	}
	
	@RequestMapping(value = "/getMovie/{movieId}", method = RequestMethod.GET)
	public Movie getMovie(@PathVariable Long movieId) {
		return iMovieService.getMovie(movieId);
	}
	
	@RequestMapping(value = "/getAllMovies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		return iMovieService.getAllMovies();
	}
}
