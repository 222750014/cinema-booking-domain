package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Booking;

import java.util.List;

public interface IBookingService extends IService<Booking,Long>{
    List<Booking> getAll();
}
