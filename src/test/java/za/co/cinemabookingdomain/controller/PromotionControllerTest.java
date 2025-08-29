/*PromotionControllerTest.java
PromotionControllerTest POJO class
Author: EP Posholi (222144408)
Date: 25 May 2025
 */
package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.domain.Promotion;
import za.co.cinemabookingdomain.service.PromotionService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PromotionController.class)
public class PromotionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PromotionService promotionService;

    @Autowired
    private ObjectMapper objectMapper;

    private Promotion youthDayPromo;
    private Promotion blackFridayPromo;

    @BeforeEach
    void setUp() {
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
    void shouldReturnAllPromotions() throws Exception {
        when(promotionService.getAllPromotions()).thenReturn(List.of(youthDayPromo, blackFridayPromo));

        mockMvc.perform(get("/api/promotions"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].promotionCode").value("YOUTH DAY 2025"))
                .andExpect(jsonPath("$[1].promotionCode").value("BLACK FRIDAY"));
    }

    @Test
    @DisplayName("Should return promotion details by promotion code")
    void shouldReturnPromotionByCode() throws Exception {
        when(promotionService.getPromotionByCode("BLACK FRIDAY")).thenReturn(Optional.of(blackFridayPromo));

        mockMvc.perform(get("/api/promotions/code/BLACK FRIDAY"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Black Friday Bonanza"));
    }

    @Test
    @DisplayName("Should create a new promotion successfully")
    void shouldCreatePromotion() throws Exception {
        when(promotionService.createPromotion(any(Promotion.class))).thenReturn(youthDayPromo);

        mockMvc.perform(post("/api/promotions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(youthDayPromo)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.promotionCode").value("YOUTH DAY 2025"));
    }

    @Test
    @DisplayName("Should validate promotion code for a given booking date")
    void shouldValidatePromotionCodeOnBookingDate() throws Exception {
        when(promotionService.isValidPromotion("YOUTH DAY 2025", LocalDate.of(2025, 6, 15)))
                .thenReturn(true);

        mockMvc.perform(get("/api/promotions/validate/YOUTH DAY 2025")
                        .param("bookingDate", "2025-06-15"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
