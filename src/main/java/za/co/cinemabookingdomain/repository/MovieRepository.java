package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
