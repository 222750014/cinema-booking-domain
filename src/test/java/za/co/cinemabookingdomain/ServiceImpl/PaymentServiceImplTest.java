package za.co.cinemabookingdomain.ServiceImpl;


import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.co.cinemabookingdomain.domain.Payment;
import za.co.cinemabookingdomain.service.IPaymentService;
import za.co.cinemabookingdomain.factory.PaymentFactory;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class PaymentServiceImplTest {


    private static IPaymentService service;
    LocalTime time = LocalTime.of(18, 27);
    private Payment payment = PaymentFactory.createPayment("12345", "Debitcard", 200.00, time);

    @Test
    void a_create() {
        Payment created = service.create(payment);
        assertNotNull(created);
        assertEquals("12345", created.getPaymentId());
        System.out.println(created);
    }

    @Test
    void b_read() {
        Payment read = service.read(payment.getPaymentId());
        assertNotNull(read);
        assertEquals("12345", read.getPaymentId());
        System.out.println(read);
    }


    @Test
    void c_update() {
        Payment newPayment = new Payment.Builder().copy(payment).setPaymentId("24689")
                .build();
        Payment updated = service.update(newPayment);
        assertNotNull(updated);
        assertEquals("24689", updated.getPaymentId());
        System.out.println(updated);
    }


    @Test
    void d_delete() {
        boolean deleted = service.delete(payment.getPaymentId());
        assertTrue(deleted);
        System.out.println("Deleted: " + deleted);
    }

    @Test
    void getAll() {
        System.out.println(service.getAll());
    }
}
