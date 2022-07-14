package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Movie;
import com.example.moviereviewsystem.repositories.IMovieRepository;
import com.example.moviereviewsystem.services.IMovieService;

@Service
public class MovieServiceImplementation implements IMovieService{

	@Autowired
	private IMovieRepository iMovieRepository;

	@Override
	@Transactional
	public Movie getMovie(Long movieId) {
		Movie movie = iMovieRepository.getReferenceById(movieId);
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> moviesList = new ArrayList<Movie>();
		moviesList = iMovieRepository.findAll();
		return moviesList;
	}

	@Override
	public Movie createMovie(Movie movie) {
		Movie savedMovie = iMovieRepository.save(movie);
		return savedMovie;
	}

	@Override
	public Movie updateMovie(Movie movie) {
		if (iMovieRepository.existsById(movie.getMovieId())) {
			Movie existingMovie = iMovieRepository.getReferenceById(movie.getMovieId());
			existingMovie.setMovieCast(movie.getMovieCast());
			existingMovie.setMoviedirector(movie.getMoviedirector());
			existingMovie.setMovieGenre(movie.getMovieGenre());
			existingMovie.setMovieName(movie.getMovieName());
			existingMovie.setMoviestudio(movie.getMoviestudio());
			existingMovie.setReleaseDate(movie.getReleaseDate());
			Movie updatedMovie = iMovieRepository.save(existingMovie);
			return updatedMovie;
		} else {
			return movie;
		}
	}

	@Override
	public boolean deleteMovie(Long movieId) {
		if (iMovieRepository.existsById(movieId)) {
			iMovieRepository.deleteById(movieId);
			return true;
		} else {
			return false;
		}
	}
}
