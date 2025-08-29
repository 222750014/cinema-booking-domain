package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.cinemabookingdomain.domain.Booking;
import za.co.cinemabookingdomain.factory.BookingFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BookingServiceTest {

    private BookingService bookingService;
    private static Booking booking1;
    private static Booking booking2;

    @Autowired
    public BookingServiceTest(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @BeforeAll
    static void setUp() {
        booking1 = BookingFactory.createBooking(1L, "Okuhle", "21/05/2025", "13:00", "The cleaning lady", 130, "Card", "Approved");
        booking2 = BookingFactory.createBooking(2L, "Fiso", "30/05/2025", "14:30", "Happy Face", 150, "Card", "Approved");
    }

    @Test
    @Order(1)
    void create() {
        Booking savedBooking = bookingService.create(booking1);
        assertNotNull(savedBooking);
        System.out.println(savedBooking);

        Booking savedBooking2 = bookingService.create(booking2);
        assertNotNull(savedBooking2);
        System.out.println(savedBooking2);
    }


    @Test
    @Order(2)
    void read() {
        Booking readBooking = bookingService.read(1L);
        assertNotNull(readBooking);
        System.out.println(readBooking);

    }

    @Test
    @Order(3)
    void update() {
        Booking bookingToUpdate = new Booking.BookingBuilder().copy(booking2).setMovieTitle("The lion king").build();

        //from Database
        Booking updatedBooking = bookingService.update(bookingToUpdate);
        assertNotNull(updatedBooking);
        System.out.println(updatedBooking);
    }

    @Test
    @Order(4)
    void delete() {
        boolean isDeleted = bookingService.delete(2L);
        assertTrue(isDeleted);
        System.out.println("Booking Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Booking> allBookings=bookingService.getAll();
        assertNotNull(allBookings);
        System.out.println(allBookings);
    }
    }
