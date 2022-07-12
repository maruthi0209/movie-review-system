package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereviewsystem.models.Movie;

public interface IMovieRepository extends JpaRepository<Movie, Long> {

}
