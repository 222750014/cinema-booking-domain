
/*Seat.java
SeatFactory
Author: VR Ramncwana (220618534)
Date: 18 May 2025
 */



package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Seat;
import za.co.cinemabookingdomain.util.Helper;

public class SeatFactory {

    public static Seat createSeat(String seatNumber, String seatType, String seatRow) {
        if(seatNumber==null ||
                Helper.isInvalidseatType(seatType) ||
                Helper.isInvalidseatRow(seatRow)){
            return null;
        }

        return new Seat.SeatBuilder()
                .setSeatNumber(seatNumber)
                .setSeatType(seatType)
                .setSeatRow(seatRow)
                .build();
    }
}

