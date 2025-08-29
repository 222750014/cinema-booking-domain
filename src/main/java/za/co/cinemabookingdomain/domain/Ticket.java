package za.co.cinemabookingdomain.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
/*
Vuyolwethu Piyo
222875437
 */

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String movieName;
    private int screenNumber;
    private int seatNumber;
    private String bookingStatus;

    protected Ticket() {
    }


    private Ticket(Builder builder) {
        this.movieName = builder.movieName;
        this.screenNumber = builder.screenNumber;
        this.seatNumber = builder.seatNumber;
        this.bookingStatus = builder.bookingStatus;
    }

    public Long getId() {
        return id;
    }

    public String getMovieName() {
        return movieName;
    }

    public int getScreenNumber() {
        return screenNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    // Static Builder class
    public static class Builder {
        private String movieName;
        private int screenNumber;
        private int seatNumber;
        private String bookingStatus;

        public Builder movieName(String movieName) {
            this.movieName = movieName;
            return this;
        }

        public Builder screenNumber(int screenNumber) {
            this.screenNumber = screenNumber;
            return this;
        }

        public Builder seatNumber(int seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public Builder bookingStatus(String bookingStatus) {
            this.bookingStatus = bookingStatus;
            return this;
        }

        public Ticket build() {
            return new Ticket(this);
        }

        public Screen.Builder setMovieName() {
            return new Screen.Builder(this);
        }
    }
}