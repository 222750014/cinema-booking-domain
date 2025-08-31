package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;
import za.co.cinemabookingdomain.domain.Payment;
import za.co.cinemabookingdomain.service.IPaymentService;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PaymentController.class)
@Import(PaymentControllerTest.MockConfig.class)
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private ObjectMapper objectMapper;

    private Payment samplePayment;


    @Test
    void shouldGetAllPayments() throws Exception {
        Mockito.when(paymentService.getAll()).thenReturn(List.of(samplePayment));

        mockMvc.perform(get("/api/payments"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value("pay123"));
    }

    @Test
    void shouldGetPaymentById() throws Exception {
        Mockito.when(paymentService.read("pay123")).thenReturn(samplePayment);

        mockMvc.perform(get("/api/payments/pay123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.method").value("Credit Card"));
    }

    @Test
    void shouldReturnNotFoundForMissingPayment() throws Exception {
        Mockito.when(paymentService.read("missing")).thenReturn(null);

        mockMvc.perform(get("/api/payments/missing"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreatePayment() throws Exception {
        Mockito.when(paymentService.create(any(Payment.class))).thenReturn(samplePayment);

        mockMvc.perform(post("/api/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePayment)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value("pay123"));
    }

    @Test
    void shouldReturnBadRequestOnCreateFailure() throws Exception {
        Mockito.when(paymentService.create(any(Payment.class))).thenThrow(new IllegalArgumentException());

        mockMvc.perform(post("/api/payments")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePayment)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldUpdatePayment() throws Exception {
        Mockito.when(paymentService.update(any(Payment.class))).thenReturn(samplePayment);

        mockMvc.perform(put("/api/payments/pay123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePayment)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("pay123"));
    }

    @Test
    void shouldReturnBadRequestOnUpdateFailure() throws Exception {
        Mockito.when(paymentService.update(any(Payment.class))).thenThrow(new IllegalArgumentException());

        mockMvc.perform(put("/api/payments/pay123")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(samplePayment)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldDeletePaymentSuccessfully() throws Exception {
        Mockito.when(paymentService.delete("pay123")).thenReturn(true);

        mockMvc.perform(delete("/api/payments/pay123"))
                .andExpect(status().isNoContent());
    }

    @Test
    void shouldReturnNotFoundOnDeleteFailure() throws Exception {
        Mockito.when(paymentService.delete("missing")).thenReturn(false);

        mockMvc.perform(delete("/api/payments/missing"))
                .andExpect(status().isNotFound());
    }

    @Configuration
    static class MockConfig {
        @Bean
        public IPaymentService paymentService() {
            return Mockito.mock(IPaymentService.class);
        }
    }


}