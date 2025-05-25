package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Showtime;

import java.time.LocalDate;

public class ShowtimeFactory {
    public static Showtime createShowtime(String movie, String screen, LocalDate date, String format, String language){
        if (movie == null || movie.isEmpty()) {
            return null;
        }
        if (screen == null || screen.isEmpty()) {
            return null;
        }
        if (date == null) {
            return null;
        }

        if (format == null || format.isEmpty()) {
            return null;
        }
        if (language == null || language.isEmpty()) {
            return null;
        }


        return new Showtime.Builder()
                .setMovie(movie)
                .setScreen(screen)
                .setDate(date)
                .setFormat(format)
                .setLanguage(language)
                .build();
    }
}
