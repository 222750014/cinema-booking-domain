package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.domain.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> { // Change String to Long
    // Optional: Add custom query methods if needed
    Seat findBySeatNumber(String seatNumber);
}