package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Seat;
import za.co.cinemabookingdomain.util.Helper;

public class SeatFactory {

    public static Seat createSeat(String seatNumber, String seatType, String seatRow) {
        if(seatNumber == null || seatNumber.trim().isEmpty() ||
                Helper.isInvalidseatType(seatType) ||
                Helper.isInvalidseatRow(seatRow)){
            return null;
        }

        return Seat.builder()
                .seatNumber(seatNumber.trim())
                .seatType(seatType)
                .seatRow(seatRow)
                .build();
    }
}