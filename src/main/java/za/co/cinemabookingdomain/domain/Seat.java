/*Seat.java
Seat POJO class
Author: VR Ramncwana (220618534)
Date: 11 May 2025
 */
package za.co.cinemabookingdomain.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "seat_number", nullable = false, unique = true)
    private String seatNumber;

    @Column(name = "seat_type", nullable = false)
    private String seatType;

    @Column(name = "seat_row", nullable = false)
    private String seatRow;

    // JPA requires a public or protected no-argument constructor
    public Seat() {
    }

    // Public constructor for manual creation
    public Seat(String seatNumber, String seatType, String seatRow) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatRow = seatRow;
    }

    // Private constructor for builder (optional)
    private Seat(SeatBuilder builder) {
        this.id = builder.id;
        this.seatNumber = builder.seatNumber;
        this.seatType = builder.seatType;
        this.seatRow = builder.seatRow;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    public String getSeatRow() {
        return seatRow;
    }

    // Setters (required for JPA updates)
    public void setId(Long id) {
        this.id = id;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public void setSeatRow(String seatRow) {
        this.seatRow = seatRow;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatRow='" + seatRow + '\'' +
                '}';
    }

    // Static method to get builder
    public static SeatBuilder builder() {
        return new SeatBuilder();
    }

    public static class SeatBuilder {
        private Long id;
        private String seatNumber;
        private String seatType;
        private String seatRow;

        public SeatBuilder() {
        }

        public SeatBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public SeatBuilder seatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public SeatBuilder seatType(String seatType) {
            this.seatType = seatType;
            return this;
        }

        public SeatBuilder seatRow(String seatRow) {
            this.seatRow = seatRow;
            return this;
        }

        public SeatBuilder copy(Seat seat) {
            this.id = seat.id;
            this.seatNumber = seat.seatNumber;
            this.seatType = seat.seatType;
            this.seatRow = seat.seatRow;
            return this;
        }

        public Seat build() {
            return new Seat(this);
        }
    }
}