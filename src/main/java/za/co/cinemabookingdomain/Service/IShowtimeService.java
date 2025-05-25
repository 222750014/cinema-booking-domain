package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Showtime;

import java.util.List;

public interface IShowtimeService extends IService<Showtime,String> {


    List<Showtime> getAll();
}
