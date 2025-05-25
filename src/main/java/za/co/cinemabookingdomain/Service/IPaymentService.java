package za.co.cinemabookingdomain.Service;

import za.co.cinemabookingdomain.Domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment,String> {
    List<Payment> getAll();
}
