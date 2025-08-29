package za.co.cinemabookingdomain.factory;

import org.junit.jupiter.api.Test;
import za.co.cinemabookingdomain.domain.Staff;

import static org.junit.jupiter.api.Assertions.*;

//222134763 Sinokhanyo Ntantiso;

class StaffFactoryTest {

    @Test
    void testCreateValidStaff() {
        Staff staff = StaffFactory.createStaff("Sinokhanyo", "Manager", "EMP001");

        assertNotNull(staff);
        assertEquals("Sinokhanyo", staff.getName());
        assertEquals("Manager", staff.getRole());
        assertEquals("EMP001", staff.getEmployeeId());

        System.out.println("Created Staff: " + staff);
    }

    @Test
    void testCreateStaffWithEmptyNameThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StaffFactory.createStaff("", "Manager", "EMP002"));

        assertEquals("Name is required", exception.getMessage());
    }

    @Test
    void testCreateStaffWithNullRoleThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StaffFactory.createStaff("Thabo", null, "EMP003"));

        assertEquals("Role is required", exception.getMessage());
    }

    @Test
    void testCreateStaffWithEmptyEmployeeIdThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                StaffFactory.createStaff("Lerato", "Cleaner", ""));

        assertEquals("Employee ID is required", exception.getMessage());
    }
}
