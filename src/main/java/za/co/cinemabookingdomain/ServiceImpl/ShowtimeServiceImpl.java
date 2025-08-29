package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.Domain.Showtime;
import za.co.cinemabookingdomain.Repository.ShowtimeRepository;
import za.co.cinemabookingdomain.Service.IShowtimeService;

import java.util.List;

@Service
public class ShowtimeServiceImpl implements IShowtimeService {

    private final ShowtimeRepository repository;

    @Autowired
    public ShowtimeServiceImpl(ShowtimeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Showtime create(Showtime showtime) {
        return repository.save(showtime);
    }

    @Override
    public Showtime read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Showtime update(Showtime showtime) {
        return repository.save(showtime);
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Showtime> getAll() {
        return repository.findAll();
    }
}