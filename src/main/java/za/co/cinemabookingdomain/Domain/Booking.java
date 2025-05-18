/*Booking.java
Booking POJO class
Author: VR Ramncwana (220618534)
Date: 11 May 2025
 */

package za.co.cinemabookingdomain.Domain;

public class Booking {
    private Long customerId;
    private String customerName;
    private String bookingDate;
    private String bookingTime;
    private String movieTitle;
    private int ticketPrice;
    private String paymentMethod;
    private String status;

    public Booking() {
    }

    public Booking(BookingBuilder builder) {
        this.customerId = builder.customerId;
        this.customerName = builder.customerName;
        this.bookingDate = builder.bookingDate;
        this.bookingTime = builder.bookingTime;
        this.movieTitle = builder.movieTitle;
        this.ticketPrice = builder.ticketPrice;
        this.paymentMethod = builder.paymentMethod;
        this.status = builder.status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public String getBookingTime() {
        return bookingTime;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getStatus() {
        return status;
    }


    @Override
    public String toString() {
        return "Booking{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", bookingDate='" + bookingDate + '\'' +
                ", bookingTime='" + bookingTime + '\'' +
                ", movieTitle='" + movieTitle + '\'' +
                ", ticketPrice=" + ticketPrice +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public static class BookingBuilder {
        private Long customerId;
        private String customerName;
        private String bookingDate;
        private String bookingTime;
        private String movieTitle;
        private int ticketPrice;
        private String paymentMethod;
        private String status;

        public BookingBuilder() {
        }

        public BookingBuilder setCustomerId(Long customerId) {
            this.customerId = customerId;
            return this;
        }

        public BookingBuilder setCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public BookingBuilder setBookingDate(String bookingDate) {
            this.bookingDate = bookingDate;
            return this;
        }

        public BookingBuilder setBookingTime(String bookingTime) {
            this.bookingTime = bookingTime;
            return this;
        }

        public BookingBuilder setMovieTitle(String movieTitle) {
            this.movieTitle = movieTitle;
            return this;
        }

        public BookingBuilder setTicketPrice(int ticketPrice) {
            this.ticketPrice = ticketPrice;
            return this;
        }

        public BookingBuilder setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
            return this;
        }

        public BookingBuilder setStatus(String status) {
            this.status = status;
            return this;
        }

        public BookingBuilder copy(Booking booking) {
            this.customerId = booking.customerId;
            this.customerName = booking.customerName;
            this.bookingDate = booking.bookingDate;
            this.bookingTime = booking.bookingTime;
            this.movieTitle = booking.movieTitle;
            this.ticketPrice = booking.ticketPrice;
            this.paymentMethod = booking.paymentMethod;
            this.status = booking.status;
            return this;
        }

        public Booking build() {return new Booking(this);}
    }

}

