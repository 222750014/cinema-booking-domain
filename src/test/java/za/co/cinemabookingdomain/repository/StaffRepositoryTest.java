package za.co.cinemabookingdomain.repository;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Staff;
import za.co.cinemabookingdomain.factory.StaffFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffRepositoryTest {

    private final IStaffRepository repository = new StaffRepository(); // direct instantiation
    private static final Staff staff = StaffFactory.createStaff("Thabo", "Manager", "EMP100");

    @Test
    void create() {
        Staff created = repository.create(staff);
        assertNotNull(created);
        assertEquals("EMP100", created.getEmployeeId());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.create(staff); // ensure it's in repo
        Staff read = repository.read("EMP100");
        assertNotNull(read);
        assertEquals("Thabo", read.getName());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(staff); // ensure it's in repo

        Staff updated = new Staff.Builder()
                .copy(staff)               // Builder must have copy() method
                .setRole("Supervisor")
                .build();

        Staff result = repository.update(updated);
        assertNotNull(result);
        assertEquals("Supervisor", result.getRole());
        System.out.println("Updated: " + result);
    }

    @Test
    void delete() {
        repository.create(staff); // ensure it's in repo
        boolean success = repository.delete("EMP100");
        assertTrue(success);
        assertNull(repository.read("EMP100"));
        System.out.println("Deleted EMP100: " + success);
    }

    @Test
    void getAll() {
        repository.create(StaffFactory.createStaff("Lebo", "Cashier", "EMP101"));
        repository.create(StaffFactory.createStaff("John", "Cleaner", "EMP102"));

        List<Staff> all = repository.getAll();
        assertFalse(all.isEmpty());
        System.out.println("All Staff: " + all);
    }
}
