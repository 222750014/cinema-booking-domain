/*Movie.java
Movie POJO class
Author: VR Ramncwana (220618534)
Date: 11 May 2025
 */


package za.co.cinemabookingdomain.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "movies")  // Optional: specify table name
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "genre")
    private String genre;

    @Column(name = "duration")
    private int duration;

    @Column(name = "rating")
    private String rating;

    @Column(name = "description")
    private String description;

    // Add other fields as needed

    // Default constructor (required by JPA)
    public Movie() {
    }

    // Constructor with parameters
    public Movie(String title, String genre, int duration, String rating, String description) {
        this.title = title;
        this.genre = genre;
        this.duration = duration;
        this.rating = rating;
        this.description = description;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", rating='" + rating + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}