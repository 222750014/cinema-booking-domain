package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Movie;
import za.co.cinemabookingdomain.util.Helper;

public class MovieFactory {

    public static Movie createMovie(String title, String genre, String duration, String rating, String description) {
        // Validate inputs
        if (title == null ||
                Helper.isInvalidgenre(genre) ||
                Helper.isInvalduration(duration)) {
            return null;
        }

        // Convert duration from String to int
        int movieDuration;
        try {
            movieDuration = Integer.parseInt(duration);
        } catch (NumberFormatException e) {
            return null; // invalid duration
        }

        // Create and return the Movie object
        return new Movie(title, genre, movieDuration, rating, description);
    }
}
