package za.co.cinemabookingdomain.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int duration;
    private String rating;
    private String description;
    private String releaseYear;
    private String showTime;

    // Default constructor for JPA
    public Movie() {
    }

    // Constructor with all fields
    public Movie(String title, String genre, int duration, String rating, String description,
                 String releaseYear, String showTime) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
        this.releaseYear = releaseYear;
        this.showTime = showTime;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getGenre() { return genre; }
    public void setGenre(String genre) { this.genre = genre; }

    public int getDuration() { return duration; }
    public void setDuration(int duration) { this.duration = duration; }

    public String getRating() { return rating; }
    public void setRating(String rating) { this.rating = rating; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getReleaseYear() { return releaseYear; }
    public void setReleaseYear(String releaseYear) { this.releaseYear = releaseYear; }

    public String getShowTime() { return showTime; }
    public void setShowTime(String showTime) { this.showTime = showTime; }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                ", releaseYear='" + releaseYear + '\'' +
                ", showTime='" + showTime + '\'' +
                '}';
    }
}
