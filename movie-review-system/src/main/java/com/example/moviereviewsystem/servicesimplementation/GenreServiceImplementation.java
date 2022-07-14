package com.example.moviereviewsystem.servicesimplementation;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
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
	public Genre getGenre(Long genreId) {
		Genre genre = iGenreRepository.getReferenceById(genreId);
		return genre;
	}

	@Override
	@Transactional
	public List<Genre> getAllGenres() {
		List<Genre> genresList = new ArrayList<Genre>();
		genresList = iGenreRepository.findAll();
		return genresList;
	}

	@Override
	@Transactional
	public Genre createGenre(Genre genre) {
		Genre savedGenre = iGenreRepository.save(genre);
		return savedGenre;
	}

	@Override
	@Transactional
	public Genre updateGenre(Genre genre) {
		if (iGenreRepository.existsById(genre.getGenreId())) {
			Genre existingGenre = iGenreRepository.getReferenceById(genre.getGenreId());
			existingGenre.setGenreDescription(genre.getGenreDescription());
			Genre updatedGenre = iGenreRepository.save(genre);
			return updatedGenre;
		} else {
			return genre;
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
