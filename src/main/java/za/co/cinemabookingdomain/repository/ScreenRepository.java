package za.co.cinemabookingdomain.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import za.co.cinemabookingdomain.domain.Screen;

import java.util.List;
import java.util.Optional;

public interface ScreenRepository extends JpaRepository<Screen, Long> {

    List<Screen> findByTypeIgnoreCase(String type);

    List<Screen> findByCapacityGreaterThan(int capacity);

    Optional<Screen> findByScreenNumber(int screenNumber);


    @Query("SELECT s FROM Screen s ORDER BY s.capacity DESC")
    List<Screen> findScreensOrderByCapacityDesc();
}

