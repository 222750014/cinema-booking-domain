package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import za.co.cinemabookingdomain.domain.Promotion;
import za.co.cinemabookingdomain.service.PromotionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.extension.ExtendWith;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class PromotionControllerTest {

    @Mock
    private PromotionService promotionService;

    @InjectMocks
    private PromotionController promotionController;

    private ObjectMapper objectMapper;

    private Promotion youthDayPromo;
    private Promotion blackFridayPromo;

    @BeforeEach
    void setUp() {
        objectMapper = new ObjectMapper();

        youthDayPromo = new Promotion.Builder()
                .setPromotionCode("YOUTH DAY 2025")
                .setName("Youth Day Special")
                .setDescription("Celebrate Youth Day with 25% off movie tickets!")
                .setDiscountPercentage(new BigDecimal("25.00"))
                .setStartDate(LocalDateTime.of(2025, 6, 14, 0, 0))
                .setEndDate(LocalDateTime.of(2025, 6, 17, 23, 59))
                .setMaxUsageCount(500)
                .build();

        blackFridayPromo = new Promotion.Builder()
                .setPromotionCode("BLACK FRIDAY")
                .setName("Black Friday Bonanza")
                .setDescription("Flat R50 off on all movie tickets!")
                .setDiscountAmount(new BigDecimal("50.00"))
                .setStartDate(LocalDateTime.of(2025, 11, 28, 0, 0))
                .setEndDate(LocalDateTime.of(2025, 11, 29, 23, 59))
                .build();
    }

    @Test
    @DisplayName("Should return all available promotions")
    void shouldReturnAllPromotions() {
        when(promotionService.getAllPromotions()).thenReturn(List.of(youthDayPromo, blackFridayPromo));

        List<Promotion> result = promotionController.getAllPromotions();

        assertEquals(2, result.size());
        assertEquals("YOUTH DAY 2025", result.get(0).getPromotionCode());
        assertEquals("BLACK FRIDAY", result.get(1).getPromotionCode());

        verify(promotionService, times(1)).getAllPromotions();
    }

    @Test
    @DisplayName("Should return promotion details by promotion code")
    void shouldReturnPromotionByCode() {
        when(promotionService.getPromotionByCode("BLACK FRIDAY")).thenReturn(Optional.of(blackFridayPromo));

        Promotion result = promotionController.getPromotionByCode("BLACK FRIDAY").getBody();

        assertNotNull(result);
        assertEquals("Black Friday Bonanza", result.getName());
        verify(promotionService, times(1)).getPromotionByCode("BLACK FRIDAY");
    }

    @Test
    @DisplayName("Should create a new promotion successfully")
    void shouldCreatePromotion() {
        when(promotionService.createPromotion(any(Promotion.class))).thenReturn(youthDayPromo);

        Promotion result = promotionController.createPromotion(youthDayPromo).getBody();

        assertNotNull(result);
        assertEquals("YOUTH DAY 2025", result.getPromotionCode());
        verify(promotionService, times(1)).createPromotion(any(Promotion.class));
    }

    @Test
    @DisplayName("Should validate promotion code for a given booking date")
    void shouldValidatePromotionCodeOnBookingDate() {
        when(promotionService.isValidPromotion("YOUTH DAY 2025", LocalDate.of(2025, 6, 15)))
                .thenReturn(true);

        boolean isValid = promotionController.validatePromotion("YOUTH DAY 2025", LocalDate.of(2025, 6, 15));

        assertTrue(isValid);
        verify(promotionService, times(1)).isValidPromotion("YOUTH DAY 2025", LocalDate.of(2025, 6, 15));
    }
}
