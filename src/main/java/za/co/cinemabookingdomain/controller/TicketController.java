package za.co.cinemabookingdomain.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.domain.Ticket;
import za.co.cinemabookingdomain.service.TicketService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    // Get all tickets
    @GetMapping
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    // Get ticket by ID
    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Create a new ticket
    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.saveTicket(ticket);
        return ResponseEntity.ok(savedTicket); // your test expects 200 OK
    }

    // Delete a ticket
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        if (ticket.isPresent()) {
            ticketService.deleteTicketById(id); // matches service method
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Get tickets by movie name
    @GetMapping("/movie/{movieName}")
    public List<Ticket> getTicketsByMovieName(@PathVariable String movieName) {
        return ticketService.getTicketsByMovieName(movieName);
    }
}
