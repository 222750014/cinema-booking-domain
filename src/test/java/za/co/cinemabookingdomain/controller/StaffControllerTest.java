package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.Domain.Staff;
import za.co.cinemabookingdomain.Service.StaffService;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StaffController.class)
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StaffService staffService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetAllStaff() throws Exception {
        Staff staff1 = new Staff(1L, "John", "Manager");
        Staff staff2 = new Staff(2L, "Alice", "Cashier");

        when(staffService.getAllStaff(id)).thenReturn(Arrays.asList(staff1, staff2));

        mockMvc.perform(get("/api/staff"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"));
    }

    @Test
    public void testGetStaffById_Found() throws Exception {
        Staff staff = new Staff(1L, "John", "Manager");
        when(staffService.getStaffById(1L)).thenReturn(Optional.of(staff));

        mockMvc.perform(get("/api/staff/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"));
    }

    @Test
    public void testGetStaffById_NotFound() throws Exception {
        when(staffService.getStaffById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/staff/1"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAddStaff() throws Exception {
        Staff staff = new Staff(null, "John", "Manager");
        Staff saved = new Staff(1L, "John", "Manager");

        when(staffService.addStaff(any(Staff.class))).thenReturn(saved);

        mockMvc.perform(post("/api/staff")
                .contentType(MediaType.APPLICATION_JSON)
