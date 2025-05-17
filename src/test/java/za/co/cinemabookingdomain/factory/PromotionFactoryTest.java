package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.Domain.Promotion;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class PromotionFactoryTest {

    @Test
    public void testCreatePromotion() {
        LocalDate validUntil = LocalDate.of(2025, 12, 31);
        Promotion promo = PromotionFactory.createPromotion(
                "SAVE20", "20% Off for Winter", validUntil);

        assertNotNull(promo);
        assertEquals("SAVE20", promo.getDiscountCode());
        assertEquals("20% Off for Winter", promo.getDescription());
        assertEquals(validUntil, promo.getValidity());
    }
}
