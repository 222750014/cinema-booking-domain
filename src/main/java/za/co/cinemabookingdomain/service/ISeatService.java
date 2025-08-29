package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Seat;

import java.util.List;

public interface ISeatService extends IService<Seat,String>{
    List<Seat> getAll();
}
