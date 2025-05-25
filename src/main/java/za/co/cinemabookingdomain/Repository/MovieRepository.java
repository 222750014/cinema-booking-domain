package za.co.cinemabookingdomain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.Domain.Movie;

public interface MovieRepository extends JpaRepository<Movie, String> {
}
