package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Concession;

import static org.junit.jupiter.api.Assertions.*;

class ConcessionTest {

    @Test
    void testConcessionCreation() {
        Concession concession = new Concession.Builder()
                .setItemName("Popcorn")
                .setPrice(45.00)
                .setAvailableQuantity(100)
                .build();

        assertNotNull(concession);
        assertEquals("Popcorn", concession.getItemName());
        assertEquals(45.00, concession.getPrice());
        assertEquals(100, concession.getAvailableQuantity());

        System.out.println("Concession created: " + concession);
    }

    @Test
    void testConcessionBuilderCopy() {
        Concession original = new Concession.Builder()
                .setItemName("Soda")
                .setPrice(30.00)
                .setAvailableQuantity(50)
                .build();

        Concession copy = new Concession.Builder()
                .copy(original)
                .build();

        assertNotNull(copy);
        assertEquals(original.getItemName(), copy.getItemName());
        assertEquals(original.getPrice(), copy.getPrice());
        assertEquals(original.getAvailableQuantity(), copy.getAvailableQuantity());

        System.out.println("Copied Concession: " + copy);
    }

    @Test
    void testConcessionToString() {
        Concession concession = new Concession.Builder()
                .setItemName("Nachos")
                .setPrice(60.00)
                .setAvailableQuantity(25)
                .build();

        String expected = "Concession{itemName='Nachos', price=60.0, availableQuantity=25}";
        assertEquals(expected, concession.toString());
    }
}

