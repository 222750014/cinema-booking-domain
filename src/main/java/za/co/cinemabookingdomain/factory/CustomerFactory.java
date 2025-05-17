package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Customer;

public class CustomerFactory {

    public static Customer createCustomer(String name, String email, String phone, Integer loyaltyPoints) {
        return new Customer.Builder()
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setLoyaltyPoints(loyaltyPoints)
                .build();
    }
}