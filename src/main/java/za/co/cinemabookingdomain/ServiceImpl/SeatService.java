package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Seat;
import za.co.cinemabookingdomain.repository.SeatRepository;
import za.co.cinemabookingdomain.service.ISeatService;

import java.util.List;
import java.util.Optional;

@Service
public class SeatService implements ISeatService {
    private final SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat create(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public Seat read(Long id) { // Change parameter from String to Long
        Optional<Seat> seat = seatRepository.findById(id);
        return seat.orElse(null);
    }

    @Override
    public Seat update(Seat seat) {
        return seatRepository.save(seat);
    }

    @Override
    public boolean delete(Long id) { // Change parameter from String to Long
        if (seatRepository.existsById(id)) {
            seatRepository.deleteById(id);
            return !seatRepository.existsById(id);
        }
        return false;
    }

    @Override
    public List<Seat> getAll() {
        return seatRepository.findAll();
    }

    // Additional method to find by seat number
    public Seat findBySeatNumber(String seatNumber) {
        return seatRepository.findBySeatNumber(seatNumber);
    }
}