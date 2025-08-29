package za.co.cinemabookingdomain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.domain.Showtime;
import za.co.cinemabookingdomain.service.IShowtimeService;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
@CrossOrigin(origins = "*")
public class ShowtimeController {

    private final IShowtimeService showtimeService;

    @Autowired
    public ShowtimeController(IShowtimeService showtimeService) {
        this.showtimeService = showtimeService;
    }

    @GetMapping
    public ResponseEntity<List<Showtime>> getAllShowtimes() {
        return ResponseEntity.ok(showtimeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Showtime> getShowtimeById(@PathVariable String id) {
        return ResponseEntity.of(java.util.Optional.ofNullable(showtimeService.read(id)));
    }

    @PostMapping
    public ResponseEntity<Showtime> createShowtime(@RequestBody Showtime showtime) {
        try {
            return ResponseEntity.status(201).body(showtimeService.create(showtime));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Showtime> updateShowtime(@PathVariable String id, @RequestBody Showtime showtime) {
        try {
            return ResponseEntity.ok(showtimeService.update(showtime));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShowtime(@PathVariable String id) {
        return showtimeService.delete(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}