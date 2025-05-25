package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Ticket;

public class TicketFactory {
    public static Ticket CreateTicket(String movieName, int screenNumber, int seatNumber, String bookingStatus) {
        return new Ticket.Builder()
                .movieName(movieName)
                .screenNumber(screenNumber)
                .seatNumber(seatNumber)
                .bookingStatus(bookingStatus)
                .build();
    }

    public static Ticket createTicket(String movieName, int screenNumber, int seatNumber) {
        return new Ticket.Builder()
                .movieName(movieName)
                .screenNumber(screenNumber)
                .seatNumber(seatNumber)
                .bookingStatus("Booked")
                .build();
    }
}