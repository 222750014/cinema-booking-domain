package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
