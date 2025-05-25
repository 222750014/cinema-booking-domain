package za.co.cinemabookingdomain.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.cinemabookingdomain.Domain.Payment;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByPaymentId(String paymentId);

    List<Payment> findByPaymentMethod(String paymentMethod);

    List<Payment> findByAmountGreaterThan(Double amount);

    List<Payment> findByTimeBetween(java.time.LocalTime startTime, java.time.LocalTime endTime);

    long countByPaymentMethod(String paymentMethod);
}