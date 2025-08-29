package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Ticket;
import za.co.cinemabookingdomain.repository.TicketRepository;
import za.co.cinemabookingdomain.service.TicketService;

import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    public Ticket saveTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Optional<Ticket> getTicketById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List<Ticket> getTicketsByMovieName(String movieName) {
        return ticketRepository.findByMovieNameIgnoreCase(movieName);
    }

    @Override
    public Optional<Ticket> getTicketByScreenAndSeat(int screenNumber, int seatNumber) {
        return ticketRepository.findByScreenNumberAndSeatNumber(screenNumber, seatNumber);
    }

    @Override
    public List<Ticket> getTicketsByBookingStatus(String bookingStatus) {
        return ticketRepository.findByBookingStatus(bookingStatus);
    }

    @Override
    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public long countBookedTicketsForMovie(String movieName) {
        return ticketRepository.countBookedTicketsForMovie(movieName);
    }

    @Override
    public void deleteTicketById(Long id) {
        ticketRepository.deleteById(id);
    }
}
