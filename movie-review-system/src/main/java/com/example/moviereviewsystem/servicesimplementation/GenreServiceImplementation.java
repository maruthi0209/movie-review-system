package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.moviereviewsystem.models.Genre;
import com.example.moviereviewsystem.repositories.IGenreRepository;
import com.example.moviereviewsystem.services.IGenreService;

@Service
public class GenreServiceImplementation implements IGenreService{

	@Autowired
	private IGenreRepository iGenreRepository;

	@Override
	@Transactional
	public ResponseEntity<Genre> getGenre(Long genreId) {
		Genre genre = iGenreRepository.getReferenceById(genreId);
		ResponseEntity<Genre> response = new ResponseEntity<>(genre, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<List<Genre>> getAllGenres() {
		List<Genre> genresList = new ArrayList<Genre>();
		genresList = iGenreRepository.findAll();
		ResponseEntity<List<Genre>> response = new ResponseEntity<>(genresList, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Genre> createGenre(Genre genre) {
		Genre savedGenre = iGenreRepository.save(genre);
		ResponseEntity<Genre> response = new ResponseEntity<>(savedGenre, HttpStatus.OK);
		return response;
	}

	@Override
	@Transactional
	public ResponseEntity<Genre> updateGenre(Genre genre) {
		if (iGenreRepository.existsById(genre.getGenreId())) {
			Genre existingGenre = iGenreRepository.getReferenceById(genre.getGenreId());
			existingGenre.setGenreDescription(genre.getGenreDescription());
			Genre updatedGenre = iGenreRepository.save(genre);
			ResponseEntity<Genre> response = new ResponseEntity<>(updatedGenre, HttpStatus.OK);
			return response;
		} else {
			ResponseEntity<Genre> failedresponse = new ResponseEntity<>(genre, HttpStatus.NOT_MODIFIED);
			return failedresponse;
		}
	}

	@Override
	@Transactional
	public boolean deleteGenre(Long genreId) {
		if (iGenreRepository.existsById(genreId)) {
			iGenreRepository.deleteById(genreId);
			return true;
		} else {
			return false;
		}
	}
}
