package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Ticket;


public class TicketFactory {
    public static Ticket CreateTicket(String movieName, int screenNumber, int seatNumber, String bookingStatus) {
      return new Ticket.Builder()
              .setMovieName()
              .setScreenNumber()
              .setSeatNumber()
              .setBookingStatus()
              .build();
    }
}
