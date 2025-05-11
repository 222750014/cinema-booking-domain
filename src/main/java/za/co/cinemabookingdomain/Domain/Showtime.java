package za.co.cinemabookingdomain.Domain;

import java.time.LocalDate;

public class Showtime {
    private final String movie;
    private final String screen;
    private final LocalDate date;
    private final String language;
    private String format; // 2D, 3D, etc.

    private Showtime(Builder builder) {
        this.movie = builder.movie;
        this.screen = builder.screen;
        this.date = builder.date;
        this.format = builder.format;
        this.language = builder.language;
    }

    public String getMovie() {
        return movie;
    }

    public String getScreen() {
        return screen;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getLanguage() {
        return language;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "Showtime{" +
                "movie='" + movie + '\'' +
                ", screen='" + screen + '\'' +
                ", date=" + date +
                ", language='" + language + '\'' +
                ", format='" + format + '\'' +
                '}';
    }

    public static class Builder {
        private String movie;
        private String screen;
        private LocalDate date;
        private String language;
        private String format;

        public Builder setMovie(String movie) {
            this.movie = movie;
            return this;
        }

        public Builder setScreen(String screen) {
            this.screen = screen;
            return this;
        }

        public Builder setDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public Builder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public Builder setFormat(String format) {
            this.format = format;
            return this;
        }

        public Builder copy(Showtime showtime) {
            this.movie = showtime.movie;
            this.screen = showtime.screen;
            this.date = showtime.date;
            this.format = showtime.format;
            this.language =showtime.language;
            return this;
        }
        public Showtime build() {
            return new Showtime(this);
        }
    }
}