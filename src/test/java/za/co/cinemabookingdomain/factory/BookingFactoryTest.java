package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Booking;

import static org.junit.jupiter.api.Assertions.*;
class BookingFactoryTest {

    private static Booking booking1;
    private static Booking booking2;

    @BeforeEach
    void setUp() {
        booking1 = BookingFactory.createBooking(1L,"Lwethu","10/06/25","13:00","TheLionKing",150,"Credit card","Approved");
        booking2 = BookingFactory.createBooking(2L,"Lwethu","10/07/25","14:00","The happiness",130,"Cash","Approved");
    }

    @Test
    void createBooking() {
        assertNotNull(booking1);
        System.out.println(booking1 );
    }

    @Test
    void createBooking2() {
        assertNotNull(booking2);
        System.out.println(booking2 );
    }
}