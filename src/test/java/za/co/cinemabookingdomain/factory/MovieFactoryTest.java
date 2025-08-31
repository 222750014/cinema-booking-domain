package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {

    private Movie movie1;

    @BeforeEach
    void setUp() {
        // Updated to pass all 7 parameters
        movie1 = MovieFactory.createMovie(
                "Acrimony",
                "Thriller",
                "2hr",
                "English",
                "Acrimony is a 2018 American psychological thriller film written, produced and directed by Tyler Perry",
                "2018",
                "14:00"
        );
    }

    @Test
    void createMovie() {
        assertNotNull(movie1, "Movie should not be null");
        assertEquals("Acrimony", movie1.getTitle());
        assertEquals("Thriller", movie1.getGenre());
        assertEquals(2, movie1.getDuration()); // duration converted to int
        assertEquals("English", movie1.getRating());
        assertEquals("2018", movie1.getReleaseYear());
        assertEquals("14:00", movie1.getShowTime());
        System.out.println(movie1);
    }

    @Test
    void createMovieWithInvalidGenre() {
        Movie invalidMovie = MovieFactory.createMovie(
                "Test",
                "InvalidGenre",
                "2hr",
                "English",
                "Description",
                "2025",
                "16:00"
        );
        assertNull(invalidMovie, "Movie should be null due to invalid genre");
    }

    @Test
    void createMovieWithInvalidDuration() {
        Movie invalidMovie = MovieFactory.createMovie(
                "Test",
                "Action",
                "abc",
                "English",
                "Description",
                "2025",
                "16:00"
        );
        assertNull(invalidMovie, "Movie should be null due to invalid duration");
    }
}
