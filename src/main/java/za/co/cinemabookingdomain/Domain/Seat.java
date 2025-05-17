/*Seat.java
Seat POJO class
Author: VR Ramncwana (220618534)
Date: 11 May 2025
 */
package za.co.cinemabookingdomain.Domain;

public class Seat {
    private String seatNumber;
    private String seatType;
    private String seatRow;

    public Seat() {
    }

    private Seat(SeatBuilder builder) {
        this.seatNumber = builder.seatNumber;
        this.seatType = builder.seatType;
        this.seatRow = builder.seatRow;
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

    @Override
    public String toString() {
        return "Seat{" +
                "seatNumber='" + seatNumber + '\'' +
                ", seatType='" + seatType + '\'' +
                ", seatRow='" + seatRow + '\'' +
                '}';
    }

    public static class SeatBuilder {
        private String seatNumber;
        private String seatType;
        private String seatRow;

        public SeatBuilder() {
        }

        public SeatBuilder setSeatNumber(String seatNumber) {
            this.seatNumber = seatNumber;
            return this;
        }

        public SeatBuilder setSeatType(String seatType) {
            this.seatType = seatType;
            return this;
        }

        public SeatBuilder setSeatRow(String seatRow) {
            this.seatRow = seatRow;
            return this;
        }

        public SeatBuilder copy(Seat seat) {
            this.seatNumber = seat.seatNumber;
            this.seatType = seat.seatType;
            this.seatRow = seat.seatRow;
            return this;
        }
        public Seat build() {return new Seat(this);}
    }
<<<<<<< HEAD
}
=======
}

>>>>>>> 42ad78a36cc113440a47ac09430f7d95b4394533
