package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereviewsystem.models.Studio;

public interface IStudioRepository extends JpaRepository<Studio, Long>{

}
