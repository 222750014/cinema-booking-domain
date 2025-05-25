package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.Domain.Seat;
import za.co.cinemabookingdomain.Repository.SeatRepository;
import za.co.cinemabookingdomain.Service.ISeatService;

import java.util.List;
@Service
public class SeatService implements ISeatService {
    private SeatRepository seatRepository;

    @Autowired
    public SeatService(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat create(Seat seat) {return seatRepository.save(seat);}


    @Override
    public Seat read(String seatNumber) {return seatRepository.findById(seatNumber).orElse(null);}


    @Override
    public Seat update(Seat seat) {return seatRepository.save(seat);}


    @Override
    public boolean delete(String seatNumber) {
        seatRepository.deleteById(seatNumber);
        return !seatRepository.existsById(seatNumber);}


    @Override
    public List<Seat> getAll() {return seatRepository.findAll();}

    }

