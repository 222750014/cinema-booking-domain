package za.co.cinemabookingdomain.ServiceImpl;

import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Screen;
import za.co.cinemabookingdomain.repository.ScreenRepository;
import za.co.cinemabookingdomain.service.ScreenService;

import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements ScreenService {

    private final ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
    }

    @Override
    public Screen saveScreen(Screen screen) {
        return screenRepository.save(screen);
    }

    @Override
    public List<Screen> getAllScreens() {
        return screenRepository.findAll();
    }

    @Override
    public Optional<Screen> getScreenById(Long id) {
        return screenRepository.findById(id);
    }

    @Override
    public List<Screen> getScreensByType(String type) {
        return screenRepository.findByTypeIgnoreCase(type);
    }

    @Override
    public Optional<Screen> getScreenByScreenNumber(int screenNumber) {
        return screenRepository.findByScreenNumber(screenNumber);
    }

    @Override
    public List<Screen> getScreensByCapacityGreaterThan(int capacity) {
        return screenRepository.findByCapacityGreaterThan(capacity);
    }

    @Override
    public void deleteScreenById(Long id) {
        screenRepository.deleteById(id);
    }

    @Override
    public List<Screen> getScreensOrderByCapacityDesc() {
        return screenRepository.findScreensOrderByCapacityDesc();
    }
}
