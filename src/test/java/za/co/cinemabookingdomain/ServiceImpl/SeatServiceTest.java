package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.cinemabookingdomain.Domain.Seat;
import za.co.cinemabookingdomain.factory.SeatFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SeatServiceTest {

    private SeatService seatService;
    private static Seat seat1;
    private static Seat seat2;
    private static Seat seat3;

    @Autowired
    public SeatServiceTest(SeatService seatService) {
        this.seatService = seatService;
    }

    @BeforeAll
    static void setUp(){
        seat1 = SeatFactory.createSeat("1","Luxury seat","3");
        seat2 = SeatFactory.createSeat("5","Standard seat","2");
        seat3 = SeatFactory.createSeat("7","Twin seat","1");}

    @Test
    @Order(1)
    void create() {
        Seat savedSeat=seatService.create(seat1);
        assertNotNull(savedSeat);
        System.out.println(savedSeat);

        Seat savedSeat2 = seatService.create(seat2);
        assertNotNull(savedSeat);
        System.out.println(savedSeat);

        Seat savedSeat3 = seatService.create(seat3);
        assertNotNull(savedSeat);
        System.out.println(savedSeat);
    }

    @Test
    @Order(2)
    void read() {
        Seat readSeat = seatService.read("1");
        assertNotNull(readSeat);
        System.out.println(readSeat);
    }

    @Test
    @Order(3)
    void update() {
        Seat seatToUpdate = new Seat.SeatBuilder().copy(seat2).setSeatType("Twin seat").build();

        //from Database
        Seat updatedSeat = seatService.update(seatToUpdate);
        assertNotNull(updatedSeat);
        System.out.println(updatedSeat  );
    }

    @Test
    @Order(4)
    void delete() {
        boolean isDeleted = seatService.delete("2");
        assertTrue(isDeleted);
        System.out.println("Seat Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Seat> allSeats=seatService.getAll();
        assertNotNull(allSeats  );
        System.out.println(allSeats);
    }
}