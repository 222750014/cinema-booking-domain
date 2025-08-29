package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Booking;
import za.co.cinemabookingdomain.Domain.Customer;

import java.util.List;

public interface IBookingService extends IService<Booking,Long>{
    List<Booking> getAll();
}
