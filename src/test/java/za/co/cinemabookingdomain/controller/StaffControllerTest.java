package za.co.cinemabookingdomain.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import za.co.cinemabookingdomain.domain.Staff;
import za.co.cinemabookingdomain.service.IStaffService;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(StaffController.class)
public class StaffControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IStaffService staffService;

    @Autowired
    private ObjectMapper objectMapper;

    private Staff staff1;
    private Staff staff2;

    @BeforeEach
    public void setup() {
        staff1 = new Staff.Builder()
                .id("1")
                .setName("John")
                .setRole("Manager")
                .setEmployeeId("EMP001")
                .build();

        staff2 = new Staff.Builder()
                .id("2")
                .setName("Alice")
                .setRole("Cashier")
                .setEmployeeId("EMP002")
                .build();
    }

    @Test
    public void testGetAllStaff() throws Exception {
        when(staffService.getAllStaff()).thenReturn(Arrays.asList(staff1, staff2));

        mockMvc.perform(get("/api/staff"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].role").value("Manager"))
                .andExpect(jsonPath("$[1].name").value("Alice"))
                .andExpect(jsonPath("$[1].role").value("Cashier"));
    }

    @Test
    public void testGetStaffById_Found() throws Exception {
        when(staffService.getStaffById("1")).thenReturn(Optional.of(staff1));

        mockMvc.perform(get("/api/staff/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.role").value("Manager"))
                .andExpect(jsonPath("$.employeeId").value("EMP001"));
    }

    @Test
    public void testGetStaffById_NotFound() throws Exception {
        when(staffService.getStaffById("99")).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/staff/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testAddStaff() throws Exception {
        Staff newStaff = new Staff.Builder()
                .setName("John")
                .setRole("Manager")
                .setEmployeeId("EMP001")
                .build();

        when(staffService.addStaff(any(Staff.class))).thenReturn(staff1);

        mockMvc.perform(post("/api/staff")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newStaff)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.role").value("Manager"))
                .andExpect(jsonPath("$.employeeId").value("EMP001"));
    }

    @Test
    public void testDeleteStaff_Found() throws Exception {
        when(staffService.getStaffById("1")).thenReturn(Optional.of(staff1));

        mockMvc.perform(delete("/api/staff/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void testDeleteStaff_NotFound() throws Exception {
        when(staffService.getStaffById("99")).thenReturn(Optional.empty());

        mockMvc.perform(delete("/api/staff/99"))
                .andExpect(status().isNotFound());
    }
}
