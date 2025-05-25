package za.co.cinemabookingdomain.Service;
import za.co.cinemabookingdomain.Domain.Screen;

import java.util.List;
import java.util.Optional;
public interface ScreenService {

    Screen saveScreen(Screen screen);


    List<Screen> getAllScreens();


    Optional<Screen> getScreenById(Long id);

    List<Screen> getScreensByType(String type);
    Optional<Screen> getScreenByScreenNumber(int screenNumber);

    List<Screen> getScreensByCapacityGreaterThan(int capacity);


    void deleteScreenById(Long id);

    List<Screen> getScreensOrderByCapacityDesc();
}

