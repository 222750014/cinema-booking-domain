package za.co.cinemabookingdomain.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.domain.Screen;
import za.co.cinemabookingdomain.service.ScreenService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/screens")
public class ScreenController {

    private final ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping
    public ResponseEntity<List<Screen>> getAllScreens() {
        List<Screen> screens = screenService.getAllScreens();
        return ResponseEntity.ok(screens);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Screen> getScreenById(@PathVariable Long id) {
        Optional<Screen> screen = screenService.getScreenById(id);
        return screen.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Screen> createScreen(@RequestBody Screen screen) {
        Screen savedScreen = screenService.saveScreen(screen);
        return ResponseEntity.ok(savedScreen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Long id) {
        Optional<Screen> screen = screenService.getScreenById(id);
        if (screen.isPresent()) {
            screenService.deleteScreenById(id);  // match the service method
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Screen>> getScreensByType(@PathVariable String type) {
        List<Screen> screens = screenService.getScreensByType(type);
        return ResponseEntity.ok(screens);
    }
}
