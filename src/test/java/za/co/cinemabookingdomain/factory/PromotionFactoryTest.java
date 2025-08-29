/*PromotionFactoryTest.java
PromotionFactoryTest POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */
package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class PromotionFactoryTest {

    @Test
    public void testCreatePromotion() {
        LocalDateTime startDate = LocalDateTime.of(2025, 6, 1, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2025, 12, 31, 23, 59);

        Promotion promo = PromotionFactory.createPromotion(
                "SAVE20",
                "Winter Promo",
                "20% Off for Winter",
                new BigDecimal("20.00"),
                null,
                startDate,
                endDate,
                100
        );

        assertNotNull(promo);
        assertEquals("SAVE20", promo.getPromotionCode());
        assertEquals("Winter Promo", promo.getName());
        assertEquals("20% Off for Winter", promo.getDescription());
        assertEquals(new BigDecimal("20.00"), promo.getDiscountPercentage());
        assertEquals(startDate, promo.getStartDate());
        assertEquals(endDate, promo.getEndDate());
        assertEquals(100, promo.getMaxUsageCount());
        assertTrue(promo.getIsActive());
        assertEquals(0, promo.getCurrentUsageCount());
    }
}
