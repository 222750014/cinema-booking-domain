package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Booking;
import za.co.cinemabookingdomain.repository.BookingRepository;
import za.co.cinemabookingdomain.service.IBookingService;

import java.util.List;
@Service
public class BookingService implements IBookingService {

    private BookingRepository bookingRepository;


@Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @Override
    public Booking create(Booking booking) {return bookingRepository.save(booking);}


    @Override
    public Booking read(Long customerId) {return bookingRepository.findById(customerId).orElse(null);}

    @Override
    public Booking update(Booking booking) {return bookingRepository.save(booking);}


    @Override
    public boolean delete(Long customerId) {
        bookingRepository.deleteById(customerId);
        return !bookingRepository.existsById(customerId);}

        @Override
        public List<Booking> getAll () {
            return bookingRepository.findAll();
        }
    }


