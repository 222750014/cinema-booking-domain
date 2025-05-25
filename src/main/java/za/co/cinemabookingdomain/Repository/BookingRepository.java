package za.co.cinemabookingdomain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.cinemabookingdomain.Domain.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}
