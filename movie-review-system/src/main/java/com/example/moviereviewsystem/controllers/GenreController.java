package com.example.moviereviewsystem.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.moviereviewsystem.models.Genre;
import com.example.moviereviewsystem.services.IGenreService;

@RestController
public class GenreController {

	@Autowired
	private IGenreService iGenreService;
	
	@RequestMapping(value = "/createGenre", method = RequestMethod.POST)
	public Genre createGenre(@RequestBody Genre genre) {
		return iGenreService.createGenre(genre);
	}
	
	@RequestMapping(value = "/updateGenre", method = RequestMethod.PUT) 
	public Genre updateGenre(@RequestBody Genre genre) {
		return iGenreService.updateGenre(genre);
	}
	
	@RequestMapping(value = "/deleteGenre/{genreId}", method = RequestMethod.DELETE)
	public boolean deleteGenre(@PathVariable Long genreId) {
		return iGenreService.deleteGenre(genreId);
	}
	
	@RequestMapping(value = "/getGenre/{genreId}", method = RequestMethod.GET)
	public Genre getGenre(@PathVariable Long genreId) {
		return iGenreService.getGenre(genreId);
	}
	
	@RequestMapping(value = "/getAllGenres", method = RequestMethod.GET)
	public List<Genre> getAllGenres() {
		return iGenreService.getAllGenres();
	}
}
