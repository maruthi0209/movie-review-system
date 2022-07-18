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

import com.example.moviereviewsystem.models.Movie;
import com.example.moviereviewsystem.services.IMovieService;

@RestController
@RequestMapping(value = "/movie")
public class MovieController {

	@Autowired
	private IMovieService iMovieService;
	
	@PostMapping(value = "/createMovie")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return iMovieService.createMovie(movie);
	}
	
	@PutMapping(value = "/updateMovie")
	public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie) {
		return iMovieService.updateMovie(movie);
	}
	
	@DeleteMapping(value = "/deleteMovie/{movieId}")
	public boolean deleteMovie(@PathVariable Long movieId) {
		return iMovieService.deleteMovie(movieId);
	}
	
	@GetMapping(value = "/getMovie/{movieId}")
	public ResponseEntity<Movie> getMovie(@PathVariable Long movieId) {
		return iMovieService.getMovie(movieId);
	}
	
	@GetMapping(value = "/getAllMovies")
	public ResponseEntity<List<Movie>> getAllMovies() {
		return iMovieService.getAllMovies();
	}
}
