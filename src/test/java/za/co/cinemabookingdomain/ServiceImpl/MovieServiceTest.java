package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.co.cinemabookingdomain.domain.Movie;
import za.co.cinemabookingdomain.factory.MovieFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MovieServiceTest {

    private final MovieService movieService;
    private static Movie movie1;
    private static Movie movie2;
    private static Movie movie3;

    @Autowired
    public MovieServiceTest(MovieService movieService) {
        this.movieService = movieService;
    }

    @BeforeAll
    static void setUp() {
        // Updated to match the fixed MovieFactory with 7 fields
        movie1 = MovieFactory.createMovie(
                "Get Out", "Horror", "100", "R",
                "A young African-American visits his girlfriend's parents for the weekend",
                "2017", "14:00"
        );

        movie2 = MovieFactory.createMovie(
                "FURIOSA", "Action", "142", "PG-13",
                "Director George Miller tells the story of renegade warrior Furiosa before her encounter with Mad Max",
                "2024", "16:30"
        );

        movie3 = MovieFactory.createMovie(
                "OBLIVION", "Action", "119", "PG-13",
                "A veteran assigned to extract Earth's remaining resources discovers a crashed spacecraft that will change everything he knew",
                "2013", "18:00"
        );
    }

    @Test
    @Order(1)
    void create() {
        Movie savedMovie1 = movieService.create(movie1);
        assertNotNull(savedMovie1);
        System.out.println(savedMovie1);

        Movie savedMovie2 = movieService.create(movie2);
        assertNotNull(savedMovie2);
        System.out.println(savedMovie2);

        Movie savedMovie3 = movieService.create(movie3);
        assertNotNull(savedMovie3);
        System.out.println(savedMovie3);
    }

    @Test
    @Order(2)
    void read() {
        Movie readMovie = movieService.read("Get Out");
        assertNotNull(readMovie);
        System.out.println(readMovie);
    }

    @Test
    @Order(3)
    void update() {
        // Example: updating the rating of FURIOSA
        Movie movieToUpdate = new Movie(
                movie2.getTitle(),
                movie2.getGenre(),
                movie2.getDuration(),
                "R", // Updated rating
                movie2.getDescription(),
                movie2.getReleaseYear(),
                movie2.getShowTime()
        );

        Movie updatedMovie = movieService.update(movieToUpdate);
        assertNotNull(updatedMovie);
        assertEquals("R", updatedMovie.getRating());
        System.out.println(updatedMovie);
    }

    @Test
    @Order(4)
    void delete() {
        boolean isDeleted = movieService.delete("FURIOSA");
        assertTrue(isDeleted);
        System.out.println("Movie Deleted Successfully");
    }

    @Test
    @Order(5)
    void getAll() {
        List<Movie> allMovies = movieService.getAll();
        assertNotNull(allMovies);
        System.out.println(allMovies);
    }
}
