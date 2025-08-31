package za.co.cinemabookingdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.co.cinemabookingdomain.domain.Payment;


import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, String> {

    Optional<Payment> findByPaymentId(String paymentId);

    void deleteByPaymentId(String paymentId);

    boolean existsByPaymentId(String paymentId);





}