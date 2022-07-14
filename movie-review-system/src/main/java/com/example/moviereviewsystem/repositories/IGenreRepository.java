package com.example.moviereviewsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereviewsystem.models.Genre;

public interface IGenreRepository extends JpaRepository<Genre, Long>{

}
