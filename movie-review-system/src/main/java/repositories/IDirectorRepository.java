package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereviewsystem.models.Director;

public interface IDirectorRepository extends JpaRepository<Director, Long> {

}
