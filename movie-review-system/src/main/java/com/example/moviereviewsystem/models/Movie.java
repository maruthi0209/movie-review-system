package com.example.moviereviewsystem.models;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="movie")
public class Movie {

    @Id
    @Column(name = "movie_id", nullable = false)
    private Long movieId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "release_date", nullable = false)
    private Date releaseDate;

    @ManyToMany()
    private List<Genre> movieGenre;

    @ManyToOne()
    private Director moviedirector;

    @ManyToOne()
    private Studio moviestudio;

    @ManyToMany()
    private List<Actor> movieCast;

	public Movie() {

	}

	public Movie(Long movieId, String movieName, Date releaseDate, List<Genre> movieGenre, Director moviedirector,
			Studio moviestudio, List<Actor> movieCast) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.releaseDate = releaseDate;
		this.movieGenre = movieGenre;
		this.moviedirector = moviedirector;
		this.moviestudio = moviestudio;
		this.movieCast = movieCast;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieName=" + movieName + ", releaseDate=" + releaseDate
				+ ", movieGenre=" + movieGenre + ", moviedirector=" + moviedirector + ", moviestudio=" + moviestudio
				+ ", movieCast=" + movieCast + "]";
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public List<Genre> getMovieGenre() {
		return movieGenre;
	}

	public void setMovieGenre(List<Genre> movieGenre) {
		this.movieGenre = movieGenre;
	}

	public Director getMoviedirector() {
		return moviedirector;
	}

	public void setMoviedirector(Director moviedirector) {
		this.moviedirector = moviedirector;
	}

	public Studio getMoviestudio() {
		return moviestudio;
	}

	public void setMoviestudio(Studio moviestudio) {
		this.moviestudio = moviestudio;
	}

	public List<Actor> getMovieCast() {
		return movieCast;
	}

	public void setMovieCast(List<Actor> movieCast) {
		this.movieCast = movieCast;
	}

    
}
