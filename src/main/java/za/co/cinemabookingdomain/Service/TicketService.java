package za.co.cinemabookingdomain.Service;


import za.co.cinemabookingdomain.Domain.Ticket;

import java.util.List;
import java.util.Optional;

public interface TicketService {

    Ticket saveTicket(Ticket ticket);

    Optional<Ticket> getTicketById(Long id);

    List<Ticket> getTicketsByMovieName(String movieName);

    Optional<Ticket> getTicketByScreenAndSeat(int screenNumber, int seatNumber);

    List<Ticket> getTicketsByBookingStatus(String bookingStatus);

    List<Ticket> getAllTickets();

    long countBookedTicketsForMovie(String movieName);

    void deleteTicketById(Long id);
}

