package repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moviereviewsystem.models.Actor;

public interface IActorRepository extends JpaRepository<Actor, Long>{

}
