package za.co.cinemabookingdomain.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.cinemabookingdomain.domain.Staff;
import za.co.cinemabookingdomain.service.IStaffService;

import java.util.List;

@RestController
@RequestMapping("/staff")
public class StaffController {

    private final IStaffService staffService;

    @Autowired
    public StaffController(IStaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping
    public ResponseEntity<List<Staff>> getAllStaff() {
        return ResponseEntity.ok(staffService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable String id) {
        Staff found = staffService.read(id);
        return (found != null) ? ResponseEntity.ok(found) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Staff> addStaff(@RequestBody Staff staff) {
        Staff created = staffService.create(staff);
        return ResponseEntity.ok(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Staff> updateStaff(@PathVariable String id, @RequestBody Staff staff) {
        staff.setId(id);  // Ensure staff entity's ID matches the path variable
        Staff updated = staffService.update(staff);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStaff(@PathVariable String id) {
        staffService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
