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

import com.example.moviereviewsystem.models.Genre;
import com.example.moviereviewsystem.services.IGenreService;

@RestController
@RequestMapping(value = "/genre")
public class GenreController {

	@Autowired
	private IGenreService iGenreService;
	
	@PostMapping(value = "/createGenre")
	public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
		return iGenreService.createGenre(genre);
	}
	
	@PutMapping(value = "/updateGenre") 
	public ResponseEntity<Genre> updateGenre(@RequestBody Genre genre) {
		return iGenreService.updateGenre(genre);
	}
	
	@DeleteMapping(value = "/deleteGenre/{genreId}")
	public boolean deleteGenre(@PathVariable Long genreId) {
		return iGenreService.deleteGenre(genreId);
	}
	
	@GetMapping(value = "/getGenre/{genreId}")
	public ResponseEntity<Genre> getGenre(@PathVariable Long genreId) {
		return iGenreService.getGenre(genreId);
	}
	
	@GetMapping(value = "/getAllGenres")
	public ResponseEntity<List<Genre>> getAllGenres() {
		return iGenreService.getAllGenres();
	}
}
