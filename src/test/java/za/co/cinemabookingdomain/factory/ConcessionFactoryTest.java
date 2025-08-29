package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Concession;

import static org.junit.jupiter.api.Assertions.*;

class ConcessionTest {

    @Test
    void testConcessionCreation() {
        Concession concession = new Concession.Builder()
                .setItemName("Popcorn")
                .setPrice(45.00)
                .setQuantityAvailable(100)
                .build();

        assertNotNull(concession);
        assertEquals("Popcorn", concession.getItemName());
        assertEquals(45.00, concession.getPrice());
        assertEquals(100, concession.getQuantityAvailable());

        System.out.println("Concession created: " + concession);
    }

    @Test
    void testConcessionBuilderCopy() {
        Concession original = new Concession.Builder()
                .setItemName("Soda")
                .setPrice(30.00)
                .setQuantityAvailable(50)
                .build();

        // Added a copy() method inside Builder (see note below)
        Concession copy = new Concession.Builder()
                .copy(original)
                .build();

        assertNotNull(copy);
        assertEquals(original.getItemName(), copy.getItemName());
        assertEquals(original.getPrice(), copy.getPrice());
        assertEquals(original.getQuantityAvailable(), copy.getQuantityAvailable());

        System.out.println("Copied Concession: " + copy);
    }

    @Test
    void testConcessionToString() {
        Concession concession = new Concession.Builder()
                .setItemName("Nachos")
                .setPrice(60.00)
                .setQuantityAvailable(25)
                .build();

        String expected = "Concession{id='" + concession.getId() + "', itemName='Nachos', price=60.0, quantityAvailable=25}";
        assertEquals(expected, concession.toString());
    }
}