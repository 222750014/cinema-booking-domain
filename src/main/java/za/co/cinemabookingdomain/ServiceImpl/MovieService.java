package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Movie;
import za.co.cinemabookingdomain.repository.MovieRepository;
import za.co.cinemabookingdomain.service.IMovieService;

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

