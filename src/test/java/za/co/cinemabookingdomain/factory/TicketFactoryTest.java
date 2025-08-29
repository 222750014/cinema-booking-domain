package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Ticket;

import static org.junit.jupiter.api.Assertions.*;

public class TicketFactoryTest {

    @Test
    public void testCreateTicket() {
        String expectedMovieName = "A Working Man";
        int expectedScreenNumber = 3;
        int expectedSeatNumber = 42;
        String expectedBookingStatus = "Booked";


        Ticket ticket = TicketFactory.createTicket(expectedMovieName, expectedScreenNumber, expectedSeatNumber);


        assertNotNull(ticket);
        assertEquals(expectedMovieName, ticket.getMovieName(), "The movie name should be correct");
        assertEquals(expectedScreenNumber, ticket.getScreenNumber() );
        assertEquals(expectedSeatNumber, ticket.getSeatNumber());
        assertEquals(expectedBookingStatus, ticket.getBookingStatus());
    }
}
