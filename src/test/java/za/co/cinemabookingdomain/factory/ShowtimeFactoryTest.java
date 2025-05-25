package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Showtime;

import java.time.LocalDate;
import java.time.Month;

import static za.co.cinemabookingdomain.factory.ShowtimeFactory.createShowtime;


import static org.junit.jupiter.api.Assertions.*;

class ShowtimeFactoryTest {

    @Test
    void testCreateShowtime() {
        LocalDate date = LocalDate.of(2025, Month.JUNE,4);
        Showtime showtime = createShowtime("SpiderMan","2",date,"2D","English");

        assertNotNull(showtime);
        assertEquals("SpiderMan",showtime.getMovie());
        assertEquals("2",showtime.getScreen());
        assertEquals(date,showtime.getDate());
        assertEquals("2D",showtime.getFormat());
        assertEquals("English",showtime.getLanguage());
        System.out.println("Created Showtime: " + showtime);

    }
}