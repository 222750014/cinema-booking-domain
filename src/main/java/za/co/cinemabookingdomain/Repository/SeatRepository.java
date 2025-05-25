package za.co.cinemabookingdomain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.Domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}
