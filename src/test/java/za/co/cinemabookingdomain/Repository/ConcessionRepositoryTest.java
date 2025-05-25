package za.co.cinemabookingdomain.Repository;

import org.junit.jupiter.api.*;
import za.co.cinemabookingdomain.Domain.Concession;
import za.co.cinemabookingdomain.factory.ConcessionFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ConcessionRepositoryTest {

    private static final ConcessionRepository repository = ConcessionRepository.getRepository();
    private static final Concession concession = ConcessionFactory.createConcession("Popcorn", 5.99, 100);

    @Test
    void a_create() {
        Concession created = repository.create(concession);
        assertNotNull(created);
        assertEquals(concession.getItemName(), created.getItemName());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        // FIX: getId() is a method, don't pass "id" param
        Concession read = repository.read(concession.getId());
        assertNotNull(read);
        assertEquals(concession.getItemName(), read.getItemName());
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Concession updated = new Concession.Builder()
                .copy(concession)
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
    @Disabled("Enable when delete logic is implemented")
    void d_delete() {
        // FIX: getId() is a method, no param
        boolean deleted = repository.delete(concession.getId());
        assertTrue(deleted);
        System.out.println("Deleted: " + concession.getId());
    }

    @Test
    void e_getAll() {
        System.out.println("All concessions:");
        repository.getAll().forEach(System.out::println);
    }
}
