package za.co.cinemabookingdomain.Domain;

/*
Vuyolwethu Piyo
222875437
 */

public class Ticket {
    private final String movieName;
    private final int screenNumber;
    private final int seatNumber;
    private final String bookingStatus;

    private Ticket(Builder builder) {
        this.movieName = builder.movieName;
        this.screenNumber = builder.screenNumber;
        this.seatNumber = builder.seatNumber;
        this.bookingStatus = builder.bookingStatus;
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
    }
}

