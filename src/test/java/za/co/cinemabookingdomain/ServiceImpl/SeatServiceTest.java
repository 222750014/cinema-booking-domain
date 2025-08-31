package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.cinemabookingdomain.domain.Seat;
import za.co.cinemabookingdomain.factory.SeatFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeatServiceTest {

    @Autowired
    private SeatService seatService;

    private static Seat seat1;
    private static Seat seat2;
    private static Seat seat3;

    @BeforeAll
    static void setUp() {
        seat1 = SeatFactory.createSeat("1", "Luxury seat", "3");
        seat2 = SeatFactory.createSeat("5", "Standard seat", "2");
        seat3 = SeatFactory.createSeat("7", "Twin seat", "1");
    }

    @Test
    @Order(1)
    void create() {
        Seat savedSeat1 = seatService.create(seat1);
        assertNotNull(savedSeat1);
        System.out.println("Saved Seat 1: " + savedSeat1);

        Seat savedSeat2 = seatService.create(seat2);
        assertNotNull(savedSeat2);
        System.out.println("Saved Seat 2: " + savedSeat2);

        Seat savedSeat3 = seatService.create(seat3);
        assertNotNull(savedSeat3);
        System.out.println("Saved Seat 3: " + savedSeat3);

        // Store the IDs for later tests
        seat1 = savedSeat1;
        seat2 = savedSeat2;
        seat3 = savedSeat3;
    }

    @Test
    @Order(2)
    void read() {
        Seat readSeat = seatService.read(seat1.getId()); // Use the stored ID
        assertNotNull(readSeat);
        System.out.println("Read Seat: " + readSeat);
    }

    @Test
    @Order(3)
    void update() {

        Seat seatToUpdate = Seat.builder()
                .id(seat2.getId()) // Preserve the ID
                .seatNumber(seat2.getSeatNumber())
                .seatType("Twin seat") // Change the type
                .seatRow(seat2.getSeatRow())
                .build();

        Seat updatedSeat = seatService.update(seatToUpdate);
        assertNotNull(updatedSeat);
        assertEquals("Twin seat", updatedSeat.getSeatType());
        System.out.println("Updated Seat: " + updatedSeat);
    }

    @Test
    @Order(4)
    void delete() {
        boolean isDeleted = seatService.delete(seat3.getId()); // Use the stored ID
        assertTrue(isDeleted);
        System.out.println("Seat Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Seat> allSeats = seatService.getAll();
        assertNotNull(allSeats);
        assertTrue(allSeats.size() >= 2); // Should have at least 2 seats (we deleted one)
        System.out.println("All Seats: " + allSeats);
    }
}