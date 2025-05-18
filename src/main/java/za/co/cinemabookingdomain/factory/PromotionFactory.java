package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Promotion;

import java.time.LocalDate;

public class PromotionFactory {

    public static Promotion createPromotion(String discountCode, String description, LocalDate validity) {
        return new Promotion.Builder()
                .setDiscountCode(discountCode)
                .setDescription(description)
                .setValidity(validity)
                .build();
    }
}