package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Showtime;
import za.co.cinemabookingdomain.Service.IShowtimeService;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.*;
import static za.co.cinemabookingdomain.factory.ShowtimeFactory.createShowtime;

class ShowtimeServiceImplTest {
    IShowtimeService service;
    LocalDate date = LocalDate.of(2025, Month.JUNE, 4);
    private final Showtime showtime = createShowtime("SpiderMan", "2", date, "2D", "English");

    @Test
    void a_create() {
        Showtime created = service.create(showtime);
        assertNotNull(created);
        assertEquals("SpiderMan", created.getMovie());  // FIXED
        System.out.println(created);
    }

    @Test
    void b_read() {
        Showtime read = service.read(showtime.getMovie());
        assertNotNull(read);
        assertEquals("SpiderMan", read.getMovie());  // FIXED
        System.out.println(read);
    }

    @Test
    void d_update() {
        Showtime newShowtime = new Showtime.Builder().copy(showtime).setMovie("Batman").build();
        Showtime updated = service.update(newShowtime);

        assertEquals("Batman", updated.getMovie());  // FIXED
        System.out.println(updated);
    }

    @Test
    void e_delete() {
        boolean deleted = service.delete(showtime.getMovie());
        assertTrue(deleted);  // FIXED: Ensures the deletion logic works
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void f_getAll() {
        assertNotNull(service.getAll());
        System.out.println(service.getAll());
    }
}