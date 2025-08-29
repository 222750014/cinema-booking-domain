package za.co.cinemabookingdomain.repository;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Concession;
import za.co.cinemabookingdomain.factory.ConcessionFactory;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConcessionRepositoryTest {

    private final IConcessionRepository repository = ConcessionRepository.getRepository(); // singleton
    private static final Concession concession = ConcessionFactory.createConcession("Popcorn", 5.99, 100, "C001");

    @Test
    void create() {
        Concession created = repository.create(concession);
        assertNotNull(created);
        assertEquals("C001", created.getId());
        System.out.println("Created: " + created);
    }

    @Test
    void read() {
        repository.create(concession);
        Concession read = repository.read("C001");
        assertNotNull(read);
        assertEquals("Popcorn", read.getItemName());
        System.out.println("Read: " + read);
    }

    @Test
    void update() {
        repository.create(concession);

        Concession updated = new Concession.Builder()
                .copy(concession)    // Builder must have copy() method
                .setPrice(6.99)
                .setQuantityAvailable(120)
                .build();

        Concession result = repository.update(updated);
        assertNotNull(result);
        assertEquals(6.99, result.getPrice());
        assertEquals(120, result.getQuantityAvailable());
        System.out.println("Updated: " + result);
    }

    @Test
    void delete() {
        repository.create(concession);
        boolean success = repository.delete("C001");
        assertTrue(success);
        assertNull(repository.read("C001"));
        System.out.println("Deleted C001: " + success);
    }

    @Test
    void getAll() {
        repository.create(ConcessionFactory.createConcession("Soda", 2.99, 50, "C002"));
        repository.create(ConcessionFactory.createConcession("Candy", 1.50, 30, "C003"));

        List<Concession> all = repository.getAll();
        assertFalse(all.isEmpty());
        System.out.println("All Concessions: " + all);
    }
}
