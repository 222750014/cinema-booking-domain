package za.co.cinemabookingdomain.factory;

import za.co.cinemabookingdomain.Domain.Promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class PromotionFactory {

    public static Promotion createPromotion(
            String promotionCode,
            String name,
            String description,
            BigDecimal discountPercentage,
            BigDecimal discountAmount,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Integer maxUsageCount
    ) {
        return new Promotion.Builder()
                .setPromotionCode(promotionCode)
                .setName(name)
                .setDescription(description)
                .setDiscountPercentage(discountPercentage)
                .setDiscountAmount(discountAmount)
                .setStartDate(startDate)
                .setEndDate(endDate)
                .setMaxUsageCount(maxUsageCount)
                .build();
    }
}