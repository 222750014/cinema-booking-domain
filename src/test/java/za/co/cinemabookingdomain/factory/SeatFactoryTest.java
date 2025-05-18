package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Seat;

import static org.junit.jupiter.api.Assertions.*;

class SeatFactoryTest {

    private static Seat seat1;

    @BeforeEach
    void setUp() {
        seat1 = SeatFactory.createSeat("1","Luxury seats","3");
    }

    @Test
    void createSeat() {
        assertNotNull(seat1);
        System.out.println( seat1 );
    }
}
