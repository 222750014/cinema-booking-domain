package za.co.cinemabookingdomain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.domain.Concession;
import za.co.cinemabookingdomain.service.IConcessionService;

import java.util.List;

@RestController
@RequestMapping("/concessions")
public class ConcessionController {

    private final IConcessionService concessionService;

    @Autowired
    public ConcessionController(IConcessionService concessionService) {
        this.concessionService = concessionService;
    }

    @GetMapping
    public ResponseEntity<List<Concession>> getAllConcessions() {
        return ResponseEntity.ok(concessionService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Concession> getConcessionById(@PathVariable String id) {
        Concession found = concessionService.read(id);
        return (found != null) ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Concession> addConcession(@RequestBody Concession concession) {
        return ResponseEntity.ok(concessionService.create(concession));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Concession> updateConcession(@PathVariable String id, @RequestBody Concession concession) {
        return ResponseEntity.ok(concessionService.update(concession));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteConcession(@PathVariable String id) {
        concessionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}