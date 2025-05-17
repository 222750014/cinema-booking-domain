package za.co.cinemabookingdomain.util;



import za.co.cinemabookingdomain.Domain.Customer;
import za.co.cinemabookingdomain.Domain.Promotion;

import java.time.LocalDate;
import java.util.UUID;

public class Helper {


    public static boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }


    public static Customer createCustomer(String name, String email, String phone, Integer loyaltyPoints) {
        if (!isValidEmail(email)) {
            throw new IllegalArgumentException("Invalid email address");
        }
        return new Customer.Builder()
                .setName(name)
                .setEmail(email)
                .setPhone(phone)
                .setLoyaltyPoints(loyaltyPoints != null ? loyaltyPoints : 0)
                .build();
    }


    public static String generateDiscountCode() {
        return "DISCOUNT-" + UUID.randomUUID().toString().substring(0, 8); // Example random discount code
    }


    public static boolean isExpired(Promotion promotion) {
        return promotion.getValidity().isBefore(LocalDate.now());
    }


    public static String formatDate(LocalDate date) {
        return date != null ? date.toString() : "N/A";
    }


    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("\\d{10}");
    }
}