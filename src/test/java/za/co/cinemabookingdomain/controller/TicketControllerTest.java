package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.domain.Ticket;
import za.co.cinemabookingdomain.service.TicketService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TicketController.class)
public class TicketControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TicketService ticketService;

    @Autowired
    private ObjectMapper objectMapper;

    private Ticket ticket1;
    private Ticket ticket2;

    @BeforeEach
    public void setup() {
        ticket1 = new Ticket.Builder()
                .movieName("A Working Man")
                .screenNumber(3)
                .seatNumber(42)
                .bookingStatus("BOOKED")
                .build();

        ticket2 = new Ticket.Builder()
                .movieName("Moana 2")
                .screenNumber(6)
                .seatNumber(67)
                .bookingStatus("FREE")
                .build();
    }

    @Test
    public void testGetAllTickets() throws Exception {
        List<Ticket> tickets = Arrays.asList(ticket1, ticket2);
        when(ticketService.getAllTickets()).thenReturn(tickets);

        mockMvc.perform(get("/api/tickets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(tickets.size())))
                .andExpect(jsonPath("$[0].movieName", is(ticket1.getMovieName())))
                .andExpect(jsonPath("$[1].seatNumber", is(ticket2.getSeatNumber())));
    }

    @Test
    public void testGetTicketById_found() throws Exception {
        when(ticketService.getTicketById(1L)).thenReturn(Optional.of(ticket1));

        mockMvc.perform(get("/api/tickets/{id}", 1))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movieName", is(ticket1.getMovieName())))
                .andExpect(jsonPath("$.bookingStatus", is(ticket1.getBookingStatus())));
    }

    @Test
    public void testGetTicketById_notFound() throws Exception {
        when(ticketService.getTicketById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/tickets/{id}", 99))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testCreateTicket() throws Exception {
        when(ticketService.saveTicket(any(Ticket.class))).thenReturn(ticket1);

        mockMvc.perform(post("/api/tickets")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(ticket1)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.movieName", is(ticket1.getMovieName())))
                .andExpect(jsonPath("$.screenNumber", is(ticket1.getScreenNumber())));
    }

    @Test
    public void testDeleteTicket_found() throws Exception {
        when(ticketService.getTicketById(1L)).thenReturn(Optional.of(ticket1));

        mockMvc.perform(delete("/api/tickets/{id}", 1))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteTicket_notFound() throws Exception {
        when(ticketService.getTicketById(99L)).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/tickets/{id}", 99))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testGetTicketsByMovieName() throws Exception {
        List<Ticket> tickets = Arrays.asList(ticket1);
        when(ticketService.getTicketsByMovieName("A Working Man")).thenReturn(tickets);

        mockMvc.perform(get("/api/tickets/movie/Avengers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", is(tickets.size())))
                .andExpect(jsonPath("$[0].movieName", is("A Working Man")));
    }

}

