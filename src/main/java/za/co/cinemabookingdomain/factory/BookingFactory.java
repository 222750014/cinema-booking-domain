/*Booking.java
BookingFactory
Author: VR Ramncwana (220618534)
Date: 18 May 2025
 */


package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Booking;
import za.co.cinemabookingdomain.util.Helper;

public class BookingFactory {

    public static Booking createBooking(Long customerId, String customerName, String bookingDate, String bookingTime, String movieTittle, int ticketPrice, String paymentMethod, String status ){
        if(customerId==null ||
                Helper.isInvalidcustomerName(customerName) ||
                Helper.isInvalidbookingTime(bookingTime) ||
                Helper.isInvalidbookingDate(bookingDate)){
            return null;
        }

        return new Booking.BookingBuilder()
                .setCustomerId(customerId)
                .setCustomerName(customerName)
                .setBookingDate(bookingDate)
                .setBookingTime(bookingTime)
                .setMovieTitle(movieTittle)
                .setTicketPrice(ticketPrice)
                .setPaymentMethod(paymentMethod)
                .setStatus(status)
                .build();
    }
}
