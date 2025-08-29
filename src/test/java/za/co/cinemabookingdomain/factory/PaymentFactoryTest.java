package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.domain.Payment;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalTime;

public class PaymentFactoryTest {
    @Test
    public void testCreatePayment(){
    LocalTime time = LocalTime.of(18,27);
    Payment payment = PaymentFactory.createPayment("12345","Debitcard",200.00,time);

        assertNotNull(payment);
        assertEquals("12345", payment.getPaymentId());
        assertEquals("Debitcard", payment.getPaymentMethod());
        assertEquals(200.00, payment.getAmount());
        assertEquals(time, payment.getTime());
        System.out.println("Created Payment: " + payment);




    }


}
