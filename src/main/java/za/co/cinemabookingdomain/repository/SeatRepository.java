package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {
}
