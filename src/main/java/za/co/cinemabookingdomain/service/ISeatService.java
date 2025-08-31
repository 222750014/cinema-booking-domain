package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Seat;
import java.util.List;

public interface ISeatService extends IService<Seat, Long> { // Change String to Long
    List<Seat> getAll();
    Seat findBySeatNumber(String seatNumber);
}