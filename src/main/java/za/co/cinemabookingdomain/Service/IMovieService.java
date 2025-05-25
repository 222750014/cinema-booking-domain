package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Movie;

import java.util.List;

public interface IMovieService extends IService<Movie,String>{
    List<Movie> getAll();
}
