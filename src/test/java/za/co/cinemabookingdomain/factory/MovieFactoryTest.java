package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Movie;

import static org.junit.jupiter.api.Assertions.*;

class MovieFactoryTest {

    private static Movie movie1;

    @BeforeEach
    void setUp() {
        movie1 = MovieFactory.createMovie("Acrimony","Thriller","2hr","English","Acrimony is a 2018 American psychological thriller film written, produced and directed by Tyler Perry","2018","14:00");
    }

    @Test
    void createMovie() {
        assertNotNull(movie1);
        System.out.println(movie1);
    }


}