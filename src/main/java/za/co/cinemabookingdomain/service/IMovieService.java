package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Movie;

import java.util.List;

public interface IMovieService extends IService<Movie,String>{
    List<Movie> getAll();
}
