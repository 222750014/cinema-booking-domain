package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.Domain.Customer;
import za.co.cinemabookingdomain.Service.CustomerService;
import za.co.cinemabookingdomain.factory.CustomerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerService customerService;

    @Autowired
    private ObjectMapper objectMapper;

    private Customer testCustomer;
    private List<Customer> customerList;

    @BeforeEach
    void setUp() {
        testCustomer = CustomerFactory.createCustomer(
                "Tshepo Mthembu",
                "tshepo.mthembu@gmail.com",
                "0766787908",
                100
        );

        Customer customer2 = CustomerFactory.createCustomer(
                "Nomsa Khumalo",
                "nomsa.khumalo@yahoo.com",
                "0823456789",
                200
        );

        customerList = Arrays.asList(testCustomer, customer2);
    }

    @Test
    void shouldGetAllCustomers() throws Exception {
        // Given
        when(customerService.getAllCustomers()).thenReturn(customerList);

        // When & Then
        mockMvc.perform(get("/api/customers"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].name").value("Tshepo Mthembu"))
                .andExpect(jsonPath("$[0].email").value("tshepo.mthembu@gmail.com"))
                .andExpect(jsonPath("$[1].name").value("Nomsa Khumalo"));

        verify(customerService, times(1)).getAllCustomers();
    }

    @Test
    void shouldGetCustomerById_WhenCustomerExists() throws Exception {
        // Given
        Long customerId = 1L;
        when(customerService.getCustomerById(customerId)).thenReturn(Optional.of(testCustomer));

        // When & Then
        mockMvc.perform(get("/api/customers/{id}", customerId))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Tshepo Mthembu"))
                .andExpect(jsonPath("$.email").value("tshepo.mthembu@gmail.com"))
                .andExpect(jsonPath("$.phone").value("0766787908"))
                .andExpect(jsonPath("$.loyaltyPoints").value(100));

        verify(customerService, times(1)).getCustomerById(customerId);
    }

    @Test
    void shouldReturn404_WhenCustomerNotFound() throws Exception {
        // Given
        Long customerId = 999L;
        when(customerService.getCustomerById(customerId)).thenReturn(Optional.empty());

        // When & Then
        mockMvc.perform(get("/api/customers/{id}", customerId))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).getCustomerById(customerId);
    }

    @Test
    void shouldCreateCustomer_WhenValidData() throws Exception {
        // Given
        Customer newCustomer = CustomerFactory.createCustomer(
                "Sibongile Dlamini",
                "sibongile.dlamini@outlook.com",
                "0718934567",
                0
        );
        when(customerService.createCustomer(any(Customer.class))).thenReturn(newCustomer);

        // When & Then
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newCustomer)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Sibongile Dlamini"))
                .andExpect(jsonPath("$.email").value("sibongile.dlamini@outlook.com"))
                .andExpect(jsonPath("$.loyaltyPoints").value(0));

        verify(customerService, times(1)).createCustomer(any(Customer.class));
    }

    @Test
    void shouldReturn400_WhenCreatingCustomerWithDuplicateEmail() throws Exception {
        // Given
        Customer duplicateCustomer = CustomerFactory.createCustomer(
                "Thabo Molefe",
                "tshepo.mthembu@gmail.com",
                "0845672314",
                0
        );
        when(customerService.createCustomer(any(Customer.class)))
                .thenThrow(new IllegalArgumentException("Email already in use: tshepo.mthembu@gmail.com"));

        // When & Then
        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(duplicateCustomer)))
                .andExpect(status().isBadRequest());

        verify(customerService, times(1)).createCustomer(any(Customer.class));
    }

    @Test
    void shouldUpdateCustomer_WhenValidData() throws Exception {
        // Given
        Long customerId = 1L;
        Customer updatedCustomer = CustomerFactory.createCustomer(
                "Tshepo Mthembu",
                "tshepo.updated@gmail.com",
                "0799123456",
                150
        );
        when(customerService.updateCustomer(eq(customerId), any(Customer.class)))
                .thenReturn(updatedCustomer);

        // When & Then
        mockMvc.perform(put("/api/customers/{id}", customerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updatedCustomer)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Tshepo Mthembu"))
                .andExpect(jsonPath("$.email").value("tshepo.updated@gmail.com"))
                .andExpect(jsonPath("$.loyaltyPoints").value(150));

        verify(customerService, times(1)).updateCustomer(eq(customerId), any(Customer.class));
    }

    @Test
    void shouldReturn404_WhenUpdatingNonexistentCustomer() throws Exception {
        // Given
        Long customerId = 999L;
        Customer updateData = CustomerFactory.createCustomer(
                "Mpho Langa",
                "mpho.langa@yahoo.com",
                "0729876543",
                0
        );
        when(customerService.updateCustomer(eq(customerId), any(Customer.class)))
                .thenThrow(new RuntimeException("Customer not found with id " + customerId));


        mockMvc.perform(put("/api/customers/{id}", customerId)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(updateData)))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).updateCustomer(eq(customerId), any(Customer.class));
    }

    @Test
    void shouldDeleteCustomer_WhenCustomerExists() throws Exception {

        Long customerId = 1L;
        doNothing().when(customerService).deleteCustomer(customerId);


        mockMvc.perform(delete("/api/customers/{id}", customerId))
                .andExpect(status().isNoContent());

        verify(customerService, times(1)).deleteCustomer(customerId);
    }

    @Test
    void shouldReturn404_WhenDeletingNonexistentCustomer() throws Exception {

        Long customerId = 999L;
        doThrow(new RuntimeException("Customer not found with id " + customerId))
                .when(customerService).deleteCustomer(customerId);


        mockMvc.perform(delete("/api/customers/{id}", customerId))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).deleteCustomer(customerId);
    }

    @Test
    void shouldGetCustomerByEmail_WhenEmailExists() throws Exception {

        String email = "tshepo.mthembu@gmail.com";
        when(customerService.getCustomerByEmail(email)).thenReturn(Optional.of(testCustomer));


        mockMvc.perform(get("/api/customers/search/email")
                        .param("email", email))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.name").value("Tshepo Mthembu"))
                .andExpect(jsonPath("$.email").value(email));

        verify(customerService, times(1)).getCustomerByEmail(email);
    }

    @Test
    void shouldReturn404_WhenEmailNotFound() throws Exception {

        String email = "nonexistent@hotmail.com";
        when(customerService.getCustomerByEmail(email)).thenReturn(Optional.empty());


        mockMvc.perform(get("/api/customers/search/email")
                        .param("email", email))
                .andExpect(status().isNotFound());

        verify(customerService, times(1)).getCustomerByEmail(email);
    }

    @Test
    void shouldSearchCustomersByName() throws Exception {

        String searchName = "Tshepo";
        when(customerService.searchCustomersByName(searchName)).thenReturn(Arrays.asList(testCustomer));


        mockMvc.perform(get("/api/customers/search/name")
                        .param("name", searchName))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].name").value("Tshepo Mthembu"));

        verify(customerService, times(1)).searchCustomersByName(searchName);
    }

    @Test
    void shouldGetTopCustomersByLoyaltyPoints() throws Exception {

        when(customerService.getTopCustomersByLoyaltyPoints()).thenReturn(customerList);


        mockMvc.perform(get("/api/customers/top-loyalty"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2));

        verify(customerService, times(1)).getTopCustomersByLoyaltyPoints();
    }

    @Test
    void shouldCountCustomersWithLoyaltyPointsAbove() throws Exception {

        Integer points = 150;
        long count = 5L;
        when(customerService.countCustomersWithLoyaltyPointsAbove(points)).thenReturn(count);


        mockMvc.perform(get("/api/customers/count/loyalty-above")
                        .param("points", points.toString()))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$").value(5));

        verify(customerService, times(1)).countCustomersWithLoyaltyPointsAbove(points);
    }

    @Test
    void shouldReturn400_WhenInvalidJsonInCreateRequest() throws Exception {

        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"invalid\": \"value\" }"))
                .andExpect(status().isBadRequest());

        verify(customerService, never()).createCustomer(any(Customer.class));
    }

    @Test
    void shouldReturn400_WhenMissingRequiredFieldsInCreateRequest() throws Exception {

        String invalidCustomerJson = "{\"phone\": \"0712345678\"}";


        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCustomerJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400_WhenNullOrEmptyName() throws Exception {

        String invalidCustomerJson = "{\"name\": \"\", \"email\": \"test@test.com\", \"phone\": \"0712345678\"}";


        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCustomerJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    void shouldReturn400_WhenInvalidEmailFormat() throws Exception {

        String invalidCustomerJson = "{\"name\": \"Test User\", \"email\": \"invalid-email\", \"phone\": \"0712345678\"}";


        mockMvc.perform(post("/api/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(invalidCustomerJson))
                .andExpect(status().isBadRequest());
    }
}