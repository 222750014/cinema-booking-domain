package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Payment;

import java.time.LocalTime;

public class PaymentFactory {
    public static Payment createPayment(String paymentId ,String paymentMethod, double amount, LocalTime time){
        if(paymentId == null || paymentId.isEmpty()){
            return null;
        }
        if( paymentMethod== null ||  paymentMethod.isEmpty()){
            return null;
        }
        if (amount <= 0 ) {
            return null;
        }
        if (time == null) {
            return null;
        }

        return new Payment.Builder()
                .setPaymentId(paymentId)
                .setPaymentMethod(paymentMethod)
                .setAmount(amount)
                .setTime(time)
                .build();


    }
}
