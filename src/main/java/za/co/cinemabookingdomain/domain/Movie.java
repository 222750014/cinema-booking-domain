/*Movie.java
Movie POJO class
Author: VR Ramncwana (220618534)
Date: 11 May 2025
 */
package za.co.cinemabookingdomain.domain;

public class Movie {
    private String title;
    private String genre;
    private String duration;
    private String language;
    private String description;
    private String releaseDate;
    private String releaseTime;

    public Movie() {
    }

    public Movie(MovieBuilder builder) {
        this.title = builder.title;
        this.genre = builder.genre;
        this.duration = builder.duration;
        this.language = builder.language;
        this.description = builder.description;
        this.releaseDate = builder.releaseDate;
        this.releaseTime = builder.releaseTime;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDuration() {
        return duration;
    }

    public String getLanguage() {
        return language;
    }

    public String getDescription() {
        return description;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration='" + duration + '\'' +
                ", language='" + language + '\'' +
                ", description='" + description + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", releaseTime='" + releaseTime + '\'' +
                '}';
    }

    public static class MovieBuilder {
        private String title;
        private String genre;
        private String duration;
        private String language;
        private String description;
        private String releaseDate;
        private String releaseTime;

        public MovieBuilder() {
        }

        public MovieBuilder setTitle(String title) {
            this.title = title;
            return this;
        }

        public MovieBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public MovieBuilder setDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public MovieBuilder setLanguage(String language) {
            this.language = language;
            return this;
        }

        public MovieBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public MovieBuilder setReleaseDate(String releaseDate) {
            this.releaseDate = releaseDate;
            return this;
        }

        public MovieBuilder setReleaseTime(String releaseTime) {
            this.releaseTime = releaseTime;
            return this;
        }

        public MovieBuilder copy(Movie movie) {
            this.title = movie.title;
            this.genre = movie.genre;
            this.duration = movie.duration;
            this.language = movie.language;
            this.description = movie.description;
            this.releaseDate = movie.releaseDate;
            this.releaseTime = movie.releaseTime;
            return this;
        }

        public Movie build() {return new Movie(this);}
    }
}