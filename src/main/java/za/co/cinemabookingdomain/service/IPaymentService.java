package za.co.cinemabookingdomain.service;

import za.co.cinemabookingdomain.domain.Payment;

import java.util.List;

public interface IPaymentService extends IService<Payment,String> {
    List<Payment> getAll();
}
