package za.co.cinemabookingdomain.ServiceImpl;


import org.springframework.stereotype.Service;
import za.co.cinemabookingdomain.Domain.Payment;
import za.co.cinemabookingdomain.Repository.PaymentRepository;
import za.co.cinemabookingdomain.Service.IPaymentService;

import java.util.List;

@Service
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository repository;


    public PaymentServiceImpl(PaymentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Payment create(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public Payment read(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public Payment update(Payment payment) {
        return repository.save(payment);
    }

    @Override
    public boolean delete(String id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Payment> getAll() {
        return repository.findAll();
    }
}