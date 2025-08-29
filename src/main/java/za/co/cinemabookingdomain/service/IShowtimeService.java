package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Showtime;

import java.util.List;

public interface IShowtimeService extends IService<Showtime,String> {


    List<Showtime> getAll();
}
