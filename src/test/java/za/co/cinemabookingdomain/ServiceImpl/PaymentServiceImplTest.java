package za.co.cinemabookingdomain.ServiceImpl;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Payment;
import za.co.cinemabookingdomain.repository.PaymentRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class PaymentServiceImplTest {

    private PaymentRepository repository;
    private PaymentServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = mock(PaymentRepository.class);
        service = new PaymentServiceImpl(repository);
    }

    @Test
    void testCreate() {
        Payment payment = new Payment();
        when(repository.save(payment)).thenReturn(payment);

        Payment result = service.create(payment);

        assertEquals(payment, result);
        verify(repository).save(payment);
    }

    @Test
    void testRead_found() {
        Payment payment = new Payment();
        when(repository.findByPaymentId("123")).thenReturn(Optional.of(payment));

        Payment result = service.read("123");

        assertEquals(payment, result);
        verify(repository).findByPaymentId("123");
    }


    @Test
    void testUpdate() {
        Payment payment = new Payment();
        when(repository.save(payment)).thenReturn(payment);

        Payment result = service.update(payment);

        assertEquals(payment, result);
        verify(repository).save(payment);
    }

    @Test
    void testDelete_success() {
        when(repository.existsByPaymentId("123")).thenReturn(true);
        doNothing().when(repository).deleteByPaymentId("123");

        boolean result = service.delete("123");

        assertTrue(result);
        verify(repository).existsByPaymentId("123");
        verify(repository).deleteByPaymentId("123");
    }



    @Test
    void testGetAll() {
        Payment p1 = new Payment();
        Payment p2 = new Payment();
        List<Payment> payments = Arrays.asList(p1, p2);

        when(repository.findAll()).thenReturn(payments);

        List<Payment> result = service.getAll();

        assertEquals(2, result.size());
        assertTrue(result.contains(p1));
        assertTrue(result.contains(p2));
        verify(repository).findAll();
    }
}