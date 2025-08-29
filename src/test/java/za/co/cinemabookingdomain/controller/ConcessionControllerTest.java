package za.co.cinemabookingdomain.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;
import za.co.cinemabookingdomain.domain.Concession;
import za.co.cinemabookingdomain.service.ConcessionService;
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

        ResponseEntity<Concession> response = concessionController.addConcession(concession);

        assertNotNull(response.getBody());
        assertEquals("Popcorn", response.getBody().getItemName());
        verify(concessionService).create(concession);
    }

    @Test
    void testReadConcession() {
        when(concessionService.read(concession.getId())).thenReturn(concession);

        ResponseEntity<Concession> response = concessionController.getConcessionById(concession.getId());

        assertNotNull(response.getBody());
        assertEquals(concession.getId(), response.getBody().getId());
        verify(concessionService).read(concession.getId());
    }

    @Test
    void testUpdateConcession() {
        Concession updatedConcession = new Concession.Builder()
                .setId(concession.getId())  // keep same ID
                .setItemName(concession.getItemName())
                .setPrice(6.99)
                .setQuantityAvailable(120)
                .build();

        when(concessionService.update(updatedConcession)).thenReturn(updatedConcession);

        ResponseEntity<Concession> response = concessionController.updateConcession(updatedConcession.getId(), updatedConcession);

        assertNotNull(response.getBody());
        assertEquals(6.99, response.getBody().getPrice());
        assertEquals(120, response.getBody().getQuantityAvailable());
        verify(concessionService).update(updatedConcession);
    }

    @Test
    void testDeleteConcession() {
        doNothing().when(concessionService).delete(concession.getId());

        ResponseEntity<Void> response = concessionController.deleteConcession(concession.getId());

        assertEquals(204, response.getStatusCodeValue()); // 204 No Content
        verify(concessionService).delete(concession.getId());
    }
}