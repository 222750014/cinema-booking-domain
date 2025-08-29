package za.co.cinemabookingdomain.Controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Concession;
import za.co.cinemabookingdomain.Service.ConcessionService;
import za.co.cinemabookingdomain.controller.ConcessionController;
import za.co.cinemabookingdomain.factory.ConcessionFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ConcessionControllerTest {

    private ConcessionService concessionService;
    private ConcessionController concessionController;

    private Concession concession;

    @BeforeEach
    void setUp() {
        concessionService = mock(ConcessionService.class);
        concessionController = new ConcessionController(concessionService);
        concession = ConcessionFactory.createConcession("Popcorn", 5.99, 100);
    }

    @Test
    void testCreateConcession() {
        when(concessionService.create(concession)).thenReturn(concession);

        Concession created = concessionController.create(concession);
        assertNotNull(created);
        assertEquals("Popcorn", created.getItemName());
        verify(concessionService).create(concession);
    }

    @Test
    void testReadConcession() {
        when(concessionService.read(concession.getId())).thenReturn(concession);

        Concession read = concessionController.read(concession.getId());
        assertNotNull(read);
        assertEquals(concession.getId(), read.getId());
        verify(concessionService).read(concession.getId());
    }

    @Test
    void testUpdateConcession() {
        Concession updatedConcession;
        updatedConcession = new Concession.Builder()
                .copy(concession)
                .setPrice(6.99)
                .setQuantityAvailable(120)
                .build();

        when(concessionService.update(updatedConcession)).thenReturn(updatedConcession);

        Concession updated = concessionController.update(updatedConcession);
        assertNotNull(updated);
        assertEquals(6.99, updated.getPrice());
        assertEquals(120, updated.getQuantityAvailable());
        verify(concessionService).update(updatedConcession);
    }

    @Test
    void testDeleteConcession() {
        when(concessionService.delete(concession.getId())).thenReturn(true);

        boolean deleted = concessionController.delete(concession.getId());
        assertTrue(deleted);
        verify(concessionService).delete(concession.getId());
    }
}
