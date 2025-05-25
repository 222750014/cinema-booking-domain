package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.Domain.Movie;
import za.co.cinemabookingdomain.Repository.MovieRepository;
import za.co.cinemabookingdomain.Service.IMovieService;

import java.util.List;
@Service
public class MovieService implements IMovieService {
  private MovieRepository movieRepository;

@Autowired
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie create(Movie movie) {return movieRepository.save(movie);}

    @Override
    public Movie read(String title) {return movieRepository.findById(title).orElse(null);}

    @Override
    public Movie update(Movie movie) {return movieRepository.save(movie);}



    @Override
    public boolean delete(String title) {
        movieRepository.deleteById(title);
        return !movieRepository.existsById(title);}


    @Override
    public List<Movie> getAll() {return movieRepository.findAll();}

    }

