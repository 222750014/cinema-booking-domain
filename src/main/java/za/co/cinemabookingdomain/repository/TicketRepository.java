package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import za.co.cinemabookingdomain.domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    Optional<Ticket> findByScreenNumberAndSeatNumber(int screenNumber, int seatNumber);

    List<Ticket> findByMovieNameIgnoreCase(String movieName);

    List<Ticket> findByBookingStatus(String bookingStatus);

    @Query("SELECT COUNT(t) FROM Ticket t WHERE t.movieName = :movieName AND t.bookingStatus = 'BOOKED'")
    long countBookedTicketsForMovie(@Param("movieName") String movieName);

    @Query("SELECT t FROM Ticket t WHERE t.bookingStatus = 'BOOKED' ORDER BY t.seatNumber ASC")
    List<Ticket> findBookedTicketsOrderedBySeatNumber();
}

