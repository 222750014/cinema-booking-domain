package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Seat;

import java.util.List;

public interface ISeatService extends IService<Seat,String>{
    List<Seat> getAll();
}
