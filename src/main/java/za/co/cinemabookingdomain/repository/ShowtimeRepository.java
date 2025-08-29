package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.cinemabookingdomain.domain.Showtime;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, String> {


    List<Showtime> findByMovie(String movie);


    List<Showtime> findByScreen(String screen);


    List<Showtime> findByDate(LocalDate date);


    List<Showtime> findByLanguage(String language);


    List<Showtime> findByFormat(String format);


    List<Showtime> findByDateBetween(LocalDate startDate, LocalDate endDate);
}