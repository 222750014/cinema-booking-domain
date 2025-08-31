package za.co.cinemabookingdomain.ServiceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.domain.Payment;
import za.co.cinemabookingdomain.repository.PaymentRepository;
import za.co.cinemabookingdomain.service.IPaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {


    private final PaymentRepository repository;
    @Autowired
    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return repository.findByPaymentId(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsByPaymentId(id)) {
            repository.deleteByPaymentId(id); // assuming this method is valid
            return true;
        }
        return false;
    }


    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}